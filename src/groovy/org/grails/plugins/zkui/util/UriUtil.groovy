package org.grails.plugins.zkui.util;

public class UriUtil {
    public static String fixToZk(uri, contextPath) {
        if (uri == null) return null
        uri = uri.toString()
        contextPath = contextPath?.toString()
        if (uri.startsWith(contextPath)) return uri.replaceFirst(contextPath, "")
        return uri
    }
}