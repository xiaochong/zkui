package org.grails.plugins.zkui.scaffolding

import groovy.text.SimpleTemplateEngine
import groovy.text.Template
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.codehaus.groovy.grails.cli.CommandLineHelper
import org.codehaus.groovy.grails.commons.GrailsDomainClass
import org.codehaus.groovy.grails.scaffolding.DomainClassPropertyComparator
import org.codehaus.groovy.grails.scaffolding.GrailsTemplateGenerator
import org.codehaus.groovy.grails.scaffolding.SimpleDomainClassPropertyComparator
import org.springframework.context.ResourceLoaderAware
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.ResourceLoader
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.util.Assert
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.plugins.PluginManagerAware
import org.codehaus.groovy.grails.plugins.GrailsPluginManager

class ZkGrailsTemplateGenerator implements GrailsTemplateGenerator, ResourceLoaderAware, PluginManagerAware {
    static final Log LOG = LogFactory.getLog(ZkGrailsTemplateGenerator)

    String basedir = "."
    File zkuiPluginDir
    boolean overwrite = false
    def engine = new SimpleTemplateEngine()
    ResourceLoader resourceLoader
    Template renderEditorTemplate
    String domainSuffix = 'Instance'
    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    /**
     * Used by the scripts so that they can pass in their AntBuilder instance.
     */
    ZkGrailsTemplateGenerator(ClassLoader classLoader) {
        engine = new SimpleTemplateEngine(classLoader)
    }

    /**
     * Default constructor.
     */
    ZkGrailsTemplateGenerator() {}

    void setGrailsApplication(GrailsApplication ga) {
        this.grailsApplication = ga
        if (ga != null) {
            def suffix = ga.config?.grails?.scaffolding?.templates?.domainSuffix
            if (suffix != [:]) {
                domainSuffix = suffix
            }
        }
    }

    void setZkuiPluginDir(File zkuiPluginDir) {
        this.zkuiPluginDir = zkuiPluginDir
    }

    void setResourceLoader(ResourceLoader rl) {
        LOG.info "Scaffolding template generator set to use resource loader ${rl}"
        this.resourceLoader = rl
    }

    // uses the type to render the appropriate editor
    def renderEditor = { property ->
        def domainClass = property.domainClass
        def cp
        if (pluginManager.hasGrailsPlugin('hibernate')) {
            cp = domainClass.constrainedProperties[property.name]
        }

        if (!renderEditorTemplate) {
            // create template once for performance
            def templateText = getTemplateText("renderEditor.template")
            renderEditorTemplate = engine.createTemplate(templateText)
        }

        def binding = [property: property,
                domainClass: domainClass,
                cp: cp,
                domainInstance: getPropertyName(domainClass)]
        return renderEditorTemplate.make(binding).toString()
    }

    void generateViews(GrailsDomainClass domainClass, String destdir) {
        Assert.hasText destdir, "Argument [destdir] not specified"

        def viewsDir = new File("${destdir}/grails-app/views/${domainClass.propertyName}")
        if (!viewsDir.exists()) {
            viewsDir.mkdirs()
        }

        for (t in getTemplateNames()) {
            LOG.info "Generating $t view for domain class [${domainClass.fullName}]"
            generateView domainClass, t, viewsDir.absolutePath
        }
    }

    void generateController(GrailsDomainClass domainClass, String destdir) {
        Assert.hasText destdir, "Argument [destdir] not specified"

        if (domainClass) {
            def fullName = domainClass.fullName
            def pkg = ""
            def pos = fullName.lastIndexOf('.')
            if (pos != -1) {
                // Package name with trailing '.'
                pkg = fullName[0..pos]
            }

            def destFile = new File("${destdir}/grails-app/controllers/${pkg.replace('.' as char, '/' as char)}${domainClass.shortName}Controller.groovy")
            if (canWrite(destFile)) {
                destFile.parentFile.mkdirs()

                destFile.withWriter { w ->
                    generateController(domainClass, w)
                }

                LOG.info("Controller generated at ${destFile}")
            }
        }
    }


    void generateComposers(GrailsDomainClass domainClass, String destdir) {
        Assert.hasText destdir, "Argument [destdir] not specified"

        if (domainClass) {
            def fullName = domainClass.fullName
            def pkg = ""
            def pos = fullName.lastIndexOf('.')
            if (pos != -1) {
                // Package name with trailing '.'
                pkg = fullName[0..pos]
            }

            def composersDir = new File("${destdir}/grails-app/composers/${pkg.replace('.' as char, '/' as char)}/${domainClass.propertyName.toLowerCase()}")
            if (!composersDir.exists()) {
                composersDir.mkdirs()
            }
            for (t in getComposerTemplateNames()) {
                LOG.info "Generating $t view for domain class [${domainClass.fullName}]"
                generateComposer(domainClass, t, composersDir.absolutePath)
            }
        }
    }

    void generateComposer(GrailsDomainClass domainClass, String composerName, String destDir) {
        File destFile = new File("$destDir/${composerName}.groovy")
        if (canWrite(destFile)) {
            destFile.withWriter { Writer writer ->
                generateComposer domainClass, composerName, writer
            }
        }
    }

    void generateComposer(GrailsDomainClass domainClass, String composerName, Writer out) {
        def templateText = getTemplateText("${composerName}.groovy")
        def t = engine.createTemplate(templateText)
        def multiPart = domainClass.properties.find {it.type == ([] as Byte[]).class || it.type == ([] as byte[]).class}

        boolean hasHibernate = pluginManager.hasGrailsPlugin('hibernate')
        def packageName = domainClass.packageName ? "${domainClass.packageName}.${domainClass.propertyName.toLowerCase()}" : ""
        def binding = [packageName: packageName,
                domainClass: domainClass,
                multiPart: multiPart,
                className: domainClass.shortName,
                propertyName: getPropertyName(domainClass),
                renderEditor: renderEditor,
                comparator: hasHibernate ? DomainClassPropertyComparator : SimpleDomainClassPropertyComparator]

        t.make(binding).writeTo(out)
    }


    private generateListView(domainClass, destDir) {
        def listFile = new File("${destDir}/list.gsp")
        if (canWrite(listFile)) {
            listFile.withWriter { w ->
                generateView(domainClass, "list", w)
            }
            LOG.info("list view generated at ${listFile.absolutePath}")
        }
    }

    private generateShowView(domainClass, destDir) {
        def showFile = new File("${destDir}/show.gsp")
        if (canWrite(showFile)) {
            showFile.withWriter { w ->
                generateView(domainClass, "show", w)
            }
            LOG.info("Show view generated at ${showFile.absolutePath}")
        }
    }

    private generateEditView(domainClass, destDir) {
        def editFile = new File("${destDir}/edit.gsp")
        if (canWrite(editFile)) {
            editFile.withWriter { w ->
                generateView(domainClass, "edit", w)
            }
            LOG.info("Edit view generated at ${editFile.absolutePath}")
        }
    }

    private generateCreateView(domainClass, destDir) {
        def createFile = new File("${destDir}/create.gsp")
        if (canWrite(createFile)) {
            createFile.withWriter { w ->
                generateView(domainClass, "create", w)
            }
            LOG.info("Create view generated at ${createFile.absolutePath}")
        }
    }

    void generateView(GrailsDomainClass domainClass, String viewName, String destDir) {
        File destFile = new File("$destDir/${viewName}.gsp")
        if (canWrite(destFile)) {
            destFile.withWriter { Writer writer ->
                generateView domainClass, viewName, writer
            }
        }
    }

    void generateView(GrailsDomainClass domainClass, String viewName, Writer out) {
        def templateText = getTemplateText("${viewName}.gsp")

        def t = engine.createTemplate(templateText)
        def multiPart = domainClass.properties.find {it.type == ([] as Byte[]).class || it.type == ([] as byte[]).class}

        boolean hasHibernate = pluginManager.hasGrailsPlugin('hibernate')
        def packageName = domainClass.packageName ? "<%@ page import=\"${domainClass.fullName}\" %>" : ""
        def binding = [packageName: packageName,
                domainClass: domainClass,
                multiPart: multiPart,
                className: domainClass.shortName,
                propertyName: getPropertyName(domainClass),
                renderEditor: renderEditor,
                comparator: hasHibernate ? DomainClassPropertyComparator : SimpleDomainClassPropertyComparator]

        t.make(binding).writeTo(out)
    }

    void generateController(GrailsDomainClass domainClass, Writer out) {
        def templateText = getTemplateText("Controller.groovy")

        boolean hasHibernate = pluginManager.hasGrailsPlugin('hibernate')
        def binding = [packageName: domainClass.packageName,
                domainClass: domainClass,
                className: domainClass.shortName,
                propertyName: getPropertyName(domainClass),
                comparator: hasHibernate ? DomainClassPropertyComparator : SimpleDomainClassPropertyComparator]

        def t = engine.createTemplate(templateText)
        t.make(binding).writeTo(out)
    }

    private String getPropertyName(GrailsDomainClass domainClass) { "${domainClass.propertyName}${domainSuffix}" }

    private helper = new CommandLineHelper()

    private canWrite(testFile) {
        if (!overwrite && testFile.exists()) {
            try {
                def response = helper.userInput("File ${testFile} already exists. Overwrite?", ['y', 'n', 'a'] as String[])
                overwrite = overwrite || response == "a"
                return overwrite || response == "y"
            }
            catch (Exception e) {
                // failure to read from standard in means we're probably running from an automation tool like a build server
                return true
            }
        }
        return true
    }

    private getTemplateText(String template) {
        def application = grailsApplication
        // first check for presence of template in application
        if (resourceLoader && application?.warDeployed) {
            return resourceLoader.getResource("/WEB-INF/templates/zkui/scaffolding/${template}").inputStream.text
        }

        def templateFile = new FileSystemResource("${basedir}/src/templates/zkui/scaffolding/${template}")
        if (!templateFile.exists()) {
            templateFile = new FileSystemResource("${zkuiPluginDir}/src/templates/zkui/scaffolding/${template}")
        }
        return templateFile.inputStream.getText()
    }

    def getComposerTemplateNames() {
        Closure filter = { it[0..-8] }
        def resources = []
        def resolver = new PathMatchingResourcePatternResolver()
        try {
            def zkuiPluginTemplates = resolver.getResources("file:${zkuiPluginDir}/src/templates/zkui/scaffolding/*Composer.groovy").filename.collect(filter)
            resources.addAll(zkuiPluginTemplates)
        }
        catch (e) {
            // ignore
            LOG.debug("Error locating templates from zkuiPluginDir: ${e.message}", e)
        }
        return resources
    }

    def getTemplateNames() {
        Closure filter = { it[0..-5] }
        if (resourceLoader && application?.isWarDeployed()) {
            def resolver = new PathMatchingResourcePatternResolver(resourceLoader)
            try {
                return resolver.getResources("/WEB-INF/templates/scaffolding/zkui/*.gsp").filename.collect(filter)
            }
            catch (e) {
                return []
            }
        }

        def resources = []
        def resolver = new PathMatchingResourcePatternResolver()
        String templatesDirPath = "${basedir}/src/templates/zkui/scaffolding"
        def templatesDir = new FileSystemResource(templatesDirPath)
        if (templatesDir.exists()) {
            try {
                resources = resolver.getResources("file:$templatesDirPath/*.gsp").filename.collect(filter)
            }
            catch (e) {
                LOG.info("Error while loading views from grails-app scaffolding folder", e)
            }
        }

        try {
            def pluginsHomeTemplates = resolver.getResources("file:${zkuiPluginDir}/src/templates/zkui/scaffolding/*.gsp").filename.collect(filter)
            resources.addAll(pluginsHomeTemplates)
        }
        catch (e) {
            // ignore
            LOG.debug("Error locating templates from pluginsHome: ${e.message}", e)
        }
        return resources
    }
}