package org.grails.plugins.zkui.input

import org.grails.plugins.zkui.AbstractTagLib

class DoubleBoxTagLib extends AbstractTagLib {
    static namespace = "z"

    def doublebox = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Doublebox
    }

}
