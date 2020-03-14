package org.stringtree.util.sort;

import java.util.Iterator;
import java.util.Vector;

import org.stringtree.util.iterator.AbstractIterator;

/**
 * An Iterator which is a sorted version of another Iterator
 */
public class SortedIteratorIterator extends AbstractIterator {
    
    protected Vector elements;
    protected Iterator it;

    protected SortedIteratorIterator(Iterator it, boolean unique) {
        elements = new Vector();

        if (it != null) {
            while (it.hasNext()) {
                Object item = it.next();
                if (!unique || !elements.contains(item))
                    elements.addElement(item);
            }
        }
        Sorter.sortVector(elements);

        this.it = elements.iterator();
    }

    public SortedIteratorIterator(Iterator it) {
        this(it, false);
    }

    public boolean hasNext() {
        return it.hasNext();
    }

    public Object next() {
        return it.next();
    }
}