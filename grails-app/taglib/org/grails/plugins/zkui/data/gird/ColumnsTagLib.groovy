package org.grails.plugins.zkui.data.gird

import org.grails.plugins.zkui.AbstractTagLib

class ColumnsTagLib extends AbstractTagLib {
    static namespace = "z"

    def columns = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Columns
    }
}
