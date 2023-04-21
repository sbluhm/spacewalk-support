package org.stringtree.util.tree;

import java.util.Collection;

public interface Tree {
    Tree getParent();
    Collection getChildren();
    Object getValue();
}
