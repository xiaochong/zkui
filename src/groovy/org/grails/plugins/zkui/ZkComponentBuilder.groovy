package org.grails.plugins.zkui

import org.zkoss.util.resource.Locators
import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.event.EventListener
import org.zkoss.zk.ui.metainfo.LanguageDefinition
import org.zkoss.zk.ui.metainfo.PageDefinition

class ZkComponentBuilder extends BuilderSupport {
    Component parentComponent
    PageDefinition pageDefinition
    LanguageDefinition languageDefinition

    ZkComponentBuilder(Component parent) {
        this.parentComponent = parent
    }

    @Override protected void setParent(Object parent, Object child) {
        child.parent = parent
    }

    @Override protected Object createNode(Object name) {
        if (name == 'build') {
            return parentComponent
        } else {
            return handle(name.toString(), [:])
        }
    }

    @Override protected Object createNode(Object name, Object value) {
        return handle(name.toString(), [:])
    }

    @Override protected Object createNode(Object name, Map attributes) {
        return handle(name.toString(), attributes)
    }

    @Override protected Object createNode(Object name, Map attributes, Object value) {
        return handle(name.toString(), attributes)
    }


    private Component handle(String name, Map attributes) {
        if (!languageDefinition) languageDefinition = LanguageDefinition.lookup(null)
        def compDefinition = languageDefinition.getComponentDefinitionIfAny(name)
        if (!compDefinition) {
            if (!pageDefinition) pageDefinition = new PageDefinition(languageDefinition, Locators.default)
            compDefinition = pageDefinition.getComponentDefinition(name, true)
        }
        Class cls = compDefinition.resolveImplementationClass(null, null)
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
            } else {
                instance[attrName] = value
            }
        }
        return instance
    }

}
