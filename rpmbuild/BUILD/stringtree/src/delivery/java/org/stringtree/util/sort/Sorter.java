package org.stringtree.util.sort;

import java.util.Vector;

public class Sorter {
    
    protected static void quickSort(Vector v, int lo, int hi) {
        if (lo >= hi)
            return;

        // Use median-of-three(lo, mid, hi) to pick a partition.
        // Also swap them into relative order while we are at it.

        int mid = (lo + hi) / 2;

        if (v.elementAt(lo).toString().compareTo(v.elementAt(mid).toString()) > 0) {
            // swap
            Object tmp = v.elementAt(lo);
            v.setElementAt(v.elementAt(mid), lo);
            v.setElementAt(tmp, mid);
        }

        if (v.elementAt(mid).toString().compareTo(v.elementAt(hi).toString()) > 0) {
            // swap
            Object tmp = v.elementAt(mid);
            v.setElementAt(v.elementAt(hi), mid);
            v.setElementAt(tmp, hi);

            if (v.elementAt(lo).toString().compareTo(
                    v.elementAt(mid).toString()) > 0) {
                // swap
                Object tmp2 = v.elementAt(lo);
                v.setElementAt(v.elementAt(mid), lo);
                v.setElementAt(tmp2, mid);
            }
        }

        int left = lo + 1; // start one past lo since already handled lo
        int right = hi - 1; // similarly
        if (left >= right)
            return; // if three or fewer we are done

        Object partition = v.elementAt(mid);

        for (;;) {
            while (v.elementAt(right).toString()
                    .compareTo(partition.toString()) > 0) {
                --right;
            }

            while (left < right
                    && v.elementAt(left).toString().compareTo(
                            partition.toString()) <= 0) {
                ++left;
            }

            if (left < right) {
                // swap
                Object tmp = v.elementAt(left);
                v.setElementAt(v.elementAt(right), left);
                v.setElementAt(tmp, right);
                --right;
            } else
                break;
        }

        quickSort(v, lo, left);
        quickSort(v, left + 1, hi);
    }

    public static void sortVector(Vector v) {
        quickSort(v, 0, v.size() - 1);
    }
}
