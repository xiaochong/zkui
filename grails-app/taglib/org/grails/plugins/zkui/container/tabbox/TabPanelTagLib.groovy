package org.grails.plugins.zkui.container.tabbox

import org.grails.plugins.zkui.AbstractTagLib

class TabPanelTagLib extends AbstractTagLib {
    static namespace = "z"

    def tabpanel = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Tabpanel
    }

}
