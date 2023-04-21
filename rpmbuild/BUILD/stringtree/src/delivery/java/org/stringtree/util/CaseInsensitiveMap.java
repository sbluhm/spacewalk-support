package org.stringtree.util;

import java.util.HashMap;

public class CaseInsensitiveMap extends HashMap {
    public Object get(Object key) {
        if (key instanceof String) key = ((String)key).toLowerCase();
        return super.get(key);
    }

    public Object put(Object key, Object value) {
        if (key instanceof String) key = ((String)key).toLowerCase();
        return super.put(key, value);
    }
}
