package org.grails.plugins.zkui

import java.lang.reflect.Method
import org.codehaus.groovy.runtime.InvokerHelper
import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.Components
import org.zkoss.zk.ui.Page
import org.zkoss.zk.ui.event.Event
import org.zkoss.zk.ui.event.EventListener
import org.zkoss.zk.ui.event.Events
import org.zkoss.zk.ui.event.ForwardEvent
import org.zkoss.zk.ui.metainfo.ComponentInfo
import org.zkoss.zk.ui.sys.ComponentsCtrl
import org.zkoss.zk.ui.util.Composer
import org.zkoss.zk.ui.util.ComposerExt

class GrailsComposerWrapper implements Composer, ComposerExt, EventListener {
    public static final char SEPARATOR = '_' as char
    final controller

    GrailsComposerWrapper(controller) {
        this.controller = controller
    }

    void onEvent(Event evt) {
        final Method mtd = ComponentsCtrl.getEventMethod(controller.getClass(), evt.getName())
        if (mtd != null) {
            if (mtd.getParameterTypes().length == 0) {
                InvokerHelper.invokeMethod(controller, mtd.getName(), null)
            } else if (evt instanceof ForwardEvent) {
                final Class<?> paramCls = (Class<?>) mtd.getParameterTypes()[0]
                //paramCls is ForwardEvent || Event
                if (ForwardEvent.class.isAssignableFrom(paramCls)
                        || Event.class.equals(paramCls)) {
                    InvokerHelper.invokeMethod(controller, mtd.getName(), [evt] as Object[])
                } else {
                    evt = Events.getRealOrigin((ForwardEvent) evt)
                    InvokerHelper.invokeMethod(controller, mtd.getName(), [evt] as Object[])
                }
            } else {
                InvokerHelper.invokeMethod(controller, mtd.getName(), [evt] as Object[])
            }
        }
    }

    public void unbindComponent(Component comp) {
        final Method[] methods = controller.getClass().getMethods()
        for (int i = 0; i < methods.length; i++) {
            final String evtName = methods[i].getName()
            if (Events.isValid(evtName))
                comp.removeEventListener(evtName, this)
        }
    }

    public void bindComponent(Component comp) {
        final Method[] methods = controller.getClass().getMethods()
        for (int i = 0; i < methods.length; i++) {
            final String evtName = methods[i].getName()
            if (Events.isValid(evtName))
                comp.addEventListener(evtName, this)
        }
    }

    void doAfterCompose(Component comp) {
        Components.wireVariables(comp, controller,'#' as char )
        Components.addForwards(comp, controller, SEPARATOR)
        this.bindComponent(comp)
        controller.afterCompose(comp)
    }

    public ComponentInfo doBeforeCompose(Page page, Component parent, ComponentInfo compInfo) {
        //do nothing
        return compInfo
    }

    public void doBeforeComposeChildren(Component comp) throws Exception {
        Components.wireController(comp, controller)
    }

    public boolean doCatch(Throwable ex) throws Exception {
        return false;
    }

    public void doFinally() throws Exception {
        //do nothing
    }
}
