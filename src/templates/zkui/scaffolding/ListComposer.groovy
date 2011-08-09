<% import grails.persistence.Event %><%=packageName ? "package ${packageName}\n\n" : ''%>import org.zkoss.zk.ui.Component
import org.zkoss.zul.*
import org.zkoss.zk.ui.event.*
import ${domainClass.fullName}

class ListComposer {
    Grid grid
    ListModelList listModel = new ListModelList()
    Paging paging
    Longbox idLongbox

    def afterCompose = {Component comp ->
        grid.rowRenderer = new ${className}RowRenderer(this)
        grid.model = listModel
        redraw()
    }

    void onClick_searchButton(Event e) {
        redraw()
    }

    def onPaging_paging(ForwardEvent fe) {
        def event = fe.origin
        redraw(event.activePage)
    }

    private def redraw(int activePage = 0) {
        int offset = activePage * paging.pageSize
        int max = paging.pageSize
        def ${propertyName}List = ${className}.createCriteria().list(offset: offset, max: max) {
            order('id','desc')
            if (idLongbox.value) {
                eq('id', idLongbox.value)
            }
        }
        paging.totalSize = ${propertyName}List.totalCount
        listModel.clear()
        listModel.addAll(${propertyName}List.id)
    }

    class ${className}RowRenderer implements RowRenderer {
        def g
        def listModel

        ${className}RowRenderer(context) {
            this.g = context.g
            this.listModel = context.listModel
        }

        void render(Row row, Object id) {
            def ${propertyName} = ${className}.get(id)
            row << {
                    <%  excludedProps = Event.allEvents.toList() << 'version'
                        allowedNames = domainClass.persistentProperties*.name << 'id' << 'dateCreated' << 'lastUpdated'
                        props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) && !Collection.isAssignableFrom(it.type) }
                        Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
                        props.eachWithIndex { p, i ->
                            if (i == 0) {%>a(href: g.createLink(controller:"${domainClass.propertyName}",action:'edit',id:id), label: ${propertyName}.id)
                    <%}else if (i < 6) {%>label(value: ${propertyName}.${p.name})
                    <%}   } %>toolbarbutton(label: g.message(code: 'default.button.delete.label', default: 'Delete'), image: "/images/skin/database_delete.png", client_onClick: "if(!confirm('\${g.message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}'))event.stop()", onClick: {
                        ${className}.get(id as Long).delete(flush: true)
                        listModel.remove(id)
                    })
            }
        }
    }
}