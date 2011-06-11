package grails.test

import org.codehaus.groovy.grails.plugins.testing.GrailsMockHttpServletRequest
import org.codehaus.groovy.grails.web.metaclass.BindDynamicMethod
import org.grails.plugins.zkui.ZkComponentBuilder
import org.grails.plugins.zkui.jsoup.select.Selector
import org.grails.plugins.zkui.util.UriUtil

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
            return Selector.select(query, delegate)
        }
        org.zkoss.zk.ui.Component.metaClass.addEventListener = {String eventName, Closure listenerClosure ->
            return delegate.addEventListener(eventName, listenerClosure as org.zkoss.zk.ui.event.EventListener)
        }
        org.zkoss.zk.ui.Component.metaClass.getParams = {
            return delegate.select("[name]").inject([:]) {s, c ->
                def e = s.get(c.name)
                if (e == null) {
                    s.put(c.name, c.value)
                } else if (e instanceof Collection) {
                    e << c.value
                } else {
                    s.put(c.name, [s.remove(c.name), c.value])
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
