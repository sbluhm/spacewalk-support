package tests;

import java.util.HashMap;
import java.util.Map;

public class TestBean {
    
    public String ms = "world";

    public int mi = 321;

    public String tos = "A Test Bean";

    public Map stuff = new HashMap();

    public TestBean() {
        stuff.put("a", "wibble");
        stuff.put("b", "hooplah");
    }

    public String getMs() {
        return ms;
    }

    public int getMi() {
        return mi;
    }

    public Map getStuff() {
        return stuff;
    }

    public String toString() {
        return tos;
    }
}
