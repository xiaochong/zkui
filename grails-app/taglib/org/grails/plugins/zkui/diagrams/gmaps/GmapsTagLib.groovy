package org.grails.plugins.zkui.diagrams.gmaps

import org.grails.plugins.zkui.AbstractTagLib

class GmapsTagLib extends AbstractTagLib {
    static namespace = "z"

    def gmaps = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.language || attrs.lat || attrs.lng || attrs.zoom || attrs.showLargeCtrl || attrs.showSmallCtrl || attrs.showZoomCtrl || attrs.showTypeCtrl || attrs.showScaleCtrl || attrs.showOverviewCtrl || attrs.normal || attrs.satellite || attrs.hybrid || attrs.physical || attrs.mapType || attrs.enableDragging || attrs.continuousZoom || attrs.doubleClickZoom || attrs.scrollWheelZoom || attrs.enableGoogleBar || attrs.sensor || attrs.baseDomain || attrs.context || attrs.ctrlKeys || attrs.popup || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.height || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.width || attrs.style || attrs.action || attrs.widgetClass || attrs.id || attrs.stubonly || attrs.mold || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.gmaps.Gmaps
    }
}
