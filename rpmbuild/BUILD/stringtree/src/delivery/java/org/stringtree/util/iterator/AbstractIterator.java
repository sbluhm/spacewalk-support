package org.stringtree.util.iterator;

import java.util.Iterator;

public abstract class AbstractIterator implements Iterator {
    
    public abstract boolean hasNext();

    public abstract Object next();

    public void remove() {
        throw new UnsupportedOperationException(this.getClass().getName()
                + " does not support remove");
    }
}
