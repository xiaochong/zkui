package org.grails.plugins.zkui.diagrams.timeline

import org.grails.plugins.zkui.AbstractTagLib

class BandinfoTagLib extends AbstractTagLib {
    static namespace = "z"

    def bandinfo = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.intervalUnit || attrs.intervalPixels || attrs.syncWith || attrs.eventSourceUrl || attrs.overview || attrs.bubbleVisible || attrs.width || attrs.context || attrs.ctrlKeys || attrs.popup || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.style || attrs.action || attrs.widgetClass || attrs.id || attrs.stubonly || attrs.mold || attrs.definition || attrs.visible
        attrs.eventSourceUrl = attrs.eventSourceUrl?.fixToZkUri(request.getContextPath())
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkforge.timeline.Bandinfo
    }
}