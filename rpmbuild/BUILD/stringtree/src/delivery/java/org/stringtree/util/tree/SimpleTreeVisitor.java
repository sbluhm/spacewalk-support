package org.stringtree.util.tree;

public abstract class SimpleTreeVisitor implements TreeVisitor {
    public void enter(Tree node) {
        visit(node);
    }

    public void exit(Tree node) {
        // do nothing, we are only interested in the nodes themselves
    }

}
