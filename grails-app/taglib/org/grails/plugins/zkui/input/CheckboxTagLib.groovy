package org.grails.plugins.zkui.input

import org.grails.plugins.zkui.AbstractTagLib

class CheckboxTagLib extends AbstractTagLib {
    static namespace = "z"

    def checkbox = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Checkbox
    }

}
