package org.grails.plugins.zkui.data.gird

import org.grails.plugins.zkui.AbstractTagLib

class GridTagLib extends AbstractTagLib {
    static namespace = "z"

    def grid = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.align || attrs.mold || attrs.vflex || attrs.fixedLayout || attrs.pagingPosition || attrs.pageSize || attrs.activePage || attrs.rowRenderer || attrs.preloadSize || attrs.innerWidth || attrs.oddRowSclass || attrs.autopaging || attrs.span || attrs.span || attrs.sizedByContent || attrs.context || attrs.popup || attrs.ctrlKeys || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.id || attrs.widgetClass || attrs.stubonly || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Grid
    }
}
