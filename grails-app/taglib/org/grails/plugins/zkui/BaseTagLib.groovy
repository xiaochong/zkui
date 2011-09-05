package org.grails.plugins.zkui

import org.grails.plugins.zkui.util.Renders
import org.zkoss.zk.fn.JspFns
import org.zkoss.zk.ui.Component

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
        out << '<meta http-equiv="Pragma" content="no-cache"/>'
        out << '<meta http-equiv="Expires" content="-1"/>'
        out << JspFns.outZkHtmlTags(servletContext, request, response, null)
    }


    def attribute = {attrs, b ->
        if (!attrs.name) {
            throwTagError("Attribute [name] must not be null")
        }
        String content = b.call()
        if (content) {
            if ("true".equalsIgnoreCase(attrs.trim)) content = content.trim()
            AbstractTagLib.setAttrs([(attrs.name): content], request['parents']?.last, servletContext)
        }
    }
}
