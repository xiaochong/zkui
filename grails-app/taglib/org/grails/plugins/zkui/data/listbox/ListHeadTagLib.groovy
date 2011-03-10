package org.grails.plugins.zkui.data.listbox

import org.grails.plugins.zkui.AbstractTagLib

class ListHeadTagLib extends AbstractTagLib {
    static namespace = "z"

    def listhead = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Listhead
    }
}
