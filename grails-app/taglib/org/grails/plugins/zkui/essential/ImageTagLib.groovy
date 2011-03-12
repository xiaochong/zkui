package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class ImageTagLib extends AbstractTagLib {
    static namespace = "z"

    def image = {attrs, b ->
        String contextPath = servletContext.contextPath
        if (attrs.src?.startsWith(contextPath)) {
            attrs.src = attrs.src.toString().replaceFirst(contextPath, '')
        }
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Image
    }

}
