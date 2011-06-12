package org.grails.plugins.zkui.diagrams.timeplot

import org.grails.plugins.zkui.AbstractTagLib

class TimeplotTagLib extends AbstractTagLib {
    static namespace = "z"

    def timeplot = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkforge.timeplot.Timeplot
    }
}
