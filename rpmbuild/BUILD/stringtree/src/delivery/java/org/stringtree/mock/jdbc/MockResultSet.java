package org.stringtree.mock.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import org.stringtree.mock.RecordingMock;

public class MockResultSet extends RecordingMock implements ResultSet {
    
    public ResultSetMetaData metadata;
    
    public MockResultSet(ResultSetMetaData metadata) {
        setMetaData(metadata);
    }
    
    public MockResultSet() {
        setMetaData(new MockResultSetMetaData());
    }
    
    public void setMetaData(ResultSetMetaData metadata) {
        this.metadata = metadata;
    }
    
    public boolean next() throws SQLException {
        record(this, "next");
        return false;
    }

    public void close() throws SQLException {
        record(this, "close");
    }

    public boolean wasNull() throws SQLException {
        record(this, "wasNull");
        return false;
    }

    public String getString(int columnIndex) throws SQLException {
        record(this, "getString", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public boolean getBoolean(int columnIndex) throws SQLException {
        record(this, "getBoolean", new Object[] { new Integer(columnIndex) });
        return false;
    }

    public byte getByte(int columnIndex) throws SQLException {
        record(this, "getByte", new Object[] { new Integer(columnIndex) });
        return 0;
    }

    public short getShort(int columnIndex) throws SQLException {
        record(this, "getShort", new Object[] { new Integer(columnIndex) });
        return 0;
    }

    public int getInt(int columnIndex) throws SQLException {
        record(this, "getInt", new Object[] { new Integer(columnIndex) });
        return 0;
    }

    public long getLong(int columnIndex) throws SQLException {
        record(this, "getLong", new Object[] { new Integer(columnIndex) });
        return 0;
    }

    public float getFloat(int columnIndex) throws SQLException {
        record(this, "getFloat", new Object[] { new Integer(columnIndex) });
        return 0;
    }

    public double getDouble(int columnIndex) throws SQLException {
        record(this, "getDouble", new Object[] { new Integer(columnIndex) });
        return 0;
    }

    public BigDecimal getBigDecimal(int columnIndex, int scale)
            throws SQLException {
        record(this, "getBigDecimal", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public byte[] getBytes(int columnIndex) throws SQLException {
        record(this, "getBytes", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public Date getDate(int columnIndex) throws SQLException {
        record(this, "getDate", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public Time getTime(int columnIndex) throws SQLException {
        record(this, "getTime", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        record(this, "getTimestamp", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        record(this, "getAsciiStream", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public InputStream getUnicodeStream(int columnIndex) throws SQLException {
        record(this, "getUnicodeStream", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public InputStream getBinaryStream(int columnIndex) throws SQLException {
        record(this, "getBinaryStream", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public String getString(String columnName) throws SQLException {
        record(this, "getString", new Object[] { columnName });
        return null;
    }

    public boolean getBoolean(String columnName) throws SQLException {
        record(this, "getBoolean", new Object[] { columnName });
        return false;
    }

    public byte getByte(String columnName) throws SQLException {
        record(this, "getByte", new Object[] { columnName });
        return 0;
    }

    public short getShort(String columnName) throws SQLException {
        record(this, "getShort", new Object[] { columnName });
        return 0;
    }

    public int getInt(String columnName) throws SQLException {
        record(this, "getInt", new Object[] { columnName });
        return 0;
    }

    public long getLong(String columnName) throws SQLException {
        record(this, "getLong", new Object[] { columnName });
        return 0;
    }

    public float getFloat(String columnName) throws SQLException {
        record(this, "getFloat", new Object[] { columnName });
        return 0;
    }

    public double getDouble(String columnName) throws SQLException {
        record(this, "getDouble", new Object[] { columnName });
        return 0;
    }

    public BigDecimal getBigDecimal(String columnName, int scale)
            throws SQLException {
        record(this, "getBigDecimal", new Object[] { columnName });
        return null;
    }

    public byte[] getBytes(String columnName) throws SQLException {
        record(this, "getBytes", new Object[] { columnName });
        return null;
    }

    public Date getDate(String columnName) throws SQLException {
        record(this, "getDate", new Object[] { columnName });
        return null;
    }

    public Time getTime(String columnName) throws SQLException {
        record(this, "getTime", new Object[] { columnName });
        return null;
    }

    public Timestamp getTimestamp(String columnName) throws SQLException {
        record(this, "getTmestamp", new Object[] { columnName });
        return null;
    }

    public InputStream getAsciiStream(String columnName) throws SQLException {
        record(this, "getAsciiSream", new Object[] { columnName });
        return null;
    }

    public InputStream getUnicodeStream(String columnName) throws SQLException {
        record(this, "getUnicodeStream", new Object[] { columnName });
        return null;
    }

    public InputStream getBinaryStream(String columnName) throws SQLException {
        record(this, "getBinaryStream", new Object[] { columnName });
        return null;
    }

    public SQLWarning getWarnings() throws SQLException {
        record(this, "getWarnings");
        return null;
    }

    public void clearWarnings() throws SQLException {
        record(this, "clearWarnings");
    }

    public String getCursorName() throws SQLException {
        record(this, "getCursorName");
        return null;
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        record(this, "getMetaData");
        return metadata;
    }

    public Object getObject(int columnIndex) throws SQLException {
        record(this, "getObject", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public Object getObject(String columnName) throws SQLException {
        record(this, "getObject", new Object[] { columnName });
        return null;
    }

    public int findColumn(String columnName) throws SQLException {
        record(this, "findColumn", new Object[] { columnName });
        return 0;
    }

    public Reader getCharacterStream(int columnIndex) throws SQLException {
        record(this, "getCharacterStream", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public Reader getCharacterStream(String columnName) throws SQLException {
        record(this, "getCharacterStream", new Object[] { columnName });
        return null;
    }

    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        record(this, "getBigDecimal", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public BigDecimal getBigDecimal(String columnName) throws SQLException {
        record(this, "getBigDecimal", new Object[] { columnName });
        return null;
    }

    public boolean isBeforeFirst() throws SQLException {
        record(this, "isBeforeFirst");
        return false;
    }

    public boolean isAfterLast() throws SQLException {
        record(this, "isAfterLast");
        return false;
    }

    public boolean isFirst() throws SQLException {
        record(this, "isFirst");
        return false;
    }

    public boolean isLast() throws SQLException {
        record(this, "isLast");
        return false;
    }

    public void beforeFirst() throws SQLException {
        record(this, "beforeFirst");
    }

    public void afterLast() throws SQLException {
        record(this, "afterLast");
    }

    public boolean first() throws SQLException {
        record(this, "first");
        return false;
    }

    public boolean last() throws SQLException {
        record(this, "last");
        return false;
    }

    public int getRow() throws SQLException {
        record(this, "getRow");
        return 0;
    }

    public boolean absolute(int row) throws SQLException {
        record(this, "absolute", new Object[] { new Integer(row) });
        return false;
    }

    public boolean relative(int rows) throws SQLException {
        record(this, "relative", new Object[] { new Integer(rows) });
        return false;
    }

    public boolean previous() throws SQLException {
        record(this, "previous");
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

    public int getType() throws SQLException {
        record(this, "getType");
        return 0;
    }

    public int getConcurrency() throws SQLException {
        record(this, "getConcurrency");
        return 0;
    }

    public boolean rowUpdated() throws SQLException {
        record(this, "rowUpdated");
        return false;
    }

    public boolean rowInserted() throws SQLException {
        record(this, "rowInserted");
        return false;
    }

    public boolean rowDeleted() throws SQLException {
        record(this, "rowDeleted");
        return false;
    }

    public void updateNull(int columnIndex) throws SQLException {
        record(this, "updateNull", new Object[] { new Integer(columnIndex) });
    }

    public void updateBoolean(int columnIndex, boolean x) throws SQLException {
        record(this, "updateBoolean", new Object[] { new Integer(columnIndex), new Boolean(x) });
    }

    public void updateByte(int columnIndex, byte x) throws SQLException {
        record(this, "updateByte", new Object[] { new Integer(columnIndex), new Byte(x) });
    }

    public void updateShort(int columnIndex, short x) throws SQLException {
        record(this, "updateShort", new Object[] { new Integer(columnIndex), new Short(x) });
    }

    public void updateInt(int columnIndex, int x) throws SQLException {
        record(this, "updateInt", new Object[] { new Integer(columnIndex), new Integer(x) });
    }

    public void updateLong(int columnIndex, long x) throws SQLException {
        record(this, "updateLong", new Object[] { new Integer(columnIndex), new Long(x) });
    }

    public void updateFloat(int columnIndex, float x) throws SQLException {
        record(this, "updateFloat", new Object[] { new Integer(columnIndex), new Float(x) });
    }

    public void updateDouble(int columnIndex, double x) throws SQLException {
        record(this, "updateDouble", new Object[] { new Integer(columnIndex), new Double(x) });
    }

    public void updateBigDecimal(int columnIndex, BigDecimal x)
            throws SQLException {
        record(this, "updateBigDecimal", new Object[] { new Integer(columnIndex), x });
    }

    public void updateString(int columnIndex, String x) throws SQLException {
        record(this, "updateString", new Object[] { new Integer(columnIndex), x });
    }

    public void updateBytes(int columnIndex, byte[] x) throws SQLException {
        record(this, "updateBytes", new Object[] { new Integer(columnIndex), x });
    }

    public void updateDate(int columnIndex, Date x) throws SQLException {
        record(this, "updateDate", new Object[] { new Integer(columnIndex), x });
    }

    public void updateTime(int columnIndex, Time x) throws SQLException {
        record(this, "updateTime", new Object[] { new Integer(columnIndex), x });
    }

    public void updateTimestamp(int columnIndex, Timestamp x)
            throws SQLException {
        record(this, "updateTimestamp", new Object[] { new Integer(columnIndex), x });
    }

    public void updateAsciiStream(int columnIndex, InputStream x, int length)
            throws SQLException {
        record(this, "updateAsciiStream", new Object[] { new Integer(columnIndex), x });
    }

    public void updateBinaryStream(int columnIndex, InputStream x, int length)
            throws SQLException {
        record(this, "updateBinaryStream", new Object[] { new Integer(columnIndex), x, new Integer(length) });
    }

    public void updateCharacterStream(int columnIndex, Reader x, int length)
            throws SQLException {
        record(this, "updateCharacterStream", new Object[] { new Integer(columnIndex), x, new Integer(length) });
    }

    public void updateObject(int columnIndex, Object x, int scale)
            throws SQLException {
        record(this, "updateObject", new Object[] { new Integer(columnIndex), x, new Integer(scale) });
    }

    public void updateObject(int columnIndex, Object x) throws SQLException {
        record(this, "updateObject", new Object[] { new Integer(columnIndex), x });
    }

    public void updateNull(String columnName) throws SQLException {
        record(this, "updateNull", new Object[] { columnName });
    }

    public void updateBoolean(String columnName, boolean x) throws SQLException {
        record(this, "updateBoolean", new Object[] { columnName, new Boolean(x) });
    }

    public void updateByte(String columnName, byte x) throws SQLException {
        record(this, "updateByte", new Object[] { columnName, new Byte(x) });
    }

    public void updateShort(String columnName, short x) throws SQLException {
        record(this, "updateShort", new Object[] { columnName, new Short(x) });
    }

    public void updateInt(String columnName, int x) throws SQLException {
        record(this, "updateInt", new Object[] { columnName, new Integer(x) });
    }

    public void updateLong(String columnName, long x) throws SQLException {
        record(this, "updateLong", new Object[] { columnName, new Long(x) });
    }

    public void updateFloat(String columnName, float x) throws SQLException {
        record(this, "updateFloat", new Object[] { columnName, new Float(x) });
    }

    public void updateDouble(String columnName, double x) throws SQLException {
        record(this, "updateDouble", new Object[] { columnName, new Double(x) });
    }

    public void updateBigDecimal(String columnName, BigDecimal x)
            throws SQLException {
        record(this, "updateBigDecimal", new Object[] { columnName, x });
    }

    public void updateString(String columnName, String x) throws SQLException {
        record(this, "updateString", new Object[] { columnName, x });
    }

    public void updateBytes(String columnName, byte[] x) throws SQLException {
        record(this, "updateBytes", new Object[] { columnName, x });
    }

    public void updateDate(String columnName, Date x) throws SQLException {
        record(this, "updateDate", new Object[] { columnName, x });
    }

    public void updateTime(String columnName, Time x) throws SQLException {
        record(this, "updateTime", new Object[] { columnName, x });
    }

    public void updateTimestamp(String columnName, Timestamp x)
            throws SQLException {
        record(this, "updateTimestamp", new Object[] { columnName, x });
    }

    public void updateAsciiStream(String columnName, InputStream x, int length)
            throws SQLException {
        record(this, "updateAsciiStream", new Object[] { columnName, x, new Integer(length) });
    }

    public void updateBinaryStream(String columnName, InputStream x, int length)
            throws SQLException {
        record(this, "updateBinaryStream", new Object[] { columnName, x, new Integer(length) });
    }

    public void updateCharacterStream(String columnName, Reader reader,
            int length) throws SQLException {
        record(this, "updateCharacterStream", new Object[] { columnName, reader, new Integer(length) });
    }

    public void updateObject(String columnName, Object x, int scale)
            throws SQLException {
        record(this, "updateObject", new Object[] { columnName, x, new Integer(scale) });
    }

    public void updateObject(String columnName, Object x) throws SQLException {
        record(this, "updateObject", new Object[] { columnName, x });
    }

    public void insertRow() throws SQLException {
        record(this, "insertRow");
    }

    public void updateRow() throws SQLException {
        record(this, "updateRow");
    }

    public void deleteRow() throws SQLException {
        record(this, "deleteRow");
    }

    public void refreshRow() throws SQLException {
        record(this, "refreshRow");
    }

    public void cancelRowUpdates() throws SQLException {
        record(this, "cancelRowUpdates");
    }

    public void moveToInsertRow() throws SQLException {
        record(this, "moveToInsertRow");
    }

    public void moveToCurrentRow() throws SQLException {
        record(this, "moveToCurrentRow");
    }

    public Statement getStatement() throws SQLException {
        record(this, "getStatement");
        return null;
    }

    public Object getObject(int columnIndex, Map map) throws SQLException {
        record(this, "getObject", new Object[] { new Integer(columnIndex), map });
        return null;
    }

    public Ref getRef(int columnIndex) throws SQLException {
        record(this, "getRef", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public Blob getBlob(int columnIndex) throws SQLException {
        record(this, "getBlob", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public Clob getClob(int columnIndex) throws SQLException {
        record(this, "getClob", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public Array getArray(int columnIndex) throws SQLException {
        record(this, "getArray", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public Object getObject(String columnName, Map map) throws SQLException {
        record(this, "getObject", new Object[] { columnName, map });
        return null;
    }

    public Ref getRef(String columnName) throws SQLException {
        record(this, "getRef", new Object[] { columnName });
        return null;
    }

    public Blob getBlob(String columnName) throws SQLException {
        record(this, "getBlob", new Object[] { columnName });
        return null;
    }

    public Clob getClob(String columnName) throws SQLException {
        record(this, "getClob", new Object[] { columnName });
        return null;
    }

    public Array getArray(String columnName) throws SQLException {
        record(this, "getArray", new Object[] { columnName });
        return null;
    }

    public Date getDate(int columnIndex, Calendar cal) throws SQLException {
        record(this, "updateIndex", new Object[] { new Integer(columnIndex), cal });
        return null;
    }

    public Date getDate(String columnName, Calendar cal) throws SQLException {
        record(this, "getDate", new Object[] { columnName, cal });
        return null;
    }

    public Time getTime(int columnIndex, Calendar cal) throws SQLException {
        record(this, "getTime", new Object[] { new Integer(columnIndex), cal });
        return null;
    }

    public Time getTime(String columnName, Calendar cal) throws SQLException {
        record(this, "getTime", new Object[] { columnName, cal });
        return null;
    }

    public Timestamp getTimestamp(int columnIndex, Calendar cal)
            throws SQLException {
        record(this, "getTimestamp", new Object[] { new Integer(columnIndex), cal });
        return null;
    }

    public Timestamp getTimestamp(String columnName, Calendar cal)
            throws SQLException {
        record(this, "getTimestamp", new Object[] { columnName, cal });
        return null;
    }

    public URL getURL(int columnIndex) throws SQLException {
        record(this, "getURL", new Object[] { new Integer(columnIndex) });
        return null;
    }

    public URL getURL(String columnName) throws SQLException {
        record(this, "getURL", new Object[] { columnName });
        return null;
    }

    public void updateRef(int columnIndex, Ref x) throws SQLException {
        record(this, "updateRef", new Object[] { new Integer(columnIndex), x });
    }

    public void updateRef(String columnName, Ref x) throws SQLException {
        record(this, "updateRef", new Object[] { columnName, x });
    }

    public void updateBlob(int columnIndex, Blob x) throws SQLException {
        record(this, "updateBlob", new Object[] { new Integer(columnIndex), x });
    }

    public void updateBlob(String columnName, Blob x) throws SQLException {
        record(this, "updateBlob", new Object[] { columnName, x });
    }

    public void updateClob(int columnIndex, Clob x) throws SQLException {
        record(this, "updateClob", new Object[] { new Integer(columnIndex), x });
    }

    public void updateClob(String columnName, Clob x) throws SQLException {
        record(this, "updateClob", new Object[] { columnName, x });
    }

    public void updateArray(int columnIndex, Array x) throws SQLException {
        record(this, "updateArray", new Object[] { new Integer(columnIndex), x });
    }

    public void updateArray(String columnName, Array x) throws SQLException {
        record(this, "updateArray", new Object[] { columnName, x });
    }
}
