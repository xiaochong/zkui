def lang = new XmlSlurper().parse("zhtml-lang.xml")

def head = '''
package org.grails.plugins.zkui

class ZhtmlTagLib extends AbstractTagLib {

    static namespace = "h"

'''

print head

lang.component.each {
    def name = it.'component-name'.text()
    println """
    def $name = { attrs, body ->
        doTag(attrs, body, "$name", 'xhtml')
    }
    """
}

println "}"