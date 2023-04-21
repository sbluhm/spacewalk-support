package org.stringtree.finder;

import java.util.Map;

import org.stringtree.fetcher.MapFetcher;

public class MapStringFinder extends FetcherStringFinder {

    public MapStringFinder(Map map) {
        super(new MapFetcher(map));
    }
}
