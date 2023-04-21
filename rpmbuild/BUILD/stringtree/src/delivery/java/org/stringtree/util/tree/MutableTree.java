package org.stringtree.util.tree;

public interface MutableTree extends Tree {
    void setParent(Tree parent);
    void addChild(Tree child);
    void removeChild(Tree child);
    void setValue(Object value);
}
