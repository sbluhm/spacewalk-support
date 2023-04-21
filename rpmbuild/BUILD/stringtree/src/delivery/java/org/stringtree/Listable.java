package org.stringtree;

import java.util.Iterator;

public interface Listable {
    static final String LIST = "fetcher.listable";
    Iterator list();
}