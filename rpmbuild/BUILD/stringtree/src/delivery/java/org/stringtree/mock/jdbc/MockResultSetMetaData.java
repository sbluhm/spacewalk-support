package org.stringtree.mock.jdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.stringtree.mock.RecordingMock;

public class MockResultSetMetaData extends RecordingMock implements ResultSetMetaData {

    public int getColumnCount() throws SQLException {
        record(this, "getColumnCount");
        return 0;
    }

    public boolean isAutoIncrement(int column) throws SQLException {
        record(this, "isAutoIncrement", new Object[] { new Integer(column) });
        return false;
    }

    public boolean isCaseSensitive(int column) throws SQLException {
        record(this, "isCaseSensitive", new Object[] { new Integer(column) });
        return false;
    }

    public boolean isSearchable(int column) throws SQLException {
        record(this, "isSearchable", new Object[] { new Integer(column) });
        return false;
    }

    public boolean isCurrency(int column) throws SQLException {
        record(this, "isCurrency", new Object[] { new Integer(column) });
        return false;
    }

    public int isNullable(int column) throws SQLException {
        record(this, "isNullable", new Object[] { new Integer(column) });
        return 0;
    }

    public boolean isSigned(int column) throws SQLException {
        record(this, "isSigned", new Object[] { new Integer(column) });
        return false;
    }

    public int getColumnDisplaySize(int column) throws SQLException {
        record(this, "getColumnDisplaySize", new Object[] { new Integer(column) });
        return 0;
    }

    public String getColumnLabel(int column) throws SQLException {
        record(this, "getColumnLabel", new Object[] { new Integer(column) });
        return null;
    }

    public String getColumnName(int column) throws SQLException {
        record(this, "getColumnName", new Object[] { new Integer(column) });
        return null;
    }

    public String getSchemaName(int column) throws SQLException {
        record(this, "getSchemaName", new Object[] { new Integer(column) });
        return null;
    }

    public int getPrecision(int column) throws SQLException {
        record(this, "getPrecision", new Object[] { new Integer(column) });
        return 0;
    }

    public int getScale(int column) throws SQLException {
        record(this, "getScale", new Object[] { new Integer(column) });
        return 0;
    }

    public String getTableName(int column) throws SQLException {
        record(this, "getTableName", new Object[] { new Integer(column) });
        return null;
    }

    public String getCatalogName(int column) throws SQLException {
        record(this, "getCatalogName", new Object[] { new Integer(column) });
        return null;
    }

    public int getColumnType(int column) throws SQLException {
        record(this, "getColumnType", new Object[] { new Integer(column) });
        return 0;
    }

    public String getColumnTypeName(int column) throws SQLException {
        record(this, "getColumnTypeName", new Object[] { new Integer(column) });
        return null;
    }

    public boolean isReadOnly(int column) throws SQLException {
        record(this, "isReadOnly", new Object[] { new Integer(column) });
        return false;
    }

    public boolean isWritable(int column) throws SQLException {
        record(this, "isWritable", new Object[] { new Integer(column) });
        return false;
    }

    public boolean isDefinitelyWritable(int column) throws SQLException {
        record(this, "isDefinitelyWritable", new Object[] { new Integer(column) });
        return false;
    }

    public String getColumnClassName(int column) throws SQLException {
        record(this, "getColumnClassName", new Object[] { new Integer(column) });
        return null;
    }
}
