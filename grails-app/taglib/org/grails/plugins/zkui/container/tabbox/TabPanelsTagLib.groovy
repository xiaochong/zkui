package org.grails.plugins.zkui.container.tabbox

import org.grails.plugins.zkui.AbstractTagLib

class TabPanelsTagLib extends AbstractTagLib {
    static namespace = "z"

    def tabpanels = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Tabpanels
    }

}
