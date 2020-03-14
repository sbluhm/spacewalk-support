package org.stringtree.juicer.tract;

import java.util.Iterator;

import org.stringtree.Fetcher;
import org.stringtree.Tract;
import org.stringtree.finder.StringFinder;
import org.stringtree.juicer.JuicerConvertHelper;

public class TractFilterFetcher implements StringFinder {
    
	private TractFilter filter;
	
	public TractFilterFetcher(TractFilter filter) {
		setFilter(filter);
	}
	
	public TractFilterFetcher() {
		setFilter(null);
	}

	public void setFilter(TractFilter filter) {
		this.filter = filter;
	}

	public Object getObject(String key) {
		filter.connectSource(new StringTractSource(key));
		return filter.nextTract();
	}
	
	public String get(String key) {
		return JuicerConvertHelper.compress((Tract)getObject(key));
	}

    public Fetcher getUnderlyingFetcher() {
        // TODO Auto-generated method stub
        return null;
    }

    public Iterator list() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean contains(String name) {
        // TODO Auto-generated method stub
        return false;
    }
}
