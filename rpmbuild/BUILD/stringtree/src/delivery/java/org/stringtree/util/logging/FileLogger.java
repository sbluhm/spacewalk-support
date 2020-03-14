package org.stringtree.util.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    
    protected File dest;

    public FileLogger(String filename) {
        dest = new File(filename);
        dest.mkdirs();
    }

    public void logPart(String text) {
        try {
            FileWriter writer = new FileWriter(dest, true);
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public void log(String text) {
        logPart(text + "\n");
    }
}
