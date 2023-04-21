package org.stringtree.util.iterator;

import java.io.IOException;

/**
 * An Iterator to iterate through the "lines" of a stream or reader.
 * 
 * @author Frank Carver
 */
public abstract class AbstractLineIterator extends AbstractIterator implements StringIterator {
    
    protected String line = null;
    protected boolean autoclose = true;
    protected boolean updated = false;

    public AbstractLineIterator(boolean autoclose) {
        this.autoclose = autoclose;
    }

    public boolean hasNext() {
        update();
        return line != null;
    }

    public Object next() {
        update();
        Object ret = line;
        updated = false;

        return ret;
    }
    
    public String nextString() {
        return (String)next();
    }

    protected abstract String readLine() throws IOException;

    protected abstract void close();

    protected void update() {
        if (updated)
            return;

        try {
            line = readLine();
            if (line == null && autoclose) {
                close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            line = null;
        }

        updated = true;
    }
}
