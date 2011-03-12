package org.grails.plugins.zkui.layouts

import org.grails.plugins.zkui.AbstractTagLib

class HboxTagLib extends AbstractTagLib {
    static namespace = "z"

    def hbox = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Hbox
    }

}
