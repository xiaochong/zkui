package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class ToolbarButtonTagLib extends AbstractTagLib {
    static namespace = "z"

    def toolbarbutton = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Toolbarbutton
    }

}
