package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class ScriptTagLib extends AbstractTagLib {
    static namespace = "z"

    def script = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.src || attrs.content || attrs.char || attrs.defer || attrs.packages || attrs.type || attrs.id || attrs.mold || attrs.widgetClass || attrs.stubonly || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Script
    }

}
