package org.stringtree.util.spec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.stringtree.fetcher.MapFetcher;
import org.stringtree.finder.FetcherStringFinder;
import org.stringtree.finder.StringFinder;

/** based on code from http://www.rgagnon.com/ - Thanks Real! */
public class EnvironmentLoader {
    
    public static void loadEnvironment(SpecProcessor processor,
            boolean logErrors) {
        try {
            Process p = null;
            Runtime r = Runtime.getRuntime();
            String OS = System.getProperty("os.name").toLowerCase();
            // System.out.println(OS);

            if (OS.indexOf("windows 9") > -1) {
                p = r.exec("command.com /c set");
            } else if ((OS.indexOf("nt") > -1)
                    || (OS.indexOf("windows 20") > -1)
                    || (OS.indexOf("windows xp") > -1)) {
                p = r.exec("cmd.exe /c set");
            } else {
                // our last hope, we assume Unix
                p = r.exec("env");
            }

            if (p != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(p
                        .getInputStream()));
                for (String line = br.readLine(); line != null; line = br
                        .readLine()) {
                    processor.process(line);
                }
            }
        } catch (IOException ioe) {
            if (logErrors) {
                ioe.printStackTrace();
            }
        }
    }

    public static void loadEnvironment(SpecProcessor processor) {
        loadEnvironment(processor, false);
    }

    public static void loadEnvironment(StringFinder context) {
        loadEnvironment(new SpecProcessor(context), false);
    }

    public static StringFinder loadEnvironment() {
        StringFinder rep = new FetcherStringFinder(new MapFetcher());
        loadEnvironment(rep);
        return rep;
    }
}
