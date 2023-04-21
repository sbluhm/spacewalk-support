package org.stringtree.fetcher;

import java.util.Iterator;

import org.stringtree.Fetcher;
import org.stringtree.Listable;

public class DelegatedListableFetcher extends DelegatedFetcher implements Listable {
    
    public DelegatedListableFetcher(Fetcher other) {
        super(other);
    }

    protected DelegatedListableFetcher() {
        super(null);
    }

    public Iterator list() {
        return ((Listable)realFetcher()).list();
    }
}
