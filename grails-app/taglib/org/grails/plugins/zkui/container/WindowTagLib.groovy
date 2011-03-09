package org.grails.plugins.zkui.container

import org.grails.plugins.zkui.AbstractTagLib

class WindowTagLib extends AbstractTagLib {
    static namespace = "z"

    /**
     * A window
     * @attr title Title
     */
    def window = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Window
    }
}