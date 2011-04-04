package org.grails.plugins.zkui.jsoup.helper

import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.metainfo.Property

class ComponentUtil {
    static boolean hasAttr(Component comp, String key) {
        String keyMethod = "get${key?.capitalize()}"
        if (comp.metaClass.respondsTo(comp, keyMethod) &&
                comp.metaClass.getMetaMethod(keyMethod).invoke(comp) != null) {
            return true
        }
        return false
    }

    static String attr(Component comp, String key) {
        return comp."${key}".toString()
    }

    static Component removeAttr(Component comp, String attributeKey) {
        //todo
    }

    static Component addClass(Component comp, String className) {
        //todo
    }

    static Component removeClass(Component comp, String className) {
        //todo
    }

    static Component toggleClass(Component comp, String className) {
        //todo
    }

    static boolean hasClass(Component comp, String className) {
        //todo
    }

    static val(Component comp) {
        return comp.value
    }

    static val(Component comp, String value) {
        Property.assign(comp, "value", value.toString())
    }

    static String attr(Component comp, String attributeKey, String attributeValue) {
        return comp[attributeKey] = attributeValue
    }

    static Integer elementSiblingIndex(Component comp) {
        if (!comp.parent) return 0
        List<Component> elements = comp.parent.children
        Validate.notNull(comp)
        Validate.notNull(elements)
        for (int i = 0; i < elements.size(); i++) {
            Component element = elements.get(i)
            if (element.equals(comp))
                return i
        }
        return null
    }

    static boolean attributeStarting(Component comp, String keyPrefix) {
        def values = comp.metaClass.methods.findAll {
            return it.name.startsWith("get") && it.getParameterTypes().length == 0 &&
                    (it.returnType.primitive || it.returnType == String)
        }
        for (attribute in values) {
            def methodName = "get${keyPrefix.capitalize()}"
            if (attribute.name.startsWith(methodName) && attribute.invoke(comp) != null)
                return true
        }
        return false
    }

    static boolean attribute(Component comp, String key) {

        return comp.metaClass.methods.any {
            it.name == "get${key.capitalize()}" && it.getParameterTypes().length == 0 &&
                    (it.returnType.primitive || it.returnType == String) && it.invoke(comp) != null
        }
    }
}
