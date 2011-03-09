package org.grails.plugins.zkui.container.tabbox

import org.grails.plugins.zkui.AbstractTagLib

class TabBoxTagLib extends AbstractTagLib {
    static namespace = "z"

    def tabbox = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Tabbox
    }
}
