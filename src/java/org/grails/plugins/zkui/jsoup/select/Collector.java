package org.grails.plugins.zkui.jsoup.select;

import org.zkoss.zk.ui.Component;

/**
 * Collects a list of elements that match the supplied criteria.
 *
 * @author Jonathan Hedley
 */
public class Collector {

    private Collector() {
    }

    /**
     * Build a list of elements, by visiting root and every descendant of root, and testing it against the evaluator.
     *
     * @param eval Evaluator to test elements against
     * @param root root of tree to descend
     * @return list of matches; empty if none
     */
    public static Components collect(Evaluator eval, Component root) {
        Components elements = new Components();
        new NodeTraversor(new Accumulator(root, elements, eval)).traverse(root);
        return elements;
    }

    private static class Accumulator implements NodeVisitor {
        private final Component root;
        private final Components elements;
        private final Evaluator eval;

        Accumulator(Component root, Components elements, Evaluator eval) {
            this.root = root;
            this.elements = elements;
            this.eval = eval;
        }

        public void head(Component node, int depth) {
            if (node != null) {
                if (eval.matches(root, node))
                    elements.add(node);
            }
        }

        public void tail(Component node, int depth) {
            // void
        }
    }
}
