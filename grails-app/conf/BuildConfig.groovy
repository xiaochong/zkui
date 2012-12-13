grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()
        mavenRepo "http://mavensync.zkoss.org/maven2/"
        grailsRepo "http://grails.org/plugins"
        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        //mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.13'
        def zkVersion = "6.5.1"
        runtime "org.zkoss.zk:zk:${zkVersion}"
        runtime "org.zkoss.zk:zul:${zkVersion}"
        runtime "org.zkoss.zk:zkplus:${zkVersion}"
        runtime "org.zkoss.zk:zhtml:${zkVersion}"
        runtime "org.zkoss.zk:zkbind:${zkVersion}"
        runtime "org.zkoss.common:zel:${zkVersion}"
    }
    plugins {
        build(":tomcat:$grailsVersion", ":release:2.0.4", ":rest-client-builder:1.0.2") {
            export = false
        }
    }
}
