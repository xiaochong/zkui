/* AttributeInfo.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		2008/3/28 2008, Created by Ian Tsai
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.grails.plugins.zkui.util;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Components;
import org.zkoss.zk.ui.Page;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Ian Tsai
 */
public class AttributesInfo {
    private final Map _attrs;
    private final int _scope;

    /**
     * @param attrs
     * @param scope
     */
    public AttributesInfo(Map attrs, String scope) {
        _attrs = attrs;
        _scope = scope == null ?
                Component.COMPONENT_SCOPE : Components.getScope(scope);
    }

    /**
     * Applies the custom attributes by component.
     *
     * @param comp
     */
    public void apply(Component comp) {
        for (Iterator it = _attrs.entrySet().iterator(); it.hasNext(); ) {
            final Map.Entry me = (Map.Entry) it.next();
            final String name = (String) me.getKey();
            comp.setAttribute(name, me.getValue(), _scope);
        }
    }

    /**
     * Applies the custom attributes by page.
     *
     * @param page
     */
    public void apply(Page page) {
        for (Iterator it = _attrs.entrySet().iterator(); it.hasNext(); ) {
            final Map.Entry me = (Map.Entry) it.next();
            final String name = (String) me.getKey();
            page.setAttribute(name, me.getValue(), _scope);
        }
    }

    //Object//
    public String toString() {
        final StringBuffer sb = new StringBuffer(40).append("[custom-attributes:");
        if (_attrs != null)
            for (Iterator it = _attrs.keySet().iterator(); it.hasNext(); )
                sb.append(' ').append(it.next());
        return sb.append(']').toString();
    }
}
