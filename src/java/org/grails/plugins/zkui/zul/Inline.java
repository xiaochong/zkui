package org.grails.plugins.zkui.zul;

import org.zkoss.zk.ui.AbstractComponent;

import java.io.IOException;
import java.io.Writer;

public class Inline extends AbstractComponent {
    private String _content = "";
    private transient boolean _inRedraw;

    /**
     * Contructs a {@link Inline} component to embed HTML tags.
     */
    public Inline() {
    }

    /**
     * Contructs a {@link Inline} component to embed HTML tags
     * with the specified content.
     */
    public Inline(String content) {
        _content = content != null ? content : "";
    }

    /**
     * Returns the embedded content (i.e., HTML tags).
     * <p>Default: empty ("").
     */
    public String getContent() {
        return _content;
    }

    /**
     * Sets the embedded content (i.e., HTML tags).
     * <p/>
     * <p>Note: Unlike {@link org.zkoss.zul.Html}, the content of {@link Inline}
     * cannot be changed dynamically.
     * In other words, once the output of
     * {@link Inline} is sent the client, calling this method
     * won't change the content at the client accordingly.
     * Rather, you have to invalidate its parent, such that the new
     * content will be sent to the client with its parent's content.
     */
    public void setContent(String content) {
        _content = content != null ? content : "";
    }

    //-- Component --//

    /**
     * Default: not childable.
     */
    public boolean isChildable() {
        return false;
    }

    public void redraw(Writer out) throws IOException {
        if (_inRedraw) { //if callback, invoke super
            super.redraw(out);
        } else {
            _inRedraw = true;
            try {
                draw(out);
            } finally {
                _inRedraw = false;
            }
        }
    }

    public String getWidgetClass() { //ZK 5.0
        return "zk.Native";
    }

    protected void renderProperties(org.zkoss.zk.ui.sys.ContentRenderer renderer)
            throws java.io.IOException { //ZK 5.0
        super.renderProperties(renderer);
        render(renderer, "prolog", getContent());
    }

    protected void draw(Writer out) throws IOException {
        if (getParent() != null)
            redraw(out); //callback
        else
            out.write(getContent()); //directly output
    }
}