package org.grails.plugins.zkui.diagrams.timeplot

import org.grails.plugins.zkui.AbstractTagLib

class TimeplotTagLib extends AbstractTagLib {
    static namespace = "z"

    def timeplot = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.height || attrs.hideTimeFlag || attrs.timeFlagFormat || attrs.width || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.style || attrs.action || attrs.widgetClass || attrs.id || attrs.stubonly || attrs.mold || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkforge.timeplot.Timeplot
    }
}
