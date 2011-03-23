package org.grails.plugins.zkui.supplementary

import org.grails.plugins.zkui.AbstractTagLib

class FrozenTagLib extends AbstractTagLib {
    static namespace = "z"

    def frozen = {attrs, b ->
        //just for Intellij IDEA coding assistance
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Frozen
    }
}
