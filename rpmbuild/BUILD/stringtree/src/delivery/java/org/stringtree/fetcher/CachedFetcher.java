package org.stringtree.fetcher;

import java.util.HashMap;
import java.util.Map;

import org.stringtree.Fetcher;

public class CachedFetcher extends DelegatedFetcher {
    
    private Map cache = new HashMap();

    public CachedFetcher(Fetcher slow) {
        super(slow);
    }

    public Object getObject(String name) {
        Object ret = null;

        if (cache.containsKey(name)) {
            ret = cache.get(name);
        } else {
            ret = super.getObject(name);
            if (ret != null) {
                cache.put(name, ret);
            }
        }

        return ret;
    }

    public boolean isCached(String name) {
        return cache.containsKey(name);
    }

    public void purge() {
        cache.clear();
    }

    public void uncache(String name) {
        cache.remove(name);
    }
}
