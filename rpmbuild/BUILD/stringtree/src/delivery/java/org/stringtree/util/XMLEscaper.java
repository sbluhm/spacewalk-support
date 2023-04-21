package org.stringtree.util;

public class XMLEscaper implements ObjectToString {

    public String convert(Object value) {
        return null==value ? "" : value.toString().
            replace("&", "&amp;").
            replace("<", "&lt;").
            replace(">","&gt;").
            replace("'","&apos;").
            replace("\"", "&quot;");
    }
}
