package org.stringtree.util.spec;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.stringtree.fetcher.RawFetcher;
import org.stringtree.finder.StringFinder;
import org.stringtree.util.MethodCallUtils;

public class Initialiser {
    
    protected Set needInit;

    public void open() {
        needInit = new HashSet();
    }

    public Object add(Object obj) {
        needInit.add(obj);
        return obj;
    }

    public void close(StringFinder context) {
        Iterator it = needInit.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof String) {
                String key = (String)obj;
                if (context instanceof RawFetcher) {
                    obj = ((RawFetcher) context).getRawObject(key);
                } else {
                    obj = context.getObject(key);
                }
            }

            if (obj instanceof CreatedHere) {
                Iterator entry = ((List) obj).iterator();
                while (entry.hasNext()) {
                    MethodCallUtils.call(entry.next(), "init", context);
                }
            } else if (obj != null) {
                MethodCallUtils.call(obj, "init", context);
            }
        }
        needInit = null;
    }
}
