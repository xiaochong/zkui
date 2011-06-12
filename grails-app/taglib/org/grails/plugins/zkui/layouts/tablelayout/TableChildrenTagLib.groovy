package org.grails.plugins.zkui.layouts.tablelayout

import org.grails.plugins.zkui.AbstractTagLib

class TableChildrenTagLib extends AbstractTagLib {
    static namespace = "z"

    def tablechildren = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zkmax.zul.Tablechildren
    }
}
