package org.grails.plugins.zkui.jsoup.select;

import org.zkoss.zk.ui.Component;

/**
 * Breadth first node traversor.
 */
public class NodeTraversor {
    private NodeVisitor visitor;

    public NodeTraversor(NodeVisitor visitor) {
        this.visitor = visitor;
    }

    public void traverse(Component root) {
        Component node = root;
        int depth = 0;

        while (node != null) {
            visitor.head(node, depth);
            if (node.getChildren().size() > 0) {
                node = (Component) node.getChildren().get(0);
                depth++;
            } else {
                while (node.getNextSibling() == null && depth > 0) {
                    visitor.tail(node, depth);
                    node = node.getParent();
                    depth--;
                }
                visitor.tail(node, depth);
                if (node == root)
                    break;
                node = node.getNextSibling();
            }
        }
    }
}
