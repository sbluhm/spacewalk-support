package org.stringtree.util.sort;

import java.util.Iterator;

/**
 * A sorted version of another Iterator which skips duplicates
 */
public class UniqueSortedIteratorIterator extends SortedIteratorIterator {
    
    public UniqueSortedIteratorIterator(Iterator it) {
        super(it, true);
    }
}