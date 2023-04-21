package tests.util;

import java.util.NoSuchElementException;

import org.stringtree.util.ArrayIterator;

import junit.framework.TestCase;

public class ArrayIteratorTest extends TestCase {
    
    protected Object[] array;
    protected ArrayIterator it;
    protected Exception exception;

    public ArrayIteratorTest(String name) {
        super(name);
    }

    public void setUp() {
        array = null;
        it = null;
        exception = null;
    }

    public void testNullArray() {
        it = new ArrayIterator(array);

        assertTrue(!it.hasNext());
        try {
            it.next();
        } catch (NoSuchElementException e) {
            exception = e;
        }
        assertTrue(exception != null);
    }

    public void testEmptyArray() {
        array = new Object[0];
        it = new ArrayIterator(array);

        assertTrue(!it.hasNext());
        try {
            it.next();
        } catch (NoSuchElementException e) {
            exception = e;
        }
        assertTrue(exception != null);
    }

    public void testNonEmptyArray() {
        array = new Object[] { "first", "second" };
        it = new ArrayIterator(array);

        assertTrue(it.hasNext());
        assertEquals("first", it.next());

        assertTrue(it.hasNext());
        assertEquals("second", it.next());

        assertTrue(!it.hasNext());
        try {
            it.next();
        } catch (NoSuchElementException e) {
            exception = e;
        }
        assertTrue(exception != null);
    }
}