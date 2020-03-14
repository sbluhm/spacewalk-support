package org.stringtree.util.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.stringtree.util.iterator.AbstractIterator;

public class NestedIterator extends AbstractIterator {
    
    protected static final Iterator[] prototype = new Iterator[0];

    protected Iterator[] iterators;
    protected int current;

    public NestedIterator(Collection collection) {
        List its = new ArrayList();
        Iterator items = collection.iterator();
        while (items.hasNext()) {
            Object obj = items.next();
            if (obj instanceof Iterator) {
                its.add(obj);
            } else if (obj instanceof Collection) {
                its.add(((Collection) obj).iterator());
            }
        }

        iterators = (Iterator[]) its.toArray(prototype);
        current = 0;
    }

    public boolean hasNext() {
        if (current >= iterators.length)
            return false;
        if (iterators[current].hasNext())
            return true;

        int peek = current;
        while (peek < iterators.length && !iterators[peek].hasNext())
            ++peek;
        return peek < iterators.length;
    }

    public Object next() {
        while (current < iterators.length && !iterators[current].hasNext())
            ++current;
        if (current >= iterators.length)
            return null;

        return iterators[current].next();
    }

}
