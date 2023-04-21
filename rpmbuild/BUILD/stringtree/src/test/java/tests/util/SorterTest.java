package tests.util;

import java.util.Vector;

import junit.framework.TestCase;

import org.stringtree.util.sort.Sorter;

public class SorterTest extends TestCase {
    
    protected Vector v;

    public SorterTest(String name) {
        super(name);
    }

    public void setUp() {
        v = new Vector();
    }

    public void testEmptyVector() {
        assertTrue(v.size() == 0);
        Sorter.sortVector(v);
        assertTrue(v.size() == 0);
    }

    public void testSingleItem() {
        v.addElement("aa");
        assertTrue(v.size() == 1);
        Sorter.sortVector(v);
        assertTrue(v.size() == 1);
    }

    public void testPresortedUniqueStrings() {
        v.addElement("aa");
        v.addElement("bb");
        v.addElement("cc");
        assertTrue(v.size() == 3);
        Sorter.sortVector(v);
        assertTrue(v.size() == 3);

        assertEquals("aa", v.elementAt(0));
        assertEquals("bb", v.elementAt(1));
        assertEquals("cc", v.elementAt(2));
    }

    public void testUnsortedUniqueStrings() {
        v.addElement("bb");
        v.addElement("aa");
        v.addElement("cc");
        assertTrue(v.size() == 3);
        Sorter.sortVector(v);
        assertTrue(v.size() == 3);

        assertEquals("aa", v.elementAt(0));
        assertEquals("bb", v.elementAt(1));
        assertEquals("cc", v.elementAt(2));
    }

    public void testReversedUniqueStrings() {
        v.addElement("cc");
        v.addElement("bb");
        v.addElement("aa");
        assertTrue(v.size() == 3);
        Sorter.sortVector(v);
        assertTrue(v.size() == 3);

        assertEquals("aa", v.elementAt(0));
        assertEquals("bb", v.elementAt(1));
        assertEquals("cc", v.elementAt(2));
    }

    public void testNonUniqueStrings() {
        v.addElement("bb");
        v.addElement("aa");
        v.addElement("cc");
        v.addElement("bb");
        assertTrue(v.size() == 4);
        Sorter.sortVector(v);
        assertTrue(v.size() == 4);

        assertEquals("aa", v.elementAt(0));
        assertEquals("bb", v.elementAt(1));
        assertEquals("bb", v.elementAt(2));
        assertEquals("cc", v.elementAt(3));
    }
}