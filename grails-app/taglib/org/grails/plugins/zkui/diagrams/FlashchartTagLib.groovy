package org.grails.plugins.zkui.diagrams

import org.grails.plugins.zkui.AbstractTagLib

class FlashchartTagLib extends AbstractTagLib {
    static namespace = "z"

    def flashchart = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zul.Flashchart
    }
}
