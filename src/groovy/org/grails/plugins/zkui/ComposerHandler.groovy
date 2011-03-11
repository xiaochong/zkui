package org.grails.plugins.zkui

import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.util.Composer
import org.zkoss.lang.Classes
import org.zkoss.zk.ui.UiException
import org.zkoss.zk.ui.util.ComposerExt
import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.grails.plugins.zkui.artefacts.ComposerArtefactHandler

class ComposerHandler {
    Composer composer
    ComposerExt composerExt

    ComposerHandler(apply) {
        composer = parseAppliedComposer(apply)
        if (composer != null)
            composerExt = composer instanceof ComposerExt ? (ComposerExt) composer : null
    }

    def doBeforeComposeChildren(Component comp) {
        composerExt?.doBeforeComposeChildren(comp)
    }

    def doAfterCompose(Component comp) {
        composer?.doAfterCompose(comp)
    }

    private static Composer parseAppliedComposer(Object o) {
        if (null == o) return null
        try {
            if (o instanceof String) {
                if (ApplicationHolder.application.isArtefactOfType(ComposerArtefactHandler.TYPE, o)) {
                    def composerBean = ApplicationHolder.application.mainContext.getBean(o)
                    o = new GrailsComposerWrapper(composerBean)
                } else {
                    o = Classes.newInstanceByThread(((String) o).trim())
                }
            } else if (o instanceof Class)
                o = ((Class) o).newInstance()
            if (o instanceof Composer)
                return (Composer) o
        } catch (Exception ex) {
            throw UiException.Aide.wrap(ex)
        }
        return null
    }
}
