package org.grails.plugins.zkui

class ZhtmlTagLib extends AbstractTagLib {

    static namespace = "h"


    def a = { attrs, body ->
        doTag(attrs, body, "a", 'xhtml')
    }


    def abbr = { attrs, body ->
        doTag(attrs, body, "abbr", 'xhtml')
    }


    def acronym = { attrs, body ->
        doTag(attrs, body, "acronym", 'xhtml')
    }


    def address = { attrs, body ->
        doTag(attrs, body, "address", 'xhtml')
    }


    def area = { attrs, body ->
        doTag(attrs, body, "area", 'xhtml')
    }


    def b = { attrs, body ->
        doTag(attrs, body, "b", 'xhtml')
    }


    def base = { attrs, body ->
        doTag(attrs, body, "base", 'xhtml')
    }


    def big = { attrs, body ->
        doTag(attrs, body, "big", 'xhtml')
    }


    def blockquote = { attrs, body ->
        doTag(attrs, body, "blockquote", 'xhtml')
    }


    def body = { attrs, body ->
        doTag(attrs, body, "body", 'xhtml')
    }


    def br = { attrs, body ->
        doTag(attrs, body, "br", 'xhtml')
    }


    def button = { attrs, body ->
        doTag(attrs, body, "button", 'xhtml')
    }


    def caption = { attrs, body ->
        doTag(attrs, body, "caption", 'xhtml')
    }


    def center = { attrs, body ->
        doTag(attrs, body, "center", 'xhtml')
    }


    def cite = { attrs, body ->
        doTag(attrs, body, "cite", 'xhtml')
    }


    def code = { attrs, body ->
        doTag(attrs, body, "code", 'xhtml')
    }


    def col = { attrs, body ->
        doTag(attrs, body, "col", 'xhtml')
    }


    def colgroup = { attrs, body ->
        doTag(attrs, body, "colgroup", 'xhtml')
    }


    def dd = { attrs, body ->
        doTag(attrs, body, "dd", 'xhtml')
    }


    def del = { attrs, body ->
        doTag(attrs, body, "del", 'xhtml')
    }


    def dfn = { attrs, body ->
        doTag(attrs, body, "dfn", 'xhtml')
    }


    def dir = { attrs, body ->
        doTag(attrs, body, "dir", 'xhtml')
    }


    def div = { attrs, body ->
        doTag(attrs, body, "div", 'xhtml')
    }


    def dl = { attrs, body ->
        doTag(attrs, body, "dl", 'xhtml')
    }


    def dt = { attrs, body ->
        doTag(attrs, body, "dt", 'xhtml')
    }


    def em = { attrs, body ->
        doTag(attrs, body, "em", 'xhtml')
    }


    def embed = { attrs, body ->
        doTag(attrs, body, "embed", 'xhtml')
    }


    def fieldset = { attrs, body ->
        doTag(attrs, body, "fieldset", 'xhtml')
    }


    def font = { attrs, body ->
        doTag(attrs, body, "font", 'xhtml')
    }


    def form = { attrs, body ->
        doTag(attrs, body, "form", 'xhtml')
    }


    def h1 = { attrs, body ->
        doTag(attrs, body, "h1", 'xhtml')
    }


    def h2 = { attrs, body ->
        doTag(attrs, body, "h2", 'xhtml')
    }


    def h3 = { attrs, body ->
        doTag(attrs, body, "h3", 'xhtml')
    }


    def h4 = { attrs, body ->
        doTag(attrs, body, "h4", 'xhtml')
    }


    def head = { attrs, body ->
        doTag(attrs, body, "head", 'xhtml')
    }


    def hr = { attrs, body ->
        doTag(attrs, body, "hr", 'xhtml')
    }


    def html = { attrs, body ->
        doTag(attrs, body, "html", 'xhtml')
    }


    def i = { attrs, body ->
        doTag(attrs, body, "i", 'xhtml')
    }


    def iframe = { attrs, body ->
        doTag(attrs, body, "iframe", 'xhtml')
    }


    def img = { attrs, body ->
        doTag(attrs, body, "img", 'xhtml')
    }


    def input = { attrs, body ->
        doTag(attrs, body, "input", 'xhtml')
    }


    def ins = { attrs, body ->
        doTag(attrs, body, "ins", 'xhtml')
    }


    def isindex = { attrs, body ->
        doTag(attrs, body, "isindex", 'xhtml')
    }


    def kbd = { attrs, body ->
        doTag(attrs, body, "kbd", 'xhtml')
    }


    def label = { attrs, body ->
        doTag(attrs, body, "label", 'xhtml')
    }


    def legend = { attrs, body ->
        doTag(attrs, body, "legend", 'xhtml')
    }


    def li = { attrs, body ->
        doTag(attrs, body, "li", 'xhtml')
    }


    def link = { attrs, body ->
        doTag(attrs, body, "link", 'xhtml')
    }


    def map = { attrs, body ->
        doTag(attrs, body, "map", 'xhtml')
    }


    def menu = { attrs, body ->
        doTag(attrs, body, "menu", 'xhtml')
    }


    def meta = { attrs, body ->
        doTag(attrs, body, "meta", 'xhtml')
    }


    def nobr = { attrs, body ->
        doTag(attrs, body, "nobr", 'xhtml')
    }


    def object = { attrs, body ->
        doTag(attrs, body, "object", 'xhtml')
    }


    def ol = { attrs, body ->
        doTag(attrs, body, "ol", 'xhtml')
    }


    def optgroup = { attrs, body ->
        doTag(attrs, body, "optgroup", 'xhtml')
    }


    def option = { attrs, body ->
        doTag(attrs, body, "option", 'xhtml')
    }


    def p = { attrs, body ->
        doTag(attrs, body, "p", 'xhtml')
    }


    def pre = { attrs, body ->
        doTag(attrs, body, "pre", 'xhtml')
    }


    def q = { attrs, body ->
        doTag(attrs, body, "q", 'xhtml')
    }


    def raw = { attrs, body ->
        doTag(attrs, body, "raw", 'xhtml')
    }


    def s = { attrs, body ->
        doTag(attrs, body, "s", 'xhtml')
    }


    def samp = { attrs, body ->
        doTag(attrs, body, "samp", 'xhtml')
    }


    def script = { attrs, body ->
        doTag(attrs, body, "script", 'xhtml')
    }


    def select = { attrs, body ->
        doTag(attrs, body, "select", 'xhtml')
    }


    def small = { attrs, body ->
        doTag(attrs, body, "small", 'xhtml')
    }


    def span = { attrs, body ->
        doTag(attrs, body, "span", 'xhtml')
    }


    def strong = { attrs, body ->
        doTag(attrs, body, "strong", 'xhtml')
    }


    def style = { attrs, body ->
        doTag(attrs, body, "style", 'xhtml')
    }


    def sub = { attrs, body ->
        doTag(attrs, body, "sub", 'xhtml')
    }


    def sup = { attrs, body ->
        doTag(attrs, body, "sup", 'xhtml')
    }


    def table = { attrs, body ->
        doTag(attrs, body, "table", 'xhtml')
    }


    def tbody = { attrs, body ->
        doTag(attrs, body, "tbody", 'xhtml')
    }


    def td = { attrs, body ->
        doTag(attrs, body, "td", 'xhtml')
    }


    def text = { attrs, body ->
        doTag(attrs, body, "text", 'xhtml')
    }


    def textarea = { attrs, body ->
        doTag(attrs, body, "textarea", 'xhtml')
    }


    def tfoot = { attrs, body ->
        doTag(attrs, body, "tfoot", 'xhtml')
    }


    def th = { attrs, body ->
        doTag(attrs, body, "th", 'xhtml')
    }


    def thead = { attrs, body ->
        doTag(attrs, body, "thead", 'xhtml')
    }


    def title = { attrs, body ->
        doTag(attrs, body, "title", 'xhtml')
    }


    def tr = { attrs, body ->
        doTag(attrs, body, "tr", 'xhtml')
    }


    def tt = { attrs, body ->
        doTag(attrs, body, "tt", 'xhtml')
    }


    def ul = { attrs, body ->
        doTag(attrs, body, "ul", 'xhtml')
    }


    def var = { attrs, body ->
        doTag(attrs, body, "var", 'xhtml')
    }


    def zkhead = { attrs, body ->
        doTag(attrs, body, "zkhead", 'xhtml')
    }

}