package org.stringtree.juicer.tract;

import java.util.Map;

public class MapReplaceTractFilter extends ReplaceTractFilter {
    
	protected Map map;
	
	public MapReplaceTractFilter(Map map, boolean polite) {
		super(polite);
		this.map = map;
	}
	
	public MapReplaceTractFilter(Map map) {
		this.map = map;
	}

	protected boolean recognize(String content) {
		return map.containsKey(content);
	}

	protected String convert(String content) {
		return (String)map.get(content);
	}
}
