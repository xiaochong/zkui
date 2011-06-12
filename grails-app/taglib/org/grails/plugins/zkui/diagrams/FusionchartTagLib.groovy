package org.grails.plugins.zkui.diagrams

import org.grails.plugins.zkui.AbstractTagLib

class FusionchartTagLib extends AbstractTagLib {
    static namespace = "z"

    def fusionchart = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.fusionchart.Fusionchart
    }
}
