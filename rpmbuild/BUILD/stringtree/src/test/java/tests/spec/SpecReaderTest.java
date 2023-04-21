package tests.spec;

import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import org.stringtree.fetcher.MapFetcher;
import org.stringtree.finder.FetcherStringFinder;
import org.stringtree.finder.StringFinder;
import org.stringtree.util.spec.SpecReader;
import org.stringtree.util.testing.Checklist;

public class SpecReaderTest extends TestCase {

    static final String BASEDIR = "testfiles/specdir/";
    
    MapFetcher repos;
    StringFinder context;
    DummyWithoutInit dummy1;
    DummyWithInit dummy2;
    DummyWithOtherInit dummy3;
    DummyWithConstructor dummy4;
    DummyWithBoth dummy5;

    public void setUp() {
        repos = new MapFetcher();
        context = new FetcherStringFinder(repos);

        dummy1 = new DummyWithoutInit();
        dummy2 = new DummyWithInit();
        dummy2.value = "ugh";
        dummy3 = new DummyWithOtherInit();
        dummy3.value = "whatever";
        dummy4 = new DummyWithConstructor("hello there");
        dummy5 = new DummyWithBoth("other.value");
        dummy5.value = "whatever";
    }

    public void testBasic() throws IOException {
        SpecReader.load(context, BASEDIR + "basic.spec");
        assertEquals("value1", context.getObject("colon"));
        assertEquals("value2", context.getObject("colon space"));
        assertEquals("value3", context.getObject("colon 2 space"));
        assertEquals("value4", context.getObject("equal"));
        assertEquals("value5", context.getObject("equal space"));
        assertEquals("value6", context.getObject("equal 2 space"));
    }

    public void testQuoted() throws IOException {
        SpecReader.load(context, BASEDIR + "quoted.spec");

        assertEquals("value1", context.getObject("colon"));
        assertEquals("value2", context.getObject("colon space"));
        assertEquals("value3", context.getObject("colon 2 space"));
        assertEquals("value4", context.getObject("equal"));
        assertEquals("value5", context.getObject("equal space"));
        assertEquals("value6", context.getObject("equal 2 space"));
    }

    public void testArray() throws IOException {
        SpecReader.load(context, BASEDIR + "array.spec");

        assertTrue(Checklist.compareCollection(new Object[] { "one" },
                (List) context.getObject("single")));

        assertTrue(Checklist.compareCollection(new Object[] { "one", "two" },
                (List) context.getObject("double")));

        assertTrue(Checklist.compareCollection(new Object[] { "one", "two" },
                (List) context.getObject("spaces")));

        assertTrue(Checklist.compareCollection(new Object[] { "one", "two",
                "three" }, (List) context.getObject("trailing")));
    }

    public void testCSV() throws IOException {
        SpecReader.load(context, BASEDIR + "csv.spec");

        assertTrue(Checklist.compareCollection(new Object[] { "one" },
                (List) context.getObject("single")));

        assertTrue(Checklist.compareCollection(new Object[] { "one", "two" },
                (List) context.getObject("double")));

        assertTrue(Checklist.compareCollection(new Object[] { "one", "two" },
                (List) context.getObject("spaces")));

        assertTrue(Checklist.compareCollection(new Object[] { "one", "two",
                "three" }, (List) context.getObject("trailing")));

        assertTrue(Checklist.compareCollection(new Object[] { "one two",
                " three " }, (List) context.getObject("quotes")));
    }

    public void testCreateWithoutInit() throws IOException {
        SpecReader.load(context, BASEDIR + "create.spec");
        DummyClass d = (DummyClass) context.getObject("one");
        assertEquals(dummy1, d);
        assertEquals(0, d.requests);
    }        

    public void testCreateWithInit() throws IOException {
        SpecReader.load(context, BASEDIR + "create.spec");
        DummyClass d = (DummyClass) context.getObject("two");
        assertEquals(dummy2, d); 
        assertEquals(1, d.requests);
    }
    
    public void testCreateWithOtherInit() throws IOException {
        SpecReader.load(context, BASEDIR + "create.spec");
        DummyClass d = (DummyClass) context.getObject("three");
        assertEquals(dummy3, d); 
        assertEquals(1, d.requests);
    }
    
    public void testCreateWithConstructor() throws IOException {
        SpecReader.load(context, BASEDIR + "create.spec");
        DummyClass d = (DummyClass) context.getObject("four");
        assertEquals(dummy4, d); 
        assertEquals(0, d.requests);
    }
    
    public void testCreateWithBoth() throws IOException {
        SpecReader.load(context, BASEDIR + "create.spec");
        DummyClass d = (DummyClass) context.getObject("five");
        assertEquals(dummy5, d);
        assertEquals(1, d.requests);
    }

    public void testLink() throws IOException {
        SpecReader.load(context, BASEDIR + "link.spec");

        assertEquals("original", context.getObject("source"));
        assertEquals("original", context.get("link"));
        repos.put("source", "changed");
        assertEquals("changed", context.getObject("source"));
        assertEquals("changed", context.get("link"));
    }

    public void testArrayCreate() throws IOException {
        SpecReader.load(context, BASEDIR + "arraycreate.spec");

        assertTrue(Checklist.compareCollection(new Object[] { dummy1, dummy2,
                dummy3 }, (List) context.getObject("array")));
    }

    public void testIndirect() throws IOException {
        SpecReader.load(context, BASEDIR + "indirect.spec");

        assertEquals(" hello there ", context.getObject("file"));
        assertEquals("more stuff", context.getObject("http"));
    }

    public void testResourceIndirect() throws IOException {
        SpecReader.load(context, BASEDIR + "rsindirect.spec");

        assertEquals("this is another file, plugh", context.get("fil"));
        assertEquals("this is a file, xyzzy", context.get("jar"));
        assertEquals("hi there", context.get("dir"));
    }

    public void testArrayIndirect() throws IOException {
        SpecReader.load(context, BASEDIR + "arrayindirect.spec");

        assertTrue(Checklist.compareCollection(new Object[] { " hello there ",
                "more stuff" }, (List) context.getObject("array")));
    }

    public void testImportCreate() throws IOException {
        SpecReader.load(context, BASEDIR + "importcreate.spec");

        assertTrue(Checklist.compareCollection(new Object[] { dummy1, dummy2,
                dummy3 }, (List) context.getObject("array")));
    }

    public void testLookupValue() {
        SpecReader.load(context, new String[] { "aa=hello", "bb=goodbye",
                "CONTEXT=aa", "cc^=CONTEXT" });

        assertEquals("hello", context.get("cc"));
    }

    public void testAdd() {
        SpecReader.load(context, new String[] { 
                "aa[]= hello world",
                "aa += goodbye"
        });

        assertEquals("[hello, world, goodbye]", context.get("aa"));

        SpecReader.load(context, new String[] { "bb += goodbye", });

        assertEquals("[goodbye]", context.get("bb"));
    }

    public void testRemove() {
        SpecReader.load(context, new String[] { 
                "aa[]= hello world",
                "aa -= hello"
        });

        assertEquals("[world]", context.get("aa"));
    }

    public void testOptional() {
        repos.put("xx", "blah");
        repos.put("bb", "hello world");
        SpecReader.load(context, new String[] { 
                "cc=goodbye",
                "aa?=whatever",
                "bb?=thing",
                "cc?=huh"
        });

        assertEquals("blah", context.get("xx"));
        assertEquals("whatever", context.get("aa"));
        assertEquals("hello world", context.get("bb"));
        assertEquals("goodbye", context.get("cc"));
    }
    
    public void testFileUrlInclude() throws IOException {
        SpecReader.load(context, BASEDIR + "fileinclude.spec");

        assertEquals("from before include", context.get("aa"));
        assertEquals("from included spec", context.get("bb"));
        assertEquals("from after include", context.get("cc"));
    }
    
    public void testResourceInclude() throws IOException {
        SpecReader.load(context, BASEDIR + "rsinclude.spec");

        assertEquals("from before include", context.get("aa"));
        assertEquals("from included spec", context.get("bb"));
        assertEquals("from after include", context.get("cc"));
    }
    
    public void testMap() throws IOException {
        SpecReader.load(context, BASEDIR + "map.spec");

        StringFinder map = (StringFinder)context.getObject("m");
        assertNotNull(map);
        assertEquals("some stuff", map.getObject("a"));
        assertEquals("hello", map.get("b"));
        assertEquals("tail", map.get("longer name"));
    }
}
