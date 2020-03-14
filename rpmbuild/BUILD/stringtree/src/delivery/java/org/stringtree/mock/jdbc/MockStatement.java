package org.stringtree.mock.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import org.stringtree.mock.RecordingMock;

public class MockStatement extends RecordingMock implements CallableStatement {
    
    public ResultSet results;
    
    public MockStatement(ResultSet results) {
        setResults(results);
    }
    
    public MockStatement() {
        this(new MockResultSet());
    }
    
    public void setResults(ResultSet results) {
        this.results = results;
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        record(this, "executeQuery", new Object[] { sql });
        return results;
    }

    public int executeUpdate(String sql) throws SQLException {
        record(this, "executeUpdate", new Object[] { sql });
        return 0;
    }

    public void close() throws SQLException {
        record(this, "close");
    }

    public int getMaxFieldSize() throws SQLException {
        record(this, "getMaxFieldSize");
        return 0;
    }

    public void setMaxFieldSize(int max) throws SQLException {
        record(this, "setMaxFieldSize", new Object[] { new Integer(max) });
    }

    public int getMaxRows() throws SQLException {
        record(this, "getMaxRows");
        return 0;
    }

    public void setMaxRows(int max) throws SQLException {
        record(this, "setMaxRows", new Object[] { new Integer(max) });
    }

    public void setEscapeProcessing(boolean enable) throws SQLException {
        record(this, "setEscapeProcessing", new Object[] { new Boolean(enable) });
    }

    public int getQueryTimeout() throws SQLException {
        record(this, "getQueryTimeout");
        return 0;
    }

    public void setQueryTimeout(int seconds) throws SQLException {
        record(this, "setQueryTimeout", new Object[] { new Integer(seconds) });
    }

    public void cancel() throws SQLException {
        record(this, "cancel");
    }

    public SQLWarning getWarnings() throws SQLException {
        record(this, "getWarnings");
        return null;
    }

    public void clearWarnings() throws SQLException {
        record(this, "clearWarnings");
    }

    public void setCursorName(String name) throws SQLException {
        record(this, "setCursorName", new Object[] { name });
    }

    public boolean execute(String sql) throws SQLException {
        record(this, "execute", new Object[] { sql });
        return false;
    }

    public ResultSet getResultSet() throws SQLException {
        record(this, "getResultSet");
        return null;
    }

    public int getUpdateCount() throws SQLException {
        record(this, "getUpdateCount");
        return 0;
    }

    public boolean getMoreResults() throws SQLException {
        record(this, "getMoreResults");
        return false;
    }

    public void setFetchDirection(int direction) throws SQLException {
        record(this, "setFetchDirection", new Object[] { new Integer(direction) });
    }

    public int getFetchDirection() throws SQLException {
        record(this, "getFetchDirection");
        return 0;
    }

    public void setFetchSize(int rows) throws SQLException {
        record(this, "setFetchSize", new Object[] { new Integer(rows) });
    }

    public int getFetchSize() throws SQLException {
        record(this, "getFetchSize");
        return 0;
    }

    public int getResultSetConcurrency() throws SQLException {
        record(this, "getResultSetConcurrency");
        return 0;
    }

    public int getResultSetType() throws SQLException {
        record(this, "getResultSetType");
        return 0;
    }

    public void addBatch(String sql) throws SQLException {
        record(this, "addBatch", new Object[] { sql });
    }

    public void clearBatch() throws SQLException {
        record(this, "clearBatch");
    }

    public int[] executeBatch() throws SQLException {
        record(this, "executeBatch");
        return null;
    }

    public Connection getConnection() throws SQLException {
        record(this, "getConnection");
        return null;
    }

    public boolean getMoreResults(int current) throws SQLException {
        record(this, "getMoreResults", new Object[] { new Integer(current) });
        return false;
    }

    public ResultSet getGeneratedKeys() throws SQLException {
        record(this, "getGeneratedKeys");
        return null;
    }

    public int executeUpdate(String sql, int autoGeneratedKeys)
            throws SQLException {
        record(this, "executeUpdate", new Object[] { sql, new Integer(autoGeneratedKeys) });
        return 0;
    }

    public int executeUpdate(String sql, int[] columnIndexes)
            throws SQLException {
        record(this, "executeUpdate", new Object[] { sql, columnIndexes });
        return 0;
    }

    public int executeUpdate(String sql, String[] columnNames)
            throws SQLException {
        record(this, "executeUpdate", new Object[] { sql, columnNames });
        return 0;
    }

    public boolean execute(String sql, int autoGeneratedKeys)
            throws SQLException {
        record(this, "execute", new Object[] { sql, new Integer(autoGeneratedKeys) });
        return false;
    }

    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        record(this, "execute", new Object[] { sql, columnIndexes });
        return false;
    }

    public boolean execute(String sql, String[] columnNames)
            throws SQLException {
        record(this, "execute", new Object[] { sql, columnNames });
        return false;
    }

    public int getResultSetHoldability() throws SQLException {
        record(this, "getResultSetHoldability");
        return 0;
    }

    public void registerOutParameter(int parameterIndex, int sqlType) throws SQLException {
        record(this, "registerOutParameter", new Object[] { new Integer(parameterIndex), new Integer(sqlType) });
    }

    public void registerOutParameter(int parameterIndex, int sqlType, int scale) throws SQLException {
        record(this, "registerOutParameter", new Object[] { new Integer(parameterIndex), new Integer(sqlType), new Integer(scale) });
    }

    public boolean wasNull() throws SQLException {
        record(this, "wasNull");
        return false;
    }

    public String getString(int parameterIndex) throws SQLException {
        record(this, "getString", new Object[] { new Integer(parameterIndex) });
        return null;
    }

    public boolean getBoolean(int parameterIndex) throws SQLException {
        record(this, "getBoolean", new Object[] { new Integer(parameterIndex) });
        return false;
    }

    public byte getByte(int parameterIndex) throws SQLException {
        record(this, "getByte", new Object[] { new Integer(parameterIndex) });
        return 0;
    }

    public short getShort(int parameterIndex) throws SQLException {
        record(this, "getShort", new Object[] { new Integer(parameterIndex) });
        return 0;
    }

    public int getInt(int parameterIndex) throws SQLException {
        record(this, "getInt", new Object[] { new Integer(parameterIndex) });
        return 0;
    }

    public long getLong(int parameterIndex) throws SQLException {
        record(this, "getLong", new Object[] { new Integer(parameterIndex) });
        return 0;
    }

    public float getFloat(int parameterIndex) throws SQLException {
        record(this, "getFloat", new Object[] { new Integer(parameterIndex) });
        return 0;
    }

    public double getDouble(int parameterIndex) throws SQLException {
        record(this, "getDouble", new Object[] { new Integer(parameterIndex) });
        return 0;
    }

    public BigDecimal getBigDecimal(int parameterIndex, int scale) throws SQLException {
        record(this, "getBigDecimal", new Object[] { new Integer(parameterIndex), new Integer(scale) });
        return null;
    }

    public byte[] getBytes(int parameterIndex) throws SQLException {
        record(this, "getBytes", new Object[] { new Integer(parameterIndex) });
        return null;
    }

    public Date getDate(int parameterIndex) throws SQLException {
        record(this, "getDate", new Object[] { new Integer(parameterIndex) });
        return null;
    }

    public Time getTime(int parameterIndex) throws SQLException {
        record(this, "getTime", new Object[] { new Integer(parameterIndex) });
        return null;
    }

    public Timestamp getTimestamp(int parameterIndex) throws SQLException {
        record(this, "getTimestamp", new Object[] { new Integer(parameterIndex) });
        return null;
    }

    public Object getObject(int parameterIndex) throws SQLException {
        record(this, "getObject", new Object[] { new Integer(parameterIndex) });
        return null;
    }

    public BigDecimal getBigDecimal(int parameterIndex) throws SQLException {
        record(this, "getBigDecimal", new Object[] { new Integer(parameterIndex) });
        return null;
    }

    public Object getObject(int i, Map map) throws SQLException {
        record(this, "getObject", new Object[] { new Integer(i), map });
        return null;
    }

    public Ref getRef(int i) throws SQLException {
        record(this, "getRef", new Object[] { new Integer(i) });
        return null;
    }

    public Blob getBlob(int i) throws SQLException {
        record(this, "getBlob", new Object[] { new Integer(i) });
        return null;
    }

    public Clob getClob(int i) throws SQLException {
        record(this, "getClob", new Object[] { new Integer(i) });
        return null;
    }

    public Array getArray(int i) throws SQLException {
        record(this, "getArray", new Object[] { new Integer(i) });
        return null;
    }

    public Date getDate(int parameterIndex, Calendar cal) throws SQLException {
        record(this, "getDate", new Object[] { new Integer(parameterIndex), cal });
        return null;
    }

    public Time getTime(int parameterIndex, Calendar cal) throws SQLException {
        record(this, "getTime", new Object[] { new Integer(parameterIndex), cal });
        return null;
    }

    public Timestamp getTimestamp(int parameterIndex, Calendar cal) throws SQLException {
        record(this, "setTimestamp", new Object[] { new Integer(parameterIndex), cal });
        return null;
    }

    public void registerOutParameter(int parameterIndex, int sqlType, String typeName) throws SQLException {
        record(this, "registerOutParameter", new Object[] { new Integer(parameterIndex), new Integer(sqlType), typeName });
    }

    public void registerOutParameter(String parameterName, int sqlType) throws SQLException {
        record(this, "registerOutParameter", new Object[] { parameterName, new Integer(sqlType) });
    }

    public void registerOutParameter(String parameterName, int sqlType, int scale) throws SQLException {
        record(this, "registerOutParameter", new Object[] { parameterName, new Integer(sqlType), new Integer(scale) });
    }

    public void registerOutParameter(String parameterName, int sqlType, String typeName) throws SQLException {
        record(this, "registerOutParameter", new Object[] { parameterName, new Integer(sqlType), typeName });
    }

    public URL getURL(int parameterIndex) throws SQLException {
        record(this, "getURL", new Object[] { new Integer(parameterIndex) });
        return null;
    }

    public void setURL(String parameterName, URL val) throws SQLException {
        record(this, "setURL", new Object[] { parameterName, val });
    }

    public void setNull(String parameterName, int sqlType) throws SQLException {
        record(this, "setNull", new Object[] { parameterName, new Integer(sqlType) });
    }

    public void setBoolean(String parameterName, boolean x) throws SQLException {
        record(this, "setBoolean", new Object[] { parameterName, new Boolean(x) });
    }

    public void setByte(String parameterName, byte x) throws SQLException {
        record(this, "setByte", new Object[] { parameterName, new Byte(x) });
    }

    public void setShort(String parameterName, short x) throws SQLException {
        record(this, "setShort", new Object[] { parameterName, new Short(x) });
    }

    public void setInt(String parameterName, int x) throws SQLException {
        record(this, "setInt", new Object[] { parameterName, new Integer(x) });
    }

    public void setLong(String parameterName, long x) throws SQLException {
        record(this, "setLong", new Object[] { parameterName, new Long(x) });
    }

    public void setFloat(String parameterName, float x) throws SQLException {
        record(this, "setFloat", new Object[] { parameterName, new Float(x) });
    }

    public void setDouble(String parameterName, double x) throws SQLException {
        record(this, "setDouble", new Object[] { parameterName, new Double(x) });
    }

    public void setBigDecimal(String parameterName, BigDecimal x) throws SQLException {
        record(this, "setBigDecimal", new Object[] { parameterName, x });
    }

    public void setString(String parameterName, String x) throws SQLException {
        record(this, "setString", new Object[] { parameterName, x });
    }

    public void setBytes(String parameterName, byte[] x) throws SQLException {
        record(this, "setBytes", new Object[] { parameterName, x });
    }

    public void setDate(String parameterName, Date x) throws SQLException {
        record(this, "setDate", new Object[] { parameterName, x });
    }

    public void setTime(String parameterName, Time x) throws SQLException {
        record(this, "setTime", new Object[] { parameterName, x });
    }

    public void setTimestamp(String parameterName, Timestamp x) throws SQLException {
        record(this, "setTimestamp", new Object[] { parameterName, x });
    }

    public void setAsciiStream(String parameterName, InputStream x, int length) throws SQLException {
        record(this, "setAsciiStream", new Object[] { parameterName, x, new Integer(length) });
    }

    public void setBinaryStream(String parameterName, InputStream x, int length) throws SQLException {
        record(this, "setBinaryStream", new Object[] { parameterName, x, new Integer(length) });
    }

    public void setObject(String parameterName, Object x, int targetSqlType, int scale) throws SQLException {
        record(this, "setObject", new Object[] { parameterName, x, new Integer(targetSqlType), new Integer(scale) });
    }

    public void setObject(String parameterName, Object x, int targetSqlType) throws SQLException {
        record(this, "setObject", new Object[] { parameterName, x, new Integer(targetSqlType) });
    }

    public void setObject(String parameterName, Object x) throws SQLException {
        record(this, "setObject", new Object[] { parameterName, x });
    }

    public void setCharacterStream(String parameterName, Reader reader, int length) throws SQLException {
        record(this, "setCharacterStream", new Object[] { parameterName, reader, new Integer(length) });
    }

    public void setDate(String parameterName, Date x, Calendar cal) throws SQLException {
        record(this, "setDate", new Object[] { parameterName, x, cal });
    }

    public void setTime(String parameterName, Time x, Calendar cal) throws SQLException {
        record(this, "setTime", new Object[] { parameterName, x, cal });
    }

    public void setTimestamp(String parameterName, Timestamp x, Calendar cal) throws SQLException {
        record(this, "setTimestamp", new Object[] { parameterName, x, cal });
    }

    public void setNull(String parameterName, int sqlType, String typeName) throws SQLException {
        record(this, "setNull", new Object[] { parameterName, new Integer(sqlType), typeName });
   }

    public String getString(String parameterName) throws SQLException {
        record(this, "getString", new Object[] { parameterName });
        return null;
    }

    public boolean getBoolean(String parameterName) throws SQLException {
        record(this, "getBoolean", new Object[] { parameterName });
        return false;
    }

    public byte getByte(String parameterName) throws SQLException {
        record(this, "getByte", new Object[] { parameterName });
        return 0;
    }

    public short getShort(String parameterName) throws SQLException {
        record(this, "getShort", new Object[] { parameterName });
        return 0;
    }

    public int getInt(String parameterName) throws SQLException {
        record(this, "getInt", new Object[] { parameterName });
        return 0;
    }

    public long getLong(String parameterName) throws SQLException {
        record(this, "getLong", new Object[] { parameterName });
        return 0;
    }

    public float getFloat(String parameterName) throws SQLException {
        record(this, "getLong", new Object[] { parameterName });
        return 0;
    }

    public double getDouble(String parameterName) throws SQLException {
        record(this, "getDouble", new Object[] { parameterName });
        return 0;
    }

    public byte[] getBytes(String parameterName) throws SQLException {
        record(this, "getBytes", new Object[] { parameterName });
        return null;
    }

    public Date getDate(String parameterName) throws SQLException {
        record(this, "getDate", new Object[] { parameterName });
        return null;
    }

    public Time getTime(String parameterName) throws SQLException {
        record(this, "getTime", new Object[] { parameterName });
        return null;
    }

    public Timestamp getTimestamp(String parameterName) throws SQLException {
        record(this, "getTimestamp", new Object[] { parameterName });
        return null;
    }

    public Object getObject(String parameterName) throws SQLException {
        record(this, "getObject", new Object[] { parameterName });
        return null;
    }

    public BigDecimal getBigDecimal(String parameterName) throws SQLException {
        record(this, "getBigDecimal", new Object[] { parameterName });
        return null;
    }

    public Object getObject(String parameterName, Map arg1) throws SQLException {
        record(this, "getObject", new Object[] { parameterName });
        return null;
    }

    public Ref getRef(String parameterName) throws SQLException {
        record(this, "getRef", new Object[] { parameterName });
        return null;
    }

    public Blob getBlob(String parameterName) throws SQLException {
        record(this, "getBlob", new Object[] { parameterName });
        return null;
    }

    public Clob getClob(String parameterName) throws SQLException {
        record(this, "getClob", new Object[] { parameterName });
        return null;
    }

    public Array getArray(String parameterName) throws SQLException {
        record(this, "getArray", new Object[] { parameterName });
        return null;
    }

    public Date getDate(String parameterName, Calendar cal) throws SQLException {
        record(this, "getDate", new Object[] { parameterName, cal });
        return null;
    }

    public Time getTime(String parameterName, Calendar cal) throws SQLException {
        record(this, "getTime", new Object[] { parameterName, cal });
        return null;
    }

    public Timestamp getTimestamp(String parameterName, Calendar cal) throws SQLException {
        record(this, "getTimestamp", new Object[] { parameterName, cal });
        return null;
    }

    public URL getURL(String parameterName) throws SQLException {
        record(this, "getURL", new Object[] { parameterName });
        return null;
    }

    public ResultSet executeQuery() throws SQLException {
        record(this, "executeQuery");
        return results;
    }

    public int executeUpdate() throws SQLException {
        record(this, "executeUpdate");
        return 0;
    }

    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        record(this, "setNull", new Object[] { new Integer(parameterIndex), new Integer(sqlType) });
    }

    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
        record(this, "setBoolean", new Object[] { new Integer(parameterIndex), new Boolean(x) });
    }

    public void setByte(int parameterIndex, byte x) throws SQLException {
        record(this, "setByte", new Object[] { new Integer(parameterIndex), new Byte(x) });
    }

    public void setShort(int parameterIndex, short x) throws SQLException {
        record(this, "setShort", new Object[] { new Integer(parameterIndex), new Short(x) });
    }

    public void setInt(int parameterIndex, int x) throws SQLException {
        record(this, "setInt", new Object[] { new Integer(parameterIndex), new Integer(x) });
    }

    public void setLong(int parameterIndex, long x) throws SQLException {
        record(this, "setLong", new Object[] { new Integer(parameterIndex), new Long(x) });
    }

    public void setFloat(int parameterIndex, float x) throws SQLException {
        record(this, "setFloat", new Object[] { new Integer(parameterIndex), new Float(x) });
    }

    public void setDouble(int parameterIndex, double x) throws SQLException {
        record(this, "setDouble", new Object[] { new Integer(parameterIndex), new Double(x) });
    }

    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
        record(this, "setBigDecimal", new Object[] { new Integer(parameterIndex), x });
    }

    public void setString(int parameterIndex, String x) throws SQLException {
        record(this, "setString", new Object[] { new Integer(parameterIndex), x });
    }

    public void setBytes(int parameterIndex, byte[] x) throws SQLException {
        record(this, "setBytes", new Object[] { new Integer(parameterIndex), x });
    }

    public void setDate(int parameterIndex, Date x) throws SQLException {
        record(this, "setDate", new Object[] { new Integer(parameterIndex), x });
    }

    public void setTime(int parameterIndex, Time x) throws SQLException {
        record(this, "setTime", new Object[] { new Integer(parameterIndex), x });
    }

    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
        record(this, "setTimestamp", new Object[] { new Integer(parameterIndex), x });
    }

    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
        record(this, "setAsciiStream", new Object[] { new Integer(parameterIndex), x, new Integer(length) });
    }

    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
        record(this, "setUnicodeStream", new Object[] { new Integer(parameterIndex), x, new Integer(length) });
    }

    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
        record(this, "setBinaryStream", new Object[] { new Integer(parameterIndex), x, new Integer(length) });
    }

    public void clearParameters() throws SQLException {
        record(this, "clearParameters");
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType, int scale) throws SQLException {
        record(this, "setObject", new Object[] { new Integer(parameterIndex), x, new Integer(targetSqlType), new Integer(scale) });
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
        record(this, "setObject", new Object[] { new Integer(parameterIndex), x, new Integer(targetSqlType) });
    }

    public void setObject(int parameterIndex, Object x) throws SQLException {
        record(this, "setObject", new Object[] { new Integer(parameterIndex), x });
    }

    public boolean execute() throws SQLException {
        record(this, "execute");
        return false;
    }

    public void addBatch() throws SQLException {
        record(this, "addBatch");
    }

    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
        record(this, "setCharacterStream", new Object[] { new Integer(parameterIndex), reader, new Integer(length) });
    }

    public void setRef(int i, Ref x) throws SQLException {
        record(this, "setRef", new Object[] { new Integer(i), x });
    }

    public void setBlob(int i, Blob x) throws SQLException {
        record(this, "setBlob", new Object[] { new Integer(i), x });
    }

    public void setClob(int i, Clob x) throws SQLException {
        record(this, "setClob", new Object[] { new Integer(i), x });
    }

    public void setArray(int i, Array x) throws SQLException {
        record(this, "setArray", new Object[] { new Integer(i), x });
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        record(this, "setMaxFieldSize");
        return null;
    }

    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
        record(this, "setDate", new Object[] { new Integer(parameterIndex), x, cal });
    }

    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
        record(this, "setTime", new Object[] { new Integer(parameterIndex), x, cal });
    }

    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
        record(this, "setTimestamp", new Object[] { new Integer(parameterIndex), x, cal });
    }

    public void setNull(int paramIndex, int sqlType, String typeName) throws SQLException {
        record(this, "setNull", new Object[] { new Integer(paramIndex), new Integer(sqlType), typeName });
    }

    public void setURL(int parameterIndex, URL x) throws SQLException {
        record(this, "setURL", new Object[] { new Integer(parameterIndex), x });
    }

    public ParameterMetaData getParameterMetaData() throws SQLException {
        record(this, "getParameterMetaData");
        return null;
    }
}
