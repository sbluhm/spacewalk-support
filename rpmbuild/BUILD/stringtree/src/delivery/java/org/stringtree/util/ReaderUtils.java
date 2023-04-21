package org.stringtree.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderUtils {
    
    public static BufferedReader makeBuffered(Reader in) {
        return (in instanceof BufferedReader) ? (BufferedReader) in
                : new BufferedReader(in);
    }

    public static String readReader(Reader in) throws IOException {
        StringBuffer ret = new StringBuffer();
        in = makeBuffered(in);

        for (int c = readChar(in); c != -1; c = readChar(in)) {
            ret.append((char) c);
        }

        return ret.toString();
    }

    private static int readChar(Reader in) throws IOException {
        int i = in.read();
        return i;
    }

    public static String readInputStream(InputStream in, String charset)
            throws IOException {
        return readReader(new InputStreamReader(in, charset));
    }

    public static String readInputStream(InputStream in) throws IOException {
        return readReader(new InputStreamReader(in));
    }

    public static void close(Reader reader) {
        try {
            if (reader != null)
                reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
