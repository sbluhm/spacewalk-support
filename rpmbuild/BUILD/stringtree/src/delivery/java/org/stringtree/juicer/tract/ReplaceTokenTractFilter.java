package org.stringtree.juicer.tract;

import java.util.Map;


import org.stringtree.Tract;

public class ReplaceTokenTractFilter extends MapReplaceTractFilter {
    
	public ReplaceTokenTractFilter(Map map) {
		super(map);
	}

	public Tract filter(Tract input) {
		if (TokenHelper.isToken(input)) {
			return super.filter(input);
		}
		return input;
	}
}
