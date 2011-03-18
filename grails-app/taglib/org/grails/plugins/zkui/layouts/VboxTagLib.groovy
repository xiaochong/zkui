package org.grails.plugins.zkui.layouts

import org.grails.plugins.zkui.AbstractTagLib

class VboxTagLib extends AbstractTagLib {
    static namespace = "z"

    def vbox = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.orient || attrs.spacing || attrs.align || attrs.pack || attrs.widths || attrs.heights || attrs.sizedByContent || attrs.context || attrs.popup || attrs.ctrlKeys || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.id || attrs.mold || attrs.widgetClass || attrs.stubonly || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Vbox
    }

}
