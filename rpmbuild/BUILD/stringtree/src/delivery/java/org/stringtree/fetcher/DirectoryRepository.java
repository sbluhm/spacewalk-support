package org.stringtree.fetcher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.File;

import org.stringtree.Container;
import org.stringtree.Listable;
import org.stringtree.Repository;
import org.stringtree.fetcher.filter.BasicRepositoryFilenameFilter;
import org.stringtree.fetcher.filter.RepositoryFilenameFilter;

public abstract class DirectoryRepository implements Repository, Listable, Container {
    
    protected File dir;
    protected RepositoryFilenameFilter filter;
    protected boolean writable;

    public DirectoryRepository(File dir, RepositoryFilenameFilter filter,
            boolean writable) {
        this.dir = dir;
        this.filter = filter;

        if (!dir.exists()) {
            dir.mkdirs();
        }
        this.writable = writable;
    }

    public DirectoryRepository(File dir, boolean writable) {
        this(dir, new BasicRepositoryFilenameFilter(), writable);
    }

    public DirectoryRepository(String dir, boolean writable) {
        this(new File(dir), writable);
    }

    public static boolean contains(File dir, String name) {
        return new File(dir, name).exists();
    }

    public File fileToRead(String name) {
        if (name.startsWith("/")) name = name.substring(1);
        File ret = filter.fileToRead(dir, name);
        return ret;
    }

    public void remove(String name) {
        if (writable) {
            filter.fileToWrite(dir, name).delete();
        }
    }

    public void clear() {
        if (writable) {
            Iterator it = list();
            while (it.hasNext()) {
                File file = filter.fileToWrite(dir, (String) it.next());
                file.delete();
            }
        }
    }

    public File fileToWrite(String name) {
        return writable ? filter.fileToWrite(dir, name) : null;
    }

    public Iterator list() {
        File[] files = dir.listFiles(filter);
        List names = new ArrayList();
        for (int i = 0; i < files.length; ++i) {
            String localName = filter.localName(dir, files[i]);
            names.add(localName);
        }

        return names.iterator();
    }

    public void lock() {
        writable = false;
    }

    public String toString() {
        return getClass() + "(dir='" + dir + "' writable=" + writable
                + " filter='" + filter + "'";
    }

    public boolean contains(String name) {
        return contains(dir, name);
    }

    public abstract Object getObject(String name);

    public abstract void put(String key, Object value);
    
    public boolean isLocked() {
        return !writable;
    }
}