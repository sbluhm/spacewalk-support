package org.stringtree.juicer;

import java.util.Iterator;
import java.util.List;

import org.stringtree.juicer.tract.TractFilter;
import org.stringtree.juicer.tract.TractSource;

public class JuicerTractHelper {
    
	public static TractSource linkTractFilters(List list, TractSource head) {
		TractSource tail = head;
		Iterator it = list.iterator();
		while (it.hasNext()) {
			TractFilter filter = (TractFilter)it.next();
			filter.connectSource(tail);
			tail = filter;
		}
		
		return tail;
	}
}
