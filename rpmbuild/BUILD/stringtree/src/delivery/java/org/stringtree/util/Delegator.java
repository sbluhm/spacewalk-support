package org.stringtree.util;

public class Delegator extends ShallowDelegator {
    
    public Delegator(Object other) {
        super(other);
    }

    public String toString() {
        return other.toString();
    }

    public boolean equals(Object obj) {
        return other.equals(obj);
    }

    public int hashCode() {
        return other.hashCode();
    }
}
