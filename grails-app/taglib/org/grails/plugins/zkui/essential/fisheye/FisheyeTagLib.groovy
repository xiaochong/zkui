package org.grails.plugins.zkui.essential.fisheye

import org.grails.plugins.zkui.AbstractTagLib

class FisheyeTagLib extends AbstractTagLib {
    static namespace = "z"

    def fisheye = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.height || attrs.width || attrs.hoverImage || attrs.src || attrs.image || attrs.label || attrs.context || attrs.ctrlKeys || attrs.popup || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.style || attrs.action || attrs.widgetClass || attrs.id || attrs.stubonly || attrs.mold || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zkex.zul.Fisheye
    }
}