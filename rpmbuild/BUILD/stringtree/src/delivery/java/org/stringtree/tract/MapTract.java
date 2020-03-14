package org.stringtree.tract;

import java.util.Iterator;
import java.util.Map;

import org.stringtree.Listable;
import org.stringtree.Tract;
import org.stringtree.fetcher.MapFetcher;
import org.stringtree.finder.StringFinder;

public class MapTract extends FetcherTract {
    
    public MapTract(String s, Map attributes) {
        if (attributes != null)
            setAttributes(attributes);
        if (s != null)
            setContent(s);
    }

    public MapTract(String s) {
        this(s, (Map) null);
    }

    public MapTract() {
        this(null, (Map) null);
    }

    public MapTract(String s, StringFinder other) {
        setAttributes(other);
        setContent(s);
    }

    public MapTract(StringFinder other) {
        setAttributes(other);
    }

    public void setAttributes(StringFinder other) {
        if (other instanceof Listable) {
            Iterator it = ((Listable)other).list();
            while (it.hasNext()) {
                String key = (String) it.next();
                put(key, other.getObject(key));
            }
        }
    }

    public void setAttributes(Map values) {
        ((MapFetcher) getUnderlyingFetcher()).putAll(values);
    }

    public void setContent(String content) {
        put(Tract.CONTENT, content);
    }

    public String getContent() {
        return get(Tract.CONTENT);
    }

    public boolean hasContent() {
        return getObject(Tract.CONTENT) != null;
    }

    public void setCharacterSet(String charset) {
        put(CHARSET, charset);
    }
    
    public Map getMap() {
        return ((MapFetcher) getUnderlyingFetcher()).getMap();
    }

    public String toString() {
        StringBuffer ret = new StringBuffer("{");
        Iterator it = list();
        while (it.hasNext()) {
            String key = (String) it.next();
            ret.append(key);
            ret.append("=");
            ret.append(get(key));
            if (it.hasNext())
                ret.append(", ");
        }
        ret.append("}");
        return ret.toString();
    }
}
