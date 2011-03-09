package org.grails.plugins.zkui.container

import org.grails.plugins.zkui.AbstractTagLib

class SpanTagLib extends AbstractTagLib {
    static namespace = "z"

    def span = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Span
    }
}
