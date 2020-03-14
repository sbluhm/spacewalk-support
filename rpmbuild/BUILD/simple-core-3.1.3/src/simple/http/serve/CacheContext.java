/*
 * CacheContext.java November 2005
 *
 * Copyright (C) 2005, Niall Gallagher <niallg@users.sf.net>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General 
 * Public License along with this library; if not, write to the 
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330, 
 * Boston, MA  02111-1307  USA
 */
  
package simple.http.serve;

import java.io.IOException;
import java.io.File;

/**
 * The <code>CacheContext</code> object is used to provide a caching
 * implementation of the context. This will ensure that frequent
 * requests for <code>Content</code> objects will hit a cache and
 * thus require less I/O to fulfill the request. The also provides a
 * means to share caching across multiple objects, which share the
 * context. The default maximum cache size is eight kilobytes.
 * 
 * @author Niall Gallagher
 *
 * @see simple.http.serve.CacheContentFactory
 */
public class CacheContext extends FactoryContext {

   /**
    * This is the default limit to the files sizes to cache.
    */         
   private static final int DEFAULT_SIZE = 8192;

   /**
    * Constructor for the <code>CacheContext</code> object. This is
    * used to create a context for the current working directory. 
    * This will use a cache that has a default maximum size of eight
    * kilobytes. Also, items remain cached for at most one minute.
    */ 
   public CacheContext() {
      this(new File("."));
   }

   /**
    * Constructor for the <code>CacheContext</code> object. This is
    * used to create a context instance for the specified directory. 
    * This will use a cache that has a default maximum size of eight
    * kilobytes. Also, items remain cached for at most one minute.
    *
    * @param base this is the directory specifying the context root
    */ 
   public CacheContext(File base) {
      this(base, DEFAULT_SIZE);
   }

   /**
    * Constructor for the <code>CacheContext</code> object. This is
    * used to create a context instance for the specified directory. 
    * This will use a cache that has a default maximum size of eight
    * kilobytes. Also, items remain cached for at most one minute.
    *
    * @param base this is the directory specifying the context root
    * @param size this is the maximum file size that will be cached
    */    
   public CacheContext(File base, int size) {
      this(base, new File[]{base}, size);
   }
 
   /**
    * Constructor for the <code>CacheContext</code> object. This is
    * used to create a context instance for the specified directory. 
    * This will use a cache that has a default maximum size of eight
    * kilobytes. Also, items remain cached for at most one minute.
    * This will make use of one directory to find configuration.
    *
    * @param base this is the directory specifying the context root
    * @param path this is the directory file used for configuration
    */ 
   public CacheContext(File base, File path) {
      this(base, new File[] {path});
   }
   
   /**
    * Constructor for the <code>CacheContext</code> object. This is
    * used to create a context instance for the specified directory. 
    * This will use a cache that has a default maximum size of eight
    * kilobytes. Also, items remain cached for at most one minute.
    * This will make use of the file list to find configuration.
    *
    * @param base this is the directory specifying the context root
    * @param list this is the range of files used for configuration
    */ 
   public CacheContext(File base, File[] list) {
      this(base, list, DEFAULT_SIZE);
   }

   /**
    * Constructor for the <code>CacheContext</code> object. This is
    * used to create a context instance for the specified directory. 
    * This will use a cache that has a default maximum size of eight
    * kilobytes. Also, items remain cached for at most one minute.
    * This will make use of the file list to find configuration.
    *
    * @param base this is the directory specifying the context root
    * @param size this is the maximum file size that will be cached 
    * @param list this is the range of files used for configuration
    */    
   public CacheContext(File base, File[] list, int size) {
      super(new CacheContentFactory(size), base, list);
   }   
}
