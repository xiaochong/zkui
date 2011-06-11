package grails.test

import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.Session

class ComposerUnitTestCase extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    protected void mockComposer(Class composerClass) {
        registerMetaClass(Component)
        registerMetaClass(Session)
        ComposerMockUtils.mockComponent()
        ComposerMockUtils.mockSession()

        registerMetaClass(composerClass)
        mockLogging(composerClass)
        ComposerMockUtils.mockComposer(composerClass)
    }
}
