package org.grails.plugins.zkui.container.tabbox

import org.grails.plugins.zkui.AbstractTagLib

class TabBoxTagLib extends AbstractTagLib {
    static namespace = "z"

    def tabbox = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.orient || attrs.mold || attrs.tabscroll || attrs.panelSpacing || attrs.selectedIndex || attrs.context || attrs.popup || attrs.ctrlKeys || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.id || attrs.widgetClass || attrs.stubonly || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Tabbox
    }
}
