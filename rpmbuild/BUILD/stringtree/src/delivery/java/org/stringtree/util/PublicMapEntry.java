package org.stringtree.util;

import java.util.Map.Entry;

public class PublicMapEntry {
    
    private Entry entry;

    public PublicMapEntry(Object entry) {
        this.entry = (Entry)entry;
    }

    public Object getKey() { 
        Object ret = entry.getKey();
        return ret;
    }

    public Object getValue() { 
        Object ret = entry.getValue();
        return ret;
    }
}
