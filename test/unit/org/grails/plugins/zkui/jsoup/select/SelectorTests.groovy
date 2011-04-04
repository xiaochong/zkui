package org.grails.plugins.zkui.jsoup.select

import grails.test.GrailsUnitTestCase
import org.zkoss.zul.Div
import org.zkoss.zul.Span

class SelectorTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testByTag() {
        Div root = getRoot()

        Components els = Selector.select("div", root)
        assertEquals(4, els.size())
        assertEquals("1", els.get(0).id)
        assertEquals("2", els.get(1).id)
        assertEquals("3", els.get(2).id)
        assertEquals("4", els.get(3).id)

        Components none = Selector.select("button", root)
        assertEquals(0, none.size())
    }

    void testById() {
        Div root = getRoot()
        Components comps = Selector.select("#5", root);
        assertEquals(1, comps.size());
        assertEquals("testZclass", comps.get(0).zclass);
    }

    void testByClass() {
        Components els = Selector.select("div.one", root);
        assertEquals(2, els.size());
        assertEquals("1", els[0].id)
        assertEquals("2", els.get(1).id)

        Components none = Selector.select(".foo", root)
        assertEquals(0, none.size())

        Components els2 = Selector.select(".one-two", new Div(sclass: 'one-two'))
        assertEquals(1, els2.size())
    }

    void testByAttribute() {
        Div root = getRoot()

        Components withTitle = Selector.select("[tooltip]", root);
        assertEquals(3, withTitle.size());

        Components foo = Selector.select("[tooltip=div1]", root);
        assertEquals(1, foo.size());

        Components not = Selector.select("div[tooltip!=div1]", root);
        assertEquals("div2",not.first().tooltip)
        assertEquals(2, not.size());

        Components starts = Selector.select("[tooltip^=di]",root);
        assertEquals(2, starts.size());
        assertEquals("div1", starts.first().tooltip);
        assertEquals("div2", starts.last().tooltip);

        Components ends = Selector.select("[tooltip\$=v2]",root);
        assertEquals(1, ends.size());
        assertEquals("div2", ends.first().tooltip);


        Components contains = Selector.select("[tooltip*=v]",root);
        assertEquals(2, contains.size());
        assertEquals("div1", contains.first().tooltip);
        assertEquals("div2", contains.last().tooltip);
    }

//    void testNamespacedTag() {
//        Document doc = Jsoup.parse("<div><abc:def id=1>Hello</abc:def></div> <abc:def class=bold id=2>There</abc:def>");
//        Elements byTag = doc.select("abc|def");
//        assertEquals(2, byTag.size());
//        assertEquals("1", byTag.first().id());
//        assertEquals("2", byTag.last().id());
//
//        Elements byAttr = doc.select(".bold");
//        assertEquals(1, byAttr.size());
//        assertEquals("2", byAttr.last().id());
//
//        Elements byTagAttr = doc.select("abc|def.bold");
//        assertEquals(1, byTagAttr.size());
//        assertEquals("2", byTagAttr.last().id());
//
//        Elements byContains = doc.select("abc|def:contains(e)");
//        assertEquals(2, byContains.size());
//        assertEquals("1", byContains.first().id());
//        assertEquals("2", byContains.last().id());
//    }

    void testByAttributeStarting() {
        Div root = getRoot()
        Components withData = Selector.select("[^tool]",root);
        assertEquals(3, withData.size());
        assertEquals("1", withData.first().id);
        assertEquals("3", withData.last().id);

        withData = Selector.select("div[^tool]",root);
        assertEquals(3, withData.size());
    }



    private Div getRoot() {
        Div root = new Div(id: 1, sclass: "one two", tooltip: "div1")
        Div div2 = new Div(id: 2, sclass: "one", tooltip: "div2")
        div2.appendChild(new Span(id: 5, zclass: "testZclass"))
        root.appendChild(div2)
        def div3 = new Div(id: 3, sclass: "two", tooltip: "")
        div3.appendChild(new Div(id: 4))
        root.appendChild(div3)
        return root
    }

}
