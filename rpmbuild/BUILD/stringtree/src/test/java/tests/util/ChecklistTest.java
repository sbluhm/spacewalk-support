package tests.util;

import junit.framework.TestCase;

import org.stringtree.util.ArrayIterator;
import org.stringtree.util.testing.Checklist;

public class ChecklistTest extends TestCase {
    
    protected Checklist c;

    public ChecklistTest(String name) {
        super(name);
    }

    public void setUp() {
        Checklist.setVerboseDefault(Checklist.SILENT);
        c = new Checklist(new String[] { "first", "second", null });
    }

    public void testEmpty() {
        assertTrue(!c.isChecked("first"));
        assertTrue(!c.isChecked("second"));
        assertTrue(!c.isChecked(null));
        assertTrue(!c.allCheckedAtLeastOnce());
        assertTrue(!c.anyCheckedMoreThanOnce());
        assertTrue(!c.anyUnknownItemsChecked());
        assertTrue(!c.allAndOnlyOnce());

        assertTrue(!c.isChecked("unknown"));
    }

    public void testIsChecked() {
        c.check("first");
        assertTrue(c.isChecked("first"));
        assertTrue(!c.isChecked("second"));
        assertTrue(!c.isChecked(null));
        assertTrue(!c.isChecked("unknown"));
    }

    public void testAllCheckedAtLeastOnce() {
        c.check("first");
        assertTrue(!c.allCheckedAtLeastOnce());
        c.check("second");
        assertTrue(!c.allCheckedAtLeastOnce());
        c.check(null);
        assertTrue(c.allCheckedAtLeastOnce());
        c.check("unknown");
        assertTrue(c.allCheckedAtLeastOnce());
    }

    public void testAnyCheckedMoreThanOnce() {
        c.check("first");
        assertTrue(!c.anyCheckedMoreThanOnce());
        c.check("first");
        assertTrue(c.anyCheckedMoreThanOnce());
    }

    public void testUnknownCheckedMoreThanOnce() {
        c.check("unknown");
        assertTrue(!c.anyCheckedMoreThanOnce());
        c.check("unknown");
        assertTrue(!c.anyCheckedMoreThanOnce());
    }

    public void testAnyUnknownItemsChecked() {
        c.check("first");
        assertTrue(!c.anyUnknownItemsChecked());
        c.check("unknown");
        assertTrue(c.anyUnknownItemsChecked());
    }

    public void testAllAndOnlyOnce() {
        c.check("first");
        assertTrue(!c.allAndOnlyOnce());
        c.check("second");
        assertTrue(!c.allAndOnlyOnce());
        c.check(null);
        assertTrue(c.allAndOnlyOnce());
        c.check("unknown");
        assertTrue(!c.allAndOnlyOnce());
    }

    public void testIterator() {
        Object[] all = new Object[] { "third", "first", "second" };
        Object[] some = new Object[] { "third", "first" };
        Object[] extra = new Object[] { "third", "first", "second", "fourth" };
        Object[] none = new Object[0];

        c = new Checklist(new String[] { "first", "second", "third" });

        c.checkIterator(new ArrayIterator(all));
        assertTrue(c.allAndOnlyOnce());

        c.checkIterator(new ArrayIterator(some));
        assertTrue(!c.allAndOnlyOnce());

        c.checkIterator(new ArrayIterator(extra));
        assertTrue(!c.allAndOnlyOnce());

        c.checkIterator(new ArrayIterator(none));
        assertTrue(!c.allAndOnlyOnce());
    }

    public void testStatic() {
        assertTrue(Checklist.compareIterator(new String[] { "first", "second",
                "third" }, new ArrayIterator(new Object[] { "third", "first",
                "second" })));

        assertTrue(!Checklist
                .compareIterator(new String[] { "first", "second", "third" },
                        new ArrayIterator(new Object[] { "third", "first" })));

        assertTrue(!Checklist.compareIterator(new String[] { "first", "second",
                "third" }, new ArrayIterator(new Object[] { "third", "first",
                "second", "fourth" })));

        assertTrue(!Checklist.compareIterator(new String[] { "first", "second",
                "third" }, new ArrayIterator(new Object[0])));
    }

    private class S {
        private String s;

        public S(String s) {
            this.s = s;
        }

        public String toString() {
            return s + "X";
        }
    }

    public void testIteratorStrings() {
        Object[] all = new Object[] { new S("third"), new S("first"),
                new S("second") };
        Object[] some = new Object[] { new S("third"), new S("first") };
        Object[] extra = new Object[] { new S("third"), new S("first"),
                new S("second"), new S("fourth") };
        Object[] none = new Object[0];

        c = new Checklist(new String[] { "firstX", "secondX", "thirdX" });

        c.checkIteratorStrings(new ArrayIterator(all));
        assertTrue(c.allAndOnlyOnce());

        c.checkIteratorStrings(new ArrayIterator(some));
        assertTrue(!c.allAndOnlyOnce());

        c.checkIteratorStrings(new ArrayIterator(extra));
        assertTrue(!c.allAndOnlyOnce());

        c.checkIteratorStrings(new ArrayIterator(none));
        assertTrue(!c.allAndOnlyOnce());
    }

    public void testStaticStrings() {
        assertTrue(Checklist.compareIteratorStrings(new String[] { "firstX",
                "secondX", "thirdX" }, new ArrayIterator(new Object[] {
                new S("third"), new S("first"), new S("second") })));

        assertTrue(!Checklist.compareIteratorStrings(new String[] { "firstX",
                "secondX", "thirdX" }, new ArrayIterator(new Object[] {
                new S("third"), new S("first") })));

        assertTrue(!Checklist.compareIteratorStrings(new String[] { "firstX",
                "secondX", "thirdX" }, new ArrayIterator(new Object[] {
                new S("third"), new S("first"), new S("second"),
                new S("fourth") })));

        assertTrue(!Checklist.compareIteratorStrings(new String[] { "firstX",
                "secondX", "thirdX" }, new ArrayIterator(new Object[0])));
    }
}