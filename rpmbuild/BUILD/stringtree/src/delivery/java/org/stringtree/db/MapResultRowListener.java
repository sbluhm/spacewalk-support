package org.stringtree.db;

import java.util.HashMap;
import java.util.Map;

public abstract class MapResultRowListener extends ResultRowListener {

    private Map map;
    
    public MapResultRowListener(Map map) {
        this.map = map;
    }
    
    public MapResultRowListener() {
        map = new HashMap();
    }
    
    public void start() {
        if (null == map) map = new HashMap();
    }

    public Object finish() {
        return map;
    }
    
    protected void put(Object key, Object value) {
        map.put(key, value);
    }
}