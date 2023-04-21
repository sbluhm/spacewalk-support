package org.stringtree.db;

public abstract class MultipleLiteralListener extends CollectingResultRowListener implements LiteralListener {

    protected String sql;
    
    public MultipleLiteralListener(String sql) {
        this.sql = sql;
    }

    public String getSQL() {
        return sql;
    }
}
