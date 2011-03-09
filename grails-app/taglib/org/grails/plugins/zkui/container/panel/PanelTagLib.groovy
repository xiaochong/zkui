package org.grails.plugins.zkui.container.panel

import org.grails.plugins.zkui.AbstractTagLib

class PanelTagLib extends AbstractTagLib {
    static namespace = "z"

    def panel = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Panel
    }

}
