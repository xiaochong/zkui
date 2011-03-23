package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class HtmlTagLib extends AbstractTagLib {
    static namespace = "z"

    def html = {attrs, b ->
        //just for Intellij IDEA coding assistance
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Html
    }
}
