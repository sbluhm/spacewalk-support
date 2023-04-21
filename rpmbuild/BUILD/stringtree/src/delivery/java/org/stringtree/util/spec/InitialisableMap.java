package org.stringtree.util.spec;

import java.util.HashMap;
import java.util.Map;

import org.stringtree.finder.StringFinder;

public class InitialisableMap extends HashMap {
    public InitialisableMap() {
        super();
    }

    public InitialisableMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public InitialisableMap(int initialCapacity) {
        super(initialCapacity);
    }

    public InitialisableMap(Map other) {
        super(other);
    }

    public void init(StringFinder context) {
System.err.println("InitialisableMap init");
    }

}
