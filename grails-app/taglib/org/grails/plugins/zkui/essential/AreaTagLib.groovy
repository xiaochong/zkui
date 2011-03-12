package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class AreaTagLib extends AbstractTagLib {
    static namespace = "z"

    def area = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Area
    }

}