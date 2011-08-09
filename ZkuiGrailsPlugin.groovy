import org.springframework.web.context.request.RequestContextHolder as RCH

import org.codehaus.groovy.grails.commons.DomainClassArtefactHandler
import org.codehaus.groovy.grails.commons.GrailsClassUtils
import org.codehaus.groovy.grails.web.metaclass.BindDynamicMethod
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.pages.TagLibraryLookup
import org.codehaus.groovy.grails.web.util.TypeConvertingMap
import org.grails.plugins.zkui.artefacts.ComposerArtefactHandler
import org.grails.plugins.zkui.jsoup.select.Selector
import org.grails.plugins.zkui.metaclass.RedirectDynamicMethod
import org.grails.plugins.zkui.util.UriUtil
import org.zkoss.zk.ui.Executions
import org.zkoss.zul.impl.InputElement

class ZkuiGrailsPlugin {
    // the plugin version
    def version = "0.3.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.2 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]

    def loadAfter = ['core', 'hibernate', 'controllers']

    def artefacts = [
            org.grails.plugins.zkui.artefacts.ComposerArtefactHandler
    ]

    def watchedResources = [
            "file:./grails-app/composers/**/*Composer.groovy",
            "file:./plugins/*/grails-app/composers/**/*Composer.groovy"]

    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp",
            "src/docs/**",
            "scripts/_Events.groovy",
            "web-app/**"
    ]

    // TODO Fill in these fields
    def author = "groovyquan"
    def authorEmail = "groovyquan[at]gmail[dot]com"
    def title = "ZK UI Plugin for Grails"
    def description = '''\\
ZK UI plugin,the same as the ZKGrails plugin, seamlessly integrates ZK with Grails' infrastructures.
The different is it more likely to use the Grails' infrastructures such as gsp, controllers rather than zk's zul.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/zkui"

    static final String GOSIV_CLASS =
    "org.grails.plugins.zkui.ZkuiGrailsOpenSessionInViewFilter"

    def doWithWebDescriptor = { webXml ->
        def listenerElement = webXml.'listener'
        def lastListener = listenerElement[listenerElement.size() - 1]
        lastListener + {
            'listener' {
                'description'("ZK listener for cleanup when a session is destroyed")
                'listener-class'("org.zkoss.zk.ui.http.HttpSessionListener")
            }
        }

        def servletElement = webXml.'servlet'
        def lastServlet = servletElement[servletElement.size() - 1]
        lastServlet + {
            'servlet' {
                'servlet-name'("auEngine")
                'servlet-class'("org.zkoss.zk.au.http.DHtmlUpdateServlet")
            }
        }

        def mappingElement = webXml.'servlet-mapping'
        def lastMapping = mappingElement[mappingElement.size() - 1]
        lastMapping + {
            'servlet-mapping' {
                'servlet-name'("auEngine")
                'url-pattern'("/zkau/*")
            }
        }

        // adding GrailsOpenSessionInView
        if (manager?.hasGrailsPlugin("hibernate")) {
            def filterElement = webXml.'filter'[0]
            filterElement + {
                'filter' {
                    'filter-name'("GOSIVFilter")
                    'filter-class'(GOSIV_CLASS)
                }
            }
            // filter for each ZK urls
            def filterMappingElement = webXml.'filter-mapping'[0]
            filterMappingElement + {
                'filter-mapping' {
                    'filter-name'("GOSIVFilter")
                    'url-pattern'("/zkau")
                }
            }
        }
    }

    def doWithSpring = {
        "webManagerInit"(org.grails.plugins.zkui.WebManagerInit)
        "zkComponentBuilder"(org.grails.plugins.zkui.ZkComponentBuilder) { bean ->
            bean.scope = "prototype"
        }
        application.composerClasses.each { composerClass ->
            "${composerClass.clazz.name}"(composerClass.clazz) { bean ->
                bean.scope = "prototype"
                bean.autowire = "byName"
            }
        }
    }


    def doWithDynamicMethods = { ctx ->
        //Inject taglib namespace to Composer
        TagLibraryLookup gspTagLibraryLookup = ctx.getBean("gspTagLibraryLookup")

        CharSequence.metaClass.fixToZkUri = {String contextPath ->
            return UriUtil.fixToZk(delegate?.toString(), contextPath)
        }

        org.zkoss.zk.ui.Component.metaClass.appendChild = {Closure closure ->
            def builder = ctx.getBean('zkComponentBuilder')
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
            return delegate.select("[name]").inject(new TypeConvertingMap()) {s, c ->
                def e = s.get(c.name)
                def value
                if (c instanceof org.zkoss.zul.Combobox) {
                    value = c.selectedItem?.value
                } else if (c instanceof org.zkoss.zul.Checkbox) {
                    value = c.value ?: c.isChecked()
                } else if (c instanceof org.zkoss.zul.Listbox) {
                    value = c.getSelectedItems()?.value as String[]
                } else {
                    value = c.value
                }
                if (e == null) {
                    s.put(c.name, value)
                } else if (e instanceof Collection) {
                    e << value
                } else {
                    s.put(c.name, [s.remove(c.name), value])
                }
                return s
            }
        }

        def gDispatcher = gspTagLibraryLookup.lookupNamespaceDispatcher(GroovyPage.DEFAULT_NAMESPACE)
        org.zkoss.zk.ui.Component.metaClass.renderErrors = {Map args ->
            if (!args.bean) {
                throw new IllegalArgumentException("[bean] attribute must be specified!")
            }
            if (!application.isArtefactOfType(DomainClassArtefactHandler.TYPE, args.bean.class)) {
                throw new IllegalArgumentException("[bean] attribute must be Domain class!")
            }
            args.bean.errors.fieldErrors.each {
                def selectedComponentList = delegate.select("[name=${it.field}]")
                String errorMessage = gDispatcher.message(error: it)
                if (selectedComponentList.size() > 0 && selectedComponentList[0] instanceof InputElement) {
                    selectedComponentList[0].setErrorMessage(errorMessage)
                } else {
                    log.info(errorMessage)
                }
            }
        }

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

        def redirect = new RedirectDynamicMethod(ctx)
        def redirectObject = {Map args ->
            redirect.invoke(delegate, "redirect", args)
        }
        def bind = new BindDynamicMethod()
        def paramsObject = {-> RCH.currentRequestAttributes().params }
        def executionObject = {-> Executions.current }
        def sessionObject = {-> Executions.current.session }
        if (manager?.hasGrailsPlugin("controllers")) {
            for (namespace in gspTagLibraryLookup.availableNamespaces) {
                def propName = GrailsClassUtils.getGetterName(namespace)
                def namespaceDispatcher = gspTagLibraryLookup.lookupNamespaceDispatcher(namespace)
                def composerClasses = application.composerClasses*.clazz
                for (Class composerClass in composerClasses) {
                    MetaClass mc = composerClass.metaClass
                    if (!mc.getMetaProperty(namespace)) {
                        mc."$propName" = { namespaceDispatcher }
                    }
                }
            }
            def composerClasses = application.composerClasses*.clazz
            for (Class composerClass in composerClasses) {
                MetaClass mc = composerClass.metaClass
                mc.redirect = redirectObject
                mc.getSession = sessionObject
                mc.getExecution = executionObject
                mc.getParams = paramsObject
                // the bindData method
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
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
        if (application.isArtefactOfType(ComposerArtefactHandler.TYPE, event.source)) {
            def context = event.ctx
            if (!context) {
                if (log.isDebugEnabled())
                    log.debug("Application context not found. Can't reload")
                return
            }
            def composerClass = application.addArtefact(ComposerArtefactHandler.TYPE, event.source)
            def composerBeanName = composerClass.clazz.name

            def beans = beans {
                "${composerBeanName}"(composerClass.clazz) { bean ->
                    bean.scope = "prototype"
                    bean.autowire = "byName"
                }
            }
            beans.registerBeans(event.ctx)
        }

        event.manager?.getGrailsPlugin("zkui")?.doWithDynamicMethods(event.ctx)

    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
