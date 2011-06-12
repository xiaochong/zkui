package org.grails.plugins.zkui.diagrams

import org.grails.plugins.zkui.AbstractTagLib

class JasperreportTagLib extends AbstractTagLib {
    static namespace = "z"

    def jasperreport = {attrs, b ->
        attrs.src = attrs.src?.fixToZkUri(request.getContextPath())
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zkex.zul.Jasperreport
    }
}
