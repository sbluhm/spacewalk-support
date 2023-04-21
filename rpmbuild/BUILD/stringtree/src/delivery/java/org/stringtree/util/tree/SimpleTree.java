package org.stringtree.util.tree;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

public class SimpleTree extends EmptyTree implements MutableTree {
    protected Tree parent;
    protected Collection children;
    protected Object value;

    public SimpleTree(Object value) {
        parent = null;
        children = Collections.EMPTY_LIST;
        this.value = value;
    }

    public SimpleTree() {
        this(null);
    }

    public SimpleTree(Tree parent, Collection children, Object value) {
        this.parent = parent;
        this.children = children;
        this.value = value;
    }

    public Tree getParent() {
        return parent;
    }

    public void setParent(Tree parent) {
        this.parent = parent;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Collection getChildren() {
        return children;
    }

    public void setChildren(Collection children) {
        this.children = children;
    }

    protected void ensureChildren() {
        if (children == Collections.EMPTY_LIST) {
            children = new ArrayList();
        }
    }

    public void addChild(Tree child) {
        ensureChildren();
        children.add(child);
    }

    public void removeChild(Tree child) {
        if (children != null) {
            children.remove(child);
        }
    }
}
