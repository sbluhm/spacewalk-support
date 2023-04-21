package org.stringtree.fetcher;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.stringtree.Fetcher;
import org.stringtree.util.URLReadingUtils;

/** TODO make it detect and return proper tracts if recognized (and try several suffixes) */ 
public class TractURLFetcher implements Fetcher {

    private URL root;

    public TractURLFetcher(URL root) {
        this.root = root;
    }

    public Object getObject(String name) {
        Object ret = null;
        URL remote = null;
        try {
            remote = new URL(root, name+".tpl");
            ret = URLReadingUtils.readRawURL(remote);
        } catch (MalformedURLException e) {
            /* don't complain, just return null */
        } catch (IOException e) {
            /* don't complain, just return null */
        }
        return ret;
    }
    
    public String toString() {
        return "TractURLFetcher(" + root + ")";
    }
}
