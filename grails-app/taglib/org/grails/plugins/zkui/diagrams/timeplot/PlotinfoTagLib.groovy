package org.grails.plugins.zkui.diagrams.timeplot

import org.grails.plugins.zkui.AbstractTagLib

class PlotinfoTagLib extends AbstractTagLib {
    static namespace = "z"

    def plotinfo = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.fillColor || attrs.bubbleHeight || attrs.bubbleWidth || attrs.dotColor || attrs.dotRadius || attrs.eventLineWidth || attrs.eventSourceUri || attrs.lineColor || attrs.lineWidth || attrs.roundValues || attrs.showValues || attrs.hideValueFlag || attrs.valuesOpacity || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.widgetClass || attrs.id || attrs.stubonly || attrs.mold || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkforge.timeplot.Plotinfo
    }
}