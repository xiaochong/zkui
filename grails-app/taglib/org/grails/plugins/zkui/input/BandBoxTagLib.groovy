package org.grails.plugins.zkui.input

import org.grails.plugins.zkui.AbstractTagLib

class BandBoxTagLib extends AbstractTagLib {
    static namespace = "z"

    def bandbox = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.open || attrs.multiline || attrs.autodrop || attrs.buttonVisible || attrs.rows || attrs.tabbable || attrs.value || attrs.type || attrs.disabled || attrs.maxlength || attrs.tabindex || attrs.readonly || attrs.cols || attrs.constraint || attrs.inplace || attrs.errorMessage || attrs.name || attrs.text || attrs.context || attrs.popup || attrs.ctrlKeys || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.id || attrs.mold || attrs.widgetClass || attrs.stubonly || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Bandbox
    }

}