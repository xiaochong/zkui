package org.grails.plugins.zkui

import org.grails.plugins.zkui.util.ComponentUtil
import org.grails.plugins.zkui.util.InlineUtils
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.zkoss.lang.ImportedClassResolver
import org.zkoss.web.servlet.http.Https
import org.zkoss.zk.ui.*
import org.zkoss.zk.ui.http.ExecutionImpl
import org.zkoss.zk.ui.http.I18Ns
import org.zkoss.zk.ui.http.WebManager
import org.zkoss.zk.ui.impl.Attributes
import org.zkoss.zk.ui.impl.RequestInfoImpl
import org.zkoss.zk.ui.metainfo.EventHandler
import org.zkoss.zk.ui.metainfo.PageDefinitions
import org.zkoss.zk.ui.metainfo.ZScript
import org.zkoss.zk.ui.sys.*
import org.zkoss.zkplus.spring.DelegatingVariableResolver

import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

abstract class AbstractTagLib implements ApplicationContextAware {
    ApplicationContext applicationContext

    void doTag(attrs, body, String tagName, String languageName = null) {
        Class cls = ComponentUtil.getComponentClass(tagName, languageName)
        Component component = (Component) cls.newInstance()
        ComposerHandler composeHandle = applicationContext.getBean('composerHandler')
        composeHandle.handle(attrs.remove("apply"))
        if (!request.getAttribute('parents')) {
            def parents = new LinkedList<Component>()
            parents.push(component)
            request.setAttribute('parents', parents)
            doRender(servletContext, request, response, body, out, composeHandle, component, attrs)
        } else {
            doChildComponent(servletContext, request, component, attrs, body, composeHandle, out)
        }
    }

    private def doChildComponent(ServletContext servletContext, HttpServletRequest request, Component component, attrs, body, ComposerHandler composeHandle, out) {
        request['parents'].last.appendChild(component)
        request['parents'].push(component)
        setAttrs(attrs, component, servletContext)
        composeHandle.doBeforeComposeChildren(component)
        bodyCall(body, component, out, request)
        composeHandle.doAfterCompose(component)
        request['parents'].pop()
        //fire onCreate event...
        ComponentUtil.sendOnCreateEvent(component)
    }

    static def setAttrs(attrs, Component component, servletContext) {
        attrs.findAll {
            it.value != null
        }.each { String attrName, value ->
            if (attrName.startsWith("on")) {
                if (ComponentUtil.isAnnotation(value)) {
                    ComponentUtil.evaluateDynaAttribute(component, attrName, value)
                } else {
                    final ZScript zScript = ZScript.parseContent(value.toString())
                    ((ComponentCtrl) component).addEventHandler(attrName, new EventHandler(null, zScript, null))
                }
            } else if (attrName.startsWith("client_")) {
                component.setWidgetListener(attrName.toString().replaceFirst("client_", ''), value.toString())
            } else {
                ComponentUtil.setAttr(component, attrName, value, servletContext.contextPath)
            }
        }
    }

    private def bodyCall(body, Component component, out, request) {
        String content = body.call()
        if (content && !content.allWhitespace) {
            if (component.metaClass.respondsTo(component, 'setContent', String)) {
                component.content = content
            } else {
                InlineUtils.adjustChildren(null, component, component.getChildren(), content)
            }
        }
        if (request['parents'].size() > 1) {
            InlineUtils.writeComponentMark(out, component)
        }
    }

    private def doRender(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response,
                         body, Writer out, composeHandle, rootComponent, attrs) {
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
            final Richlet richlet = new EmbedRichlet(body, request, composeHandle, rootComponent, attrs, servletContext, out)
            page = uf.newPage(ri, richlet, path)
            page.setZScriptLanguage("groovy")
            String zkPageId = request.getAttribute('zk_page_id')
            if (zkPageId) {
                page.setId(zkPageId)
            }
            String zkPageStyle = request.getAttribute('zk_page_style')
            if (zkPageStyle) {
                page.setStyle(zkPageStyle)
            }
            page.addVariableResolver(new DelegatingVariableResolver())

            //fix zk 6.5.1 bug of _impclss NullPointerException
            def importedClassResolver = new ImportedClassResolver()
            page.addClassResolver(importedClassResolver)
            page._impclss = importedClassResolver.importedClasses


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
            exec.setAttribute(Attributes.PAGE_RENDERER, new org.grails.plugins.zkui.PageRenderer())
            try {
                wappc.getUiEngine().execNewPage(exec, richlet, page, out)
            } finally {
                exec.removeAttribute(Attributes.PAGE_REDRAW_CONTROL)
                exec.removeAttribute(Attributes.PAGE_RENDERER)
            }
        } finally {
            SessionsCtrl.setCurrent((Session) null)
            I18Ns.cleanup(request, old)
            request.getAttribute('parents').clear()
            request.removeAttribute('parents')
        }
    }

    private class EmbedRichlet extends GenericRichlet {
        def body
        def request
        def composeHandle
        def rootComp
        def attrs
        def servletContext
        def out

        EmbedRichlet(body, request, composeHandle, rootComp, attrs, servletContext, out) {
            this.body = body
            this.request = request
            this.composeHandle = composeHandle
            this.rootComp = rootComp
            this.attrs = attrs
            this.servletContext = servletContext
            this.out = out
        }

        void service(Page page) {
            rootComp.setPage(page)
            setAttrs(attrs, rootComp, servletContext)
            composeHandle.doBeforeComposeChildren(rootComp)
            bodyCall(body, rootComp, out, request)
            composeHandle.doAfterCompose(rootComp)
            ComponentUtil.sendOnCreateEvent(rootComp)
        }
    }
}