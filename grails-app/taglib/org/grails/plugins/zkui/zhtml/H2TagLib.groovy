package org.grails.plugins.zkui.zhtml

import org.grails.plugins.zkui.AbstractTagLib

class H2TagLib extends AbstractTagLib {
    static namespace = "h"

    def h2 = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zhtml.H2
    }
}
