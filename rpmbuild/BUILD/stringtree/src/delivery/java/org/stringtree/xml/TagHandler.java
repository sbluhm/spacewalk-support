package org.stringtree.xml;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

public interface TagHandler {
	public Object doPair(Object context, String name, Map args, Reader in) throws IOException;
	public Object doSingle(Object context, String name, Map args);
	public String getName();
	public Tag getTag();
}