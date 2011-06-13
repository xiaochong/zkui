package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class CaptchaTagLib extends AbstractTagLib {
    static namespace = "z"

    def captcha = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.height || attrs.bgColor || attrs.engine || attrs.fontColor || attrs.exclude || attrs.noise || attrs.length || attrs.value || attrs.width || attrs.frame || attrs.border || attrs.align || attrs.src || attrs.hspace || attrs.vspace || attrs.hover || attrs.border || attrs.context || attrs.ctrlKeys || attrs.popup || attrs.tooltip || attrs.class || attrs.left || attrs.top || attrs.zIndex || attrs.zindex || attrs.tooltiptext || attrs.zclass || attrs.sclass || attrs.draggable || attrs.droppable || attrs.focus || attrs.renderdefer || attrs.vflex || attrs.hflex || attrs.style || attrs.action || attrs.widgetClass || attrs.id || attrs.stubonly || attrs.mold || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    Class getComponentClass() {
        return org.zkoss.zul.Captcha
    }
}