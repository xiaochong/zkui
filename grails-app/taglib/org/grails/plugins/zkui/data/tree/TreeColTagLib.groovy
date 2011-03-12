package org.grails.plugins.zkui.data.tree

import org.grails.plugins.zkui.AbstractTagLib

class TreeColTagLib extends AbstractTagLib {
    static namespace = "z"

    def treecol = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Treecol
    }

}