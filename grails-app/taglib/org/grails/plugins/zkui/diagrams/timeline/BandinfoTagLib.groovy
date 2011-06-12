package org.grails.plugins.zkui.diagrams.timeline

import org.grails.plugins.zkui.AbstractTagLib

class BandinfoTagLib extends AbstractTagLib {
    static namespace = "z"

    def bandinfo = {attrs, b ->
        attrs.eventSourceUrl = attrs.eventSourceUrl?.fixToZkUri(request.getContextPath())
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkforge.timeline.Bandinfo
    }
}