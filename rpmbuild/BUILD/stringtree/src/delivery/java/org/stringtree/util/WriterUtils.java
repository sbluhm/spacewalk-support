package org.stringtree.util;

import java.io.PrintWriter;
import java.io.Writer;

public class WriterUtils {
    
    public static PrintWriter ensurePrint(Writer out) {
        return isPrint(out) ? (PrintWriter) out : new PrintWriter(out);
    }

    private static boolean isPrint(Writer out) {
        return out instanceof PrintWriter;
    }
}
