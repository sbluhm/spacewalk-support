package org.stringtree.db;

import java.util.ArrayList;
import java.util.Collection;

public abstract class CollectingResultRowListener extends ResultRowListener {

    private Collection collection;
    
    public void start() {
        collection = new ArrayList();
    }

    public Object finish() {
        return collection;
    }
    
    protected void add(Object object) {
        collection.add(object);
    }

}
