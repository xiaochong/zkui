package org.grails.plugins.zkui.input

import org.grails.plugins.zkui.AbstractTagLib

class TextBoxTagLib extends AbstractTagLib {
    static namespace = "z"

    def textbox = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Textbox
    }

}
