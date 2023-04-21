package tests.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.stringtree.util.iterator.Spliterator;
import org.stringtree.xml.XMLReader;

import junit.framework.TestCase;

public class XMLTestCase extends TestCase {

    XMLReader reader;
    Object obj1;
    Map map1;
    List list1;
    
    Object obj2;
    Map map2;
    List list2;
    
    boolean strict = false;
    Map keyCache;

    public void setUp() {
        reader = new XMLReader();
        obj1 = null;
        map1 = null;
        obj2 = null;
        map2 = null;
        keyCache = new HashMap();
    }
    
    protected void read(String text, boolean trim) {
        reader.setTrimCdata(trim);
        obj1 = reader.read(text);
        if (strict) obj2 = reader.read("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + text);
    }

    protected void parse(String label, String xml, boolean trim) {
        read(xml, trim);
        if (obj1 instanceof Map) {
            map1 = (Map) obj1;
            if (strict) {
                assertTrue(obj2 instanceof Map);
                map2 = (Map) obj2;
            }
        } else if (obj1 instanceof List) {
            list1 = (List)obj1;
            if (strict) {
                assertTrue(obj2 instanceof List);
                list2 = (List) obj2;
            }
        }
        if (null != label) {
            //System.err.println("(without) " + label + ": " + obj1);
            //System.err.println("(with) " + label + ": " + obj2);
        }
    }

    protected void parse(String label, String xml) {
        parse(label, xml, true);
    }

    protected void parse(String xml) {
        parse(null, xml);
    }

    public void assertMapSize(int desired, Map map) {
        assertEquals(desired, map.size());
    }

    public void assertListSize(int desired, List list) {
        assertEquals(desired, list.size());
    }

    public void assertMapSize(int desired) {
        assertMapSize(desired, map1);
        if (strict) assertMapSize(desired, map2);
    }

    public void assertListSize(int desired) {
        assertListSize(desired, list1);
        if (strict) assertListSize(desired, list2);
    }
    
    public void assertType(Map map, Class c, String name) {
        Object obj = get(map, name);
        assertNotNull(obj);
        assertTrue(c.isInstance(obj));
    }
    
    public void assertType(Class c, String name) {
        assertType(map1, c, name);
        if (strict) assertType(map2, c, name);
    }

    public void assertContents(Map map, String desired, String key) {
        assertEquals(desired, get(map, key));
    }

    public void assertContents(String desired, String key) {
        assertContents(map1, desired, key);
        if (strict) assertContents(map1, desired, key);
    }

    public void assertContents(Map map, Object desired, String path, int index) {
        Object obj = get(map, path);
        assertTrue(obj instanceof List);
        assertEquals(desired, ((List)obj).get(index));
    }

    public void assertContents(Object desired, String path, int index) {
        assertContents(map1, desired, path, index);
        if (strict) assertContents(map1, desired, path, index);
    }

    public Object get(Map map, String key) {
        if (keyCache.containsKey(key)) {
            return keyCache.get(key);
        }
        
        Spliterator it = new Spliterator(key, "/");
        Map context = map;
        Object value = null;
        while (it.hasNext()) {
            String child = it.nextString();
            if (it.hasNext()) {
                context = (Map)context.get(child);
            } else {
                value = context.get(child);
            }
        }
        
        keyCache.put(key, value);
        return value;
    }
}
