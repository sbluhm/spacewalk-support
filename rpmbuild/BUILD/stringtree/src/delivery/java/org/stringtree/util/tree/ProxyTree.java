package org.stringtree.util.tree;

import java.util.Collection;

import org.stringtree.util.MutableProxy;
import org.stringtree.util.Proxy;

public class ProxyTree extends SimpleTree {
    public ProxyTree() {
        super();
    }

    public ProxyTree(Tree parent, Collection children, Object value) {
        super(parent, children, value);
    }

    public Object getValue() {
        Object ret = value;
        if (ret != null && ret instanceof Proxy) {
            ret = ((Proxy) ret).getValue();
        }

        return ret;
    }

    public void setValue(Object value) {
        if (this.value != null && this.value instanceof Proxy) {
            if (this.value instanceof MutableProxy) {
                ((MutableProxy) this.value).setValue(value);
            } else {
                throw new UnsupportedOperationException(
                        "This proxy object is read-only");
            }
        } else {
            this.value = value;
        }
    }
}
