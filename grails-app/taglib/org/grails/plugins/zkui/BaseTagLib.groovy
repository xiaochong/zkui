package org.grails.plugins.zkui

import org.grails.plugins.zkui.util.Renders
import org.zkoss.util.ArraysX
import org.zkoss.xel.VariableResolver
import org.zkoss.zk.fn.JspFns
import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.Execution
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.util.Template

class BaseTagLib {
    static namespace = "z"

    /**
     * render a zk Component.
     *
     * @attr comp REQUIRED the field name
     */
    def render = { attrs, b ->
        if (!attrs.comp) {
            throwTagError("Attribute [comp] must not be null")
        }
        if (!(attrs.comp instanceof Component)) {
            throwTagError("Attribute [comp] has to be org.zkoss.zk.ui.Component")
        }
        Component comp = attrs.comp
        Renders.render(servletContext, request, response, comp, null, out)
    }

    /**
     * render a zk style sheet and javascript resource.
     */
    def resources = {attrs, b ->
        out << '<meta http-equiv="Pragma" content="no-cache"/>'
        out << '<meta http-equiv="Expires" content="-1"/>'
        out << JspFns.outZkHtmlTags(servletContext, request, response, null)
    }


    def attribute = {attrs, b ->
        if (!attrs.name) {
            throwTagError("Attribute [name] must not be null")
        }
        String content = b.call()
        if (content) {
            if ("true".equalsIgnoreCase(attrs.trim)) content = content.trim()
            AbstractTagLib.setAttrs([(attrs.name): content], request['parents']?.last, servletContext)
        }
    }

    def page = {attrs, b ->
        if (attrs.id) {
            request.setAttribute('zk_page_id', attrs.id)
        }
        def zkPageStyle = attrs.style
        if (zkPageStyle) {
            zkPageStyle = zkPageStyle != null && zkPageStyle.length() > 0 ? zkPageStyle : null
            request.setAttribute('zk_page_style', zkPageStyle)
        }
        out << b.call()
        request.removeAttribute('zk_page_id')
        request.removeAttribute('zk_page_style')
    }

    def template = {attrs, b ->
        true || attrs.name || attrs.src
        final Map<String, String> _params = new LinkedHashMap<String, String>()
        String name = null, src = null;
        attrs.each {key, value ->
            final String attnm = key
            final String attval = value
            if ("name".equals(attnm)) {
                name = attval;
            } else if ("src".equals(attnm)) {
                src = attval;
            } else {
                _params.put(attnm, attval)
            }
        }
        def comp = request['parents']?.last
        def body = b()?.toString()?.replace('#{', '${')
        comp.setTemplate(name, new TemplateImpl(_params, src, body))
    }

    private static class TemplateImpl implements Template, Serializable {
        final Map _params
        final String src
        final String body

        TemplateImpl(Map _params, String src, String body) {
            this._params = _params
            this.src = src
            this.body = body
        }

        Component[] create(Component parent, Component insertBefore, VariableResolver resolver) {
            final Execution exec = Executions.getCurrent()
            if (resolver != null) exec.addVariableResolver(resolver)
            final Component[] cs
            try {
                cs = [exec.createComponentsDirectly(body, null, parent, insertBefore, resolver)] as Component[]
            } finally {
                if (resolver != null) exec.removeVariableResolver(resolver)
            }
            final Component c2 = src != null ?
                exec.createComponents(src, parent, insertBefore, resolver) : null
            def components = merge(cs, c2)
            return components
        }

        Map<String, Object> getParameters() {
            return _params
        }

        private static Component[] merge(Component[] cs, Component c) {
            if (c != null) {
                cs = (Component[]) ArraysX.resize(cs, cs.length + 1)
                cs[cs.length - 1] = c
            }
            return cs
        }
    }
}
