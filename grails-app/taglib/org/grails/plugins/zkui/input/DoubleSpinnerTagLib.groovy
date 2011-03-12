package org.grails.plugins.zkui.input

import org.grails.plugins.zkui.AbstractTagLib

class DoubleSpinnerTagLib extends AbstractTagLib {
    static namespace = "z"

    def doublespinner = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Doublespinner
    }

}
