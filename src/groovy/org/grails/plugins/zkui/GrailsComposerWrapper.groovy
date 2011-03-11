package org.grails.plugins.zkui

import org.zkoss.zk.ui.event.EventListener
import org.zkoss.zk.ui.event.Event
import org.zkoss.zk.ui.sys.ComponentsCtrl
import java.lang.reflect.Method
import org.codehaus.groovy.runtime.InvokerHelper
import org.zkoss.zk.ui.event.ForwardEvent
import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.event.Events
import org.zkoss.zk.ui.util.Composer
import org.zkoss.zk.ui.Components

class GrailsComposerWrapper implements Composer, EventListener {
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
                    evt = ((ForwardEvent) evt).getOrigin()
                    while (evt instanceof ForwardEvent) {
                        evt = ((ForwardEvent) evt).getOrigin()
                    }
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
        Components.wireVariables(comp, controller)
        Components.addForwards(comp, controller, SEPARATOR)
        this.bindComponent(comp)
        controller.afterCompose(comp)
    }
}
