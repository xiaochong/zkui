package org.grails.plugins.zkui.data.gird

import org.grails.plugins.zkui.AbstractTagLib

class RowsTagLib extends AbstractTagLib {
    static namespace = "z"

    def rows = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Rows
    }
}
