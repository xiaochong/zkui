package org.grails.plugins.zkui.multimedia

import org.grails.plugins.zkui.AbstractTagLib

class FlashTagLib extends AbstractTagLib {
    static namespace = "z"

    def flash = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Flash
    }

}
