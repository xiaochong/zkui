package org.grails.plugins.zkui.zhtml

import org.grails.plugins.zkui.AbstractTagLib

class NobrTagLib extends AbstractTagLib {
    static namespace = "h"

    def nobr = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zhtml.Nobr
    }
}
