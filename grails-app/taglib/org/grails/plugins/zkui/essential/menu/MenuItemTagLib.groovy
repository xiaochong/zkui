package org.grails.plugins.zkui.essential.menu

import org.grails.plugins.zkui.AbstractTagLib

class MenuItemTagLib extends AbstractTagLib {
    static namespace = "z"

    def menuitem = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Menuitem
    }

}
