package org.grails.plugins.zkui.container.tabbox

import org.grails.plugins.zkui.AbstractTagLib

class TabsTagLib extends AbstractTagLib {
    static namespace = "z"

    def tabs = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Tabs
    }

}
