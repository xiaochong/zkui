<% import grails.persistence.Event %><% import org.codehaus.groovy.grails.plugins.PluginManagerHolder %>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>

<body>
<z:window style="padding:5px" apply="${domainClass.packageName}.${className.toLowerCase()}.CreateComposer">
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
                if (!Collection.class.isAssignableFrom(p.type)) {
                    if (hasHibernate) {
                        cp = domainClass.constrainedProperties[p.name]
                        display = (cp ? cp.display : true)
                    }
                    if (display) { %>
            <z:row>
                <z:label value="\${message(code:'${domainClass.propertyName}.${p.name}.label',default:'${p.naturalName}')}"/>
                ${renderEditor(p)}
            </z:row>
        <%  }   }   } %>
        </z:rows>
    </z:grid>
    <z:hlayout>
        <z:button id="saveButton" label="\${message(code: 'default.button.create.label', default: 'Create')}"/>
        <z:button href="\${createLink(action:'list')}" label="\${message(code: 'default.list.label', args:[entityName])}"/>
    </z:hlayout>
</z:window>
</body>
</html>