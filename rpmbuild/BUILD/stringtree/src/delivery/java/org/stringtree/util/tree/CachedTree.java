package org.stringtree.util.tree;

import java.util.Collection;

import org.stringtree.util.Cached;

public class CachedTree extends ProxyTree {
    public CachedTree() {
        super();
    }

    public CachedTree(Tree parent, Collection children, Object value) {
        super(parent, children, value);
    }

    public int getCachedStatus() {
        int ret = Cached.FULL;
        if (value != null && value instanceof Cached) {
            ret = ((Cached) value).getCachedStatus();
        }

        return ret;
    }
}
