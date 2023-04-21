package org.stringtree.util.tree;

import java.util.Collection;
import java.util.Collections;

public class EmptyTree implements Tree {
    public Tree getParent() {
        return null;
    }

    public Object getValue() {
        return null;
    }

    public Collection getChildren() {
        return Collections.EMPTY_LIST;
    }

    public boolean equals(Object other) {
        return (other instanceof Tree) ? Trees.equals(this, (Tree)other) : false;
    }
}
