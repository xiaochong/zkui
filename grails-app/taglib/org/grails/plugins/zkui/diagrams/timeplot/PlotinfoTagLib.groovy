package org.grails.plugins.zkui.diagrams.timeplot

import org.grails.plugins.zkui.AbstractTagLib

class PlotinfoTagLib extends AbstractTagLib {
    static namespace = "z"

    def plotinfo = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkforge.timeplot.Plotinfo
    }
}