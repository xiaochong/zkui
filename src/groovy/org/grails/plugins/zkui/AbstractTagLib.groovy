package org.grails.plugins.zkui

import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.grails.plugins.zkui.util.InlineUtils
import org.grails.plugins.zkui.util.ZkUriHandler
import org.zkoss.web.servlet.http.Https
import org.zkoss.zk.ui.event.CreateEvent
import org.zkoss.zk.ui.event.Events
import org.zkoss.zk.ui.http.ExecutionImpl
import org.zkoss.zk.ui.http.I18Ns
import org.zkoss.zk.ui.http.WebManager
import org.zkoss.zk.ui.impl.Attributes
import org.zkoss.zk.ui.impl.RequestInfoImpl
import org.zkoss.zk.ui.metainfo.EventHandler
import org.zkoss.zk.ui.metainfo.PageDefinitions
import org.zkoss.zk.ui.metainfo.Property
import org.zkoss.zk.ui.metainfo.ZScript
import org.zkoss.zul.Constraint
import org.zkoss.zk.ui.*
import org.zkoss.zk.ui.sys.*

abstract class AbstractTagLib {

    abstract Class getComponentClass()

    void doTag(attrs, body, ServletContext servletContext, HttpServletRequest request,
               HttpServletResponse response, Binding pageScope, Writer out) {
        def composeHandle = new ComposerHandler(attrs.remove("apply"))
        Component component = componentClass.newInstance()
        composeHandle.doBeforeComposeChildren(component)
        if (!pageScope.variables.containsKey("parents")) {
            pageScope.parents = new LinkedList<Component>()
            pageScope.parents.push(component)
            doRender(servletContext, request, response, body, pageScope, out, composeHandle, component, attrs)
        } else {
            doChildComponent(servletContext, pageScope, component, attrs, body, composeHandle, out)
        }
    }

    private def doChildComponent(ServletContext servletContext, Binding pageScope, Component component, attrs, body, ComposerHandler composeHandle, out) {
        pageScope.parents.last.appendChild(component)
        pageScope.parents.push(component)
        setAttrs(attrs, component, servletContext)
        bodyCall(body, component, out)
        composeHandle.doAfterCompose(component)
        pageScope.parents.pop()
        //fire onCreate event...
        sendOnCreateEvent(component)
    }

    static def sendOnCreateEvent(Component component) {
        if (Events.isListened(component, Events.ON_CREATE, false)) {
            Events.postEvent(new CreateEvent(Events.ON_CREATE, component, Executions.getCurrent().getArg()))
        }
    }

    static def setAttrs(attrs, Component component, servletContext) {
        attrs.findAll {
            it.value != null
        }.each {String attrName, value ->
            if (attrName.startsWith("on")) {
                final ZScript zScript = ZScript.parseContent(value.toString())
                ((ComponentCtrl) component).addEventHandler(attrName, new EventHandler(zScript, null))
            } else if (attrName.startsWith("client_")) {
                component.setWidgetListener(attrName.toString().replaceFirst("client_", ''), value.toString())
            } else {
                def attrType = component.metaClass.getMetaProperty(attrName)?.type
                if (attrType?.isPrimitive() || attrType in String || attrType in Number || attrType in Boolean || attrType in Character || attrType in Constraint || attrType == null) {
                    value = ZkUriHandler.handle(component, attrName, value, servletContext.contextPath)
                    Property.assign(component, attrName, value.toString())
                } else {
                    component[attrName] = value
                }
            }
        }
    }

    private def bodyCall(body, Component component, out) {
        String content = body.call()
        if (content && !content.allWhitespace) {
            if (component.metaClass.respondsTo(component, 'setContent', String)) {
                component.content = content
            } else {
                InlineUtils.adjustChildren(null, component, component.getChildren(), content)
            }
        }
        if (pageScope.parents.size() > 1) {
            InlineUtils.writeComponentMark(out, component)
        }
    }

    private def doRender(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response,
                         body, Binding pageScope, Writer out, composeHandle, rootComponent, attrs) {
        final Page page
        final WebManager webManager = WebManager.getWebManagerIfAny(servletContext)
        final Session sess = WebManager.getSession(servletContext, request)

        SessionsCtrl.setCurrent(sess)
        Object old = I18Ns.setup(sess, request, response, "UTF-8")
        try {
            final WebApp webApp = sess.getWebApp()
            final WebAppCtrl wappc = (WebAppCtrl) webApp
            final String path = Https.getThisServletPath(request)
            final Desktop desktop = webManager.getDesktop(sess, request, response, path, true)
            final RequestInfo ri = new RequestInfoImpl(webApp, sess, desktop, request,
                    PageDefinitions.getLocator(webApp, path))
            ((SessionCtrl) sess).notifyClientRequest(true)

            final UiFactory uf = wappc.getUiFactory()
            final Richlet richlet = new EmbedRichlet(body, pageScope, composeHandle, rootComponent, attrs, servletContext, out)
            page = uf.newPage(ri, richlet, path)
            page.setZScriptLanguage("groovy")

            final Execution exec = new ExecutionImpl(servletContext, request, response, desktop, page)
            final boolean cacheable = exec.getDesktop().getDevice().isCacheable()
            if (!cacheable) {
                try {
                    exec.setResponseHeader("Pragma", "no-cache")
                    exec.addResponseHeader("Cache-Control", "no-cache")
                    exec.addResponseHeader("Cache-Control", "no-store")
                    exec.setResponseHeader("Expires", "-1")
                    exec.setAttribute(Attributes.NO_CACHE, Boolean.TRUE)
                } catch (Throwable ex) { //ignore it
                }
            }
            exec.setAttribute(Attributes.PAGE_REDRAW_CONTROL, "page")
            exec.setAttribute(Attributes.PAGE_RENDERER, new PageRenderer());
            try {
                wappc.getUiEngine().execNewPage(exec, richlet, page, out)
            } finally {
                exec.removeAttribute(Attributes.PAGE_REDRAW_CONTROL);
                exec.removeAttribute(Attributes.PAGE_RENDERER);
            }
        } finally {
            SessionsCtrl.setCurrent((Session) null)
            I18Ns.cleanup(request, old)
            pageScope.parents.clear()
            pageScope.variables.remove("parents")
        }
    }

    private class EmbedRichlet extends GenericRichlet {
        def body
        def pageScope
        def composeHandle
        def rootComp
        def attrs
        def servletContext
        def out

        EmbedRichlet(body, pageScope, composeHandle, rootComp, attrs, servletContext, out) {
            this.body = body
            this.pageScope = pageScope
            this.composeHandle = composeHandle
            this.rootComp = rootComp
            this.attrs = attrs
            this.servletContext = servletContext
            this.out = out
        }

        void service(Page page) {
            rootComp.setPage(page)
            setAttrs(attrs, rootComp, servletContext)
            bodyCall(body, rootComp, out)
            composeHandle.doAfterCompose(rootComp)
            sendOnCreateEvent(rootComp)
        }
    }
}