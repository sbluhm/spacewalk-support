package org.stringtree.util.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Sorter2 {
    
    public List sort(Object obj) {
        List list = null;
        if (obj instanceof List) {
            list = (List)obj;
        } else if (obj instanceof Collection){
            Collection collection = (Collection)obj;
            list = new ArrayList(collection.size());
            list.addAll(collection);
        } else if (obj instanceof Iterator) {
            Iterator it = (Iterator)obj;
            list = new ArrayList();
            while (it.hasNext()) {
                list.add(it.next());
            }
        } else if (obj instanceof Object[]) {
            Object[] array = (Object[])obj;
            list = new ArrayList();
            for (int i = 0; i < array.length; ++i) {
                list.add(array[i]);
            }
        }
        
        if (list != null) {
            Collections.sort(list);
        }
        return list;
    }
}
