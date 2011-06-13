package org.grails.plugins.zkui.diagrams.gmaps

import org.grails.plugins.zkui.AbstractTagLib

class GmarkerTagLib extends AbstractTagLib {
    static namespace = "z"

    def gmarker = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.draggingEnabled || attrs.iconAnchorX || attrs.iconAnchorY || attrs.iconDragCrossAnchorX || attrs.iconDragCrossAnchorY || attrs.iconDragCrossImage || attrs.iconDragCrossHeight || attrs.iconDragCrossWidth || attrs.iconImageMap || attrs.iconInfoAnchorX || attrs.iconInfoAnchorY || attrs.iconMaxHeight || attrs.iconMozPrintImage || attrs.iconPrintImage || attrs.iconPrintShadow || attrs.iconShadow || attrs.iconShadowHeight || attrs.iconShadowWidth || attrs.iconHeight || attrs.iconSizeHeight || attrs.iconWidth || attrs.iconTransparent || attrs.maxzoom || attrs.minzoom || attrs.iconImage || attrs.content || attrs.open || attrs.lat || attrs.lng || attrs.context || attrs.ctrlKeys || attrs.popup || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.widgetClass || attrs.id || attrs.stubonly || attrs.mold || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.gmaps.Gmarker
    }
}