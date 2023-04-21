package org.stringtree.finder;

import org.stringtree.fetcher.EmptyFetcher;

public class EmptyStringFinder extends FetcherStringFinder {

    public static final EmptyStringFinder it = new EmptyStringFinder();

    public EmptyStringFinder() {
        super(new EmptyFetcher());
    }
}
