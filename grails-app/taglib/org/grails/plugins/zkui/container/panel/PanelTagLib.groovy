package org.grails.plugins.zkui.container.panel

import org.grails.plugins.zkui.AbstractTagLib

class PanelTagLib extends AbstractTagLib {
    static namespace = "z"

    def panel = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.open || attrs.framable || attrs.movable || attrs.maximized || attrs.minimized || attrs.minimizable || attrs.collapsible || attrs.minheight || attrs.minwidth || attrs.sizable || attrs.title || attrs.visible || attrs.border || attrs.closable || attrs.maximizable || attrs.floatable || attrs.context || attrs.popup || attrs.ctrlKeys || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.id || attrs.mold || attrs.widgetClass || attrs.stubonly || attrs.definition
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Panel
    }

}
