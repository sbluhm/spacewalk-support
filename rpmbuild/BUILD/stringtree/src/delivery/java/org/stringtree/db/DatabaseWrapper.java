package org.stringtree.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.stringtree.util.PropertyResourceUtils;
import org.stringtree.util.ResourceUtils;

public class DatabaseWrapper {
    protected static String scriptfile = "dbscripts.properties";

    public static final ResultRowListener singleValueListener = new SingleValueResultListener();

    private static final StatementPopulator dummyPopulator = new StatementPopulator() {
        public void populate(PreparedStatement ps) {
            // do nothing, the statement is assumed to be already populated
        }
    };
    
    private DataSource ds = null;
    private Class resourceRoot = null;
    private Properties scripts;

    private void init(DataSource datasource, Class resourceRoot,
            Properties scripts) {
        this.ds = datasource;
        this.resourceRoot = resourceRoot;
        this.scripts = scripts;
    }

    private void init(DataSource datasource, Class resourceRoot,
            String scriptfile) {
        init(datasource, resourceRoot, PropertyResourceUtils
                .readPropertyResource(resourceRoot, scriptfile));
    }

    private void init(String jndiName, Class resourceRoot, String scriptfile)
            throws NamingException {
        InitialContext ctx;
        ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup(jndiName);
        init(ds, resourceRoot, scriptfile);
    }

    public DatabaseWrapper(DataSource datasource, Class resourceRoot,
            String scriptfile) {
        init(datasource, resourceRoot, scriptfile);
    }

    public DatabaseWrapper(DataSource datasource, Class resourceRoot,
            Properties scripts) {
        init(datasource, resourceRoot, scripts);
    }

    public DatabaseWrapper(DataSource datasource, Class resourceRoot) {
        init(datasource, resourceRoot, (Properties) null);
    }

    public DatabaseWrapper(DataSource datasource) {
        init(datasource, this.getClass(), (Properties) null);
    }

    public DatabaseWrapper(String jndiName, Class resourceRoot, String scripts)
            throws NamingException {
        init(jndiName, resourceRoot, scripts);
    }

    public DatabaseWrapper(Class resourceRoot, String jndiName)
            throws NamingException {
        this(jndiName, resourceRoot, scriptfile);
    }

    public Object query(String script, StatementPopulator populator,
            ResultRowListener listener) throws SQLException {
        return literalQuery(getScript(script), populator, listener);
    }

    public Object literalQuery(String sql, RowListener listener) throws SQLException {
        return literalQuery(sql, dummyPopulator, listener);
    }

    public Object literalQuery(LiteralListener listener) throws SQLException {
        return literalQuery(listener.getSQL(), dummyPopulator, listener);
    }

    public Object literalQuery(LiteralPopulatorListener literal) throws SQLException {
        return literalQuery(literal.getSQL(), literal, literal);
    }

    public Object literalQuery(String sql, StatementPopulator populator,
            RowListener listener) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet results = null;
        Object ret = null;
        try {
            connection = ds.getConnection();
            ps = connection.prepareStatement(sql);
            populator.populate(ps);
            results = ps.executeQuery();
            listener.start();
            for (int rowNumber = 0; results.next() && ret == null; ++rowNumber) {
                ret = listener.row(results, rowNumber);
            }
            if (ret == null)
                ret = listener.finish();
        } finally {
            if (results != null) {
                results.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return ret;
    }

    public Object query(String script, ResultRowListener listener) throws SQLException {
        return query(script, dummyPopulator, listener);
    }
    
    public Object singleValueQuery(String script) throws SQLException {
        return query(script, dummyPopulator, singleValueListener);
    }

    public Object literalUpdate(String sql, StatementPopulator populator)
            throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        Object ret = null;

        try {
            connection = ds.getConnection();
            ps = connection.prepareStatement(sql);
            populator.populate(ps);
            ps.execute();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return ret;
    }
    
    public Object literalUpdate(LiteralPopulator populator) throws SQLException {
        return literalUpdate(populator.getSQL(), populator);
    }

    public Object literalUpdate(String sql)
            throws SQLException {
        return literalUpdate(sql, dummyPopulator);
    }

    public Object update(String script, StatementPopulator populator)
            throws SQLException {
        return literalUpdate(getScript(script), populator);
    }

    public Object update(String script) throws SQLException {
        return update(script, dummyPopulator);
    }

    protected String getScript(String script) {
        String ret = null;

        if (scripts != null && scripts.containsKey(script)) {
            ret = scripts.getProperty(script);
        }

        if (ret == null && resourceRoot != null) {
            try {
                String filename = script + ".sql";
                ret = ResourceUtils.readRawResource(resourceRoot, filename);

                if (scripts != null) {
                    scripts.put(script, ret);
                }
            } catch (IOException e) {
                // do nothing, it's OK, we still have other options.
            }
        }

        // no script found, treat as literal SQL
        if (ret == null) {
            ret = script;
        }

        return ret;
    }

    public void script(String filename) throws IOException, SQLException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        Connection connection = ds.getConnection();
        Statement st;
        try {
            for (String str = in.readLine(); str != null; str = in.readLine()) {
                st = connection.createStatement();
                try {
                    st.execute(str);
                } finally {
                    st.close();
                }
            }
        } finally {
            connection.close();
        }
    }
}
