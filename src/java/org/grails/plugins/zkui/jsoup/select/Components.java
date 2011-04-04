package org.grails.plugins.zkui.jsoup.select;

import org.grails.plugins.zkui.jsoup.helper.ComponentUtil;
import org.zkoss.zk.ui.Component;

import java.util.*;

/**
 * A list of {@link Component Components}, with methods that act on every element in the list
 *
 * @author Jonathan Hedley, jonathan@hedley.net
 */
public class Components implements List<Component>, Cloneable {
    private List<Component> contents;

    public Components() {
        contents = new ArrayList<Component>();
    }

    public Components(Collection<Component> elements) {
        contents = new ArrayList<Component>(elements);
    }

    public Components(List<Component> elements) {
        contents = elements;
    }

    public Components(Component... elements) {
        this(Arrays.asList(elements));
    }

    @Override
    public Components clone() {
        List<Component> elements = new ArrayList<Component>();

        for (Component e : contents)
            elements.add((Component) e.clone());
        return new Components(elements);
    }

    // attribute methods

    /**
     * Get an attribute value from the first matched element that has the attribute.
     *
     * @param attributeKey The attribute key.
     * @return The attribute value from the first matched element that has the attribute.. If no elements were matched (isEmpty() == true),
     *         or if the no elements have the attribute, returns empty string.
     * @see #hasAttr(String)
     */
    public String attr(String attributeKey) {
        for (Component element : contents) {
            if (ComponentUtil.hasAttr(element, attributeKey))
                return ComponentUtil.attr(element, attributeKey);
        }
        return "";
    }

    /**
     * Checks if any of the matched elements have this attribute set.
     *
     * @param attributeKey attribute key
     * @return true if any of the elements have the attribute; false if none do.
     */
    public boolean hasAttr(String attributeKey) {
        for (Component element : contents) {
            if (ComponentUtil.hasAttr(element, attributeKey))
                return true;
        }
        return false;
    }

    /**
     * Set an attribute on all matched elements.
     *
     * @param attributeKey   attribute key
     * @param attributeValue attribute value
     * @return this
     */
    public Components attr(String attributeKey, String attributeValue) {
        for (Component element : contents) {
            ComponentUtil.attr(element, attributeKey, attributeValue);
        }
        return this;
    }

    /**
     * Remove an attribute from every matched element.
     *
     * @param attributeKey The attribute to remove.
     * @return this (for chaining)
     */
    public Components removeAttr(String attributeKey) {
        for (Component element : contents) {
            ComponentUtil.removeAttr(element, attributeKey);
        }
        return this;
    }

    /**
     * Add the class name to every matched element's {@code class} attribute.
     *
     * @param className class name to add
     * @return this
     */
    public Components addClass(String className) {
        for (Component element : contents) {
            ComponentUtil.addClass(element, className);
        }
        return this;
    }

    /**
     * Remove the class name from every matched element's {@code class} attribute, if present.
     *
     * @param className class name to remove
     * @return this
     */
    public Components removeClass(String className) {
        for (Component element : contents) {
            ComponentUtil.removeClass(element, className);
        }
        return this;
    }

    /**
     * Toggle the class name on every matched element's {@code class} attribute.
     *
     * @param className class name to add if missing, or remove if present, from every element.
     * @return this
     */
    public Components toggleClass(String className) {
        for (Component element : contents) {
            ComponentUtil.toggleClass(element, className);
        }
        return this;
    }

    /**
     * Determine if any of the matched elements have this class name set in their {@code class} attribute.
     *
     * @param className class name to check for
     * @return true if any do, false if none do
     */
    public boolean hasClass(String className) {
        for (Component element : contents) {
            if (ComponentUtil.hasClass(element, className))
                return true;
        }
        return false;
    }

    /**
     * Get the form element's value of the first matched element.
     *
     * @return The form element's value, or empty if not set.
     * @see Component
     */
    public String val() {
        if (size() > 0)
            return ComponentUtil.val(first()).toString();
        else
            return "";
    }

    /**
     * Set the form element's value in each of the matched elements.
     *
     * @param value The value to set into each matched element
     * @return this (for chaining)
     */
    public Components val(String value) {
        for (Component element : contents)
            ComponentUtil.val(element, value);
        return this;
    }

//    /**
//     * Get the combined text of all the matched elements.
//     * <p/>
//     * Note that it is possible to get repeats if the matched elements contain both parent elements and their own
//     * children, as the Component.text() method returns the combined text of a parent and all its children.
//     *
//     * @return string of all text: unescaped and no HTML.
//     * @see Component#text()
//     */
//    public String text() {
//        StringBuilder sb = new StringBuilder();
//        for (Component element : contents) {
//            if (sb.length() != 0)
//                sb.append(" ");
//            sb.append(element.text());
//        }
//        return sb.toString();
//    }
//
//    public boolean hasText() {
//        for (Component element : contents) {
//            if (element.hasText())
//                return true;
//        }
//        return false;
//    }
//
//    /**
//     * Get the combined inner HTML of all matched elements.
//     *
//     * @return string of all element's inner HTML.
//     * @see #text()
//     * @see #outerHtml()
//     */
//    public String html() {
//        StringBuilder sb = new StringBuilder();
//        for (Component element : contents) {
//            if (sb.length() != 0)
//                sb.append("\n");
//            sb.append(element.html());
//        }
//        return sb.toString();
//    }
//
//    /**
//     * Get the combined outer HTML of all matched elements.
//     *
//     * @return string of all element's outer HTML.
//     * @see #text()
//     * @see #html()
//     */
//    public String outerHtml() {
//        StringBuilder sb = new StringBuilder();
//        for (Component element : contents) {
//            if (sb.length() != 0)
//                sb.append("\n");
//            sb.append(element.outerHtml());
//        }
//        return sb.toString();
//    }
//
//    /**
//     * Get the combined outer HTML of all matched elements. Alias of {@link #outerHtml()}.
//     *
//     * @return string of all element's outer HTML.
//     * @see #text()
//     * @see #html()
//     */
//    public String toString() {
//        return outerHtml();
//    }
//
//    /**
//     * Update the tag name of each matched element. For example, to change each {@code <i>} to a {@code <em>}, do
//     * {@code doc.select("i").tagName("em");}
//     *
//     * @param tagName the new tag name
//     * @return this, for chaining
//     * @see Component#tagName(String)
//     */
//    public Components tagName(String tagName) {
//        for (Component element : contents) {
//            element.tagName(tagName);
//        }
//        return this;
//    }
//
//    /**
//     * Set the inner HTML of each matched element.
//     *
//     * @param html HTML to parse and set into each matched element.
//     * @return this, for chaining
//     * @see Component#html(String)
//     */
//    public Components html(String html) {
//        for (Component element : contents) {
//            element.html(html);
//        }
//        return this;
//    }
//
//    /**
//     * Add the supplied HTML to the start of each matched element's inner HTML.
//     *
//     * @param html HTML to add inside each element, before the existing HTML
//     * @return this, for chaining
//     * @see Component#prepend(String)
//     */
//    public Components prepend(String html) {
//        for (Component element : contents) {
//            element.prepend(html);
//        }
//        return this;
//    }
//
//    /**
//     * Add the supplied HTML to the end of each matched element's inner HTML.
//     *
//     * @param html HTML to add inside each element, after the existing HTML
//     * @return this, for chaining
//     * @see Component#append(String)
//     */
//    public Components append(String html) {
//        for (Component element : contents) {
//            element.append(html);
//        }
//        return this;
//    }
//
//    /**
//     * Insert the supplied HTML before each matched element's outer HTML.
//     *
//     * @param html HTML to insert before each element
//     * @return this, for chaining
//     * @see Component#before(String)
//     */
//    public Components before(String html) {
//        for (Component element : contents) {
//            element.before(html);
//        }
//        return this;
//    }
//
//    /**
//     * Insert the supplied HTML after each matched element's outer HTML.
//     *
//     * @param html HTML to insert after each element
//     * @return this, for chaining
//     * @see Component#after(String)
//     */
//    public Components after(String html) {
//        for (Component element : contents) {
//            element.after(html);
//        }
//        return this;
//    }
//
//    /**
//     * Wrap the supplied HTML around each matched elements. For example, with HTML
//     * {@code <p><b>This</b> is <b>Jsoup</b></p>},
//     * <code>doc.select("b").wrap("&lt;i&gt;&lt;/i&gt;");</code>
//     * becomes {@code <p><i><b>This</b></i> is <i><b>jsoup</b></i></p>}
//     *
//     * @param html HTML to wrap around each element, e.g. {@code <div class="head"></div>}. Can be arbitrarily deep.
//     * @return this (for chaining)
//     * @see Component#wrap
//     */
//    public Components wrap(String html) {
//        Validate.notEmpty(html);
//        for (Component element : contents) {
//            element.wrap(html);
//        }
//        return this;
//    }
//
//    /**
//     * Empty (remove all child nodes from) each matched element. This is similar to setting the inner HTML of each
//     * element to nothing.
//     * <p>
//     * E.g. HTML: {@code <div><p>Hello <b>there</b></p> <p>now</p></div>}<br>
//     * <code>doc.select("p").empty();</code><br>
//     * HTML = {@code <div><p></p> <p></p></div>}
//     *
//     * @return this, for chaining
//     * @see Component#empty()
//     * @see #remove()
//     */
//    public Components empty() {
//        for (Component element : contents) {
//            element.empty();
//        }
//        return this;
//    }
//
//    /**
//     * Remove each matched element from the DOM. This is similar to setting the outer HTML of each element to nothing.
//     * <p>
//     * E.g. HTML: {@code <div><p>Hello</p> <p>there</p> <img /></div>}<br>
//     * <code>doc.select("p").remove();</code><br>
//     * HTML = {@code <div> <img /></div>}
//     * <p/>
//     * Note that this method should not be used to clean user-submitted HTML; rather, use {@link org.jsoup.safety.Cleaner} to clean HTML.
//     *
//     * @return this, for chaining
//     * @see Component#empty()
//     * @see #empty()
//     */
//    public Components remove() {
//        for (Component element : contents) {
//            element.remove();
//        }
//        return this;
//    }

    // filters

    /**
     * Find matching elements within this element list.
     *
     * @param query A {@link Selector} query
     * @return the filtered list of elements, or an empty list if none match.
     */
    public Components select(String query) {
        return Selector.select(query, this);
    }

    /**
     * Remove elements from this list that do not match the {@link Selector} query.
     * <p/>
     * E.g. HTML: {@code <div class=logo>One</div> <div>Two</div>}<br>
     * <code>Components divs = doc.select("div").not("#logo");</code><br>
     * Result: {@code divs: [<div>Two</div>]}
     * <p/>
     *
     * @param query the selector query whose results should be removed from these elements
     * @return a new elements list that contains only the filtered results
     */
    public Components not(String query) {
        Components out = Selector.select(query, this);
        return Selector.filterOut(this, out);
    }

    /**
     * Get the <i>nth</i> matched element as an Components object.
     * <p/>
     * See also {@link #get(int)} to retrieve an Component.
     *
     * @param index the (zero-based) index of the element in the list to retain
     * @return Components containing only the specified element, or, if that element did not exist, an empty list.
     */
    public Components eq(int index) {
        return contents.size() > index ? new Components(get(index)) : new Components();
    }

    /**
     * Test if any of the matched elements match the supplied query.
     *
     * @param query A selector
     * @return true if at least one element in the list matches the query.
     */
    public boolean is(String query) {
        Components children = select(query);
        return !children.isEmpty();
    }

//    /**
//     * Get all of the parents and ancestor elements of the matched elements.
//     *
//     * @return
//     */
//    public Components parents() {
//        HashSet<Component> combo = new LinkedHashSet<Component>();
//        for (Component e : contents) {
//            combo.addAll(e.parents());
//        }
//        return new Components(combo);
//    }

    // list-like methods

    /**
     * Get the first matched element.
     *
     * @return The first matched element, or <code>null</code> if contents is empty;
     */
    public Component first() {
        return contents.isEmpty() ? null : contents.get(0);
    }

    /**
     * Get the last matched element.
     *
     * @return The last matched element, or <code>null</code> if contents is empty.
     */
    public Component last() {
        return contents.isEmpty() ? null : contents.get(contents.size() - 1);
    }

    // implements List<Component> delegates:
    public int size() {
        return contents.size();
    }

    public boolean isEmpty() {
        return contents.isEmpty();
    }

    public boolean contains(Object o) {
        return contents.contains(o);
    }

    public Iterator<Component> iterator() {
        return contents.iterator();
    }

    public Object[] toArray() {
        return contents.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return contents.toArray(a);
    }

    public boolean add(Component element) {
        return contents.add(element);
    }

    public boolean remove(Object o) {
        return contents.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return contents.containsAll(c);
    }

    public boolean addAll(Collection<? extends Component> c) {
        return contents.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends Component> c) {
        return contents.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return contents.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return contents.retainAll(c);
    }

    public void clear() {
        contents.clear();
    }

    public boolean equals(Object o) {
        return contents.equals(o);
    }

    public int hashCode() {
        return contents.hashCode();
    }

    public Component get(int index) {
        return contents.get(index);
    }

    public Component set(int index, Component element) {
        return contents.set(index, element);
    }

    public void add(int index, Component element) {
        contents.add(index, element);
    }

    public Component remove(int index) {
        return contents.remove(index);
    }

    public int indexOf(Object o) {
        return contents.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return contents.lastIndexOf(o);
    }

    public ListIterator<Component> listIterator() {
        return contents.listIterator();
    }

    public ListIterator<Component> listIterator(int index) {
        return contents.listIterator(index);
    }

    public List<Component> subList(int fromIndex, int toIndex) {
        return contents.subList(fromIndex, toIndex);
    }
}