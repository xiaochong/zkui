package org.grails.plugins.zkui

import javax.servlet.ServletContext
import org.grails.plugins.zkui.util.ComponentUtil
import org.springframework.web.context.ServletContextAware
import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.event.EventListener

class ZkComponentBuilder extends BuilderSupport implements ServletContextAware {
    ServletContext servletContext
    Component parentComponent

    protected void setParent(Object parent, Object child) {
        child.parent = parent
    }

    protected Object createNode(Object name) {
        return handle(name.toString(), [:])
    }

    protected Object createNode(Object name, Object value) {
        if (name == 'build' && value instanceof Component) {
            this.parentComponent = value
            return value
        } else {
            return handle(name.toString(), [:])
        }
    }

    protected Object createNode(Object name, Map attributes) {
        return handle(name.toString(), attributes)
    }

    protected Object createNode(Object name, Map attributes, Object value) {
        return handle(name.toString(), attributes)
    }

    private Component handle(String name, Map attributes) {
        Class cls = ComponentUtil.getComponentClass(name, null)
        Component instance = (Component) cls.newInstance()
        attributes.each {String attrName, Object value ->
            if (attrName =~ /^on[A-Z]\w+/) {
                if (value instanceof Closure) {
                    // If listener is a closure then it's a server side listener
                    // e.g. onClick { event -> doSomethingWithEvent }
                    instance.addEventListener(attrName, value as EventListener)
                } else if (value instanceof String) {
                    // If listener is a String then it's a client side listener
                    // e.g. onClick: "alert('Say hi from JS');"
                    instance.setWidgetListener(attrName, value)
                }
            } else if (attrName.startsWith("client_")) {
                instance.setWidgetListener(attrName.toString().replaceFirst("client_", ''), value.toString())
            } else {
                ComponentUtil.setAttr(instance, attrName, value, servletContext.contextPath)
            }
        }
        ComponentUtil.sendOnCreateEvent(instance)
        return instance
    }

    void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext
    }
}
