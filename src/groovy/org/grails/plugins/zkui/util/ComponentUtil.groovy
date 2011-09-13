package org.grails.plugins.zkui.util

import org.zkoss.zk.ui.metainfo.ComponentDefinition
import org.zkoss.zk.ui.metainfo.LanguageDefinition

class ComponentUtil {
    static Class getComponentClass(String tagName, String languageName) {
        LanguageDefinition languageDefinition = LanguageDefinition.lookup(languageName)
        ComponentDefinition compDefinition = languageDefinition.getComponentDefinition(tagName)
        return compDefinition.resolveImplementationClass(null, null)
    }
}
