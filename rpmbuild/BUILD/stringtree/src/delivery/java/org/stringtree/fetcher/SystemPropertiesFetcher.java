package org.stringtree.fetcher;

import java.util.Date;

public class SystemPropertiesFetcher extends MapFetcher {
    
    public SystemPropertiesFetcher() {
        super(System.getProperties());
    }

    public Object getObject(String name) {
        if ("date".equals(name)) {
            return new Date();
        }

        return super.getObject(name);
    }

}
