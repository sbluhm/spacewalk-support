package tests.util;

import org.stringtree.finder.StringFinder;
import org.stringtree.finder.StringKeeper;

public class MethodCallExample {
    
    public StringFinder context;
    public int requests = 0;

    public void init(StringFinder context) {
        this.context = context;
    }

    public void request() {
        ++requests;
    }
    
    public void m1(StringFinder context) {
        ++requests;
    }
    
    public void m2() {
        ++requests;
    }
    
    public void m2(String s) {
        ++requests;
    }
    
    public void m2(StringFinder context) {
        ++requests;
    }
    
    public void m2(StringKeeper context) {
        ++requests;
    }
}
