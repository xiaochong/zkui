package org.grails.plugins.zkui.layouts.columnlayout

import org.grails.plugins.zkui.AbstractTagLib

class ColumnChildrenTagLib extends AbstractTagLib {
    static namespace = "z"

    def columnchildren = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zkex.zul.Columnchildren
    }
}
