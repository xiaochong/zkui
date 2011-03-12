package org.grails.plugins.zkui.data.tree

import org.grails.plugins.zkui.AbstractTagLib

class TreeRowTagLib extends AbstractTagLib {
    static namespace = "z"

    def treerow = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Treerow
    }

}
