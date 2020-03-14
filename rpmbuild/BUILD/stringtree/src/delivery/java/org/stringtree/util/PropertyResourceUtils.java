package org.stringtree.util;

import java.util.Properties;

public class PropertyResourceUtils {
    
    public static Properties readPropertyResource(ClassLoader loader,
            String filename) {
        return PropertyStreamUtils.readProperties(ResourceUtils
                .getResourceStream(loader, filename));
    }

    public static Properties readPropertyResource(Object self, String filename) {
        return readPropertyResource(self.getClass().getClassLoader(), filename);
    }

    public static Properties readPropertyResource(String filename) {
        return readPropertyResource(ResourceUtils.class.getClassLoader(),
                filename);
    }
}
