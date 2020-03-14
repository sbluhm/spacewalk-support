package org.stringtree.finder;

import java.util.HashMap;
import java.util.Map;

import org.stringtree.fetcher.MapFetcher;

public class MapStringKeeper extends FetcherStringKeeper {

    public MapStringKeeper(Map map) {
        super(new MapFetcher(map));
    }

    public MapStringKeeper() {
        this(new HashMap());
    }
}
