package org.stringtree.template.pattern;

import org.stringtree.fetcher.StorerHelper;
import org.stringtree.finder.StringFinder;
import org.stringtree.template.StringCollector;
import org.stringtree.template.Templater;

/**
 * recognize patterns of the form: 
 *   name=value -> return ""
 * As a side effect, set the context value "name" to value
 */
public class AssignmentPatternHandler implements TemplatePatternHandler {

    public Object getObject(String name, StringFinder context, 
            Templater templater, StringCollector collector) {
        int eq = name.indexOf("=");
        if (eq <= 0) {
            return null;
        }

        String var = name.substring(0, eq);
        Object val = templater.getObject(name.substring(eq+1), context, collector);
        StorerHelper.put(context.getUnderlyingFetcher(), var, val);
        return "";
    }
}
