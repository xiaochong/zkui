package org.grails.plugins.zkui;

import org.codehaus.groovy.grails.commons.ApplicationAttributes;
import org.codehaus.groovy.grails.support.PersistenceContextInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ZkuiGrailsOpenSessionInViewFilter extends OncePerRequestFilter {

    public static final String PERSISTENCE_INTERCEPTOR = "persistenceInterceptor";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ApplicationContext context = (ApplicationContext) getServletContext().getAttribute(ApplicationAttributes.APPLICATION_CONTEXT);

        PersistenceContextInterceptor persistenceInterceptor = null;

        if (context != null && context.containsBean(PERSISTENCE_INTERCEPTOR)) {
            persistenceInterceptor = context.getBean(PERSISTENCE_INTERCEPTOR, PersistenceContextInterceptor.class);
            if (persistenceInterceptor != null) persistenceInterceptor.init();
        }
        try {
            filterChain.doFilter(request, response);
        } finally {
            if (persistenceInterceptor != null && persistenceInterceptor.isOpen()) {
                persistenceInterceptor.flush();
                persistenceInterceptor.destroy();
            }
        }
    }
}