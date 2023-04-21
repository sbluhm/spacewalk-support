package org.stringtree.util.logging;

import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class CategoryLogger extends DelegatedLogger {
    
    private class Category {
        Category parent;

        Boolean logging;

        Category(Category parent) {
            this.parent = parent;
            this.logging = null;
        }
    }

    public static final String ALL = "ALL";
    public static final String nl = System.getProperty("line.separator");

    private static String spaces = "                                                            ";
    private Map categories;
    private Category root;

    public CategoryLogger(Logger logger) {
        super(logger);

        categories = new HashMap();
        root = new Category(null);

        root.logging = Boolean.TRUE;
        categories.put("ALL", root);
    }

    public CategoryLogger(Writer out) {
        this(new WriterLogger(out));
    }

    public CategoryLogger(OutputStream out) {
        this(new StreamLogger(out));
    }

    public CategoryLogger() {
        this(System.out);
    }

    private Category add(String name, Category parent) {
        Category ret = new Category(parent);
        categories.put(name, ret);
        return ret;
    }

    public void addCategory(String name, String parentName) {
        Category parent = (Category) categories.get(parentName);
        if (parent == null) {
            parent = root;
        }

        add(name, parent);
    }

    public void addCategory(String name) {
        add(name, root);
    }

    public boolean isLoggable(String name) {
        Category category = (Category) categories.get(name);
        if (category == null) {
            category = add(name, root);
        }

        while (category.logging == null) {
            category = category.parent;
        }

        return category.logging.booleanValue();
    }

    public void allowLogging(String name) {
        Category category = (Category) categories.get(name);
        if (category == null) {
            category = add(name, root);
        }

        category.logging = Boolean.TRUE;
    }

    public void preventLogging(String name) {
        Category category = (Category) categories.get(name);
        if (category == null) {
            category = add(name, root);
        }

        category.logging = Boolean.FALSE;
    }

    public static String indent(int level) {
        return spaces.substring(spaces.length() - level);
    }

    public void log(String category, String message, int level) {
        if (isLoggable(category)) {
            logPart("(");
            logPart(category);
            logPart(") ");
            if (level > 0)
                logPart(indent(level));
            log(message);
        }
    }

    public void log(String category, String message) {
        log(category, message, 0);
    }
}