package org.stringtree.mock.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Map;

import org.stringtree.mock.RecordingMock;


public class MockDatabaseConnection extends RecordingMock implements Connection {
    
    public Statement statement = null;
    
    public MockDatabaseConnection(Statement statement) {
        setStatement(statement);
    }
    
    public MockDatabaseConnection() {
        setStatement(new MockStatement());
    }
    
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

	public Statement createStatement() throws SQLException {
		record(this, "createStatement");
		return statement;
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		record(this, "prepareStatement", new Object[] { sql });
        return (PreparedStatement)statement;
	}

	public CallableStatement prepareCall(String sql) throws SQLException {
		record(this, "prepareCall", new Object[] { sql });
        return (CallableStatement)statement;
	}

	public String nativeSQL(String sql) throws SQLException {
		record(this, "nativeSQL", new Object[] { sql });
		return null;
	}

	public void setAutoCommit(boolean arg0) throws SQLException {
		record(this, "setAutoCommit");

	}

	public boolean getAutoCommit() throws SQLException {
		record(this, "getAutoCommit");
		return false;
	}

	public void commit() throws SQLException {
		record(this, "commit");

	}

	public void rollback() throws SQLException {
		record(this, "rollback");

	}

	public void close() throws SQLException {
		record(this, "close");

	}

	public boolean isClosed() throws SQLException {
		record(this, "isClosed");
		return false;
	}

	public DatabaseMetaData getMetaData() throws SQLException {
		record(this, "getMetaData");
		return null;
	}

	public void setReadOnly(boolean arg0) throws SQLException {
		record(this, "setReadOnly", new Object[] { new Boolean(arg0) });

	}

	public boolean isReadOnly() throws SQLException {
		record(this, "isReadOnly");
		return false;
	}

	public void setCatalog(String arg0) throws SQLException {
		record(this, "setCatalog", new Object[] { arg0 });

	}

	public String getCatalog() throws SQLException {
		record(this, "getCatalog");
		return null;
	}

	public void setTransactionIsolation(int arg0) throws SQLException {
		record(this, "setTransactionIsolation", new Object[] { new Integer(arg0) });

	}

	public int getTransactionIsolation() throws SQLException {
		record(this, "getTransactionIsolation");
		return 0;
	}

	public SQLWarning getWarnings() throws SQLException {
		record(this, "getWarnings");
		return null;
	}

	public void clearWarnings() throws SQLException {
		record(this, "clearWarnings");

	}

	public Statement createStatement(int arg0, int arg1) throws SQLException {
		record(this, "createStatement", new Object[] { new Integer(arg0), new Integer(arg1) });
		return statement;
	}

	public PreparedStatement prepareStatement(String arg0, int arg1, int arg2) throws SQLException {
		record(this, "prepareStatement", new Object[] { arg0, new Integer(arg1), new Integer(arg2) });
		return (PreparedStatement)statement;
	}

	public CallableStatement prepareCall(String arg0, int arg1, int arg2) throws SQLException {
		record(this, "prepareCall", new Object[] { arg0, new Integer(arg1), new Integer(arg2) });
		return (CallableStatement)statement;
	}

	public Map getTypeMap() throws SQLException {
		record(this, "getTypeMap()");
		return null;
	}

	public void setTypeMap(Map arg0) throws SQLException {
		record(this, "setTypeMap", new Object[] { arg0 });

	}

	public void setHoldability(int arg0) throws SQLException {
		record(this, "setHoldability", new Object[] { new Integer(arg0) });

	}

	public int getHoldability() throws SQLException {
		record(this, "getHoldability");
		return 0;
	}

	public Savepoint setSavepoint() throws SQLException {
		record(this, "setSavepoint");
		return null;
	}

	public Savepoint setSavepoint(String arg0) throws SQLException {
		record(this, "setSavepoint", new Object[] { arg0 });
		return null;
	}

	public void rollback(Savepoint arg0) throws SQLException {
		record(this, "rollback", new Object[] { arg0 });

	}

	public void releaseSavepoint(Savepoint arg0) throws SQLException {
		record(this, "releaseSavepoint", new Object[] { arg0 });

	}

	public Statement createStatement(int arg0, int arg1, int arg2) throws SQLException {
		record(this, "createStatement", new Object[] { new Integer(arg0), 
				new Integer(arg1), new Integer(arg2) });
		return statement;
	}

	public PreparedStatement prepareStatement(String arg0, int arg1, int arg2,
			int arg3) throws SQLException {
		record(this, "prepareStatement", new Object[] { arg0, 
				new Integer(arg1), new Integer(arg2), new Integer(arg3) });
        return (PreparedStatement)statement;
	}

	public CallableStatement prepareCall(String arg0, int arg1, int arg2, int arg3) throws SQLException {
		record(this, "prepareCall", new Object[] { arg0, 
				new Integer(arg1), new Integer(arg2), new Integer(arg3) });
        return (CallableStatement)statement;
	}

	public PreparedStatement prepareStatement(String arg0, int arg1)
			throws SQLException {
		record(this, "prepareStatement", new Object[] { arg0, new Integer(arg1) });
        return (PreparedStatement)statement;
	}

	public PreparedStatement prepareStatement(String arg0, int[] arg1)
			throws SQLException {
		record(this, "prepareStatement", new Object[] { arg0, arg1 });
        return (PreparedStatement)statement;
	}

	public PreparedStatement prepareStatement(String arg0, String[] arg1)
			throws SQLException {
		record(this, "prepareStatement", new Object[] { arg0, arg1 });
        return (PreparedStatement)statement;
	}
}
