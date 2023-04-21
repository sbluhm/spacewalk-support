package org.stringtree.xml;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class MultiValueTagHandler extends BasicTagHandler {
	private Collection tags;
	
	public MultiValueTagHandler(String name) {
		super(name);
		tags = new ArrayList();
	}
	
	public Object doPair(Object context, String name, Map args, Reader in) throws IOException {
		Tag ret = (Tag)super.doPair(context, name, args, in);		
		tags.add(ret.clone());		
		return ret;
	}
	
	public Iterator elements() {
		return tags.iterator();
	}

    public int countTags() {
    	return tags.size();
    }

    public Iterator getTags() {
    	return tags.iterator();
    }
}