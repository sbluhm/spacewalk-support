package tests;

import tests.URL.URLTest;
import tests.db.DatabaseTests;
import tests.fetcher.FetcherTests;
import tests.iterator.SkipCommentsTest;
import tests.jndi.JNDITests;
import tests.json.JSONTests;
import tests.juicer.JuicerTests;
import tests.spec.SpecTests;
import tests.template.TemplateTests;
import tests.tree.HierarchyTests;
import tests.util.UtilTests;
import tests.workflow.WorkflowTests;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LocalTests extends TestCase {
    
    public static TestSuite suite() {
        TestSuite ret = new TestSuite();

        ret.addTest(HierarchyTests.suite());
        ret.addTest(new TestSuite(SkipCommentsTest.class));
        ret.addTest(JSONTests.suite());
        ret.addTest(DatabaseTests.suite());
        ret.addTest(TemplateTests.suite());
        ret.addTest(WorkflowTests.suite());
        ret.addTest(JuicerTests.suite());
        ret.addTest(JNDITests.suite());
        ret.addTest(new TestSuite(URLTest.class));
        ret.addTest(UtilTests.suite());
        ret.addTest(SpecTests.suite());
        ret.addTest(FetcherTests.suite());

        return ret;
    }
}
