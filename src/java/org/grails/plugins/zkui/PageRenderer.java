package org.grails.plugins.zkui;

import org.grails.plugins.zkui.zul.Inline;
import org.zkoss.xml.XMLs;
import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.sys.ComponentCtrl;
import org.zkoss.zk.ui.sys.HtmlPageRenders;
import org.zkoss.zk.ui.sys.SEORenderer;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

class PageRenderer implements org.zkoss.zk.ui.sys.PageRenderer {
    public void render(Page page, Writer out) throws IOException {
        final Execution exec = Executions.getCurrent();
        final Desktop desktop = exec.getDesktop();

        out.write("<script type=\"text/javascript\">zkpb('");
        out.write(page.getUuid());
        out.write("','");
        out.write(desktop.getId());
        out.write("','");
        out.write(getContextURI(exec));
        out.write("','");
        out.write(desktop.getUpdateURI(null));
        out.write("','");
        out.write(desktop.getRequestPath());
        out.write('\'');

        String style = page.getStyle();
        if (style != null && style.length() > 0) {
            out.write(",{style:'");
            out.write(style);
            out.write("'}");
        }

        out.write(");zkpe();</script>\n");

        for (Iterator it = page.getRoots().iterator(); it.hasNext(); ) {
            final Component comp = (Component) it.next();
            if (!(comp instanceof Inline)) {
                out.write("<div");
                writeAttr(out, "id", comp.getUuid());
                out.write(">");
                if (page != null) {
                    final WebApp wapp = page.getDesktop().getWebApp();
                    String currentVersion = wapp.getVersion();
                    if (org.zkoss.util.Utils.compareVersion(org.zkoss.util.Utils.parseVersion(currentVersion),
                            org.zkoss.util.Utils.parseVersion("5.0.7")) > -1) {
                        SEORenderer[] seos = wapp.getConfiguration().getSEORenderers();
                        for (int i = 0; i < seos.length; i++) {
                            (seos[i]).render(page, out);
                        }
                    }
                }
                out.write("</div><script type=\"text/javascript\">");
            }

            ((ComponentCtrl) comp).redraw(out);

            if (!(comp instanceof Inline)) {
                out.write("</script>\n");
            }
        }

        out.write(HtmlPageRenders.outResponseJavaScripts(exec));
    }

    private static String getContextURI(Execution exec) {
        if (exec != null) {
            String s = exec.encodeURL("/");
            int j = s.lastIndexOf('/'); //might have jsessionid=...
            return j >= 0 ? s.substring(0, j) + s.substring(j + 1) : s;
        }
        return "";
    }

    private static void writeAttr(Writer out, String name, String value)
            throws IOException {
        out.write(' ');
        out.write(name);
        out.write("=\"");
        out.write(XMLs.encodeAttribute(value));
        out.write('"');
    }
}