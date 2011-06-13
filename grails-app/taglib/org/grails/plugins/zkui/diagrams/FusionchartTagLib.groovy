package org.grails.plugins.zkui.diagrams

import org.grails.plugins.zkui.AbstractTagLib

class FusionchartTagLib extends AbstractTagLib {
    static namespace = "z"

    def fusionchart = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.orient || attrs.threeD || attrs.xAxis || attrs.yAxis || attrs.showLegend || attrs.paneAlpha || attrs.paneColor || attrs.fgAlpha || attrs.bgAlpha || attrs.bgColor || attrs.dateFormat || attrs.useChartFgAlpha || attrs.decimalPrecision || attrs.title || attrs.model || attrs.type || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.widgetClass || attrs.id || attrs.stubonly || attrs.mold || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.fusionchart.Fusionchart
    }
}
