package org.grails.plugins.zkui.supplementary

import org.grails.plugins.zkui.AbstractTagLib

class CellTagLib extends AbstractTagLib {
    static namespace = "z"

    def cell = {attrs, b ->
        //just for Intellij IDEA coding assistance
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Cell
    }
}
