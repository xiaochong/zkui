package org.grails.plugins.zkui.data.listbox

import org.grails.plugins.zkui.AbstractTagLib

class ListCellTagLib extends AbstractTagLib {
    static namespace = "z"

    def listcell = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Listcell
    }
}
