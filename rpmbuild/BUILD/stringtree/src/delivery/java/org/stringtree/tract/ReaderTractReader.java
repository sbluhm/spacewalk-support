package org.stringtree.tract;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.stringtree.Tract;
import org.stringtree.fetcher.FallbackRepository;
import org.stringtree.finder.FetcherStringFinder;
import org.stringtree.finder.StringFinder;
import org.stringtree.util.ReaderUtils;
import org.stringtree.util.spec.SpecReader;

public class ReaderTractReader {
    
    public static void load(Tract tract, Reader in, StringFinder context)
            throws IOException {
        tract.clear();
        BufferedReader bin = new BufferedReader(in);

        SpecReader.load(new FetcherStringFinder(new FallbackRepository(tract,context)), false, bin);
        if (!tract.contains(Tract.CONTENT)) {
            loadContent(tract, bin);
        }
    }

    protected static void loadContent(Tract tract, Reader in)
            throws FileNotFoundException, UnsupportedEncodingException,
            IOException {
        String indirect = tract.get(Tract.CONTENT_LOCATION, null);
        if (indirect != null) {
            File root = new File(".");
            File file = new File(root, indirect);
            if (file.canRead()) {
                FileInputStream fin = new FileInputStream(file);
                Reader reader = new InputStreamReader(fin, tract
                        .getCharacterSet());
                loadText(tract, reader);
                fin.close();
            }
        } else {
            loadText(tract, in);
        }
    }

    public static void loadText(Tract tract, Reader in) throws IOException {
        tract.setContent(ReaderUtils.readReader(in));
    }
}
