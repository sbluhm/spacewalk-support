package org.stringtree.fetcher;

import java.util.Iterator;

import org.stringtree.Listable;
import org.stringtree.Repository;

public class DelegatedListableRepository extends DelegatedRepository implements Listable {

    public DelegatedListableRepository(Repository other) {
        super(other);
    }

    protected DelegatedListableRepository() {
        super(null);
    }
    
    public Iterator list() {
        return ((Listable)realFetcher()).list();
    }
}
