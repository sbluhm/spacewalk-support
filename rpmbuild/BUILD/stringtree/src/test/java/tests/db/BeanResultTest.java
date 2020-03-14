package tests.db;

import javax.sql.DataSource;

import org.stringtree.mock.jdbc.MockDataSource;

import junit.framework.TestCase;

public class BeanResultTest extends TestCase {
    
    DataSource ds;
    
    public void setUp() {
        ds = new MockDataSource();
    }

    public void testEmpty() {
        // this method intentionally left blank!
    }
}
