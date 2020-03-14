package tests.db;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DatabaseTests extends TestCase {
    
    public static TestSuite suite() {
        TestSuite ret = new TestSuite();

        ret.addTest(new TestSuite(BeanResultTest.class));
        return ret;
    }
}
