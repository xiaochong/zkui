package grails.test.mixin.web

import grails.test.ComposerMockUtils

/**
 * A ComposerUnitTestMixin used to improve unit testing when mocking domain classes in
 * the grails 2.0.x way.
 *
 * @author Philip Vendil Mar 24, 2012
 *
 */
class ComposerUnitTestMixin {


    def <T> T mockComposer(Class<T> composerClass) {
        ComposerMockUtils.mockComponent()
        ComposerMockUtils.mockSession()
        ComposerMockUtils.mockComposer(composerClass)
        return composerClass.newInstance()
    }

}
