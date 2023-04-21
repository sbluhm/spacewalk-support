package tests.template;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.stringtree.Fetcher;
import org.stringtree.fetcher.MapFetcher;
import org.stringtree.finder.FetcherStringFinder;
import org.stringtree.finder.StringFinder;
import org.stringtree.template.ByteArrayStringCollector;
import org.stringtree.template.DirectFetcherTemplater;
import org.stringtree.template.StringCollector;
import org.stringtree.template.Templater;
import org.stringtree.template.TemplaterHelper;
import org.stringtree.util.XMLEscaper;

import junit.framework.TestCase;

public class NestedTemplateTest extends TestCase {
    
    Templater templater;
    Map tplstore;
    Fetcher templates;
    MapFetcher context;
    StringCollector collector;
    StringFinder finder;

    public void setUp() {
        tplstore = new HashMap();
        context = new MapFetcher();
        finder = new FetcherStringFinder(context);
        templates = new MapFetcher(tplstore);
        templater = new DirectFetcherTemplater(templates);
        collector = new ByteArrayStringCollector();
        
        tplstore.put("top", "<list>${*list}</list>");
        tplstore.put("list", "${this*map}");
        tplstore.put("map", "<map>${this*entry}</map>");
        tplstore.put("entry", "<entry><id>${this.key}</id><kids>${this.value*list}</kids></entry>");
    }
    
    public void testSingleEntryNoKids() {
        List list = new ArrayList();
        Map entries = new HashMap();
        list.add(entries);

        entries.put("1", null);
        
        context.put("this", list);
        String result = TemplaterHelper.expand(templater, finder, "top");
        assertEquals("<list><map><entry><id>1</id><kids></kids></entry></map></list>", result);
    }
    
    public void testDeepEntry() {
        List list = new ArrayList();
        Map entries = new HashMap();
        list.add(entries);

        List kids = new ArrayList();
        
        Map kids1 = new HashMap();
        kids1.put("1.1", null);
        kids.add(kids1);

        Map kids2 = new HashMap();
        kids2.put("1.2", null);
        kids.add(kids2);
        
        entries.put("1", kids);

        context.put("this", list);
        String result = TemplaterHelper.expand(templater, finder, "top");
        assertEquals("<list><map><entry><id>1</id><kids><map><entry><id>1.1</id><kids></kids></entry></map><map><entry><id>1.2</id><kids></kids></entry></map></kids></entry></map></list>", result);
    }
    
    public void testEscapedDeepEntry() {
        templater.setStringConverter(new XMLEscaper());
        
        List list = new ArrayList();
        Map entries = new HashMap();
        list.add(entries);

        List kids = new ArrayList();
        
        Map kids1 = new HashMap();
        kids1.put("1 & 1", null);
        kids.add(kids1);

        Map kids2 = new HashMap();
        kids2.put("1 > 2", null);
        kids.add(kids2);
        
        entries.put("<1>", kids);

        String result = TemplaterHelper.expand(templater, list, finder, "top");
        assertEquals("<list><map><entry><id>&lt;1&gt;</id><kids><map><entry><id>1 &amp; 1</id><kids></kids></entry></map><map><entry><id>1 &gt; 2</id><kids></kids></entry></map></kids></entry></map></list>", result);
    }

}
