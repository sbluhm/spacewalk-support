/*
 * FilterPipeline.java February 2001
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
 
package simple.http;

import java.net.InetAddress;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Set;

/**
 * This is a <code>FilterPipeline</code> object that is used to wrap
 * the <code>Pipeline</code> it is given. This contains methods that 
 * act as proxies to the given <code>Pipeline</code>
 * <p>
 * The <code>FilterPipeline</code> enables the <code>Pipeline</code>
 * to be subclassed easily. Subclasses may want to implement buffering
 * or security features to the <code>Pipeline</code>'s that it uses.
 * The <code>PipelineFactory</code> can produce these implementations
 * to be processed with the <code>PipelineHandler</code>.
 *
 * @author Niall Gallagher
 */ 
public class FilterPipeline extends Pipeline {
   
   /**
    * This is the <code>Pipeline</code> that is wrapped.
    */
   protected Pipeline pipe;

   /**
   /**
    * This constructor allows the <code>FilterPipeline</code> to be 
    * extended in such a way that it does not do any initialization 
    * of the object itself. This is used if there is no need for a
    * <code>Socket</code> or <code>Hashtable</code> reference.
    * This is used by the <code>Poller</code> object.         
    */
   protected FilterPipeline(){
      super();           
   }

   /**
    * This wraps the <code>Pipeline</code> given. This will contain
    * the same <code>Socket</code> object as the <code>Pipeline</code>
    * it is given. Any sub classes of the <code>Pipeline</code> may 
    * use this to enable it to attach some extra functionality to the
    * <code>Pipeline</code> like buffering or security.
    *
    * @param pipe the <code>Pipeline</code> that is being wrapped
    *
    * @throws IOException if the object could not be created
    */ 
   public FilterPipeline(Pipeline pipe) throws IOException{
      this.table = pipe.table;
      this.sock = pipe.sock;      
      this.pipe = pipe;
   }
   /**
    * Retrieves the <code>InputStream</code>. This is a communication 
    * channel between the client and the server. The stream returned
    * is the same as the <code>Pipeline.getInputStream</code>.
    *
    * @throws IOException thrown if there is an I/O problem.
    *
    * @return an <code>InputStream</code> from the client, i.e. the
    * <code>Pipeline</code>
    */ 
   public synchronized InputStream getInputStream() throws IOException {
      return pipe.getInputStream();
   }

   /**
    * Retrieves the <code>OutputStream</code>. This is a communication
    * channel from the server to the client. The stream returned is
    * the same as the <code>Pipeline.getOuputStream</code>.
    *
    * @throws IOException thrown if there is an I/O problem
    *
    * @return an <code>OutputStream</code> to the client, i.e. the
    * <code>Pipeline</code>
    */ 
   public synchronized OutputStream getOutputStream() throws IOException {
      return pipe.getOutputStream();
   }

   /**
    * This corresponds to the identity of the host that created
    * the connection. The domain name can be retrieved from this.
    *
    * @return the identity of the peer that created connection
    */ 
   public synchronized InetAddress getInetAddress() {
      return pipe.getInetAddress();
   }

   /**
    * The <code>put</code> method is used to insert a mapping to
    * the attributes that pairs the issued name with the issued
    * value. The value can be referenced in future by its name.
    *
    * @param name this is the name of the value being inserted
    * @param value this is the named value that is inserted
    */
   public void put(String name, Object value) {
      table.put(name, value);           
   }

   /**
    * The <code>get</code> method is used to retrieve the value
    * mapped to the specified name. If a value does not exist
    * matching the given name, then this returns null.
    * 
    * @param name this is the name of the value to be retrieved
    *  
    * @return returns the value if it exists or null otherwise
    */
   public Object get(String name) {
      return table.get(name);           
   }

   /**
    * The <code>remove</code> method is used to remove the 
    * named value from the attributes. This method will remove
    * the value or returns silently if the name does not exits.
    *
    * @param name this is the name of the value to be removed
    */
   public void remove(String name) {
      table.remove(name);           
   }

   /**
    * To ascertain what mappings exist, the names of all values
    * previously put into this attributes can be retrieved with 
    * this method. This will return a <code>Set</code> that 
    * contains the names of all the mappings added to this.
    *
    * @return this returns all the keys for existing mappings
    */
   public Set keySet() {
      return table.keySet();           
   }

   /**
    * This is a close method that ensures the communication link 
    * is shutdown. Closes the <code>InputStream</code> and the
    * <code>OutputStream</code> of the <code>Pipeline</code>. This 
    * method will not propagate any exceptions.
    */ 
   public synchronized void close() {
      pipe.close();
   } 
}
