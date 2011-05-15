package org.grails.plugins.zkui

import org.zkoss.lang.Library
import org.zkoss.web.servlet.http.Https
import org.zkoss.web.servlet.xel.RequestContext
import org.zkoss.web.servlet.xel.RequestContexts
import org.zkoss.zk.ui.http.ExecutionImpl
import org.zkoss.zk.ui.http.I18Ns
import org.zkoss.zk.ui.http.Utils
import org.zkoss.zk.ui.http.WebManager
import org.zkoss.zk.ui.sys.HtmlPageRenders
import org.zkoss.zk.ui.*

class BaseTagLib {
    static namespace = "z"

    /**
     * render a zk Component.
     *
     * @attr comp REQUIRED the field name
     */
    def render = { attrs, b ->
        if (!attrs.comp) {
            throwTagError("Attribute [comp] must not be null")
        }
        if (!(attrs.comp instanceof Component)) {
            throwTagError("Attribute [comp] has to be org.zkoss.zk.ui.Component")
        }
        Component comp = attrs.comp
        Renders.render(servletContext, request, response, comp, null, out)
    }

    /**
     * render a zk style sheet and javascript resource.
     */
    def resources = {attrs, b ->
        String path = Https.getThisServletPath(request)
        WebManager webManager = WebManager.getWebManagerIfAny(servletContext)
        if (webManager == null) {
            final String ATTR = "org.zkoss.zkplus.embed.updateURI"
            String updateURI = Library.getProperty(ATTR)
            if (updateURI == null)
                updateURI = "/zkau"
            else
                updateURI = Utils.checkUpdateURI(updateURI, ATTR)
            webManager = new WebManager(servletContext, updateURI);
        }
        final Session sess = WebManager.getSession(servletContext, request)
        final WebApp webApp = sess.getWebApp()
        final Object old = I18Ns.setup(sess, request, response, webApp.getConfiguration().getResponseCharset())
        RequestContexts.push([getOut: {out}, getRequest: {request}, getResponse: {response}, getServletContext: {servletContext}, variableResolver: {}] as RequestContext)
        try {
            final Desktop desktop = webManager.getDesktop(sess, request, response, path, true)
            if (desktop == null) return
            Execution exec = new ExecutionImpl(servletContext, request, response, desktop, null)
            out << HtmlPageRenders.outLangStyleSheets(exec, null, null)
            out << HtmlPageRenders.outLangJavaScripts(exec, null, null)
        } finally {
            RequestContexts.pop()
            I18Ns.cleanup(request, old)
        }
    }
}
