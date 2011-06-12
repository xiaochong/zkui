package org.grails.plugins.zkui.input

import org.grails.plugins.zkui.AbstractTagLib

class ColorboxTagLib extends AbstractTagLib {
    static namespace = "z"

    def colorbox = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zkex.zul.Colorbox
    }
}
