package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class StyleTagLib extends AbstractTagLib {
    static namespace = "z"

    def style = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.src || attrs.content || attrs.dynamic || attrs.media || attrs.visible || attrs.id || attrs.mold || attrs.widgetClass || attrs.stubonly || attrs.definition
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Style
    }

}
