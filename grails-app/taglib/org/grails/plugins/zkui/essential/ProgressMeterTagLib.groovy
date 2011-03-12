package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class ProgressMeterTagLib extends AbstractTagLib {
    static namespace = "z"

    def progressmeter = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Progressmeter
    }

}