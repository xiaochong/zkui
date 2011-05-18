/*
 * Copyright 2004-2005 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grails.plugins.zkui.metaclass;

import groovy.lang.MissingMethodException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.groovy.grails.commons.GrailsApplication;
import org.codehaus.groovy.grails.commons.metaclass.AbstractDynamicMethodInvocation;
import org.codehaus.groovy.grails.web.mapping.UrlCreator;
import org.codehaus.groovy.grails.web.mapping.UrlMappingsHolder;
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes;
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsWebRequest;
import org.codehaus.groovy.grails.web.servlet.mvc.RedirectEventListener;
import org.codehaus.groovy.grails.web.servlet.mvc.exceptions.CannotRedirectException;
import org.grails.plugins.zkui.util.UriUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.zkoss.zk.ui.Executions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


/**
 * Implements the "redirect" Controller method for action redirection.
 *
 * @author Graeme Rocher
 * @since 0.2
 *        <p/>
 *        Created Oct 27, 2005
 */
public class ZkRedirectDynamicMethod extends AbstractDynamicMethodInvocation {

    public static final String METHOD_SIGNATURE = "redirect";
    public static final Pattern METHOD_PATTERN = Pattern.compile('^' + METHOD_SIGNATURE + '$');
    public static final String ARGUMENT_URI = "uri";
    public static final String ARGUMENT_URL = "url";
    public static final String ARGUMENT_CONTROLLER = "controller";
    public static final String ARGUMENT_ACTION = "action";
    public static final String ARGUMENT_ID = "id";
    public static final String ARGUMENT_PARAMS = "params";
    public static final String GRAILS_VIEWS_ENABLE_JSESSIONID = "grails.views.enable.jsessionid";
    public static final String GRAILS_REDIRECT_ISSUED = "org.codehaus.groovy.grails.REDIRECT_ISSUED";

    private static final String ARGUMENT_FRAGMENT = "fragment";
    public static final String ARGUMENT_ERRORS = "errors";

    private static final Log LOG = LogFactory.getLog(ZkRedirectDynamicMethod.class);
    private UrlMappingsHolder urlMappingsHolder;
    private boolean useJessionId = false;
    private ApplicationContext applicationContext;

    /**
     * Constructor.
     *
     * @param applicationContext
     */
    public ZkRedirectDynamicMethod(ApplicationContext applicationContext) {
        super(METHOD_PATTERN);

        if (applicationContext.containsBean(UrlMappingsHolder.BEAN_ID)) {
            urlMappingsHolder = (UrlMappingsHolder) applicationContext.getBean(UrlMappingsHolder.BEAN_ID);
        }

        GrailsApplication application = (GrailsApplication) applicationContext.getBean(GrailsApplication.APPLICATION_ID);
        Object o = application.getFlatConfig().get(GRAILS_VIEWS_ENABLE_JSESSIONID);
        if (o instanceof Boolean) {
            useJessionId = (Boolean) o;
        }
        this.applicationContext = applicationContext;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public Object invoke(Object target, String methodName, Object[] arguments) {
        if (arguments.length == 0) {
            throw new MissingMethodException(METHOD_SIGNATURE, target.getClass(), arguments);
        }

        Map argMap = arguments[0] instanceof Map ? (Map) arguments[0] : Collections.EMPTY_MAP;
        if (argMap.isEmpty()) {
            throw new MissingMethodException(METHOD_SIGNATURE, target.getClass(), arguments);
        }

        GrailsWebRequest webRequest = (GrailsWebRequest) RequestContextHolder.currentRequestAttributes();

        HttpServletRequest request = webRequest.getCurrentRequest();
        if (request.getAttribute(GRAILS_REDIRECT_ISSUED) != null) {
            throw new CannotRedirectException("Cannot issue a redirect(..) here. A previous call to redirect(..) has already redirected the response.");
        }

        HttpServletResponse response = webRequest.getCurrentResponse();
        if (response.isCommitted()) {
            throw new CannotRedirectException("Cannot issue a redirect(..) here. The response has already been committed either by another redirect or by directly writing to the response.");
        }

        Object uri = argMap.get(ARGUMENT_URI);
        String url = argMap.containsKey(ARGUMENT_URL) ? argMap.get(ARGUMENT_URL).toString() : null;
        String actualUri;
        if (uri != null) {
            GrailsApplicationAttributes attrs = webRequest.getAttributes();
            actualUri = attrs.getApplicationUri(request) + uri.toString();
        } else if (url != null) {
            actualUri = url;
        } else {
            if (argMap.get(ARGUMENT_ACTION) == null || argMap.get(ARGUMENT_CONTROLLER) == null) {
                throw new CannotRedirectException("redirect required attribute [controller] or attribute [action] is missing");
            }
            String actionName = argMap.get(ARGUMENT_ACTION).toString();
            String controllerName = argMap.get(ARGUMENT_CONTROLLER).toString();
            controllerName = controllerName != null ? controllerName : webRequest.getControllerName();

            Map params = (Map) argMap.get(ARGUMENT_PARAMS);
            if (params == null) {
                params = new HashMap();
            }

            if (LOG.isDebugEnabled()) {
                LOG.debug("Dynamic method [redirect] looking up URL mapping for controller [" + controllerName + "] and action [" + actionName + "] and params [" + params + "] with [" + urlMappingsHolder + "]");
            }

            Object id = argMap.get(ARGUMENT_ID);
            try {
                if (id != null) {
                    params.put(ARGUMENT_ID, id);
                }

                UrlCreator urlMapping = urlMappingsHolder.getReverseMapping(controllerName, actionName, params);
                if (urlMapping == null && LOG.isDebugEnabled()) {
                    LOG.debug("Dynamic method [redirect] no URL mapping found for params [" + params + "]");
                }

                String frag = argMap.get(ARGUMENT_FRAGMENT) != null ? argMap.get(ARGUMENT_FRAGMENT).toString() : null;
                actualUri = urlMapping.createURL(controllerName, actionName, params, request.getCharacterEncoding(), frag);

                if (LOG.isDebugEnabled()) {
                    LOG.debug("Dynamic method [redirect] mapped to URL [" + actualUri + "]");
                }
            } finally {
                if (id != null) {
                    params.remove(ARGUMENT_ID);
                }
            }
        }

        return redirectResponse(actualUri, request, response);
    }

    /*
     * Redirects the response the the given URI
     */
    private Object redirectResponse(String actualUri, HttpServletRequest request, HttpServletResponse response) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Dynamic method [redirect] forwarding request to [" + actualUri + "]");
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("Executing redirect with response [" + response + "]");
        }

        String redirectUrl = useJessionId ? response.encodeRedirectURL(actualUri) : actualUri;
        redirectUrl = UriUtil.fixToZk(redirectUrl, request.getContextPath());
        Executions.getCurrent().sendRedirect(redirectUrl);
        Map<String, RedirectEventListener> redirectListeners = applicationContext.getBeansOfType(RedirectEventListener.class);
        for (RedirectEventListener redirectEventListener : redirectListeners.values()) {
            redirectEventListener.responseRedirected(redirectUrl);
        }
        request.setAttribute(GRAILS_REDIRECT_ISSUED, true);
        return null;
    }

}

