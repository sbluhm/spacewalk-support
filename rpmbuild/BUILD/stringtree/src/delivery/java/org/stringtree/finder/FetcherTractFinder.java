package org.stringtree.finder;

import org.stringtree.Fetcher;
import org.stringtree.Tract;
import org.stringtree.fetcher.FetcherTractHelper;

public class FetcherTractFinder extends FetcherObjectFinder implements TractFinder {
    
    public FetcherTractFinder(Fetcher fetcher) {
        super(fetcher);
    }

    public Tract get(String name) {
        return FetcherTractHelper.getTract(fetcher, name);
    }
}
