package org.grails.plugins.zkui.diagrams.timeline

import org.grails.plugins.zkui.AbstractTagLib

class TimelineTagLib extends AbstractTagLib {
    static namespace = "z"

    def timeline = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkforge.timeline.Timeline
    }
}
