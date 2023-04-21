package tests.util;

import java.util.HashMap;

public class ParamClass extends CreatedClass {
    
    public ParamClass(HashMap map) {
        contents = (String) map.get("greeting");
        ++requests;
    }
}
