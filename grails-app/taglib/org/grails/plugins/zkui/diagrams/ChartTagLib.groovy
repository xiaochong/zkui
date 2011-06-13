package org.grails.plugins.zkui.diagrams

import org.grails.plugins.zkui.AbstractTagLib

class ChartTagLib extends AbstractTagLib {
    static namespace = "z"

    def chart = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.orient || attrs.height || attrs.threeD || attrs.xAxis || attrs.yAxis || attrs.showLegend || attrs.showTooltiptext || attrs.paneAlpha || attrs.paneColor || attrs.fgAlpha || attrs.bgAlpha || attrs.bgColor || attrs.period || attrs.dateFormat || attrs.engine || attrs.areaListener || attrs.title || attrs.width || attrs.model || attrs.type || attrs.align || attrs.src || attrs.hspace || attrs.vspace || attrs.hover || attrs.border || attrs.context || attrs.ctrlKeys || attrs.popup || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.style || attrs.action || attrs.widgetClass || attrs.id || attrs.stubonly || attrs.mold || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zul.Chart
    }
}