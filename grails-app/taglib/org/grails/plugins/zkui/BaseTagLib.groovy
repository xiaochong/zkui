package org.grails.plugins.zkui

import org.zkoss.zkplus.embed.Renders
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
}
