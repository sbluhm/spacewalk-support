package tests.fetcher;

import junit.framework.TestCase;

import org.stringtree.Fetcher;
import org.stringtree.Tract;
import org.stringtree.fetcher.BeanFetcher;

import tests.TestBean;

public class BeanFetcherTest extends TestCase {
    
    Fetcher sf;

    public void setUp() {
        sf = new BeanFetcher(new SimpleBean());
    }

    public void testBeanStringFetcher() {
        sf = new BeanFetcher(new TestBean());
        assertEquals("get missing property", null, sf.getObject("hello"));
        assertEquals("get object property", "world", sf.getObject("ms"));
        assertEquals("get primitive property", new Integer(321), sf.getObject("mi"));
        assertEquals("get this", "A Test Bean", sf
                .getObject(Tract.CONTENT).toString());
    }

    public void testBeanBooleans() {
        assertEquals("get boolean bean property", Boolean.TRUE, sf.getObject("boolD"));
        assertEquals("get Boolean bean property", Boolean.FALSE, sf.getObject("boolE"));
    }

    public void testRawBooleans() {
        assertEquals("get boolean bean property", Boolean.TRUE, sf.getObject("isBoolD"));
        assertEquals("get boolean bean property", Boolean.FALSE, sf.getObject("getBoolD"));
        assertEquals("get Boolean bean property", Boolean.TRUE, sf.getObject("isBoolE"));
        assertEquals("get Boolean bean property", Boolean.FALSE, sf.getObject("getBoolE"));
    }

    public void testMemberShadowing() {
        assertEquals("get method shadowing public field", "method", sf.getObject("stone"));
        assertEquals("is method shadowing public field", Boolean.FALSE, sf.getObject("blood"));
    }
}
