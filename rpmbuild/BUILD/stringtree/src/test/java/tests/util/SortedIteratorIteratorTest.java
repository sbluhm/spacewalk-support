package tests.util;

import java.util.NoSuchElementException;
import java.util.Vector;

import junit.framework.TestCase;

import org.stringtree.util.ArrayIterator;
import org.stringtree.util.sort.SortedIteratorIterator;
import org.stringtree.util.sort.UniqueSortedIteratorIterator;

public class SortedIteratorIteratorTest extends TestCase {
    
    SortedIteratorIterator see0;
    SortedIteratorIterator see1;
    Exception exception;
    Vector v;

    public SortedIteratorIteratorTest(String name) {
        super(name);
    }

    public void setUp() {
        v = new Vector();
        v.addElement("one");
        v.addElement("two");
        v.addElement("yellow");
        v.addElement("banana");

        see0 = null;
        see1 = new SortedIteratorIterator(v.iterator());
    }

    public void testNull() {
        see0 = new SortedIteratorIterator(null);

        assertTrue(!see0.hasNext());
        try {
            see0.next();
        } catch (NoSuchElementException e) {
            exception = e;
        }
        assertTrue(exception != null);
    }

    public void testEmptyTable() {
        see0 = new SortedIteratorIterator((new Vector()).iterator());

        assertTrue(!see0.hasNext());
        try {
            see0.next();
        } catch (NoSuchElementException e) {
            exception = e;
        }
        assertTrue(exception != null);
    }

    public void testElements() {
        assertTrue(see1.hasNext());
        assertEquals("banana", see1.next());

        assertTrue(see1.hasNext());
        assertEquals("one", see1.next());

        assertTrue(see1.hasNext());
        assertEquals("two", see1.next());

        assertTrue(see1.hasNext());
        assertEquals("yellow", see1.next());

        assertTrue(!see1.hasNext());
        try {
            see1.next();
        } catch (NoSuchElementException e) {
            exception = e;
        }
        assertTrue(exception != null);
    }

    public void testUniqueSortedIterator() {
        String[] values = new String[] { "aaaa", "aaaa", "bb", "aaab", "bb",
                "aaaa", "bb", "bb" };
        UniqueSortedIteratorIterator usii = new UniqueSortedIteratorIterator(
                new ArrayIterator(values));

        assertTrue(usii.hasNext());
        assertEquals("aaaa", usii.next());
        assertTrue(usii.hasNext());
        assertEquals("aaab", usii.next());
        assertTrue(usii.hasNext());
        assertEquals("bb", usii.next());
        assertFalse(usii.hasNext());
    }
}