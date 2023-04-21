package org.stringtree.util.spec;

import java.util.Iterator;
import java.util.List;

import org.stringtree.util.iterator.BlankPaddedSpliterator;

public class ArrayFormat extends SimpleHandler {
    
    public Object parseString(String name, String text) {
        Iterator it = getIterator(text);
        List ret = new SpecList();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj != null) {
                ret.add(obj);
            }
        }

        return ret;
    }

    protected Iterator getIterator(String text) {
        return new BlankPaddedSpliterator(text);
    }
}
