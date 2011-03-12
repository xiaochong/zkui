package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class AppletTagLib extends AbstractTagLib {
    static namespace = "z"

    def applet = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Applet
    }

}
