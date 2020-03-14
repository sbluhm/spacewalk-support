/*
 * Cache.java February 2001
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

/**
 * This is a LRU, Least Recently Used, <code>Cache</code> used to store
 * objects. This ensures that the <code>Cache</code> does not allow
 * too many objects to be cached. This does not account for anything 
 * other than the number of lockable regions, i.e. synchronized Least 
 * Recently Used lists, and the maximum number of items a region can 
 * have before it removes the least recently used objects. 
 *
 * @author Niall Gallagher
 */ 
public class Cache {

   /**
    * This is the default number of regions for the cache.
    */
   private static final int DEFAULT_LOCKS = 20;
   
   /**
    * This is the default number of elements per lock.
    */
   private static final int DEFAULT_LIMIT = 100;
   
   /**
    * Used to store the lists that store objects.
    */
   private CacheList[] list;

   /**
    * This is used to create a <code>Cache</code> object for storing
    * objects. This <code>Cache</code> is an LRU <code>Cache</code>
    * meaning that the Least Recently Used items are removed if the 
    * size of a region grows to large, the default is two thousand.
    */ 
   public Cache() {
      this(DEFAULT_LOCKS, DEFAULT_LIMIT);
   }

   /**
    * This is used to create a <code>Cache</code> object for storing
    * objects. This <code>Cache</code> is an LRU <code>Cache</code>
    * meaning that the Least Recently Used items are removed if the 
    * size if the region grows to large. This constructor configures 
    * the <code>Cache</code> as specified.
    *
    * @param regions number of regions that are synchronized
    * @param limit the maximum amount of objects per region
    */ 
   public Cache(int regions, int limit) {
      this.init(regions, limit);
   }

   /**
    * In this <code>Cache</code> a region is considered to be an area
    * within the <code>Cache</code> that is synchronized independantly. 
    * This means that if there are two threads accessing the 
    * <code>Cache</code>, they can access objects that hash to a different 
    * regions concurrently. This <code>Cache</code> maintains an array of
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
    * This will store the object given in the <code>Cache</code> 
    * under the reference specified. The object may exist in the
    * <code>Cache</code> if it remains an actively used object.
    *
    * @param key this is the key that references the object
    * @param obj this is the object that is to be stored
    */ 
   public void cache(Object key, Object obj){
      int pos = translate(key);
      list[pos].insert(key, obj); 
   }

   /**
    * This is a simple function that maps an objects hash
    * code using <code>Object.hashCode</code> into an array
    * subscript. This is used to index into a specific list.
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
    * This will search the <code>Cache</code> to see if the item
    * in the cache. If it is in the cache this will return it.
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
    * <code>Cache</code>. If it exists this returns true else
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
    * This will remove all items from the <code>Cache</code>. 
    * This is used to synchronize the cached objects.
    */ 
   public void clear() {
      for(int i = 0; i < list.length; i++){
         list[i].clear();      
      }
   }
}
