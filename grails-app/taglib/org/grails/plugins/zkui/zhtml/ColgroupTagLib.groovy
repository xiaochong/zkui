package org.grails.plugins.zkui.zhtml

import org.grails.plugins.zkui.AbstractTagLib

class ColgroupTagLib extends AbstractTagLib {
    static namespace = "h"

    def colgroup = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zhtml.Colgroup
    }
}
