package org.stringtree.util;

public interface MutableProxy extends Proxy {
    void setValue(Object value);
}