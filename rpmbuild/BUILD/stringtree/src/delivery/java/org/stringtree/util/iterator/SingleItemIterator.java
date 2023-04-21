package org.stringtree.util.iterator;

import java.util.NoSuchElementException;

public class SingleItemIterator extends AbstractIterator {
    
    private final Object item;
    private boolean done;

    public SingleItemIterator(Object item) {
        this.item = item;
        done = false;
    }

    public boolean hasNext() {
        return !done;
    }

    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        done = true;
        return item;
    }
}
