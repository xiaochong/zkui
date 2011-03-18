package org.grails.plugins.zkui.input

import org.grails.plugins.zkui.AbstractTagLib

class RadioTagLib extends AbstractTagLib {
    static namespace = "z"

    def radio = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.checked || attrs.radiogroup || attrs.selected || attrs.disabled || attrs.tabindex || attrs.name || attrs.value || attrs.src || attrs.hoverImage || attrs.image || attrs.label || attrs.context || attrs.popup || attrs.ctrlKeys || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.id || attrs.mold || attrs.widgetClass || attrs.stubonly || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Radio
    }

}
