/*
 * CacheContentFactory.java November 2005
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

import simple.util.cache.TimeCache;
import java.io.IOException;
import java.io.File;

/**
 * The <code>CacheContentFactory</code> is used to create a factory
 * that can be used to create and cache files as instances of the
 * <code>Content</code> interface. This is useful when a hot spot
 * cache is required for frequently referenced files. The defaults 
 * for the file cache use a maximum file size of eight kilobytes.
 * <p>
 * This factory object can limit the items stored within the cache
 * by file size. This ensures that the resources consumed by the 
 * file cache can be restricted. Also the concurrency parameters 
 * for the cache can be specified as regions and region limits.
 * 
 * @author Niall Gallagher
 *
 * @see simple.http.serve.CacheContext
 * @see simple.util.cache.TimeCache
 */
public class CacheContentFactory implements ContentFactory {

   /**
    * This is the default length of time to cache a file.
    */         
   private static final int DEFAULT_TIMEOUT = 60000;        

   /**
    * This is the default maximum size for a cached file. 
    */ 
   private static final int DEFAULT_SIZE = 8192;
        
   /**
    * This is the default number of regions for the cache.
    */
   private static final int DEFAULT_LOCKS = 10;
   
   /**
    * This is the default number of elements per lock.
    */
   private static final int DEFAULT_LIMIT = 6;
   
   /**  
    * This is used to cache the content objects created.  
    */  
   protected TimeCache cache;  

   /**
    * This is the maximum allowed size for a cached file.
    */ 
   protected int size;

   /**
    * Constructor for the <code>CacheContentFactory</code> object. 
    * This object provides caching for any context implementation 
    * that makes heavy use of <code>Content</code> objects. Caching
    * done by this object ensures that the content objects are kept
    * in memory for at least one minute, to change this behaviour
    * this object can be subclassed and use different settings.
    */ 
   protected CacheContentFactory() {
      this(DEFAULT_SIZE);           
   }
   
   /**
    * Constructor for the <code>CacheContentFactory</code> object. 
    * This object provides caching for any context implementation 
    * that makes heavy use of <code>Content</code> objects. Caching
    * done by this object ensures that the content objects are kept
    * in memory for at least one minute, to change this behaviour
    * this object can be subclassed and use different settings.
    *
    * @param size this is the maximum allow file size to cache
    */ 
   public CacheContentFactory(int size) {
      this(size, DEFAULT_LOCKS, DEFAULT_LIMIT);
   }

   /**
    * Constructor for the <code>CacheContentFactory</code> object. 
    * This object provides caching for any context implementation 
    * that makes heavy use of <code>Content</code> objects. Caching
    * done by this object ensures that the content objects are kept
    * in memory for at least one minute, to change this behaviour
    * this object can be subclassed and use different settings.
    *
    * @param size this is the maximum allow file size to cache
    * @param regions this is the number of locks the cache uses
    * @param limit this is the maximum capacity of each LRU list
    */ 
   public CacheContentFactory(int size, int regions, int limit) {
      this.cache = new TimeCache(regions, limit);           
      this.size = size;           
   }
   
   /**
    * This implementation of the <code>getInstance</code> method will
    * cache the created <code>Content</code> object. This is done
    * to increase the performance of the <code>Context</code> for 
    * objects that are requested frequently. The size of the file
    * that is cached is dependant on the construction parameters.
    * <p>
    * If the file referenced is greater than the specified maximum
    * then a one kilobyte buffer is cached for that file as is used
    * to transfer the contents of the file to the output stream.
    *
    * @param target the request URI for the content required
    * @param context this is the context used to locate the file
    *
    * @return this returns a <code>Content</code> instance
    *
    * @throws ContentException this is thrown if there is an error
    * locating the specified file, or creating the object
    */
   public Content getInstance(Context context, String target) throws ContentException {
      try {           
         if(target.indexOf('?') < 0) {              
            return getContent(context, target, DEFAULT_TIMEOUT);
         }
         return getContent(context, target);         
      }catch(IOException e) {
         throw new ContentException(target);              
      }         
   }           
   
   /**
    * This method allows a size to be specified for the maximum
    * buffer size. If the file resource is less than the buffer size 
    * then the entire contents of the file are buffered within the
    * issued implementation. This will allocate up to 1 kilobyte for
    * files that are larger than the specified buffer size.
    * <p>
    * This implementation of the <code>getContent</code> method will
    * cache the created <code>Content</code> object. This is done
    * to increase the performance of the <code>Context</code> for 
    * objects that are requested frequently. The buffer size that
    * can be specified provides a guide for how much memory should
    * be taken up with the content cached object.
    * 
    * @param context this is the object used to locate the file
    * @param target this is the request URI that identifies the file 
    * @param timeout the number of milliseconds to cache the file 
    *
    * @throws IOException this is thrown if the file resource does
    * not exist or cannot be accessed 
    */  
   protected Content getContent(Context context, String target, int timeout) throws IOException {   
      Object data = cache.lookup(target);  
         
      if(data != null) {  
         return (Content)data;  
      }  
      data = getContent(context, target);  
      cache.cache(target, data, timeout);  
      
      return (Content)data; 
   }

   /**
    * This is used to create the <code>Content</code> instances. The
    * <code>getInstance</code> method can be used by subclasses that
    * want to introduce dynamic <code>Content</code> objects. This
    * enables the <code>getContent</code> method to cache the
    * resulting instances without having to know what types they are.
    * <p>
    * By default the <code>CacheContentFactory</code> produces objects
    * that will write static content as it appears on the underlying
    * file system. This uses the specified size to ensure that the
    * buffers used by the content are not larger than the maximum.
    *
    * @param context this is the object used to locate the file
    * @param target this is the request URI that identifies the file 
    *
    * @throws IOException this is thrown if the file resource does
    * not exist or cannot be accessed     
    */
   protected Content getContent(Context context, String target) throws IOException{   
      if(context.getFile(target).length() <= size){
         return new BufferedContent(context,target);
      }
      return new StreamContent(context,target);
   }
}
