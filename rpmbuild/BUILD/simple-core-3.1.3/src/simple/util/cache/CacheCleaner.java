/*
 * CacheCleaner.java February 2001
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

/**
 * This is used to asynchronously remove objects from the cache when 
 * those objects timeout. This uses the <code>Scheduler</code> that 
 * the <code>TimeCache</code> uses to store the timeouts of objects 
 * that are in the <code>TimeCache</code>. This is an active object 
 * and an instance of this will automatically start a thread.
 *
 * @author Niall Gallagher
 */ 
final class CacheCleaner implements Runnable {      

   /**
    * This is the time cache that is to to be cleaned by this.
    */
   private TimeCache cache;   
   
   /**
    * This refers to the stale objects in the time cache.
    */
   private Scheduler queue;
      
   /**
    * This allows the cleaner to run concurrently.
    */
   protected Thread thread;      

   /**
    * This will start a thread to remove each stale item. The
    * cache instance this will be cleaning must be provided.
    *
    * @param cache the time cache that this is cleaning    
    * @param queue the queue that contains stale items
    */ 
   public CacheCleaner(TimeCache cache, Scheduler queue) {
      this.thread = new Thread(this);
      this.cache = cache;
      this.queue = queue;
      this.thread.start();
   }

   /**
    * This is a driver for the clean method to dequeue and
    * remove objects that have timed out. This will catch any
    * exceptions that propagate from the clean method, however
    * this is unlikely because the thread that is dequeuing is
    * private and the only exception is InterruptedException.
    */ 
   public void run(){
      while(true){
         try {
            clean();
         }catch(Exception e){
            e.printStackTrace();
         }
      }
   }

   /**
    * This dequeues and removes the stale objects in the
    * <code>TimeCache</code>. This will remove items from the
    * <code>TimeCache</code> only if the item that is to be 
    * removed exists within the cache, see 
    * <code>CacheReference</code>.
    *
    * @exception InterruptedException this unlikely to happen
    */ 
   public void clean() throws InterruptedException {
      Object stale = queue.dequeue();
      CacheReference ref = (CacheReference)stale;
      Object cached = ref.get();
      
      if(cached != null && cached == cache.lookup(ref)){
         cache.remove(ref);
      }         
   }
}


