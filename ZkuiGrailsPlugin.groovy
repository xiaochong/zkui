import java.lang.reflect.Method
import org.codehaus.groovy.grails.commons.spring.TypeSpecifyableTransactionProxyFactoryBean
import org.codehaus.groovy.grails.orm.support.GroovyAwareNamedTransactionAttributeSource
import org.grails.plugins.zkui.artefacts.ComposerArtefactHandler
import org.grails.plugins.zkui.artefacts.GrailsComposerClass
import org.springframework.beans.factory.config.MethodInvokingFactoryBean
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.transaction.annotation.Transactional

class ZkuiGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.2 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]

    def loadAfter = ['hibernate', 'domainClass', 'services']

    def artefacts = [
            org.grails.plugins.zkui.artefacts.ComposerArtefactHandler
    ]

    def watchedResources = [
            "file:./grails-app/composers/**/*Composer.groovy",
            "file:./plugins/*/grails-app/composers/**/*Composer.groovy"]

    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def author = "groovyquan"
    def authorEmail = "groovyquan@gmail.com"
    def title = "ZK UI/ZK ui plugin for Grails"
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
                println "composerBeanName:${composerBeanName}-${composerClass.clazz}"
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
        // TODO Implement registering dynamic methods to classes (optional)
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

    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
