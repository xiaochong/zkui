package org.grails.plugins.zkui.diagrams.gmaps

import org.grails.plugins.zkui.AbstractTagLib

class GpolylineTagLib extends AbstractTagLib {
    static namespace = "z"

    def gpolyline = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.gmaps.Gpolyline
    }
}