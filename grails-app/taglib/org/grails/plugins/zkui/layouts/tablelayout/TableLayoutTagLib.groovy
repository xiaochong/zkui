package org.grails.plugins.zkui.layouts.tablelayout

import org.grails.plugins.zkui.AbstractTagLib

class TableLayoutTagLib extends AbstractTagLib {
    static namespace = "z"

    def tablelayout = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zkmax.zul.Tablelayout
    }
}