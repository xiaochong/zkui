import java.lang.reflect.Method
import org.codehaus.groovy.grails.commons.GrailsClassUtils
import org.codehaus.groovy.grails.commons.spring.TypeSpecifyableTransactionProxyFactoryBean
import org.codehaus.groovy.grails.orm.support.GroovyAwareNamedTransactionAttributeSource
import org.codehaus.groovy.grails.web.pages.TagLibraryLookup
import org.grails.plugins.zkui.ZkComponentBuilder
import org.grails.plugins.zkui.artefacts.ComposerArtefactHandler
import org.grails.plugins.zkui.artefacts.GrailsComposerClass
import org.grails.plugins.zkui.jsoup.select.Selector
import org.springframework.beans.factory.config.MethodInvokingFactoryBean
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.transaction.annotation.Transactional
import org.grails.plugins.zkui.metaclass.ZkRedirectDynamicMethod
import org.zkoss.zk.ui.Executions

class ZkuiGrailsPlugin {
    // the plugin version
    def version = "0.2"
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
this plugin adds ZK Ajax framework (www.zkoss.org) support to Grails applications seamless.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/zkui"

    def doWithWebDescriptor = { webXml ->
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
    }

    def doWithSpring = {
        application.composerClasses.each { composerClass ->
            def composerBeanName = composerClass.clazz.name
            def hasDataSource = (application.config?.dataSource || application.domainClasses)
            if (hasDataSource && shouldCreateTransactionalProxy(composerClass)) {
                "${composerClass.fullName}ComposerClass"(MethodInvokingFactoryBean) { bean ->
                    bean.lazyInit = true
                    targetObject = ref("grailsApplication", true)
                    targetMethod = "getArtefact"
                    arguments = [ComposerArtefactHandler.TYPE, composerClass.fullName]
                }
                def props = new Properties()
                props."*" = "PROPAGATION_REQUIRED"
                "${composerBeanName}"(TypeSpecifyableTransactionProxyFactoryBean, composerClass.clazz) { bean ->
                    bean.scope = "prototype"
                    bean.lazyInit = true
                    target = { innerBean ->
                        innerBean.lazyInit = true
                        innerBean.factoryBean = "${composerClass.fullName}ComposerClass"
                        innerBean.factoryMethod = "newInstance"
                        innerBean.autowire = "byName"
                        innerBean.scope = "prototype"
                    }
                    proxyTargetClass = true
                    transactionAttributeSource = new GroovyAwareNamedTransactionAttributeSource(transactionalAttributes: props)
                    transactionManager = ref("transactionManager")
                }
            } else {
                "${composerBeanName}"(composerClass.clazz) { bean ->
                    bean.scope = "prototype"
                    bean.autowire = "byName"
                }
            }
        }
    }

    def shouldCreateTransactionalProxy(GrailsComposerClass composerClass) {
        Class javaClass = composerClass.clazz

        try {
            composerClass.transactional &&
                    !AnnotationUtils.findAnnotation(javaClass, Transactional) &&
                    !javaClass.methods.any { Method m -> AnnotationUtils.findAnnotation(m, Transactional) != null }
        } catch (e) {
            e.printStackTrace()
            return false
        }
    }

    def doWithDynamicMethods = { ctx ->
        org.zkoss.zk.ui.Component.metaClass.appendChild = {Closure closure ->
            def builder = new ZkComponentBuilder(delegate)
            closure.resolveStrategy = Closure.DELEGATE_FIRST
            builder.build(closure)
        }
        org.zkoss.zk.ui.Component.metaClass.leftShift = {Object value ->
            delegate.appendChild(value)
        }
        org.zkoss.zk.ui.Component.metaClass.select = {String query ->
            return Selector.select(query, delegate)
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

        //Inject taglib namespace to Composer
        TagLibraryLookup gspTagLibraryLookup = ctx.getBean("gspTagLibraryLookup")
        def redirect = new ZkRedirectDynamicMethod(ctx)
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
                    mc.redirect = {Map args ->
                        redirect.invoke(delegate, "redirect", args)
                    }
                    mc.getSession = {-> Executions.current.session }
                    mc.getExecution = {-> Executions.current }
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

            if (shouldCreateTransactionalProxy(composerClass) && event.ctx.containsBean("transactionManager")) {
                def beans = beans {
                    "${composerClass.fullName}ComposerClass"(MethodInvokingFactoryBean) { bean ->
                        bean.lazyInit = true
                        targetObject = ref("grailsApplication", true)
                        targetMethod = "getArtefact"
                        arguments = [ComposerArtefactHandler.TYPE, composerClass.fullName]
                    }
                    def props = new Properties()
                    props."*" = "PROPAGATION_REQUIRED"
                    "${composerBeanName}"(TypeSpecifyableTransactionProxyFactoryBean, composerClass.clazz) { bean ->
                        bean.scope = "prototype"
                        bean.lazyInit = true
                        target = { innerBean ->
                            innerBean.lazyInit = true
                            innerBean.factoryBean = "${composerClass.fullName}ComposerClass"
                            innerBean.factoryMethod = "newInstance"
                            innerBean.autowire = "byName"
                            innerBean.scope = "prototype"
                        }
                        proxyTargetClass = true
                        transactionAttributeSource = new GroovyAwareNamedTransactionAttributeSource(transactionalAttributes: props)
                        transactionManager = ref("transactionManager")
                    }
                }
                beans.registerBeans(event.ctx)
            }
            else {
                def beans = beans {
                    "${composerBeanName}"(composerClass.clazz) { bean ->
                        bean.scope = "prototype"
                        bean.autowire = "byName"
                    }
                }
                beans.registerBeans(event.ctx)
            }

        }

        event.manager?.getGrailsPlugin("zkui")?.doWithDynamicMethods(event.ctx)

    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
