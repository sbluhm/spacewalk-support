package org.stringtree.fetcher;

import java.util.Iterator;

import org.stringtree.Fetcher;
import org.stringtree.Listable;
import org.stringtree.util.ObjectFilter;
import org.stringtree.util.iterator.EmptyIterator;

public class ListableHelper {
    
    public static Listable getListable(Fetcher fetcher) {
        if (fetcher instanceof Listable)
            return ((Listable) fetcher);
        return (Listable) fetcher.getObject(Listable.LIST);
    }

    public static Iterator list(Fetcher fetcher) {
        Listable list = getListable(fetcher);
        return list != null ? list.list() : EmptyIterator.it();
    }

    public static Fetcher subset(Fetcher fetcher, ObjectFilter filter) {
        Iterator it = list(fetcher);
        if (it == null)
            return EmptyFetcher.it;

        MapFetcher ret = new MapFetcher();
        while (it.hasNext()) {
            String key = (String) it.next();
            if (filter.accept(key)) {
                ret.put(key, fetcher.getObject(key));
            }
        }
        ret.lock();

        return ret;
    }

    public static int count(Fetcher fetcher) {
        Iterator it = list(fetcher);
        if (it == null)
            return 0;

        int ret = 0;
        while (it.hasNext()) {
            ++ret;
            it.next();
        }

        return ret;
    }
}
