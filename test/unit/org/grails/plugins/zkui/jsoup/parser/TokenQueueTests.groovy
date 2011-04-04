package org.grails.plugins.zkui.jsoup.parser

import grails.test.GrailsUnitTestCase

class TokenQueueTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    public void testChompBalanced() {
        TokenQueue tq = new TokenQueue(":contains(one (two) three) four");
        String pre = tq.consumeTo("(");
        String guts = tq.chompBalanced('(' as char, ')' as char);
        String remainder = tq.remainder();

        assertEquals(":contains", pre);
        assertEquals("one (two) three", guts);
        assertEquals(" four", remainder);
    }

    public void testChompEscapedBalanced() {
        TokenQueue tq = new TokenQueue(":contains(one (two) \\( \\) \\) three) four");
        String pre = tq.consumeTo("(");
        String guts = tq.chompBalanced('(' as char, ')' as char);
        String remainder = tq.remainder();

        assertEquals(":contains", pre);
        assertEquals("one (two) \\( \\) \\) three", guts);
        assertEquals("one (two) ( ) ) three", TokenQueue.unescape(guts));
        assertEquals(" four", remainder);
    }

    public void testChompBalancedMatchesAsMuchAsPossible() {
        TokenQueue tq = new TokenQueue("unbalanced(something(or another");
        tq.consumeTo("(");
        String match = tq.chompBalanced('(' as char, ')' as char);
        assertEquals("something(or another", match);
    }

    public void testUnescape() {
        assertEquals("one ( ) \\", TokenQueue.unescape("one \\( \\) \\\\"));
    }

    public void testChompToIgnoreCase() {
        String t = "<textarea>one < two </TEXTarea>";
        TokenQueue tq = new TokenQueue(t);
        String data = tq.chompToIgnoreCase("</textarea");
        assertEquals("<textarea>one < two ", data);

        tq = new TokenQueue("<textarea> one two < three </oops>");
        data = tq.chompToIgnoreCase("</textarea");
        assertEquals("<textarea> one two < three </oops>", data);
    }

    public void testDddFirst() {
        TokenQueue tq = new TokenQueue("One Two");
        tq.consumeWord();
        tq.addFirst("Three");
        assertEquals("Three Two", tq.remainder());
    }
}
