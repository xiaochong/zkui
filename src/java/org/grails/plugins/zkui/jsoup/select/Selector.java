package org.grails.plugins.zkui.jsoup.select;

import org.grails.plugins.zkui.jsoup.helper.Validate;
import org.zkoss.zk.ui.Component;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * CSS-like Component selector, that finds Components matching a query.
 * <p/>
 * <h2>Selector syntax</h2>
 * A selector is a chain of simple selectors, seperated by combinators. Selectors are case insensitive (including against
 * Components, attributes, and attribute values).
 * <p/>
 * The universal selector (*) is implicit when no Component selector is supplied (i.e. {@code *.header} and {@code .header}
 * is equivalent).
 * <p/>
 * <table>
 * <tr><th>Pattern</th><th>Matches</th><th>Example</th></tr>
 * <tr><td><code>*</code></td><td>any Component</td><td><code>*</code></td></tr>
 * <tr><td><code>tag</code></td><td>Components with the given tag name</td><td><code>div</code></td></tr>
 * <tr><td><code>ns|E</code></td><td>Components of type E in the namespace <i>ns</i></td><td><code>fb|name</code> finds <code>&lt;fb:name></code> Components</td></tr>
 * <tr><td><code>#id</code></td><td>Components with attribute ID of "id"</td><td><code>div#wrap</code>, <code>#logo</code></td></tr>
 * <tr><td><code>.class</code></td><td>Components with a class name of "class"</td><td><code>div.left</code>, <code>.result</code></td></tr>
 * <tr><td><code>[attr]</code></td><td>Components with an attribute named "attr" (with any value)</td><td><code>a[href]</code>, <code>[title]</code></td></tr>
 * <tr><td><code>[^attrPrefix]</code></td><td>Components with an attribute name starting with "attrPrefix". Use to find Components with HTML5 datasets</td><td><code>[^data-]</code>, <code>div[^data-]</code></td></tr>
 * <tr><td><code>[attr=val]</code></td><td>Components with an attribute named "attr", and value equal to "val"</td><td><code>img[width=500]</code>, <code>a[rel=nofollow]</code></td></tr>
 * <tr><td><code>[attr^=valPrefix]</code></td><td>Components with an attribute named "attr", and value starting with "valPrefix"</td><td><code>a[href^=http:]</code></code></td></tr>
 * <tr><td><code>[attr$=valSuffix]</code></td><td>Components with an attribute named "attr", and value ending with "valSuffix"</td><td><code>img[src$=.png]</code></td></tr>
 * <tr><td><code>[attr*=valContaining]</code></td><td>Components with an attribute named "attr", and value containing "valContaining"</td><td><code>a[href*=/search/]</code></td></tr>
 * <tr><td><code>[attr~=<em>regex</em>]</code></td><td>Components with an attribute named "attr", and value matching the regular expression</td><td><code>img[src~=(?i)\\.(png|jpe?g)]</code></td></tr>
 * <tr><td></td><td>The above may be combined in any order</td><td><code>div.header[title]</code></td></tr>
 * <tr><td><td colspan="3"><h3>Combinators</h3></td></tr>
 * <tr><td><code>E F</code></td><td>an F Component descended from an E Component</td><td><code>div a</code>, <code>.logo h1</code></td></tr>
 * <tr><td><code>E > F</code></td><td>an F direct child of E</td><td><code>ol > li</code></td></tr>
 * <tr><td><code>E + F</code></td><td>an F Component immediately preceded by sibling E</td><td><code>li + li</code>, <code>div.head + div</code></td></tr>
 * <tr><td><code>E ~ F</code></td><td>an F Component preceded by sibling E</td><td><code>h1 ~ p</code></td></tr>
 * <tr><td><code>E, F, G</code></td><td>all matching Components E, F, or G</td><td><code>a[href], div, h3</code></td></tr>
 * <tr><td><td colspan="3"><h3>Pseudo selectors</h3></td></tr>
 * <tr><td><code>:lt(<em>n</em>)</code></td><td>Components whose sibling index is less than <em>n</em></td><td><code>td:lt(3)</code> finds the first 2 cells of each row</td></tr>
 * <tr><td><code>:gt(<em>n</em>)</code></td><td>Components whose sibling index is greater than <em>n</em></td><td><code>td:gt(1)</code> finds cells after skipping the first two</td></tr>
 * <tr><td><code>:eq(<em>n</em>)</code></td><td>Components whose sibling index is equal to <em>n</em></td><td><code>td:eq(0)</code> finds the first cell of each row</td></tr>
 * <tr><td><code>:has(<em>selector</em>)</code></td><td>Components that contains at least one Component matching the <em>selector</em></td><td><code>div:has(p)</code> finds divs that contain p Components </td></tr>
 * <tr><td><code>:not(<em>selector</em>)</code></td><td>Components that do not match the <em>selector</em>. </td><code>div:not(.logo)</code> finds all divs that do not have the "logo" class</td></tr>
 * <tr><td><code>:contains(<em>text</em>)</code></td><td>Components that contains the specified text. The search is case insensitive. The text may appear in the found Component, or any of its descendants.</td><td><code>p:contains(jsoup)</code> finds p Components containing the text "jsoup".</td></tr>
 * <tr><td><code>:matches(<em>regex</em>)</code></td><td>Components whose text matches the specified regular expression. The text may appear in the found Component, or any of its descendants.</td><td><code>td:matches(\\d+)</code> finds table cells containing digits. <code>div:matches((?i)login)</code> finds divs containing the text, case insensitively.</td></tr>
 * <tr><td><code>:containsOwn(<em>text</em>)</code></td><td>Components that directly contains the specified text. The search is case insensitive. The text must appear in the found Component, not any of its descendants.</td><td><code>p:containsOwn(jsoup)</code> finds p Components with own text "jsoup".</td></tr>
 * <tr><td><code>:matchesOwn(<em>regex</em>)</code></td><td>Components whose own text matches the specified regular expression. The text must appear in the found Component, not any of its descendants.</td><td><code>td:matchesOwn(\\d+)</code> finds table cells directly containing digits. <code>div:matchesOwn((?i)login)</code> finds divs containing the text, case insensitively.</td></tr>
 * <tr><td></td><td>The above may be combined in any order and with other selectors</td><td><code>.light:contains(name):eq(0)</code></td></tr>
 * </table>
 *
 * @author Jonathan Hedley, jonathan@hedley.net
 */
public class Selector {
    private final Evaluator evaluator;
    private final Component root;

    private Selector(String query, Component root) {
        Validate.notNull(query);
        query = query.trim();
        Validate.notEmpty(query);
        Validate.notNull(root);

        this.evaluator = QueryParser.parse(query);
        this.root = root;
    }

    /**
     * Find Components matching selector.
     *
     * @param query CSS selector
     * @param root  root Component to descend into
     * @return matching Components, empty if not
     */
    public static Components select(String query, Component root) {
        return new Selector(query, root).select();
    }

    /**
     * Find Components matching selector.
     *
     * @param query CSS selector
     * @param roots root Components to descend into
     * @return matching Components, empty if not
     */
    public static Components select(String query, Iterable<Component> roots) {
        Validate.notEmpty(query);
        Validate.notNull(roots);
        LinkedHashSet<Component> Components = new LinkedHashSet<Component>();

        for (Component root : roots) {
            Components.addAll(select(query, root));
        }
        return new Components(Components);
    }

    private Components select() {
        return Collector.collect(evaluator, root);
    }

    // exclude set. package open so that Components can implement .not() selector.
    static Components filterOut(Collection<Component> Components, Collection<Component> outs) {
        Components output = new Components();
        for (Component el : Components) {
            boolean found = false;
            for (Component out : outs) {
                if (el.equals(out)) {
                    found = true;
                    break;
                }
            }
            if (!found)
                output.add(el);
        }
        return output;
    }

    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String msg, Object... params) {
            super(String.format(msg, params));
        }
    }
}
