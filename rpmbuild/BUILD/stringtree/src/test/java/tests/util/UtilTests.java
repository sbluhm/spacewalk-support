package tests.util;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class UtilTests extends TestCase {
    
    public static boolean logging = false;

    public UtilTests(String name) {
        super(name);
    }

    public static TestSuite suite() {
        TestSuite ret = new TestSuite();

        ret.addTest(new TestSuite(GuidTest.class));
        ret.addTest(new TestSuite(XMLTestUtilsTest.class));
        ret.addTest(new TestSuite(NestedIteratorTest.class));
        ret.addTest(new TestSuite(StringSplitterTest.class));
        ret.addTest(new TestSuite(ClassUtilTest.class));
        ret.addTest(new TestSuite(MethodCallTest.class));
        ret.addTest(new TestSuite(TractTest.class));
        ret.addTest(new TestSuite(AttributeContentTest.class));
        ret.addTest(new TestSuite(CacheTest.class));
        ret.addTest(new TestSuite(TreeTest.class));
        ret.addTest(new TestSuite(TreeWalkerTest.class));
        ret.addTest(new TestSuite(UtilTest.class));
        ret.addTest(new TestSuite(ArrayIteratorTest.class));
        ret.addTest(new TestSuite(ChecklistTest.class));
        ret.addTest(new TestSuite(LoggerTest.class));
        ret.addTest(new TestSuite(SortedIteratorIteratorTest.class));
        ret.addTest(new TestSuite(SorterTest.class));

        return ret;
    }

    public static void log(String s) {
        if (logging) {
            System.out.println(s);
        }
    }
}
