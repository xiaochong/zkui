package grails.test

import org.codehaus.groovy.grails.plugins.testing.GrailsMockHttpServletRequest
import org.codehaus.groovy.grails.web.metaclass.BindDynamicMethod
import org.codehaus.groovy.grails.web.util.TypeConvertingMap
import org.grails.plugins.zkui.ZkComponentBuilder
import org.grails.plugins.zkui.util.UriUtil
import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.select.Selectors

class ComposerMockUtils {

    static void mockComponent() {
        CharSequence.metaClass.fixToZkUri = {String contextPath ->
            return UriUtil.fixToZk(delegate?.toString(), contextPath)
        }

        org.zkoss.zk.ui.Component.metaClass.appendChild = {Closure closure ->
            def builder = new ZkComponentBuilder()
            def mockRequest = new GrailsMockHttpServletRequest()
            builder.servletContext = mockRequest.servletContext
            closure.resolveStrategy = Closure.DELEGATE_FIRST
            builder.build(delegate, closure)
        }
        org.zkoss.zk.ui.Component.metaClass.leftShift = {Object value ->
            delegate.appendChild(value)
        }
        org.zkoss.zk.ui.Component.metaClass.select = {String query ->
            return Selectors.find((Component) delegate, query)
        }
        org.zkoss.zk.ui.Component.metaClass.addEventListener = {String eventName, Closure listenerClosure ->
            return delegate.addEventListener(eventName, listenerClosure as org.zkoss.zk.ui.event.EventListener)
        }
        org.zkoss.zk.ui.Component.metaClass.getParams = {
            return delegate.select("*").inject([:]) {s, c ->
                if (!c.metaClass.respondsTo(c, 'getName')) return s
                if (c.name == null) return s
                def e = s.get(c.name)
                def value
                if (c instanceof org.zkoss.zul.Combobox) {
                    value = c.selectedItem?.value
                } else if (c instanceof org.zkoss.zul.Checkbox) {
                    value = c.value ?: c.isChecked()
                } else if (c instanceof org.zkoss.zul.Listbox) {
                    value = c.getSelectedItems()?.value
                } else if (c instanceof org.zkoss.zul.Radiogroup) {
                    return s
                } else if (c.metaClass.respondsTo(c, 'getValue')) {
                    value = c.value
                } else {
                    return s
                }
                if (value == null) {
                    value = ''
                }
                if (e == null) {
                    s.put(c.name, value)
                } else if (e instanceof Collection) {
                    e << value
                } else {
                    s.put(c.name, [s.remove(c.name), value])
                }
                return s
            }.inject(new TypeConvertingMap()) {s, e ->
                if (e instanceof Collection) {
                    s.put(e.key, e.value as String[])
                } else {
                    s.put(e.key, e.value)
                }
                return s
            }
        }
    }

    static void mockSession() {
        org.zkoss.zk.ui.Session.metaClass.getAt = { String name ->
            delegate.getAttribute(name)
        }

        org.zkoss.zk.ui.Session.metaClass.putAt = { String name, value ->
            delegate.setAttribute(name, value)
        }

        org.zkoss.zk.ui.Execution.metaClass.getAt = { String name ->
            delegate.getAttribute(name)
        }

        org.zkoss.zk.ui.Execution.metaClass.putAt = { String name, value ->
            delegate.setAttribute(name, value)
        }
    }

    static void mockComposer(Class clazz) {
        MetaClass mc = clazz.metaClass
        def redArgs = [:]
        mc.getRedirectArgs = {-> redArgs}
        mc.redirect = {Map map -> redirectArgs.putAll(map)}
        mc.getParams = {-> [:] }
        // the flash object
        mc.getFlash = {-> [:] }

        // the bindData method
        def bind = new BindDynamicMethod()
        mc.bindData = {Object target, Object args ->
            bind.invoke(delegate, BindDynamicMethod.METHOD_SIGNATURE, [target, args] as Object[])
        }
        mc.bindData = {Object target, Object args, List disallowed ->
            bind.invoke(delegate, BindDynamicMethod.METHOD_SIGNATURE, [target, args, [exclude: disallowed]] as Object[])
        }
        mc.bindData = {Object target, Object args, List disallowed, String filter ->
            bind.invoke(delegate, BindDynamicMethod.METHOD_SIGNATURE, [target, args, [exclude: disallowed], filter] as Object[])
        }
        mc.bindData = {Object target, Object args, Map includeExclude ->
            bind.invoke(delegate, BindDynamicMethod.METHOD_SIGNATURE, [target, args, includeExclude] as Object[])
        }
        mc.bindData = {Object target, Object args, Map includeExclude, String filter ->
            bind.invoke(delegate, BindDynamicMethod.METHOD_SIGNATURE, [target, args, includeExclude, filter] as Object[])
        }
        mc.bindData = {Object target, Object args, String filter ->
            bind.invoke(delegate, BindDynamicMethod.METHOD_SIGNATURE, [target, args, filter] as Object[])
        }
    }
}
