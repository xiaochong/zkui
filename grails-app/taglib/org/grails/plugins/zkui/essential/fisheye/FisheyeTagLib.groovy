package org.grails.plugins.zkui.essential.fisheye

import org.grails.plugins.zkui.AbstractTagLib

class FisheyeTagLib extends AbstractTagLib {
    static namespace = "z"

    def fisheye = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zkex.zul.Fisheye
    }
}