package org.stringtree.mock.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.RecordingMock;

public class MockDataSource extends RecordingMock implements DataSource {

	public Connection connection;
    
    public MockDataSource() {
        setConnection(new MockDatabaseConnection());
    }
    
    public MockDataSource(Connection connection) {
        setConnection(connection);
    }
    
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
	
	public Connection getConnection() throws SQLException {
		record(new MockAction(this, "getConnection"));
		if (connection == null) {
			connection = new MockDatabaseConnection();
		}
		return connection;
	}

	public Connection getConnection(String arg0, String arg1) throws SQLException {
		record(new MockAction(this, "getConnection", new Object[] { arg0, arg1 }));
		if (connection == null) {
			
		}
		return connection;
	}

	public PrintWriter getLogWriter() throws SQLException {
		record(new MockAction(this, "getLogWriter"));
		return null;
	}

	public void setLogWriter(PrintWriter arg0) throws SQLException {
		record(new MockAction(this, "setLogWriter", new Object[] { arg0 }));
	}

	public void setLoginTimeout(int arg0) throws SQLException {
		record(new MockAction(this, "setLoginTimeout", new Object[] { new Integer(arg0) }));
	}

	public int getLoginTimeout() throws SQLException {
		record(new MockAction(this, "createStatement"));
		return 0;
	}
}