package org.grails.plugins.zkui.container.panel

import org.grails.plugins.zkui.AbstractTagLib

class PanelChildrenTagLib extends AbstractTagLib {
    static namespace = "z"

    def panelchildren = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.height || attrs.width || attrs.context || attrs.popup || attrs.ctrlKeys || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.style || attrs.action || attrs.id || attrs.mold || attrs.widgetClass || attrs.stubonly || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Panelchildren
    }
}
