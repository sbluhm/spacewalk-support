package tests.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.stringtree.util.iterator.NestedIterator;
import org.stringtree.util.testing.Checklist;

import junit.framework.TestCase;

public class NestedIteratorTest extends TestCase {
    
    Iterator it;
    Collection coll;
    Collection item;

    public void setUp() {
        coll = new ArrayList();
    }

    public void testEmpty() {
        assertTrue(Checklist.compareIterator(new String[] {},
                new NestedIterator(coll)));
    }

    public void testSingleSingle() {
        item = new ArrayList();
        item.add("hello");
        coll.add(item);

        assertTrue(Checklist.compareIterator(new String[] { "hello" },
                new NestedIterator(coll)));
    }

    public void testMultipleMultiple() {
        item = new ArrayList();
        item.add("hello");
        item.add("there");
        coll.add(item);

        item = new ArrayList();
        item.add("cruel");
        item.add("world");
        coll.add(item);

        assertTrue(Checklist.compareIterator(new String[] { "hello", "there",
                "cruel", "world" }, new NestedIterator(coll)));
    }

    public void testGapAtStart() {
        item = new ArrayList();
        coll.add(item);

        item = new ArrayList();
        item.add("cruel");
        item.add("world");
        coll.add(item);

        assertTrue(Checklist.compareIterator(new String[] { "cruel", "world" },
                new NestedIterator(coll)));
    }

    public void testGapAtEnd() {
        item = new ArrayList();
        item.add("cruel");
        item.add("world");
        coll.add(item);

        item = new ArrayList();
        coll.add(item);

        assertTrue(Checklist.compareIterator(new String[] { "cruel", "world" },
                new NestedIterator(coll)));
    }

    public void testGapInMiddle() {
        item = new ArrayList();
        item.add("hello");
        item.add("there");
        coll.add(item);

        item = new ArrayList();
        coll.add(item);

        item = new ArrayList();
        item.add("cruel");
        item.add("world");
        coll.add(item);

        assertTrue(Checklist.compareIterator(new String[] { "hello", "there",
                "cruel", "world" }, new NestedIterator(coll)));
    }

    public void testBigGapInMiddle() {
        item = new ArrayList();
        item.add("hello");
        item.add("there");
        coll.add(item);

        item = new ArrayList();
        coll.add(item);

        item = new ArrayList();
        coll.add(item);

        item = new ArrayList();
        coll.add(item);

        item = new ArrayList();
        item.add("cruel");
        item.add("world");
        coll.add(item);

        assertTrue(Checklist.compareIterator(new String[] { "hello", "there",
                "cruel", "world" }, new NestedIterator(coll)));
    }
}