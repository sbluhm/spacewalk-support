package tests.util;

import junit.framework.TestCase;

import org.stringtree.fetcher.MapFetcher;
import org.stringtree.finder.FetcherStringKeeper;
import org.stringtree.util.MethodCallUtils;

public class MethodCallTest extends TestCase {
    
    MethodCallExample example;
    MapFetcher fetcher;
    FetcherStringKeeper context;

    public void setUp() {
        example = new MethodCallExample();
        fetcher = new MapFetcher();
        context = new FetcherStringKeeper(fetcher);
    }

    public void testRequest() {
        assertEquals(0, example.requests);
        MethodCallUtils.call(example, "request");
        assertEquals(1, example.requests);
    }

    public void testInit() {
        assertEquals(null, example.context);
        MethodCallUtils.call(example, "init", context);
        assertEquals(context, example.context);
    }

    public void testUnknown() {
        assertEquals(null, example.context);
        MethodCallUtils.call(example, "wibble", context);
        assertEquals(null, example.context);
    }
    
    public void testMethodMatching() {
        assertEquals(0, example.requests);
        MethodCallUtils.call(example, "m1", context);
        assertEquals(1, example.requests);
    }
    
    public void testMethodMatching2() {
        assertEquals(0, example.requests);
        MethodCallUtils.call(example, "m2", context);
        assertEquals(1, example.requests);
    }
}
