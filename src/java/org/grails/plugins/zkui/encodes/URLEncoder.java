package org.grails.plugins.zkui.encodes;

import org.zkoss.util.logging.Log;
import org.zkoss.web.servlet.Charsets;
import org.zkoss.web.servlet.Servlets;
import org.zkoss.web.servlet.http.Encodes;
import org.zkoss.web.servlet.http.Https;
import org.zkoss.web.util.resource.ExtendletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class URLEncoder implements org.zkoss.web.servlet.http.Encodes.URLEncoder {
    private static final Log log = Log.lookup(Https.class);

    /**
     * unsafe character when that are used in url's location.
     */
    private static final char[] URI_UNSAFE;
    /**
     * unsafe character when that are used in url's query.
     */
    private static final char[] URI_COMP_UNSAFE;

    static {
        URI_UNSAFE = "`%^{}[]\\\"<>|".toCharArray();
        Arrays.sort(URI_UNSAFE);

        URI_COMP_UNSAFE = "`%^{}[]\\\"<>|$&,/:;=?".toCharArray();
        Arrays.sort(URI_COMP_UNSAFE);
    }

    public String encodeURL(ServletContext ctx, ServletRequest request, ServletResponse response, String url, Encodes.URLEncoder defaultEncoder) throws Exception {
        return encodeURL0(ctx, request, response, url);
    }

    private static final String encodeURL0(ServletContext ctx,
                                           ServletRequest request, ServletResponse response, String uri)
            throws Exception {
        if (uri == null || uri.length() == 0)
            return uri; //keep as it is

        boolean ctxpathSpecified = false;
        if (uri.charAt(0) != '/') { //NOT relative to context path
            if (Servlets.isUniversalURL(uri)) return uri; //nothing to do

            if (uri.charAt(0) == '~') { //foreign context
                final String ctxroot;
                if (uri.length() == 1) {
                    ctxroot = uri = "/";
                } else if (uri.charAt(1) == '/') {
                    ctxroot = "/";
                    uri = uri.substring(1);
                } else {
                    uri = '/' + uri.substring(1);
                    final int j = uri.indexOf('/', 1);
                    ctxroot = j >= 0 ? uri.substring(0, j) : uri;
                }

                final ExtendletContext extctx =
                        Servlets.getExtendletContext(ctx, ctxroot.substring(1));
                if (extctx != null) {
                    final int j = uri.indexOf('/', 1);
                    return extctx.encodeURL(request, response,
                            j >= 0 ? uri.substring(j) : "/");
                }

                final ServletContext newctx = ctx.getContext(ctxroot);
                if (newctx != null) {
                    ctx = newctx;
                } else if (log.debugable()) {
                    log.debug("Context not found: " + ctxroot);
                }
                ctxpathSpecified = true;
            } else if (Https.isIncluded(request) || Https.isForwarded(request)) {
                //if reletive URI and being included/forwarded,
                //converts to absolute
                String pgpath = Https.getThisServletPath(request);
                if (pgpath != null) {
                    int j = pgpath.lastIndexOf('/');
                    if (j >= 0) {
                        uri = pgpath.substring(0, j + 1) + uri;
                    } else {
                        log.warning("The current page doesn't contain '/':" + pgpath);
                    }
                }
            }
        }

        //locate by locale and browser if necessary
        uri = Servlets.locate(ctx, request, uri, null);

        //prefix context path
        if (!ctxpathSpecified && uri.charAt(0) == '/'
                && (request instanceof HttpServletRequest)) {
            //Work around with a bug when we wrap Pluto's RenderRequest (1.0.1)
            String ctxpath = ((HttpServletRequest) request).getContextPath();
            if (ctxpath.length() > 0 && ctxpath.charAt(0) != '/')
                ctxpath = '/' + ctxpath;

            //Some Web server's ctxpath is "/"
            final int last = ctxpath.length() - 1;
            if (last >= 0 && ctxpath.charAt(last) == '/')
                ctxpath = ctxpath.substring(0, last);

            uri = ctxpath + uri;
        }

        int j = uri.indexOf('?');
        if (j < 0) {
            uri = encodeURI(uri);
        } else {
            uri = encodeURI(uri.substring(0, j)) + uri.substring(j);
        }
        //encode
        if (response instanceof HttpServletResponse && !uri.contains("/static/")) //zkui fix #118,todo make it configurable
            uri = ((HttpServletResponse) response).encodeURL(uri);
        return uri;
    }

    public static final String encodeURI(String s)
            throws UnsupportedEncodingException {
        return encodeURI0(s, URI_UNSAFE);
    }

    public static final String encodeURIComponent(String s)
            throws UnsupportedEncodingException {
        return encodeURI0(s, URI_COMP_UNSAFE);
    }

    private static final String encodeURI0(String s, char[] unsafes)
            throws UnsupportedEncodingException {
        if (s == null)
            return null;

        final String charset = Charsets.getURICharset();
        final byte[] in = s.getBytes(charset);
        final byte[] out = new byte[in.length * 3];//at most: %xx
        int j = 0, k = 0;
        for (; j < in.length; ++j) {
            //Though it is ok to use '+' for ' ', Jetty has problem to
            //handle space between chinese characters.
            final char cc = (char) (((int) in[j]) & 0xff);
            if (cc >= 0x80 || cc <= ' '
                    || Arrays.binarySearch(unsafes, cc) >= 0) {
                out[k++] = (byte) '%';
                String cvt = Integer.toHexString(cc);
                if (cvt.length() == 1) {
                    out[k++] = (byte) '0';
                    out[k++] = (byte) cvt.charAt(0);
                } else {
                    out[k++] = (byte) cvt.charAt(0);
                    out[k++] = (byte) cvt.charAt(1);
                }
            } else {
                out[k++] = in[j];
            }
        }
        return j == k ? s : new String(out, 0, k, charset);
    }
}
