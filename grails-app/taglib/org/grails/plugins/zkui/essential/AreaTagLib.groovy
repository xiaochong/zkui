package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class AreaTagLib extends AbstractTagLib {
    static namespace = "z"

    def area = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.tooltiptext || attrs.coords || attrs.shape || attrs.id || attrs.mold || attrs.widgetClass || attrs.stubonly || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Area
    }

}