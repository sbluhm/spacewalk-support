package org.stringtree.finder;

import org.stringtree.fetcher.EmptyFetcher;

public class EmptyStringKeeper extends FetcherStringKeeper {

    public static final EmptyStringKeeper emptyStringKeeper = new EmptyStringKeeper();

    public EmptyStringKeeper() {
        super(new EmptyFetcher());
    }
}
