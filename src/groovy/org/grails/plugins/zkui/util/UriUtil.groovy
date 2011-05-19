package org.grails.plugins.zkui.util;

public class UriUtil {
    public static String fixToZk(String uri, String contextPath) {
        if (uri == null) return null
        if (uri.startsWith(contextPath)) return uri.replaceFirst(contextPath, "")
        return uri
    }
}