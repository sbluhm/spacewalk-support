package org.stringtree.template;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.stringtree.util.StringUtils;

public class ByteArrayStringCollector implements StringCollector {

    private ByteArrayOutputStream buf;
    private PrintStream ps;

    public ByteArrayStringCollector() {
        buf = new ByteArrayOutputStream();
        ps = new PrintStream(buf);
    }

    public void write(char cc) {
        ps.print(cc);
    }

    public void write(String value) {
        ps.print(value);
    }

    public void write(byte[] bytes) {
        try {
            ps.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(Object value) {
        write(StringUtils.nullToEmpty(value));
    }

    public void flush() {
        ps.flush();
    }

    public int length() {
        ps.flush();
        return buf.size();
    }

    public PrintStream printStream() {
        return ps;
    }

    public byte[] toByteArray() {
        ps.flush();
        return buf.toByteArray();
    }

    public String toString() {
        return buf.toString();
    }
}
