package tests.spec;

import org.stringtree.finder.StringFinder;

public class DummyWithOtherInit extends DummyClass {
    
    public Object value = "unset";

    public boolean equals(Object other) {
        return other instanceof DummyWithOtherInit
                && ((DummyWithOtherInit) other).value.equals(value);
    }

    public void init(StringFinder context) {
        ++requests;
        value = context.getObject("other.value");
    }

    public String toString() {
        return "DummyWithOtherInit:" + value;
    }
}
