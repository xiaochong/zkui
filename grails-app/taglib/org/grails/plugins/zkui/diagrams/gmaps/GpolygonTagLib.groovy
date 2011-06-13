package org.grails.plugins.zkui.diagrams.gmaps

import org.grails.plugins.zkui.AbstractTagLib

class GpolygonTagLib extends AbstractTagLib {
    static namespace = "z"

    def gpolygon = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.outline || attrs.fill || attrs.fillColor || attrs.fillOpacity || attrs.points || attrs.numLevels || attrs.color || attrs.opacity || attrs.weight || attrs.context || attrs.ctrlKeys || attrs.popup || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.widgetClass || attrs.id || attrs.stubonly || attrs.mold || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.gmaps.Gpolygon
    }
}