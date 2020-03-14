package org.stringtree.util.tree;

public interface TreeVisitor {
    void enter(Tree node);
    void visit(Tree node);
    void exit(Tree node);
}
