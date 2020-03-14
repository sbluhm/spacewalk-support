package org.stringtree.tract;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.stringtree.Tract;
import org.stringtree.finder.StringFinder;
import org.stringtree.util.StringUtils;
import org.stringtree.util.URLReadingUtils;

public class StreamTractReader extends ReaderTractReader {
    
    public static void load(Tract tract, InputStream in, StringFinder context,
            String charset) throws IOException {
        load(tract, new InputStreamReader(in, charset), context);
    }

    public static void load(Tract tract, InputStream in, StringFinder context)
            throws IOException {
        load(tract, in, context, "UTF-8");
    }

    public static void load(Tract tract, String from, StringFinder context)
            throws IOException {
        if (StringUtils.isBlank(from))
            return;

        URL url = URLReadingUtils.findURL(from, "file");
        InputStream in = null;

        in = url.openStream();
        load(tract, in, context);
    }

    public static void load(Tract tract, String from) throws IOException {
        load(tract, from, null);
    }
}
