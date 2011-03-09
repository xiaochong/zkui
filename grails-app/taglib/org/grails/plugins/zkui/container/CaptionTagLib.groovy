package org.grails.plugins.zkui.container

import org.grails.plugins.zkui.AbstractTagLib

class CaptionTagLib extends AbstractTagLib {
    static namespace = "z"

    def caption = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Caption
    }
}
