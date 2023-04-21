package org.stringtree.fetcher;

import java.io.PrintStream;
import java.util.Iterator;

import org.stringtree.Fetcher;
import org.stringtree.Listable;

import org.stringtree.util.sort.UniqueSortedIteratorIterator;

public class FetcherHelper {
    
    public static Object getPeelback(Fetcher context, String name, String sep) {
        Object ret = context.getObject(name);
        if (ret != null)
            return ret;

        int pos = name.length() + 1;
        while (ret == null) {
            pos = name.lastIndexOf(sep, pos - 1);
            if (pos == -1)
                break;
            String parentName = name.substring(0, pos);
            Object parent = context.getObject(parentName);
            String childName = name.substring(pos + 1);
            if (parent != null) {
                Fetcher fetcher = new UnknownObjectFetcher(parent, context);
                ret = getPeelback(fetcher, childName, sep);
            }
        }

        return ret;
    }

    public static Object getPeelback(Fetcher fetcher, String name) {
        return getPeelback(fetcher, name, ".");
    }

    public static void dump(String title, Fetcher context, PrintStream out) {
        Listable list = (Listable) context.getObject(Listable.LIST);

        if (list != null) {
            out.println(title);

            Iterator it = new UniqueSortedIteratorIterator(list.list());
            while (it.hasNext()) {
                String key = (String) it.next();
                out.print(key);
                out.print(" => ");
                out.println(FetcherStringHelper.getString(context, key));
            }
        } else {
            out.println("sorry, can't list context");
        }
    }

    public static void dump(String title, Fetcher context) {
        dump(title, context, System.out);
    }
}
