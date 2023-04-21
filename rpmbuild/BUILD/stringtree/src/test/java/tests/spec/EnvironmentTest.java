package tests.spec;

import org.stringtree.finder.StringFinder;
import org.stringtree.util.spec.EnvironmentLoader;

import junit.framework.TestCase;

public class EnvironmentTest extends TestCase {
    
    public void testEnvironment() {
        StringFinder rep = EnvironmentLoader.loadEnvironment();
        // Diagnostics.dumpFetcher(rep.getUnderlyingFetcher(), "environment");
        String[] possibilties = new String[] { "JAVA_HOME", "USER", "USER_NAME", "PATH" };
        boolean checked = false;
        for (int i = 0; i < possibilties.length; ++i) {
            String string = possibilties[i];
            String env = System.getenv(string);
            if (env != null) { 
                if (env.equals(rep.get(string))) {
                    checked = true;
                    break;
                }
            }
        }
        assertTrue(checked);
    }
}
