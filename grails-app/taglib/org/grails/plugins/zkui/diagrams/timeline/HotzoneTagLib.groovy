package org.grails.plugins.zkui.diagrams.timeline

import org.grails.plugins.zkui.AbstractTagLib

class HotzoneTagLib extends AbstractTagLib {
    static namespace = "z"

    def hotzone = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkforge.timeline.Hotzone
    }
}
