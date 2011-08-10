<% import grails.persistence.Event %><% import org.codehaus.groovy.grails.plugins.PluginManagerHolder %><%=packageName%>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>

<body>
<z:window style="padding:5px" apply="${domainClass.packageName}.${className.toLowerCase()}.EditComposer">
    <z:longbox name="id" value="\${${propertyName}.id}" visible="false"/>
    <z:longbox name="version" value="\${${propertyName}.version}" visible="false"/>
    <z:grid>
        <z:columns sizable="true">
            <z:column label="\${message(code:'name',default:'Name')}" width="100px"/>
            <z:column label="\${message(code:'value',default:'Value')}"/>
        </z:columns>
        <z:rows>
        <%  excludedProps = Event.allEvents.toList() << 'version' << 'id' << 'dateCreated' << 'lastUpdated'
            persistentPropNames = domainClass.persistentProperties*.name
            props = domainClass.properties.findAll { persistentPropNames.contains(it.name) && !excludedProps.contains(it.name) }
            Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
            display = true
            boolean hasHibernate = PluginManagerHolder.pluginManager.hasGrailsPlugin('hibernate')
            props.each { p ->
                    if (hasHibernate) {
                        cp = domainClass.constrainedProperties[p.name]
                        display = (cp ? cp.display : true)
                    }
                    if (display) { %>
            <z:row>
                <z:label value="\${message(code:'${domainClass.propertyName}.${p.name}.label',default:'${p.naturalName}')}"/>
                ${renderEditor(p)}
            </z:row>
        <%  }   } %>
        </z:rows>
    </z:grid>
    <z:hlayout>
        <z:button id="saveButton" label="\${message(code: 'default.button.update.label', default: 'Update')}"/>
        <z:button href="\${createLink(action:'list')}" label="\${message(code: 'default.list.label', args:[entityName])}"/>
    </z:hlayout>
</z:window>
</body>
</html>