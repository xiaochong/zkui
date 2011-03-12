package org.grails.plugins.zkui.essential.menu

import org.grails.plugins.zkui.AbstractTagLib

class MenuPopupTagLib extends AbstractTagLib {
    static namespace = "z"

    def menupopup = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Menupopup
    }

}
