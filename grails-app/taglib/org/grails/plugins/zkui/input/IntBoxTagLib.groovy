package org.grails.plugins.zkui.input

import org.grails.plugins.zkui.AbstractTagLib

class IntBoxTagLib extends AbstractTagLib {
    static namespace = "z"

    def intbox = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Intbox
    }

}