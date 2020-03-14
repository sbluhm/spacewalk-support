package org.stringtree.util;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.stringtree.Fetcher;
import org.stringtree.Listable;
import org.stringtree.util.sort.SortedIteratorIterator;

public class Diagnostics {
    
	public static void dumpMap(Map map, String title, OutputStream stream) {
		PrintStream out;

		if (stream != null) {
			if (stream instanceof PrintStream) {
				out = (PrintStream)stream;
			} else {
				out = new PrintStream(stream);
			}

			out.println("Map: start of [" + title + "] ---------------");
			Iterator keys = new SortedIteratorIterator(map.keySet().iterator());
			while (keys.hasNext()) {
				Object key = keys.next();
				out.println("'" + key + "'->'" + map.get(key) + "'");
			}
			out.println("Map: end of   [" + title + "] ---------------");
		}
	}

	public static void dumpMap(Map map, String title) {
		dumpMap(map, title, System.out);
	}


    public static void dumpFetcher(Fetcher fetcher, String title, OutputStream stream)
    {
        PrintStream out;

        if (stream != null)
        {
            if (stream instanceof PrintStream)
            {
                out = (PrintStream)stream;
            }
            else
            {
                out = new PrintStream(stream);
            }

            out.println("Fetcher: start of [" + title + "] ---------------");
            Listable listable = null;
            if (fetcher instanceof Listable)
            {
                listable = (Listable)fetcher;
            }
            else
            {
                listable = (Listable)fetcher.getObject(Listable.LIST);
            }
            
            if (listable != null)
            {
                Iterator keys = new SortedIteratorIterator(listable.list());
                while (keys.hasNext())
                {
                    Object key = keys.next();
                    out.println("'" + key + "'->'" + fetcher.getObject((String)key) + "'");
                }
            }
            else
            {
                out.println("unable to list context");
            }
            out.println("Fetcher: end of   [" + title + "] ---------------");
        }
    }

    public static void dumpFetcher(Fetcher fetcher, String title)
    {
        dumpFetcher(fetcher, title, System.err);
    }

	public static String showList(List list) {
		return showIterator(list.iterator());
	}

	public static String showIterator(Iterator it) {
		StringBuffer ret = new StringBuffer("[");
		while (it.hasNext()) {
			Object obj = it.next();
			if (obj != null) {
				ret.append(obj.toString());
			}

			if (it.hasNext()) {
				ret.append(",");
			}
		}
		ret.append("]");

		return ret.toString();
	}

	public static void whereAmI(PrintStream out) {
		try {
			throw new Exception("You are Here");
		} catch(Exception e) {
			e.printStackTrace(out);
		}
	}

    public static void whereAmI() {
        whereAmI(System.out);
    }

    public String showArray(Object[] array) {
        StringBuffer ret = new StringBuffer("[");
        for (int i = 0; i < array.length; ++i) {
            ret.append(" '");
            ret.append(array[i]);
            ret.append("'");
        }
        ret.append(" ]");
        return ret.toString();
    }
}
