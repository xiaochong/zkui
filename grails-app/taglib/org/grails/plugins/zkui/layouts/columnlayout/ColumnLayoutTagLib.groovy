package org.grails.plugins.zkui.layouts.columnlayout

import org.grails.plugins.zkui.AbstractTagLib

class ColumnLayoutTagLib extends AbstractTagLib {
    static namespace = "z"

    def columnlayout = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zkex.zul.Columnlayout
    }
}
