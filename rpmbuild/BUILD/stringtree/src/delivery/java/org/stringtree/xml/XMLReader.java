package org.stringtree.xml;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.stringtree.util.StringUtils;

public class XMLReader extends RootTagHandler {

    private int level = 0;
    private boolean trim = true;
    private boolean includeDirectives = false;
    private boolean ignoreRoot = false;
    private boolean allowSingles = true;
    private String attributePrefix = "@";
    
    public Object doPair(Object context, String name, Map attributes, Reader in) throws IOException {
//System.err.println("doPair name=" + name + " level=" + level + " attributes=" + attributes);
        Map map = (Map)context; 
        String oldCdata = getCdata();

        Map child = null;
        if (level == 0 && ignoreRoot) {
            child = map;
        } else {
            child = new HashMap();
        }
        
        ++level;
          Tag tag = (Tag)super.doPair(child, name, attributes, in);
        --level;
        if (level > 0 || ignoreRoot==false) populate(name, attributes, map, child, tag);
        
        setCdata(oldCdata);
        return tag;
    }

    public Object doSingle(Object context, String name, Map attributes) {
//System.err.println("doSingle name=" + name + " level=" + level + " attributes=" + attributes);
        Map map = (Map)context; 
        Map child = new HashMap();
        Tag tag = (Tag)super.doSingle(context, name, attributes);
        if (includeDirectives || !name.startsWith("?")) populate(name, attributes, map, child, tag);
        
        return tag;
    }


    private void populate(String name, Map attributes, Map parent, Map child, Tag tag) {
        Iterator it = attributes.keySet().iterator();
        while (it.hasNext()) {
            String key = (String)it.next();
            add(child, attributePrefix + key, attributes.get(key));
        }
        
        Map cdataParent = parent;
        String cdataName = name;
        if (!child.isEmpty()) {
            add(parent, name, child);
            cdataName = "text()";
            cdataParent = child;
        }

        String cdata = tag.getData();
        if (trim) cdata = cdata.trim();
        if (!StringUtils.isBlank(cdata)) {
            add(cdataParent, cdataName, cdata);
        }
    }

    private void add(Map map, String name, Object value) {
        Object child = map.get(name);
        if (null == child) {
            if (!(value instanceof Collection) && !allowSingles) {
                Collection collection = new ArrayList();
                collection.add(value);
                value = collection;
            }
            map.put(name, value);
        } else if (child instanceof Collection) {
            ((Collection)child).add(value);
        } else {
            Collection collection = new ArrayList();
            collection.add(child);
            collection.add(value);
            map.put(name, collection);
        }
    }

    public Object read(String string) {
        Map map = new HashMap();
        try {
            run(map, new StringReader(string));
        } catch (IOException e) {
             e.printStackTrace();
        }

        if (allowSingles) return map;
        
        Collection collection = new ArrayList();
        collection.add(map);
        return collection;
    }

    public void setTrimCdata(boolean trim) {
        this.trim  = trim;
    }

    public void setInlcudeProcessingDirectives(boolean includeDirectives) {
        this.includeDirectives = includeDirectives;
    }

    public void setIgnoreRoot(boolean ignore) {
        this.ignoreRoot = ignore;
    }

    public void setAllowSingles(boolean allow) {
        this.allowSingles = allow;
    }

    public void setAttributePrefix(String prefix) {
        this.attributePrefix = prefix;
    }
}
