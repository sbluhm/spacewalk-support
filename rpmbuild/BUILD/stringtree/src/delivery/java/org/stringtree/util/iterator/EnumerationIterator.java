package org.stringtree.util.iterator;

import java.util.Enumeration;

public class EnumerationIterator extends AbstractIterator {
    
    private final Enumeration e;

    public EnumerationIterator(Enumeration e) {
        this.e = e;
    }

    public boolean hasNext() {
        return e.hasMoreElements();
    }

    public Object next() {
        return e.nextElement();
    }
}