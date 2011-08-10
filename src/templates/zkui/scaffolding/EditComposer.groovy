<% import grails.persistence.Event %><%=packageName ? "package ${packageName}\n\n" : ''%>import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.event.Event
import org.zkoss.zul.*
import ${domainClass.fullName}

class EditComposer {
    Window self
    def afterCompose = {Component comp ->
        //todo initialize components here
    }

    void onClick_saveButton(Event e) {
        def params=self.params
        def ${propertyName} = ${className}.get(params.id)
        if (${propertyName}) {
            if (params.version != null) {
                def version = params.version
                if (${propertyName}.version > version) {
                    String failureMessage = g.message(code:"default.optimistic.locking.failure",args:[g.message(code: '${domainClass.propertyName}.label', default: '${className}')],default:"Another user has updated this \${${propertyName}} while you were editing")
                    Messagebox.show(failureMessage, g.message(code:'error',default:'Error'), Messagebox.YES, Messagebox.ERROR)
                    return
                }
            }
            ${propertyName}.properties = params
            if (!${propertyName}.hasErrors() && ${propertyName}.save(flush: true)) {
                flash.message = g.message(code: 'default.updated.message', args: [g.message(code: '${domainClass.propertyName}.label', default: '${className}'), ${propertyName}.id])
                redirect(controller: "${domainClass.propertyName}", action: "edit", id: ${propertyName}.id)
            }else {
                log.error ${propertyName}.errors
                self.renderErrors(bean: ${propertyName})
            }
        }
        else {
            flash.message = g.message(code: 'default.not.found.message', args: [g.message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
            redirect(controller: "${domainClass.propertyName}",action: "list")
        }

    }
}