package org.grails.plugins.zkui.util

import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.event.CreateEvent
import org.zkoss.zk.ui.event.Events
import org.zkoss.zk.ui.metainfo.ComponentDefinition
import org.zkoss.zk.ui.metainfo.LanguageDefinition
import org.zkoss.zk.ui.metainfo.Property
import org.zkoss.zul.Constraint

class ComponentUtil {
    static Class getComponentClass(String tagName, String languageName) {
        LanguageDefinition languageDefinition = LanguageDefinition.lookup(languageName)
        ComponentDefinition compDefinition = languageDefinition.getComponentDefinition(tagName)
        return compDefinition.resolveImplementationClass(null, null)
    }

    static def sendOnCreateEvent(Component component) {
        if (Events.isListened(component, Events.ON_CREATE, false)) {
            Events.postEvent(new CreateEvent(Events.ON_CREATE, component, Executions.getCurrent().getArg()))
        }
    }

    static def setAttr(Component component, String attrName, value, contextPath) {
        def attrType = component.metaClass.getMetaProperty(attrName)?.type
        if (attrType?.isPrimitive() || attrType in String || attrType in Number || attrType in Boolean || attrType in Character || attrType in Constraint || attrType == null) {
            value = ZkUriHandler.handle(component, attrName, value, contextPath)
            if (value != null) Property.assign(component, attrName, value.toString())
        } else {
            component[attrName] = value
        }
    }
}
