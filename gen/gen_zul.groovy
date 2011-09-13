def elementExclude = ['custom-attributes', 'attribute', 'variables', 'zk', 'zscript']
def extElement = [
        span: ['apply', 'context', 'popup', 'ctrlKeys', 'tooltip', 'class', 'left', 'top', 'zIndex', 'zindex', 'height', 'tooltiptext', 'zclass', 'sclass', 'draggable', 'droppable', 'focus', 'renderdefer', 'vflex', 'hflex', 'width', 'style', 'action', 'id', 'mold', 'widgetClass', 'stubonly', 'definition', 'visible'],
        timeline: ['apply', 'orient', 'height', 'width', 'context', 'ctrlKeys', 'popup', 'tooltip', 'class', 'left', 'top', 'zIndex', 'zindex', 'tooltiptext', 'zclass', 'sclass', 'draggable', 'droppable', 'focus', 'renderdefer', 'vflex', 'hflex', 'style', 'action', 'widgetClass', 'id', 'stubonly', 'mold', 'definition', 'visible'],
        bandinfo: ['apply', 'intervalUnit', 'intervalPixels', 'syncWith', 'eventSourceUrl', 'overview', 'bubbleVisible'],
        hotzone: ['apply', 'unit', 'multiple', 'magnify'],
        timeplot: ['apply', 'height', 'hideTimeFlag', 'timeFlagFormat', 'width', 'class', 'left', 'top', 'zIndex', 'zindex', 'tooltiptext', 'zclass', 'sclass', 'draggable', 'droppable', 'focus', 'renderdefer', 'vflex', 'hflex', 'style', 'action', 'widgetClass', 'id', 'stubonly', 'mold', 'definition', 'visible'],
        plotinfo: ['apply', 'fillColor', 'bubbleHeight', 'bubbleWidth', 'dotColor', 'dotRadius', 'eventLineWidth', 'eventSourceUri', 'lineColor', 'lineWidth', 'roundValues', 'showValues', 'hideValueFlag', 'valuesOpacity']
]
def elementList = []
def attributeGroupMap = [:]
def elementMap = [:]
def elementAttributeGroupMap = [:]
def root = new XmlSlurper().parse("zul.xsd")
root.element.each {
    String elementName = it.@name.text()
    if (!elementExclude.contains(elementName)) {
        elementList << elementName
    }
}
root.attributeGroup.each {group ->
    String groupName = group.@name
    if ("zkAttrGroup" != groupName) {
        attributeGroupMap.put(groupName, group.attribute.collect {
            it.@name.text()
        })
    } else {
        attributeGroupMap.put(groupName, ['apply'])
    }
}
root.attributeGroup.each {group ->
    String groupName = group.@name
    group.attributeGroup.each {
        def attributeGroupAttributes = attributeGroupMap[it.@ref.text()]
        if (attributeGroupAttributes) {
            attributeGroupMap[groupName].addAll(attributeGroupAttributes)
        }
    }
}

elementList.each {String element ->
    def complexType = root.complexType.find {it.@name.text() == "${element}Type".toString()}
    elementMap.put(element, complexType.attribute.collect {
        it.@name.text()
    })

    elementAttributeGroupMap.put(element, complexType.attributeGroup.collect {
        it.@ref.text()
    })
}
elementMap.each {element ->
    elementAttributeGroupMap[element.key].each {attributeGroup ->
        element.value.addAll(attributeGroupMap[attributeGroup])
        element.value = element.value.unique()
    }
}
extElement.each {
    elementMap.put(it.key, it.value)
}

def head = '''
package org.grails.plugins.zkui

class ZulTagLib extends AbstractTagLib {

    static namespace = "z"

'''

print head

elementMap.each {
    def name = it.key
    println """
    /**
     *
${it.value.collect {"     * @attr ${it} "}.join("\n")}
     */
    def ${name == 'flash' ? 'flashes' : name} = { attrs, body ->
        true || ${it.value.collect {'attrs.' + it}.join(' || ')}
        doTag(attrs, body, "$name")
    }
    """
}

println "}"