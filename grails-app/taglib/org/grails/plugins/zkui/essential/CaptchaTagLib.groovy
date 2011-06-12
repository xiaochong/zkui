package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class CaptchaTagLib extends AbstractTagLib {
    static namespace = "z"

    def captcha = {attrs, b ->
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zul.Captcha
    }
}