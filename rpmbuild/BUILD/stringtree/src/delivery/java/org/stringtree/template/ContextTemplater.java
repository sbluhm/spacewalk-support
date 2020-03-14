package org.stringtree.template;

import org.stringtree.finder.StringFinder;

public class ContextTemplater extends RecursiveTemplater {

    private StringFinder context;
    private String key;

    public ContextTemplater(StringFinder context, String key) {
        this.context = context;
        this.key = key;
    }

    public ContextTemplater(StringFinder context) {
        this(context, "template.");
    }

    protected Object getTemplate(String templateName) {
        return context.getObject(key + templateName);
    }
}
