package org.grails.plugins.zkui.util

import org.zkoss.zk.ui.Component

class ZkUriHandler {
    /**
     *
     * @param component the zk Component
     * @param attrName Component attribute name
     * @param value
     * @return the processed value
     */
    static Object handle(Component component, String attrName, Object value, String contextPath) {
        if (value && handleAttrList.contains(attrName)) {
            if (component.metaClass.getMetaMethod('set' + attrName.capitalize(), [String] as Object[])) {
                def uri = value.toString()
                if (uri.startsWith(contextPath)) return uri.replaceFirst(contextPath, "")
            }
        }
        return value
    }

    static List<String> handleAttrList = ['src', 'href', 'image'].asImmutable()
}
