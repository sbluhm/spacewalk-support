package org.stringtree.fetcher;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.stringtree.Container;
import org.stringtree.Listable;
import org.stringtree.Repository;
import org.stringtree.Storer;

public class MapFetcher implements Repository, Listable, Container {
    
    protected Map values;
    private boolean locked;

    public MapFetcher(Map values, boolean locked) {
        this.values = values;
        this.locked = locked;
    }

    public MapFetcher(Map values) {
        this(values, false);
    }

    public MapFetcher() {
        this(new HashMap());
    }

    public Object getObject(String key) {
        if (Storer.STORE.equals(key) || Listable.LIST.equals(key)
                || Container.CONTAINER.equals(key))
            return this;
        return values.get(key);
    }

    public void put(String key, Object value) {
        if (!locked)
            values.put(key, value);
    }

    public void putAll(Map map) {
        if (!locked) {
            values.putAll(map);
        }
    }

    public void remove(String name) {
        values.remove(name);
    }

    public void clear() {
        values.clear();
    }

    public void lock() {
        locked = true;
    }
    
    public boolean isLocked() {
        return locked;
    }

    public Iterator list() {
        Iterator ret = values.keySet().iterator();
        return ret;
    }

    public boolean contains(String name) {
        return values.containsKey(name);
    }
    
    public Map getMap() {
        return values;
    }
}
