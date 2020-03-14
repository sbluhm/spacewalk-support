package org.stringtree.util.iterator;

public class BlankPaddedSpliterator extends Spliterator {
    
    public BlankPaddedSpliterator(String string, String seps) {
        super(string, "");
        setPadding(" \t");
        setType('\\', TT_ESCAPE);
        addSeparators(seps);
    }
    
    public BlankPaddedSpliterator(String string) {
        this(string,"");
    }
}
