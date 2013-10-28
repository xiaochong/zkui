import org.codehaus.groovy.grails.commons.DomainClassArtefactHandler
import org.codehaus.groovy.grails.commons.GrailsClassUtils
import org.codehaus.groovy.grails.web.metaclass.BindDynamicMethod
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.pages.TagLibraryLookup
import org.codehaus.groovy.grails.web.util.TypeConvertingMap
import org.grails.plugins.zkui.artefacts.composer.ComposerArtefactHandler
import org.grails.plugins.zkui.artefacts.vm.ViewModelArtefactHandler
import org.grails.plugins.zkui.metaclass.RedirectDynamicMethod
import org.grails.plugins.zkui.util.ComponentErrorRendererUtil
import org.grails.plugins.zkui.util.UriUtil
import org.springframework.web.context.request.RequestContextHolder as RCH
import org.zkoss.lang.Library
import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.Page
import org.zkoss.zk.ui.select.Selectors
import org.zkoss.zul.Messagebox
import org.zkoss.zul.impl.InputElement

class ZkuiGrailsPlugin {
    // the plugin version
    def version = "0.5.7"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.2 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]

    def loadAfter = ['core', 'hibernate', 'controllers']

    def artefacts = [
            ComposerArtefactHandler, ViewModelArtefactHandler
    ]

    def watchedResources = [
            "file:./grails-app/composers/**/*Composer.groovy",
            "file:./plugins/*/grails-app/composers/**/*Composer.groovy",
            "file:./grails-app/vms/**/*VM.groovy",
            "file:./plugins/*/grails-app/vms/**/*VM.groovy"
    ]

    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp",
            "src/docs/**",
            "scripts/_Events.groovy",
            "web-app/**",
            "gen/**"
    ]

    def author = "groovyquan"
    def authorEmail = "groovyquan@gmail.com"
    def title = "Grails ZK UI Plugin"
    def description = '''\
ZK UI plugin,the same as the ZKGrails plugin, seamlessly integrates ZK with Grails' infrastructures.
The different is it more likely to use the Grails' infrastructures such as gsp, controllers rather than zk's zul.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/zkui"

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "LGPL"

    // Location of the plugin's issue tracker.
    def issueManagement = [system: "github", url: "https://github.com/xiaochong/zkui/issues"]

    // Online location of the plugin's browseable source code.
    def scm = [url: "https://github.com/xiaochong/zkui/"]

    static final String GOSIV_CLASS = "org.grails.plugins.zkui.ZkuiGrailsOpenSessionInViewFilter"

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
        "composerHandler"(org.grails.plugins.zkui.ComposerHandler) { bean ->
            bean.scope = "prototype"
        }
        "zkComponentBuilder"(org.grails.plugins.zkui.ZkComponentBuilder) { bean ->
            bean.scope = "prototype"
        }
        "org.zkoss.bind.BindComposer"(org.grails.plugins.zkui.composer.BindComposer) { bean ->
            bean.scope = "prototype"
        }
        application.composerClasses.each { composerClass ->
            "${composerClass.clazz.name}"(composerClass.clazz) { bean ->
                bean.scope = "prototype"
                bean.autowire = "byName"
            }
        }
        application.viewModelClasses.each { viewModelClass ->
            "${viewModelClass.clazz.name}"(viewModelClass.clazz) { bean ->
                bean.scope = "prototype"
                bean.autowire = "byName"
            }
        }
    }

    def doWithDynamicMethods = { ctx ->
        //Inject taglib namespace to Composer
        TagLibraryLookup gspTagLibraryLookup = ctx.getBean("gspTagLibraryLookup")

        CharSequence.metaClass.fixToZkUri = { String contextPath ->
            return UriUtil.fixToZk(delegate?.toString(), contextPath)
        }

        org.zkoss.zk.ui.Component.metaClass.appendChild = { Closure closure ->
            def builder = ctx.getBean('zkComponentBuilder')
            closure.resolveStrategy = Closure.DELEGATE_FIRST
            builder.build(delegate, closure)
        }
        org.zkoss.zk.ui.Component.metaClass.leftShift = { Object value ->
            delegate.appendChild(value)
        }
        org.zkoss.zk.ui.Component.metaClass.select = { String query ->
            return Selectors.find((Component) delegate, query)
        }
        org.zkoss.zk.ui.Page.metaClass.select = { String query ->
            return Selectors.find((Page) delegate, query)
        }
        org.zkoss.zk.ui.Component.metaClass.addEventListener = { String eventName, Closure listenerClosure ->
            return delegate.addEventListener(eventName, listenerClosure as org.zkoss.zk.ui.event.EventListener)
        }
        org.zkoss.zk.ui.Component.metaClass.getParams = {
            return delegate.select("*").inject([:]) { s, c ->
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
            }.inject(new TypeConvertingMap()) { s, e ->
                if (e.value instanceof Collection) {
                    s.put(e.key, e.value as String[])
                } else {
                    s.put(e.key, e.value)
                }
                return s
            }
        }

        def gDispatcher = gspTagLibraryLookup.lookupNamespaceDispatcher(GroovyPage.DEFAULT_NAMESPACE)
        org.zkoss.zk.ui.Component.metaClass.renderErrors = { Map args ->
            if (!args.bean) {
                throw new IllegalArgumentException("[bean] attribute must be specified!")
            }
            if (!application.isArtefactOfType(DomainClassArtefactHandler.TYPE, args.bean.class)) {
                throw new IllegalArgumentException("[bean] attribute must be Domain class!")
            }
            def domainClass = application.getDomainClass(args.bean.class.name)
            args.bean.errors.fieldErrors.each {
                def p = domainClass.getPropertyByName(it.field)
                def name
                if (p.manyToOne || p.oneToOne) {
                    name = "${p.referencedDomainClass.propertyName}.id"
                } else {
                    name = it.field
                }
                def selectedComponentList = delegate.select("[name='${name}']")
                String errorMessage = gDispatcher.message(error: it)
                if (selectedComponentList.size() > 0 && selectedComponentList[0] instanceof InputElement) {
                    selectedComponentList[0].setErrorMessage(errorMessage)
                } else {
                    //todo the remaining errorMessage
                }
            }
        }

        ComponentErrorRendererUtil errorRendererUtil = new ComponentErrorRendererUtil()

        errorRendererUtil.addRenderMapAsErrors()

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

        Messagebox.metaClass.static.show = { int messageCode, int titleCode, int buttons, java.lang.String icon, int focus, Closure listener ->
            Messagebox.show(messageCode, titleCode, buttons, icon, focus, listener as org.zkoss.zk.ui.event.EventListener)
        }
        Messagebox.metaClass.static.show = { int messageCode, java.lang.Object[] args, int titleCode, int buttons, String icon, int focus, Closure listener ->
            Messagebox.show(messageCode, args, titleCode, buttons, icon, focus, listener as org.zkoss.zk.ui.event.EventListener)
        }
        Messagebox.metaClass.static.show = { int messageCode, java.lang.Object arg, int titleCode, int buttons, java.lang.String icon, int focus, Closure listener ->
            Messagebox.show(messageCode, arg, titleCode, buttons, icon, focus, listener as org.zkoss.zk.ui.event.EventListener)
        }
        Messagebox.metaClass.static.show = { String message, java.lang.String title, int buttons, String icon, Closure listener ->
            Messagebox.show(message, title, buttons, icon, listener as org.zkoss.zk.ui.event.EventListener)
        }
        Messagebox.metaClass.static.show = { String message, String title, int buttons, String icon, int focus, Closure listener ->
            Messagebox.show(message, title, buttons, icon, focus, listener as org.zkoss.zk.ui.event.EventListener)
        }

        def redirect = new RedirectDynamicMethod(ctx)
        def redirectObject = { Map args ->
            redirect.invoke(delegate, "redirect", args)
        }
        def bind = new BindDynamicMethod()
        def paramsObject = {-> RCH.currentRequestAttributes().params }
        def flashObject = {-> RCH.currentRequestAttributes().flashScope }
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
                // the flash object
                mc.getFlash = flashObject
                // the bindData method
                mc.bindData = { Object target, Object args ->
                    bind.invoke(delegate, BindDynamicMethod.METHOD_SIGNATURE, [target, args] as Object[])
                }
                mc.bindData = { Object target, Object args, List disallowed ->
                    bind.invoke(delegate, BindDynamicMethod.METHOD_SIGNATURE, [target, args, [exclude: disallowed]] as Object[])
                }
                mc.bindData = { Object target, Object args, List disallowed, String filter ->
                    bind.invoke(delegate, BindDynamicMethod.METHOD_SIGNATURE, [target, args, [exclude: disallowed], filter] as Object[])
                }
                mc.bindData = { Object target, Object args, Map includeExclude ->
                    bind.invoke(delegate, BindDynamicMethod.METHOD_SIGNATURE, [target, args, includeExclude] as Object[])
                }
                mc.bindData = { Object target, Object args, Map includeExclude, String filter ->
                    bind.invoke(delegate, BindDynamicMethod.METHOD_SIGNATURE, [target, args, includeExclude, filter] as Object[])
                }
                mc.bindData = { Object target, Object args, String filter ->
                    bind.invoke(delegate, BindDynamicMethod.METHOD_SIGNATURE, [target, args, filter] as Object[])
                }
            }
        }
    }

    def doWithApplicationContext = { applicationContext ->
        Library.setProperty("org.zkoss.web.servlet.http.URLEncoder", "org.grails.plugins.zkui.encodes.URLEncoder")
    }

    def onChange = { event ->
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
        def artefactType = null
        if (application.isArtefactOfType(ComposerArtefactHandler.TYPE, event.source)) {
            artefactType = ComposerArtefactHandler.TYPE
        } else if (application.isArtefactOfType(ViewModelArtefactHandler.TYPE, event.source)) {
            artefactType = ViewModelArtefactHandler.TYPE
        }
        if (artefactType) {
            def context = event.ctx
            if (!context) {
                if (log.isDebugEnabled())
                    log.debug("Application context not found. Can't reload")
                return
            }
            def artefactClass = application.addArtefact(artefactType, event.source)
            def artefactBeanName = artefactClass.clazz.name

            def beans = beans {
                "${artefactBeanName}"(artefactClass.clazz) { bean ->
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
