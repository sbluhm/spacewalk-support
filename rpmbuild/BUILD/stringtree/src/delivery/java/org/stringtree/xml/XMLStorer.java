package org.stringtree.xml;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Stack;

import org.stringtree.Fetcher;
import org.stringtree.fetcher.hierarchy.HierarchyHelper;
import org.stringtree.fetcher.hierarchy.HierarchyStorer;
import org.stringtree.util.ArrayIterator;

// TODO not threadsafe; split into public method(s) and worker object?
public class XMLStorer implements HierarchyStorer {
    
    private Fetcher fetcher;
    private Stack keynames;
    private boolean inSaveTag = false;
    private HierarchyHelper helper;
    
    public XMLStorer(HierarchyHelper helper) {
        this.helper = helper;
    }
    
    private static String translate(String s) {
        StringBuffer ret = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            switch (c) {
            case '>':
                ret.append("&gt;");
                break;
            case '<':
                ret.append("&lt;");
                break;
            case '&':
                ret.append("&amp;");
                break;
            case '\"':
                ret.append("&quot;");
                break;
            case '\'':
                ret.append("&apos;");
                break;
            default:
                ret.append(c);
                break;
            }
        }
        
        return ret.toString();
    }
    
    private void closeTag(Writer out) throws IOException {
        if (inSaveTag) {
            out.write(">");

            Object value = fetcher.getObject((String)keynames.pop());
            if (value != null && !value.equals("")) {
                String translated = translate(value.toString());
                out.write(translated);
            }
            
            inSaveTag = false;
        }
    }
	
	private void end(Writer out, String key, Object value) throws IOException {
        String tag = helper.getLeafName(key);
        if (tag != null && !helper.isAttribute(key)) {
            closeTag(out);
	    	out.write("</" + tag + ">");
        }
	}
    

	private void start(Writer out, String key, Object value) throws IOException {
        String tag = helper.getLeafName(key);
        if (tag != null) {
            if (helper.isAttribute(key)) {
                out.write(" " + tag + "=\"" + value + "\"");
            } else {
                closeTag(out);

  		        out.write("<" + tag);
                keynames.push(key);
                inSaveTag = true;
            }
        }
	}
    
	private Object[] expandKey(String key) {
        int depth = helper.getDepth(key);
        Object[] ret = new Object[depth];
        for (int i = depth-1; i >= 0; --i) {
            ret[i] = key;
            key = helper.getParentKey(key);
        }
		
		return ret;
	}

	private Object[] writeKey(Writer out, Object[] context, String key) throws IOException {
		Object[] keys = expandKey(key);
		Iterator cit = new ArrayIterator(context);
		Iterator kit = new ArrayIterator(keys);
		
		String keyElement = null;
		String contextElement = null;
		
		// skip over common root elements
		//
		while (cit.hasNext() && kit.hasNext()) {
			contextElement = (String)cit.next();
			keyElement = (String)kit.next();
            
			if (! contextElement.equals(keyElement)) {
				break;
			}
			contextElement = null;
			keyElement = null;
		}
		
		// end any remaining context elements (in reverse order)
		//
		Stack s = new Stack();
		if (contextElement != null) {
			s.push(contextElement);
		}
		while (cit.hasNext()) {
			s.push(cit.next());
		}

        while (!s.empty()) {
            String element = (String)s.pop();
			end(out, element, fetcher.getObject(element));
		}
        
		// start any remaining key elements
		//
		if (keyElement != null) {
			start(out, keyElement, fetcher.getObject(keyElement));
		}
		while (kit.hasNext()) {
            String element = (String)kit.next();
			start(out, element, fetcher.getObject(element));
		}
		
		return keys;
	}
	

    public void store(Fetcher fetcher, Writer writer) throws IOException {
        this.fetcher = fetcher;
		Object[] context = new Object[0];
        keynames = new Stack();
        inSaveTag = false;

        // TODO write out XML header
        Iterator it = helper.depthFirst(fetcher);
		while (it.hasNext()) {
            String key = (String)it.next();
            if (key != null && !key.endsWith("~")) {
                context = writeKey(writer, context, key);
            }
		}

		// flush out any remaining context, closing any remaining tags
		//
		writeKey(writer, context, null);
    }
}