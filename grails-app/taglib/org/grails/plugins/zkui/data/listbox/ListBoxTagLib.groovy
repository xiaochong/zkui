package org.grails.plugins.zkui.data.listbox

import org.grails.plugins.zkui.AbstractTagLib

class ListBoxTagLib extends AbstractTagLib {
    static namespace = "z"

    def listbox = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.disabled || attrs.mold || attrs.vflex || attrs.fixedLayout || attrs.pagingPosition || attrs.pageSize || attrs.activePage || attrs.preloadSize || attrs.innerWidth || attrs.oddRowSclass || attrs.autopaging || attrs.maxlength || attrs.checkmark || attrs.tabindex || attrs.seltype || attrs.multiple || attrs.nonselectableTags || attrs.itemRenderer || attrs.name || attrs.selectedIndex || attrs.rows || attrs.span || attrs.span || attrs.sizedByContent || attrs.context || attrs.popup || attrs.ctrlKeys || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.id || attrs.widgetClass || attrs.stubonly || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Listbox
    }
}
