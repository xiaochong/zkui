package org.grails.plugins.zkui.jsoup.select;

import org.zkoss.zk.ui.Component;

/**
 * Base structural evaluator.
 */
abstract class StructuralEvaluator extends Evaluator {
    Evaluator evaluator;

    static class Root extends Evaluator {
        public boolean matches(Component root, Component element) {
            return root == element;
        }
    }

    static class Has extends StructuralEvaluator {
        public Has(Evaluator evaluator) {
            this.evaluator = evaluator;
        }

        public boolean matches(Component root, Component element) {
            for (Component e : Collector.collect(new AllComponents(), element)) {
                if (e != element && evaluator.matches(root, e))
                    return true;
            }
            return false;
        }

        public String toString() {
            return String.format(":has(%s)", evaluator);
        }
    }

    static class Not extends StructuralEvaluator {
        public Not(Evaluator evaluator) {
            this.evaluator = evaluator;
        }

        public boolean matches(Component root, Component node) {
            return !evaluator.matches(root, node);
        }

        public String toString() {
            return String.format(":not%s", evaluator);
        }
    }

    static class Parent extends StructuralEvaluator {
        public Parent(Evaluator evaluator) {
            this.evaluator = evaluator;
        }

        public boolean matches(Component root, Component element) {
            if (root == element)
                return false;

            Component parent = element.getParent();
            while (parent != root) {
                if (evaluator.matches(root, parent))
                    return true;
                parent = parent.getParent();
            }
            return false;
        }

        public String toString() {
            return String.format(":parent%s", evaluator);
        }
    }

    static class ImmediateParent extends StructuralEvaluator {
        public ImmediateParent(Evaluator evaluator) {
            this.evaluator = evaluator;
        }

        public boolean matches(Component root, Component element) {
            if (root == element)
                return false;

            Component parent = element.getParent();
            return parent != null && evaluator.matches(root, parent);
        }
    }

    static class PreviousSibling extends StructuralEvaluator {
        public PreviousSibling(Evaluator evaluator) {
            this.evaluator = evaluator;
        }

        public boolean matches(Component root, Component element) {
            if (root == element)
                return false;

            Component prev = element.getPreviousSibling();

            while (prev != null) {
                if (evaluator.matches(root, prev))
                    return true;

                prev = prev.getPreviousSibling();
            }
            return false;
        }

        public String toString() {
            return String.format(":prev*%s", evaluator);
        }
    }

    static class ImmediatePreviousSibling extends StructuralEvaluator {
        public ImmediatePreviousSibling(Evaluator evaluator) {
            this.evaluator = evaluator;
        }

        public boolean matches(Component root, Component element) {
            if (root == element)
                return false;

            Component prev = element.getPreviousSibling();
            return prev != null && evaluator.matches(root, prev);
        }

        public String toString() {
            return String.format(":prev%s", evaluator);
        }
    }
}
