package org.stringtree.util.testing;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

public class Checklist {
    public static final int SILENT = 0;
    public static final int NORMAL = 1;
    public static final int VERBOSE = 2;
    
    private static int verboseDefault = NORMAL;
    
    private Object[] items;
    private int[] ticks; // note: extra slot at the end to represent unknown items
    private int verbose;

    public static void setVerboseDefault(int verbose) {
        verboseDefault = verbose;
    }

    public static int getVerboseDefault() {
        return verboseDefault;
    }

    public Checklist(Object[] items, int verbose) {
        set(items);
        setVerbose(verbose);
    }

    public Checklist(Collection items, int verbose) {
        set(items);
        setVerbose(verbose);
    }

    public Checklist(Object[] items) {
        this(items, verboseDefault);
    }

    public Checklist(Collection items) {
        this(items, verboseDefault);
    }

    private void set(Object[] array) {
        items = array;
        ticks = new int[array.length + 1];
        reset();
    }

    private void set(Collection collection) {
        set(collection.toArray());
    }

    public void reset() {
        for (int i = 0; i < ticks.length; ++i) {
            ticks[i] = 0;
        }
    }

    public void setVerbose(int verbose) {
        this.verbose = verbose;
    }

    private boolean match(Object a, Object b) {
        return (a == null) ? b == null : a.equals(b);
    }

    private int find(Object obj) {
        int ret = items.length;

        for (int i = 0; i < items.length; ++i) {
            if (match(items[i], obj)) {
                if (verbose > NORMAL) {
                    System.out.println("Checklist object '" + obj
                            + "' matched item " + (i + 1) + " / "
                            + items.length);
                }

                ret = i;
            }
        }

        if (ret == items.length) {
            if (verbose > SILENT) {
                System.out.println("Checklist object '" + obj
                        + "' failed to match ");
            }
        }

        return ret;
    }

    public void check(Object o) {
        ++ticks[find(o)];
    }

    public boolean isChecked(Object o) {
        return ticks[find(o)] > 0;
    }

    public boolean allCheckedAtLeastOnce() {
        boolean ret = true;

        for (int i = 0; i < items.length; ++i) {
            if (ticks[i] == 0) {
                ret = false;
                if (verbose > SILENT) {
                    System.out.println("Checklist Failure: item '" + items[i] + "' never checked");
                }
            }
        }

        return ret;
    }

    public boolean anyCheckedMoreThanOnce() {
        boolean ret = false;

        for (int i = 0; i < items.length; ++i) {
            if (ticks[i] > 1) {
                ret = true;
                if (verbose > SILENT) {
                    System.out.println("Checklist Failure: item '" + items[i] + 
                        "' checked " + ticks[i] + " times");
                }
            }
        }

        return ret;
    }

    public boolean anyUnknownItemsChecked() {
        boolean ret = ticks[items.length] > 0;
        if (verbose > SILENT) {
            if (ret) {
                System.out.println("Checklist Failure: unknown item(s) checked "
                        + ticks[items.length] + " times");
            }
        }
        return ret;
    }

    public boolean allAndOnlyOnce() {
        return allCheckedAtLeastOnce() && !anyCheckedMoreThanOnce()
                && !anyUnknownItemsChecked();
    }

    public String toString() {
        String ret = "";
        for (int i = 0; i < items.length; ++i) {
            ret += "'" + items[i] + "' [" + ticks[i] + "]\n";
        }
        return ret + "'unknown' [" + ticks[items.length] + "]\n";
    }

    public void checkIterator(Iterator it) {
        reset();
        while (it.hasNext()) {
            check(it.next());
        }
    }

    public void checkEnumeration(Enumeration it) {
        reset();
        while (it.hasMoreElements()) {
            check(it.nextElement());
        }
    }

    public void checkCollection(Collection c) {
        checkIterator(c.iterator());
    }

    public void checkIteratorStrings(Iterator it) {
        reset();
        while (it.hasNext()) {
            String element = it.next().toString();
            check(element);
        }
    }

    public void checkEnumerationStrings(Enumeration it) {
        reset();
        while (it.hasMoreElements()) {
            check(it.nextElement().toString());
        }
    }

    public static boolean compareIterator(Object[] items, Iterator it,
            int verbose) {
        Checklist c = new Checklist(items);
        c.setVerbose(verbose);
        c.checkIterator(it);
        return c.allAndOnlyOnce();
    }

    public static boolean compareIterator(Object[] items, Iterator it,
            boolean verbose) {
        return compareIterator(items, it, verbose ? VERBOSE : verboseDefault);
    }

    public static boolean compareIterator(Object[] items, Iterator it) {
        return compareIterator(items, it, verboseDefault);
    }

    public static boolean compareEnumeration(Object[] items, Enumeration it) {
        Checklist c = new Checklist(items);
        c.checkEnumeration(it);
        return c.allAndOnlyOnce();
    }

    public static boolean compareCollection(Object[] items, Collection c,
            boolean verbose) {
        return compareIterator(items, c.iterator(), verbose);
    }

    public static boolean compareCollection(Object[] items, Collection c) {
        return compareIterator(items, c.iterator());
    }

    public static boolean compareIteratorStrings(Object[] items, Iterator it) {
        Checklist c = new Checklist(items);
        c.checkIteratorStrings(it);
        return c.allAndOnlyOnce();
    }

    public static boolean compareEnumerationStrings(Object[] items,
            Enumeration it) {
        Checklist c = new Checklist(items);
        c.checkEnumerationStrings(it);
        return c.allAndOnlyOnce();
    }

    public static boolean compareIterator(Collection items, Iterator it) {
        return compareIterator(items.toArray(), it);
    }

    public static boolean compareEnumeration(Collection items, Enumeration it) {
        return compareEnumeration(items.toArray(), it);
    }

    public static boolean compareCollection(Collection items, Collection c) {
        return compareCollection(items.toArray(), c);
    }

    public static boolean compareIteratorStrings(Collection items, Iterator it) {
        return compareIteratorStrings(items.toArray(), it);
    }

    public static boolean compareEnumerationStrings(Collection items,
            Enumeration it) {
        return compareEnumerationStrings(items.toArray(), it);
    }
}