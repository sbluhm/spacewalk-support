package org.stringtree.fetcher;

import org.stringtree.Fetcher;
import org.stringtree.Repository;
import org.stringtree.Storer;

public class FetcherRepository extends DelegatedFetcher implements Repository {
    
    protected Storer storer;

    public FetcherRepository(Fetcher fetcher) {
        super(fetcher);
        this.storer = (Storer) fetcher.getObject(Storer.STORE);
    }

    public void put(String name, Object value) {
        storer.put(name, value);
    }

    public void remove(String name) {
        storer.remove(name);
    }

    public void clear() {
        storer.clear();
    }

    public void lock() {
        storer.lock();
    }
    
    public boolean isLocked() {
        return storer.isLocked();
    }

}
