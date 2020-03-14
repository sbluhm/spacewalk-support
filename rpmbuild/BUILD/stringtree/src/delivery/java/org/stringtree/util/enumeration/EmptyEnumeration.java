package org.stringtree.util.enumeration;

import java.util.Enumeration;

public class EmptyEnumeration implements Enumeration {
	
    public boolean hasMoreElements() {
		return false;
	}

	public Object nextElement() {
		return null;
	}

}
