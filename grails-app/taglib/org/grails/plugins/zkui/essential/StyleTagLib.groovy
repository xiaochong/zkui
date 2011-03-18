package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class StyleTagLib extends AbstractTagLib {
    static namespace = "z"

    /**
     * The style component used to specify <tt>CSS</tt> styles for the owner desktop.<b>Note:</b>
     *
     * @attr src Sets the URI of an external style sheet. Calling this method implies setContent(null). In other words, the last invocation of setSrc(java.lang.String) overrides the previous setContent(java.lang.String), if any.
     * @attr content Sets the content of the style element. By content we mean the CSS rules that will be sent to the client. Calling this method implies setSrc(null). In other words, the last invocation of setContent(java.lang.String) overrides the previous setSrc(java.lang.String), if any.
     * @attr dynamic Deprecated.  As of release 5.0.0, it is decided automatically.
     * @attr media Sets the media dependencies for this style sheet. Refer to media-depedent style sheet for details.
     * @attr visible Not allowd.
     * @attr id Description copied from interface: Component Sets the ID. The scope of uniqueness depends on whether this component is a root component. Refer to Component.getId() for more details. Default: "" (an empty string; it means no ID at all).
     * @attr mold Description copied from interface: Component Sets the mold to render this component.
     * @attr widgetClass Description copied from interface: Component Sets the widget class (aka., the widget type). The widget class is a JavaScript class, including the package name. For example, "zul.wnd.Window".
     * @attr stubonly Description copied from interface: Component Sets whether this component is stub-only. By stub-only, we mean we don't need to maintain the states of the component at the server side. Default: "inherit" (i.e., the same as the parent's stub-only, and "false" is assumed if none of parents is specified with stub-only). If a component is set to stub-only, the application running at the server shall not access it anymore after renderred to the client. The ZK loader will try to minimize the memory footprint by merging stub-only components and replacing with light-weight components. However, the event listeners and handlers are preserved, so they will be invoked if the corresponding event is received. Since the original component is gone, the event is the more generic format: an instance of Event (rather than MouseEvent or others). If a component is stub-only, the application usually access it only at the client since all widgets are preserved at the client (so are events). This method is available only for ZK EE.
     * @attr definition Description copied from interface: ComponentCtrl Sets the component definition by specifing the name.
     *
     */
    def style = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.src || attrs.content || attrs.dynamic || attrs.media || attrs.visible || attrs.id || attrs.mold || attrs.widgetClass || attrs.stubonly || attrs.definition
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Style
    }

}
