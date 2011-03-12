package org.grails.plugins.zkui.multimedia

import org.grails.plugins.zkui.AbstractTagLib

class AudioTagLib extends AbstractTagLib {
    static namespace = "z"

    def audio = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Audio
    }

}
