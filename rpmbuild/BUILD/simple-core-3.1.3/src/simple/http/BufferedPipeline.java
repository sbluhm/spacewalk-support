/*
 * BufferedPipeline.java Spetember 2002
 *
 * Copyright (C) 2002, Niall Gallagher <niallg@users.sf.net>
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

import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;
import java.net.Socket;

/**
 * The <code>BufferedPipeline</code> is used to provide a pipeline
 * that buffers the ouput. This is used to that the TCP packets are
 * sufficently large so as to increase network performance. This 
 * is issued from the <code>BufferedPipelineFactory</code> this
 * can then be used to to create <code>ConnectionHandler</code>
 * objects that will buffer the HTTP response.
 *
 * @author Niall Gallagher
 */
class BufferedPipeline extends Pipeline {

   /**
    * The <code>BufferedOutputStream</code> issued by this.
    */
   protected OutputStream out;

   /**
    * Constructor for the <code>BufferedPipeline</code> creates
    * a <code>BufferedOutputStream</code> using the stream issued 
    * from the socket object and the size to specify the buffer 
    * size. If the output stream cannot be created this throws 
    * an <code>IOException</code>.
    *
    * @param sock this is the <code>Socket</code> that this
    * <code>Pipeline</code> wraps
    * @param size this is the size of the output buffer used
    *
    * @throws IOException if there is an I/O problem 
    */
   public BufferedPipeline(Socket sock, int size) throws IOException{
      this.out = new BufferedOutputStream(sock, size);
      this.table = new Hashtable();
      this.sock = sock;
   }

   /**
    * Retrives the <code>OutputStream</code>. This is a communication
    * channel from the server to the client. The stream returned is
    * the same as the <code>Socket.getOuputStream</code> wraped in
    * a <code>BufferedOutputStream</code>.
    *
    * @throws IOException thrown if there is an I/O problem
    *
    * @return an <code>OutputStream</code> to the client, i.e. the
    * <code>Pipeline</code>
    */ 
   public OutputStream getOutputStream(){
      return out;
   }
}
