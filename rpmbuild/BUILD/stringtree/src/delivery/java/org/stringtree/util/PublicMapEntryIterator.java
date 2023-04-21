package org.stringtree.util;

import java.util.Iterator;

public class PublicMapEntryIterator implements Iterator {

    private Iterator iterator;

    public PublicMapEntryIterator(Iterator iterator) {
        this.iterator = iterator;
    }

    public boolean hasNext() {
         return iterator.hasNext();
    }

    public Object next() {
        return new PublicMapEntry(iterator.next());
    }

    public void remove() {
        iterator.remove();
    }
}
