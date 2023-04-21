/*
 * TimeCache.java February 2001
 *
 * Copyright (C) 2001, Niall Gallagher <niallg@users.sf.net>
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
 
package simple.util.cache;

import simple.util.schedule.Scheduler;
import java.lang.ref.Reference;

/**
 * This is a LRU, Least Recently Used, <code>TimeCache</code> for caching
 * objects. This ensures that the <code>TimeCache</code> does not allow
 * too many objects to be cached. This does not account for anything 
 * other than the number of lockable regions, i.e. synchronized Least 
 * Recently Used lists, and the maximum number of items a region can 
 * have before it removes the least recently used objects. 
 * <p>
 * When objects are cached they can be cached for a specified number of
 * miliseconds, when this expires then the time cache will remove the 
 * item, this removal is very accurate to the timeout specified for the
 * object. If no time out is given a default timeout for this is used. 
 * The maximum capacity of the <code>TimeCache</code> is regions * limit, 
 * however this does not provide an exact Least Recently Used semantic
 * as some regions are likely to have more hits than others.
 *
 * @author Niall Gallagher
 */ 
public class TimeCache {

   /**
    * This is the default refresh rate for the cache.
    */
   private static final int DEFAULT_TIMEOUT = 60000;

   /**
    * This is the default number of regions for the cache.
    */
   private static final int DEFAULT_LOCKS = 10;
   
   /**
    * This is the default number of elements per lock.
    */
   private static final int DEFAULT_LIMIT = 6;
   
   /**
    * Used by this to dispose of expired objects.
    */
   private Scheduler queue;
   
   /**
    * Will use the scheduler to clean this.
    */
   private CacheCleaner cleaner;

   /**
    * Used to store the lists that store objects.
    */
   private CacheList[] list;

   /**
    * Default length of time an item can be cached.
    */
   private int timeout;   

   /**
    * This is used to create a <code>TimeCache</code> object for storing
    * objects. This cache implementation is an Least Recently Used cache
    * meaning that the Least Recently Used items are removed if the 
    * size of a region grows to large. This has a maximum capacity 
    * of 60, unlikely.
    */ 
   public TimeCache() {
      this(DEFAULT_LOCKS, DEFAULT_LIMIT);
   }

   /**
    * This is used to create a <code>TimeCache</code> object for storing
    * objects. This cache implementation is an Least Recently Used cache
    * meaning that the Least Recently Used items are removed if the 
    * size if the region grows to large. This constructor configures 
    * the <code>TimeCache</code> as specified.
    *
    * @param regions number of regions that are synchronized
    * @param limit the maximum amount of objects per region
    */ 
   public TimeCache(int regions, int limit) {
      this(regions, limit, DEFAULT_TIMEOUT);
   }

   /**
    * This is a constructor method used by 'this' to specify the 
    * characteristics that the <code>TimeCache</code> may have. This
    * will allow the max timeout to be specified for the
    * <code>TimeCache</code>.
    *
    * @param regions number of regions that are synchronized
    * @param limit the maximum amount of objects per region
    * @param timeout the default timeout peroid for an object
    */ 
   public TimeCache(int regions, int limit, int timeout){  
      this.queue = new Scheduler(); 
      this.cleaner = new CacheCleaner(this,queue);
      this.timeout = timeout;
      this.init(regions,limit);
   }

   /**
    * In this <code>TimeCache</code> a region is considered to be an area
    * within the <code>TimeCache</code> that is synchronized independantly. 
    * This means that if there are two threads accessing the 
    * <code>TimeCache</code>, they can access objects that hash to a different 
    * regions concurrently. This <code>TimeCache</code> maintains an array of
    * <code>CacheList</code> objects. These are Least Recently Used
    * lists in the sense that if they reach there maximum capacity they
    * will drop the most unused items. The limit defines the maximum
    * capacity of a region i.e. list.
    *
    * @param regions number of regions that are synchronized
    * @param limit the maximum amount of objects per region
    */ 
   private void init(int regions, int limit) {
      list = new CacheList[regions];
      
      for(int i = 0; i < regions; i++){
         list[i] = new CacheList(limit);
      }
   }

   /**
    * This will store the object given in the <code>TimeCache</code> 
    * under the reference specified. The object may exist in the
    * <code>TimeCache</code> for a limited time only specified by a
    * timeout.
    *
    * @param key this is the key that references the object
    * @param obj this is the object that is to be stored
    */ 
   public void cache(Object key, Object obj){
      int pos = translate(key);
      list[pos].insert(key, obj); 
      schedule(key, obj, timeout);
   }

   /**
    * This will store the object given in the <code>TimeCache</code> 
    * under the reference specified. The object may exist in the
    * <code>TimeCache</code> for a limited time only specified by a
    * timeout.
    *
    * @param key this is the key that references the object
    * @param obj this is the object that is to be stored
    * @param timeout max amount of time this can be
    * cached.
    */ 
   public void cache(Object key, Object obj, int timeout){
      int pos = translate(key);      
      list[pos].insert(key, obj);       
      schedule(key, obj, timeout);
   }

   /**
    * This is used so that objects that are enqueued into the
    * <code>TimeCache</code> can be removed after a certain peroid 
    * of time.
    *
    * @param key this is the key that references the object
    * @param obj this is the object that is to be stored
    * @param timeout max amount of time this can be cached
    */ 
   private void schedule(Object key, Object obj, int timeout){      
      Reference ref = new CacheReference(key, obj);
      queue.enqueue(ref, timeout);                  
   }

   /**
    * This is a simple function that maps an objects hash
    * code using <code>Object.hashCode</code> into an array
    * subscript.
    *
    * @param key the object that is to be translated
    *
    * @return an array subscript into the list
    */ 
   private int translate(Object key) {
      int hash = key.hashCode();
      if(hash < 0) hash *= -1;   
      return hash % list.length;  
   }
  
   /**
    * This will search the <code>TimeCache</code> to see if the item
    * in the time cache. If it is in the cache this will return it.
    * This provides a very concurrent lookup mechanism, where threads
    * have less contention for locks, as the key decides which list
    * to use based on the value of the key hash code.
    *
    * @param key this is the key that references the object
    *
    * @return the object that is referenced by the key
    */ 
   public Object lookup(Object key) {
      int pos = translate(key);
      return list[pos].lookup(key);      
   }

   /**
    * This will check to see if an object exists within the 
    * <code>TimeCache</code>. If it exists this returns true else
    * false.
    *
    * @param key this is the key that references the object
    *
    * @return a boolean indicating the status of the object
    */ 
   public boolean contains(Object key) {
      int pos = translate(key);
      return list[pos].contains(key);
   }

   /**
    * This will remove the object cached using the specified 
    * key. If the object is not stored this does nothing.
    * This ensures that no reference fot the object is left.
    *
    * @param key this is the key that references the object
    */ 
   public Object remove(Object key) {
      int pos = translate(key);
      return list[pos].remove(key);      
   }

   /**
    * This will remove all items from the <code>TimeCache</code>. 
    * This is used to synchronize the cached objects.
    */ 
   public void clear() {
      for(int i = 0; i < list.length; i++){
         list[i].clear();      
      }
   }
}
