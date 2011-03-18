package org.grails.plugins.zkui.essential

import org.grails.plugins.zkui.AbstractTagLib

class AreaTagLib extends AbstractTagLib {
    static namespace = "z"

    /**
     * An area of a image map. Instead of the application processing the coordinates, developers can add the area components as children of a imagemap component thus defining a target. The imagemap component will translate the mouse pointer coordinates into a logical name ie. The id of the area the user clicked.
     *
     * @attr tooltiptext Sets the text as the tooltip.
     * @attr coords Sets the coords of this area. Its content depends on getShape():
     * @attr shape Sets the shape of this area.
     * @attr id Description copied from interface: Component Sets the ID. The scope of uniqueness depends on whether this component is a root component. Refer to Component.getId() for more details. Default: "" (an empty string; it means no ID at all).
     * @attr mold Description copied from interface: Component Sets the mold to render this component.
     * @attr widgetClass Description copied from interface: Component Sets the widget class (aka., the widget type). The widget class is a JavaScript class, including the package name. For example, "zul.wnd.Window".
     * @attr stubonly Description copied from interface: Component Sets whether this component is stub-only. By stub-only, we mean we don't need to maintain the states of the component at the server side. Default: "inherit" (i.e., the same as the parent's stub-only, and "false" is assumed if none of parents is specified with stub-only). If a component is set to stub-only, the application running at the server shall not access it anymore after renderred to the client. The ZK loader will try to minimize the memory footprint by merging stub-only components and replacing with light-weight components. However, the event listeners and handlers are preserved, so they will be invoked if the corresponding event is received. Since the original component is gone, the event is the more generic format: an instance of Event (rather than MouseEvent or others). If a component is stub-only, the application usually access it only at the client since all widgets are preserved at the client (so are events). This method is available only for ZK EE.
     * @attr definition Description copied from interface: ComponentCtrl Sets the component definition by specifing the name.
     * @attr visible Description copied from interface: Component Sets whether this component is visible.
     *
     */
    def area = {attrs, b ->
        //just for Intellij IDEA coding assistance
        true || attrs.apply || attrs.tooltiptext || attrs.coords || attrs.shape || attrs.id || attrs.mold || attrs.widgetClass || attrs.stubonly || attrs.definition || attrs.visible
        doTag(attrs, b, servletContext, request, response, pageScope, out)
    }

    @Override
    Class getComponentClass() {
        return org.zkoss.zul.Area
    }

}