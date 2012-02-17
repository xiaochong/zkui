<% import grails.persistence.Event %><%=packageName ? "package ${packageName}\n\n" : ''%>import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.event.Event
import org.zkoss.zul.*
import ${domainClass.fullName}

class CreateComposer {
    Window self
    def afterCompose = {Component comp ->
        //todo initialize components here
    }

    void onClick_saveButton(Event e) {
        def ${propertyName} = new ${className}(self.params)
        if (!${propertyName}.save(flush: true) && ${propertyName}.hasErrors()) {
            log.error ${propertyName}.errors
            self.renderErrors(bean: ${propertyName})
        } else {
            flash.message = g.message(code: 'default.created.message', args: [g.message(code: '${domainClass.propertyName}.label', default: '${className}'), ${propertyName}.id])
            redirect(controller: "${domainClass.propertyName}", action: "list")
        }
    }
}