package org.grails.plugins.zkui

import grails.test.GrailsUnitTestCase
import org.zkoss.zul.Div
import javax.servlet.ServletContext

class ZkComponentBuilderTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testBuild() {
        Div div = new Div()
        def builder = new ZkComponentBuilder()
        def servletContextMock = mockFor(ServletContext)
        servletContextMock.demand.getContextPath(2..2) {return "/"}
        builder.servletContext = servletContextMock.createMock()
        builder.build(div){
            span(id: 'test') {
                button(id: 'button',onClick:{})
            }
        }
        assertEquals 1, div.children.size()
        assertEquals "test", div.children[0].id
        assertEquals "button", div.children[0].children[0].id
        assertEquals 1, div.children[0].children[0].getListenerIterator("onClick").size()
    }
}
