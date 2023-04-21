package org.stringtree.juicer;

import java.util.Iterator;
import java.util.List;

import org.stringtree.juicer.string.StringFilter;
import org.stringtree.juicer.string.StringSource;

public class JuicerStringHelper {
    
	public static StringSource linkStringFilters(List list, StringSource head) {
		StringSource tail = head;
		Iterator it = list.iterator();
		while (it.hasNext()) {
			StringFilter filter = (StringFilter)it.next();
			filter.connectSource(tail);
			tail = filter;
		}
		
		return tail;
	}
}
