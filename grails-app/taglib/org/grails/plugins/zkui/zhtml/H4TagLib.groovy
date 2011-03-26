package org.grails.plugins.zkui.zhtml

import org.grails.plugins.zkui.AbstractTagLib

class H4TagLib extends AbstractTagLib {
    static namespace = "h"

    def h4 = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zhtml.H4
    }
}
