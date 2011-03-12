package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class LabelTagLib extends AbstractTagLib {
    static namespace = "z"

    /**
     * A Label
     */
    def label = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Label
    }

}
