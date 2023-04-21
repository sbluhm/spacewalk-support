package org.stringtree.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyStreamUtils {
    
    public static Properties readProperties(InputStream in) {
        Properties ret = new Properties();
        try {
            ret.load(in);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            if (in != null)
                in.close();
        } catch (IOException ioe) {
            ioe.printStackTrace(); // exception in close makes little sense
        }

        return ret;
    }
}
