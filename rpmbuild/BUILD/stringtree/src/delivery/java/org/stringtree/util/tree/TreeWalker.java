package org.stringtree.util.tree;

import java.util.Collection;
import java.util.Iterator;

public class TreeWalker {
    protected Tree root;

    public TreeWalker(Tree root) {
        this.root = root;
    }

    public void walkChildren(TreeVisitor visitor) {
        walkChildren(visitor, root);
    }

    public void walk(TreeVisitor visitor) {
        walkAll(visitor, root);
    }

    protected void walkChildren(TreeVisitor visitor, Tree node) {
        Collection children = node.getChildren();
        if (children != null) {
            Iterator it = children.iterator();
            while (it.hasNext()) {
                Tree child = (Tree) it.next();
                walkAll(visitor, child);
            }
        }
    }

    protected void walkAll(TreeVisitor visitor, Tree node) {
        visitor.enter(node);
        walkChildren(visitor, node);
        visitor.exit(node);
    }
}
