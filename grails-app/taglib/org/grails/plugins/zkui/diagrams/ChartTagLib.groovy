package org.grails.plugins.zkui.diagrams

import org.grails.plugins.zkui.AbstractTagLib

class ChartTagLib extends AbstractTagLib {
    static namespace = "z"

    def chart = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zul.Chart
    }
}