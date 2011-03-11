package org.grails.plugins.zkui

import org.zkoss.zk.ui.Component
import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.zkoss.zk.ui.metainfo.Property
import org.zkoss.zul.Html

abstract class AbstractTagLib {

    void doTag(attrs, body, ServletContext servletContext, HttpServletRequest request,
               HttpServletResponse response, Binding pageScope, Writer out) {
        def composeHandle = new ComposerHandler(attrs.remove("apply"))
        if (!pageScope.variables.containsKey("parent")) pageScope.parent = new LinkedList<Component>()
        Component component = (Component) componentClass.newInstance()
        composeHandle.doBeforeComposeChildren(component)
        pageScope.parent.push(component)
        if (pageScope.parent.size() > 1) pageScope.parent[pageScope.parent.size() - 2].appendChild(component)
        attrs.each {attrName, value -> Property.assign(component, attrName, value)}
        String content = body.call()
        if (content && !content.allWhitespace) component.appendChild(new Html(content))
        composeHandle.doAfterCompose(component)
        if (pageScope.parent.size() == 1) {
            Renders.render(servletContext, request, response, (Component) pageScope.parent.remove(), null, out)
        } else {
            pageScope.parent.pop()
        }
    }

    abstract Class getComponentClass()
}
