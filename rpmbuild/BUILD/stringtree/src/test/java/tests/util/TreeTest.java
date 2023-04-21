package tests.util;

import java.util.Collections;

import junit.framework.TestCase;

import org.stringtree.util.testing.Checklist;
import org.stringtree.util.tree.EmptyTree;
import org.stringtree.util.tree.MutableTree;
import org.stringtree.util.tree.SimpleTree;
import org.stringtree.util.tree.Tree;
import org.stringtree.util.tree.Trees;

public class TreeTest extends TestCase {
    
    public void testEmptyTree() {
        Tree t = new EmptyTree();
        assertEquals(null, t.getParent());
        assertTrue(t.getChildren().isEmpty());
        assertEquals(null, t.getValue());

        assertEquals(new EmptyTree(), t);
        assertEquals(Trees.EMPTY_TREE, t);
        assertEquals(Trees.EMPTY_TREE, new EmptyTree());
    }

    public void testEmptySimpleTree() {
        Tree t = new SimpleTree();

        assertEquals(null, t.getParent());
        assertTrue(t.getChildren().isEmpty());
        assertEquals(null, t.getValue());

        assertEquals(Trees.EMPTY_TREE, t);
        assertEquals(new SimpleTree(null, Collections.EMPTY_LIST, null), t);
    }

    public void testNodeWithValue() {
        MutableTree t = new SimpleTree();
        t.setValue("hoople");

        assertEquals(null, t.getParent());
        assertTrue(t.getChildren().isEmpty());
        assertEquals("hoople", t.getValue());

        assertEquals(new SimpleTree(null, Collections.EMPTY_LIST, "hoople"), t);
    }

    public void testNodeWithParent() {
        MutableTree t = new SimpleTree();
        Tree parent = new EmptyTree();
        t.setParent(parent);

        assertEquals(parent, t.getParent());
        assertTrue(t.getChildren().isEmpty());
        assertEquals(null, t.getValue());

        assertEquals(new SimpleTree(parent, Collections.EMPTY_LIST, null), t);
    }

    public void testNodeWithChild() {
        MutableTree t = new SimpleTree();
        Tree c1 = new SimpleTree(t, Collections.EMPTY_LIST, "c1");
        t.addChild(c1);

        assertEquals(null, t.getParent());
        assertFalse(t.getChildren().isEmpty());
        assertTrue(Checklist.compareCollection(new Object[] { c1 }, t
                .getChildren()));
        assertEquals(null, t.getValue());

        MutableTree t2 = new SimpleTree();
        t2.addChild(new SimpleTree(t, Collections.EMPTY_LIST, "c1"));
        assertEquals(t2, t);
    }

    public void testNodeWithChildren() {
        MutableTree t = new SimpleTree();
        Tree c1 = new SimpleTree(t, Collections.EMPTY_LIST, "c1");
        Tree c2 = new SimpleTree(t, Collections.EMPTY_LIST, "c2");
        t.addChild(c1);
        t.addChild(c2);

        assertEquals(null, t.getParent());
        assertEquals(null, t.getValue());
        assertFalse(t.getChildren().isEmpty());

        assertTrue(Checklist.compareCollection(new Object[] { c1, c2 }, t
                .getChildren()));

        MutableTree t2 = new SimpleTree();
        t2.addChild(new SimpleTree(t2, Collections.EMPTY_LIST, "c1"));
        t2.addChild(new SimpleTree(t2, Collections.EMPTY_LIST, "c2"));
        assertEquals(t2, t);

        t.removeChild(c2);

        assertTrue(Checklist.compareCollection(new Object[] { c1 }, t
                .getChildren()));

        MutableTree t3 = new SimpleTree();
        t3.addChild(new SimpleTree(t3, Collections.EMPTY_LIST, "c1"));
        assertEquals(t3, t);
    }
}