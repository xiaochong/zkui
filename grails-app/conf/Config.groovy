// configuration for plugin testing - will not be included in the plugin zip

log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error 'org.codehaus.groovy.grails.web.servlet',  //  controllers
            'org.codehaus.groovy.grails.web.pages', //  GSP
            'org.codehaus.groovy.grails.web.sitemesh', //  layouts
            'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
            'org.codehaus.groovy.grails.web.mapping', // URL mapping
            'org.codehaus.groovy.grails.commons', // core / classloading
            'org.codehaus.groovy.grails.plugins', // plugins
            'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
            'org.springframework',
            'org.hibernate',
            'net.sf.ehcache.hibernate'

    warn 'org.mortbay.log'
}

grails.doc.title = "Grails ZK UI Plugin"
grails.doc.authors = "groovyquan"
grails.doc.license = "GNU Free Documentation License"
grails.doc.copyright = "This document is licensed under GNU Free Documentation License,ZK UI Plugin is released under LGPL"
grails.doc.footer = "Grails ZK UI Plugin Project"
grails.doc.logo = '<a href="http://www.grails.org/plugin/zkui" target="_blank"><img alt="ZK UI Logo" title="ZK UI Plugin for Grails Framework" src="../img/zkui_logo.png" border="0"/></a>'
grails.doc.sponsorLogo = '<a href="http://springsource.com" target="_blank"></a>'
grails.doc.images = new File("src/docs/resources/img")
