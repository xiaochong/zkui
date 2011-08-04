<% import grails.persistence.Event %><%=packageName ? "package ${packageName}\n\n" : ''%>import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.event.Event
import org.zkoss.zul.*
import ${domainClass.fullName}

class EditComposer {
    static transactional = true
    Window self
    def afterCompose = {Component comp ->
        //todo initialize components here
    }

    void onClick_saveButton(Event e) {
        def ${propertyName} = ${className}.get(self.params.id)
        if (${propertyName}) {
            ${propertyName}.properties = self.params
            if (!${propertyName}.hasErrors() && ${propertyName}.save(flush: true)) {
                Messagebox.show("\${g.message(code: 'default.updated.message', args: [g.message(code: '${domainClass.propertyName}.label', default: '${className}'), ${propertyName}.id])}")
            }else {
                log.error ${propertyName}.errors
                self.renderErrors(bean: ${propertyName})
            }
        }
        else {
            redirect(controller: "${domainClass.propertyName}",action: "list")
        }

    }
}