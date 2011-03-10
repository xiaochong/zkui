package org.grails.plugins.zkui.data.listbox

import org.grails.plugins.zkui.AbstractTagLib

class ListItemTagLib extends AbstractTagLib {
    static namespace = "z"

    def listitem = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Listitem
    }
}
