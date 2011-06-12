package org.grails.plugins.zkui.layouts.portallayout

import org.grails.plugins.zkui.AbstractTagLib

class PortalLayoutTagLib extends AbstractTagLib {
    static namespace = "z"

    def portallayout = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zkmax.zul.Portallayout
    }
}
