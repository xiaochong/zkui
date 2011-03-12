package org.grails.plugins.zkui.data.tree

import org.grails.plugins.zkui.AbstractTagLib

class TreeFootTagLib extends AbstractTagLib {
    static namespace = "z"

    def treefoot = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Treefoot
    }

}
