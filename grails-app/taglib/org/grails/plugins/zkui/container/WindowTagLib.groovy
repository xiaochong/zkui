package org.grails.plugins.zkui.container

import org.grails.plugins.zkui.AbstractTagLib

class WindowTagLib extends AbstractTagLib {
    static namespace = "z"

    /**
     * A window
     * @attr title Title
     */
    def window = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.mode || attrs.mode || attrs.draggable || attrs.contentStyle || attrs.contentSclass || attrs.maximized || attrs.minimized || attrs.minimizable || attrs.minheight || attrs.minwidth || attrs.sizable || attrs.defaultActionOnShow || attrs.shadow || attrs.title || attrs.visible || attrs.border || attrs.position || attrs.closable || attrs.maximizable || attrs.context || attrs.popup || attrs.ctrlKeys || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.id || attrs.mold || attrs.widgetClass || attrs.stubonly || attrs.definition
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Window
    }
}