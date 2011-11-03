package org.grails.plugins.zkui.util

import java.util.Map.Entry
import org.codehaus.groovy.grails.web.util.StreamCharBuffer
import org.zkoss.lang.reflect.Fields
import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.event.CreateEvent
import org.zkoss.zk.ui.event.Events
import org.zkoss.zk.ui.ext.DynamicPropertied
import org.zkoss.zk.ui.metainfo.ComponentDefinition
import org.zkoss.zk.ui.metainfo.LanguageDefinition
import org.zkoss.zk.ui.metainfo.Property
import org.zkoss.zk.ui.metainfo.impl.AnnotationHelper

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
        value = ZkUriHandler.handle(component, attrName, value, contextPath)
        evaluateDynaAttribute(component, attrName, value)
    }

    static def evaluateDynaAttributes(Component target, Map attrs) {
        for (Iterator itor = attrs.entrySet().iterator(); itor.hasNext();) {
            Map.Entry entry = (Entry) itor.next();
            String attnm = (String) entry.getKey();
            Object value = entry.getValue();
            evaluateDynaAttribute(target, attnm, value);
        }
    }

    static def evaluateDynaAttribute(Component target, String attnm, Object value) {
        if (value == null) return
        if (value instanceof String || value instanceof StreamCharBuffer) {
            String attval = value.toString();
            // test if this attribute is an annotation...
            if (isAnnotation(attval)) { //annotation
                AnnotationHelper helper = new AnnotationHelper();
                helper.addByCompoundValue(attval);
                helper.applyAnnotations(target, "self".equals(attnm) ? null : attnm, true);
            }
            else if (target.getDefinition().isMacro())
                ((DynamicPropertied) target).setDynamicProperty(attnm, value);
            else Property.assign(target, attnm, value.toString());
        } else if (target.getDefinition().isMacro())
            ((DynamicPropertied) target).setDynamicProperty(attnm, value);
        else Fields.setByCompound(target, attnm, value, true);
    }

    static boolean isAnnotation(String attval) {
        return attval.startsWith('@');
    }
}
