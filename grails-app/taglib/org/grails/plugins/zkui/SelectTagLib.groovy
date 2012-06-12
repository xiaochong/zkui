package org.grails.plugins.zkui

import org.springframework.web.servlet.support.RequestContextUtils as RCU

import org.codehaus.groovy.grails.commons.DomainClassArtefactHandler
import org.codehaus.groovy.grails.web.util.StreamCharBuffer
import org.springframework.beans.SimpleTypeConverter
import org.springframework.context.MessageSourceResolvable
import org.zkoss.zul.*

class SelectTagLib {
    static namespace = "zkui"

    def select = { attrs ->
        def messageSource = grailsAttributes.getApplicationContext().getBean("messageSource")
        def locale = RCU.getLocale(request)
        attrs.id = attrs.id ?: attrs.name
        def from = attrs.remove('from')
        def keys = attrs.remove('keys')
        def optionKey = attrs.remove('optionKey')
        def optionValue = attrs.remove('optionValue')
        def value = attrs.remove('value')
        if (value instanceof Collection && attrs.multiple == null) {
            attrs.multiple = true
        }
        if (value instanceof StreamCharBuffer) {
            value = value.toString()
        }
        def valueMessagePrefix = attrs.remove('valueMessagePrefix')
        def noSelection = attrs.remove('noSelection')
        if (noSelection != null) {
            noSelection = noSelection.entrySet().iterator().next()
        }
        def disabled = attrs.remove('disabled')
        if (disabled && Boolean.valueOf(disabled)) {
            attrs.disabled = true
        }
        if (from) {
            List<ItemObject> modelList = []
            Integer selectedIndex
            from.eachWithIndex {el, i ->
                Boolean selected
                def keyValue = null
                if (keys) {
                    keyValue = keys[i]
                    selected = isSelected(keyValue, value, null)
                    if (!selectedIndex && selected) {
                        selectedIndex = i
                    }
                } else if (optionKey) {
                    if (optionKey instanceof Closure) {
                        keyValue = optionKey(el)
                    } else if (el != null && optionKey == 'id' && grailsApplication.getArtefact(DomainClassArtefactHandler.TYPE, el.getClass().name)) {
                        keyValue = el.ident()
                    } else {
                        keyValue = el[optionKey]
                    }
                    selected = isSelected(keyValue, value, el)
                    if (!selectedIndex && selected) {
                        selectedIndex = i
                    }
                } else {
                    keyValue = el
                    selected = isSelected(keyValue, value, null)
                    if (!selectedIndex && selected) {
                        selectedIndex = i
                    }
                }
                StringBuilder labelBuilder = new StringBuilder()
                if (optionValue) {
                    if (optionValue instanceof Closure) {
                        labelBuilder << optionValue(el).toString()
                    } else {
                        labelBuilder << el[optionValue].toString()
                    }
                } else if (el instanceof MessageSourceResolvable) {
                    labelBuilder << messageSource.getMessage(el, locale)
                } else if (valueMessagePrefix) {
                    def message = messageSource.getMessage("${valueMessagePrefix}.${keyValue}", null, null, locale)
                    if (message != null) {
                        labelBuilder << message
                    } else if (keyValue && keys) {
                        def s = el.toString()
                        if (s) labelBuilder << s
                    } else if (keyValue) {
                        labelBuilder << keyValue
                    } else {
                        def s = el.toString()
                        if (s) labelBuilder << s
                    }
                } else {
                    def s = el.toString()
                    if (s) labelBuilder << s
                }
                modelList << new ItemObject(labelBuilder.toString(), keyValue, selected)
            }
            if (attrs.multiple && attrs.multiple != 'false') {
                attrs.width = attrs.width ?: "200px"
                z.listbox([model: new ListModelList(modelList), itemRenderer: new SelectListitemRenderer()] + attrs)
            } else {
                if (selectedIndex != null) {
                    attrs.onCreate = "self.selectedIndex = ${selectedIndex}".toString()
                } else if (noSelection != null) {
                    def noSelectionKey = noSelection.key
                    def noSelectionValue = noSelection.value
                    modelList.add(0, new ItemObject(noSelectionValue, noSelectionKey))
                    attrs.onCreate = "self.selectedIndex = 0"
                }
                z.combobox([model: new ListModelList(modelList), itemRenderer: new SelectComboitemRenderer(), readonly: true] + attrs)
            }
            return
        }
    }


    def typeConverter = new SimpleTypeConverter()

    private isSelected(keyValue, value, el) {
        boolean selected = false
        def keyClass = keyValue?.getClass()
        if (keyClass.isInstance(value)) {
            selected = (keyValue == value)
        }
        else if (value instanceof Collection) {
            // first try keyValue
            selected = value.contains(keyValue)
            if (!selected && el != null) {
                selected = value.contains(el)
            }
        }
        else if (keyClass && value) {
            try {
                value = typeConverter.convertIfNecessary(value, keyClass)
                selected = (keyValue == value)
            }
            catch (e) {
                // ignore
            }
        }
        if (selected) return true
        return false
    }

    class SelectComboitemRenderer implements ComboitemRenderer {
        @Override
        void render(Comboitem comboitem, Object o, int i) {
            comboitem.label = o.key
            comboitem.value = o.value
        }
    }

    class SelectListitemRenderer implements ListitemRenderer {
        @Override
        void render(Listitem listitem, Object o, int i) {
            listitem.label = o.key
            listitem.value = o.value
            listitem.selected = o.selected
        }
    }

    class ItemObject {
        String key
        Object value
        Boolean selected

        ItemObject(String key, Object value, Boolean selected = false) {
            this.key = key
            this.value = value
            this.selected = selected
        }
    }
}
