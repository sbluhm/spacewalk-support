package org.stringtree.fetcher;

import org.stringtree.Fetcher;
import org.stringtree.finder.ObjectFinder;
import org.stringtree.util.IntegerNumberUtils;

public class FetcherNumberHelper {
    
    public static int getInt(Fetcher context, String key, int dfl) {
        return IntegerNumberUtils.intValue(context.getObject(key), dfl);
    }

    public static int getInt(Fetcher context, String key) {
        return IntegerNumberUtils.intValue(context.getObject(key));
    }
    
    public static int getInt(ObjectFinder context, String key, int dfl) {
        return IntegerNumberUtils.intValue(context.getObject(key), dfl);
    }

    public static int getInt(ObjectFinder context, String key) {
        return IntegerNumberUtils.intValue(context.getObject(key));
    }
}
