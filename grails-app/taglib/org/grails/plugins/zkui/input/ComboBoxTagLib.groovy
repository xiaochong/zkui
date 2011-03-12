package org.grails.plugins.zkui.input

import org.grails.plugins.zkui.AbstractTagLib

class ComboBoxTagLib extends AbstractTagLib {
    static namespace = "z"

    def combobox = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Combobox
    }

}
