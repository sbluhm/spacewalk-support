package org.stringtree.util;

import java.io.File;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class FileUtils {
    
    public static File ensureDirectory(File dir) {
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    public static File ensureDirectory(String name) {
        return ensureDirectory(new File(name));
    }

    public static File ensureDirectory(File root, String name) {
        return ensureDirectory(new File(root, name));
    }

    /**
     * extract the local path information from a URL in a form suitable for
     * contructing a File
     * 
     * @return a string with the '/' replacd by local separators
     */
    public static String getLocalFilePath(String path) {
        String ret = path;

        if (File.separatorChar != '/' && path.indexOf("/") >= 0) {
            StringBuffer buf = new StringBuffer(path.length());
            CharacterIterator it = new StringCharacterIterator(path);
            for (char c = it.first(); c != CharacterIterator.DONE; c = it
                    .next()) {
                if (c == '/') {
                    c = File.separatorChar;
                }
                buf.append(c);
            }

            ret = buf.toString();
        }

        return ret;
    }
}
