package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class ButtonTagLib extends AbstractTagLib {
    static namespace = "z"

    /**
     * A Button
     */
    def button = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Button
    }

}
