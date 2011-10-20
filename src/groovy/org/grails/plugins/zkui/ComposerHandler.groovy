package org.grails.plugins.zkui

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.plugins.support.aware.GrailsApplicationAware
import org.zkoss.lang.Classes
import org.zkoss.util.CollectionsX
import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.UiException
import org.zkoss.zk.ui.util.Composer
import org.zkoss.zk.ui.util.ComposerExt

class ComposerHandler implements GrailsApplicationAware {
    GrailsApplication grailsApplication
    Composer composer
    ComposerExt composerExt

    def handle(apply) {
        composer = parseAppliedComposer(apply)
        if (composer != null)
            composerExt = composer instanceof ComposerExt ? (ComposerExt) composer : null
        return this
    }

    def doBeforeComposeChildren(Component comp) {
        composerExt?.doBeforeComposeChildren(comp)
    }

    def doAfterCompose(Component comp) {
        composer?.doAfterCompose(comp)
    }

    private Composer parseAppliedComposer(Object o) {
        if (null == o) return null
        try {
            if (o instanceof String) {
                final String s = (String) o
                if (s.indexOf(',') >= 0)
                    o = CollectionsX.parse(null, s, ',' as char).collect {String sp ->
                        return change(sp)
                    }
            }
            if (o instanceof Collection) {
                final Collection c = (Collection) o;
                int sz = c.size();
                switch (sz) {
                    case 0: return null;
                    case 1: o = c.iterator().next(); break;
                    default: o = c.toArray(new Object[sz]); break;
                }
            }
            if (o instanceof Object[]) {
                final Object[] cs = (Object[]) o;
                switch (cs.length) {
                    case 0: return null;
                    case 1: o = cs[0]; break;
                    default: return new MultiComposer(cs)
                }
            }
            if (o instanceof String) {
                o = change(o)
            }
            else if (o instanceof Class)
                o = ((Class) o).newInstance();
            if (o instanceof Composer)
                return (Composer) o;
        } catch (Exception ex) {
            throw UiException.Aide.wrap(ex);
        }
        return null
    }

    private def change(String o) {
        def context = grailsApplication.mainContext
        def containsBean = context.containsBean(o)
        if (containsBean) {
            return new GrailsComposerWrapper(context.getBean(o))
        } else {
            return Classes.newInstanceByThread(((String) o).trim())
        }
    }
}
