package org.stringtree.template;

import org.stringtree.finder.StringFinder;
import org.stringtree.util.ObjectToString;

public interface Templater {
    static final String TEMPLATER = "stringtree.templater";

    void expand(StringFinder context, String templateName,
            StringCollector collector);

    void expandTemplate(StringFinder context, Object template,
            StringCollector collector);

    Object getObject(String name, StringFinder context, StringCollector collector);
    String get(String name, StringFinder context, StringCollector collector);
    
    void setStringConverter(ObjectToString converter);
}