package org.grails.plugins.zkui

import javax.servlet.ServletContext
import org.springframework.web.context.ServletContextAware
import org.zkoss.lang.Library
import org.zkoss.zk.ui.http.WebManager

class WebManagerInit implements ServletContextAware {
    void setServletContext(ServletContext servletContext) {
        final WebManager webman = WebManager.getWebManagerIfAny(servletContext);
        if (webman == null) {
            final String ATTR = "org.zkoss.zkplus.embed.updateURI";
            String updateURI = Library.getProperty(ATTR);
            if (updateURI == null)
                updateURI = "/zkau";
            else
                updateURI = org.zkoss.zk.ui.http.Utils.checkUpdateURI(updateURI, ATTR);
            new WebManager(servletContext, updateURI);
        }
    }
}