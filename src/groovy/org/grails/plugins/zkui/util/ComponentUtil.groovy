package org.grails.plugins.zkui.util

import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.event.CreateEvent
import org.zkoss.zk.ui.event.Events
import org.zkoss.zk.ui.metainfo.ComponentDefinition
import org.zkoss.zk.ui.metainfo.LanguageDefinition

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
}
