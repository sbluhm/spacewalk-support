package org.stringtree.template;

import org.stringtree.Fetcher;
import org.stringtree.fetcher.DelegatedFetcher;

public class WrappedFetcher extends DelegatedFetcher {
    
    private Object obj;

    public WrappedFetcher(Object obj, Fetcher realFetcher) {
        super(realFetcher);
        this.obj = obj;
    }

    public Object getObject(String name) {
        return "this".equals(name) ? obj : super.getObject(name);
    }
}
