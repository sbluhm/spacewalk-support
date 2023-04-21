package tests.template;

import java.util.Collections;
import java.util.List;

public class Sorter {
    
    public List sort(Object obj) {
        List list = (List)obj;
        Collections.sort((List)obj);
        return list;
    }
}
