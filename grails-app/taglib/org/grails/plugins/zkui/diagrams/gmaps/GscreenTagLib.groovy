package org.grails.plugins.zkui.diagrams.gmaps

import org.grails.plugins.zkui.AbstractTagLib

class GscreenTagLib extends AbstractTagLib {
    static namespace = "z"

    def gscreen = {attrs, b ->
        attrs.src = attrs.src?.fixToZkUri(request.getContextPath())
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.gmaps.Gscreen
    }
}
