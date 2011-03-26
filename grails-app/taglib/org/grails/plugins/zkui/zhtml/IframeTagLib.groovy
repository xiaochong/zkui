package org.grails.plugins.zkui.zhtml

import org.grails.plugins.zkui.AbstractTagLib

class IframeTagLib extends AbstractTagLib {
    static namespace = "h"

    def iframe = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zhtml.Iframe
    }
}
