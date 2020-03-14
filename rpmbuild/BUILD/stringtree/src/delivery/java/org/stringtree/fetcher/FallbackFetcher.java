package org.stringtree.fetcher;

import java.util.Arrays;
import java.util.Iterator;

import org.stringtree.Fetcher;

public class FallbackFetcher implements Fetcher {
    
    protected Fetcher[] fetchers;

    public FallbackFetcher(Fetcher[] fetchers) {
        this.fetchers = fetchers;
    }

    public FallbackFetcher(Fetcher top, Fetcher context) {
        this(new Fetcher[] { top, context });
    }

    public static Object getObject(String name, Fetcher[] fetchers) {
        Object ret = null;

        for (int i = 0; ret == null && i < fetchers.length; ++i) {
            Fetcher fetcher = fetchers[i];
            ret = fetcher.getObject(name);
        }

        return ret;
    }

    public Object getObject(String name) {
        return getObject(name, fetchers);
    }

    public String toString() {
        StringBuffer ret = new StringBuffer("Fallback: [");
        for (int i = 0; i < fetchers.length; ++i) {
            ret.append(" ");
            ret.append(fetchers[i]);
        }
        ret.append(" ]");

        return ret.toString();
    }

    public Fetcher top() {
        return fetchers[0];
    }

    public Iterator listFetchers() {
        return Arrays.asList(fetchers).iterator();
    }
}