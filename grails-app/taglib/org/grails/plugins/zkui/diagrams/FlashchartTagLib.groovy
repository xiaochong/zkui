package org.grails.plugins.zkui.diagrams

import org.grails.plugins.zkui.AbstractTagLib

class FlashchartTagLib extends AbstractTagLib {
    static namespace = "z"

    def flashchart = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.xaxis || attrs.yaxis || attrs.chartStyle || attrs.type || attrs.version || attrs.src || attrs.bgcolor || attrs.loop || attrs.autoplay || attrs.wmode || attrs.quality || attrs.autoPlay || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.widgetClass || attrs.id || attrs.stubonly || attrs.mold || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zul.Flashchart
    }
}
