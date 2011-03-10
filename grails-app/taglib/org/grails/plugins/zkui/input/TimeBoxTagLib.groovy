package org.grails.plugins.zkui.input

import org.grails.plugins.zkui.AbstractTagLib

class TimeBoxTagLib extends AbstractTagLib {
    static namespace = "z"

    def timebox = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Timebox
    }

}
