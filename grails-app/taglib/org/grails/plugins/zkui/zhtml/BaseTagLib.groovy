package org.grails.plugins.zkui.zhtml

import org.grails.plugins.zkui.AbstractTagLib

class BaseTagLib extends AbstractTagLib {
    static namespace = "h"

    def base = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zhtml.Base
    }
}
