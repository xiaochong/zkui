package org.grails.plugins.zkui

import org.springframework.web.servlet.support.RequestContextUtils as RCU

import org.codehaus.groovy.grails.commons.DomainClassArtefactHandler
import org.codehaus.groovy.grails.web.util.StreamCharBuffer
import org.springframework.beans.SimpleTypeConverter
import org.springframework.context.MessageSourceResolvable
import org.zkoss.zul.Comboitem
import org.zkoss.zul.ComboitemRenderer
import org.zkoss.zul.ListModelList

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
            attrs.multiline = true
        }
        if (attrs.multiple) {
            attrs.multiline = attrs.remove("multiple")
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
            attrs.disabled = 'disabled'
        }
        if (from) {
            List<ComboitemValue> modelList = []
            Integer selectedIndex
            from.eachWithIndex {el, i ->
                def keyValue = null
                if (keys) {
                    keyValue = keys[i]
                    if (!selectedIndex && isSelected(keyValue, value, null)) {
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
                    if (!selectedIndex && isSelected(keyValue, value, el)) {
                        selectedIndex = i
                    }
                } else {
                    keyValue = el
                    if (!selectedIndex && isSelected(keyValue, value, null)) {
                        selectedIndex = i
                    }
                }
                StringBuilder labelBuilder = new StringBuilder()
                if (optionValue) {
                    if (optionValue instanceof Closure) {
                        labelBuilder << optionValue(el).toString().encodeAsHTML()
                    } else {
                        labelBuilder << el[optionValue].toString().encodeAsHTML()
                    }
                } else if (el instanceof MessageSourceResolvable) {
                    labelBuilder << messageSource.getMessage(el, locale)
                } else if (valueMessagePrefix) {
                    def message = messageSource.getMessage("${valueMessagePrefix}.${keyValue}", null, null, locale)
                    if (message != null) {
                        labelBuilder << message.encodeAsHTML()
                    } else if (keyValue && keys) {
                        def s = el.toString()
                        if (s) labelBuilder << s.encodeAsHTML()
                    } else if (keyValue) {
                        labelBuilder << keyValue.encodeAsHTML()
                    } else {
                        def s = el.toString()
                        if (s) labelBuilder << s.encodeAsHTML()
                    }
                } else {
                    def s = el.toString()
                    if (s) labelBuilder << s.encodeAsHTML()
                }
                modelList << new ComboitemValue(labelBuilder.toString(), keyValue)
            }
            if (selectedIndex != null) {
                attrs.onCreate = "self.selectedIndex = ${selectedIndex}".toString()
            } else if (noSelection != null) {
                def noSelectionKey = noSelection.key
                def noSelectionValue = noSelection.value
                modelList.add(0, new ComboitemValue(noSelectionValue, noSelectionKey))
                attrs.onCreate = "self.selectedIndex = 0"
            }
            z.combobox([model: new ListModelList(modelList), itemRenderer: new SelectComboitemRenderer(),readonly:true] + attrs)
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
        void render(Comboitem comboitem, Object o) {
            comboitem.label = o.label
            comboitem.value = o.value
        }
    }

    class ComboitemValue {
        String label
        Object value

        ComboitemValue(String label, Object value) {
            this.label = label
            this.value = value
        }

    }
}
