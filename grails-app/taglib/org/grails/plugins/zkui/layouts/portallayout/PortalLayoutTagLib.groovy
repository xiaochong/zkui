package org.grails.plugins.zkui.layouts.portallayout

import org.grails.plugins.zkui.AbstractTagLib

class PortalLayoutTagLib extends AbstractTagLib {
    static namespace = "z"

    def portallayout = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.maximizedMode || attrs.context || attrs.ctrlKeys || attrs.popup || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.widgetClass || attrs.id || attrs.stubonly || attrs.mold || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zkmax.zul.Portallayout
    }
}
