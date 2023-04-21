/*
 * ExtendedContext.java November 2005
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
 * The <code>ExtendedContext</code> object is used to provide a file
 * context that extends another seperate context. This is used so
 * that files from another context are available to this one. Such
 * a configuration has advantages when acquiring templates or files
 * in a server with multiple hosts. It allows a set of stock files,
 * images, and templates to become available to multiple contexts.
 * 
 * @author Niall Gallagher
 *
 * @see simple.http.serve.CacheContext
 */
public class ExtendedContext extends CacheContext {

   /**
    * This is the default limit to the files sizes to cache.
    */         
   private static final int DEFAULT_SIZE = 8192;
   
   /**
    * The context used if a file is not found in this context.
    */ 
   protected Context extend;
        
   /**
    * Constructor for the <code>ExtendedContext</code> object. This 
    * is used to create a context that will search the provided base
    * path before the extended directory. This allows a set of stock
    * images, templates, and files to be shared between separate
    * extended context instances in a server with several hosts.
    *
    * @param base this is the directory specifying the context root
    * @param extend this is the directory path that is extended
    */ 
   public ExtendedContext(File base, File extend) {
      this(base, extend, new File[] {base, extend});
   }
  
   /**
    * Constructor for the <code>ExtendedContext</code> object. This 
    * is used to create a context that will search the provided base
    * path before the extended directory. This allows a set of stock
    * images, templates, and files to be shared between separate
    * extended context instances in a server with several hosts.
    *
    * @param base this is the directory specifying the context root
    * @param extend this is the directory path that is extended
    * @param list this is the range of files used for configuration
    */    
   public ExtendedContext(File base, File extend, File[] list) {
      super(base, list, DEFAULT_SIZE);
      this.extend = new FileContext(extend);
   }  

   /**
    * This method is used to acquire an <code>Index</code> for the 
    * URI path provided. The index is first acquired using the base
    * path for this context, if the file does not exist then the
    * extended directory path is used to provide the index. This is
    * done so that files from both directories are visible.
    *
    * @param target this is the URI path referenceing an OS file
    *
    * @return this returns an index object for the URI target
    */ 
   public Index getIndex(String target) {
      Index index = super.getIndex(target);
      
      if(!index.getFile().exists()) {
         return extend.getIndex(target);                       
      }           
      return index;
   }   
}
