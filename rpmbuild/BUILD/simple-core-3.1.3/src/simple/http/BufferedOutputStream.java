/*
 * BufferedOutputStream.java December 2003
 *
 * Copyright (C) 2003, Niall Gallagher <niallg@users.sf.net>
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

import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * The <code>BufferedOutputStream</code> object is used to wrap the
 * default socket output stream in such a way that buffering can be
 * done. To increase performance output buffering can be performed.
 * This form of buffering ensures that a single TCP packet can be 
 * used to deliver the HTTP message and body. By default this uses 
 * a zero length buffer so no bytes are buffered.
 * 
 * @author Niall Gallagher
 *
 * @see simple.http.Pipeline
 */
class BufferedOutputStream extends OutputStream {

   /**
    * This is the socket output stream that is written to.
    */         
   private OutputStream out;        

   /**
    * This is the array that the bytes are buffered with.
    */ 
   private byte[] buf;

   /**
    * This is used to count the number of buffered bytes.
    */ 
   private int count;
   
   /**
    * Constructor for the <code>BufferOutputStream</code> object.
    * This creates an output stream that basically wraps the socket
    * output stream. This will use a zero-length buffer so that all
    * bytes skip buffering and are written directly to the socket.
    *
    * @param sock this is the socket this pipeline is to use
    *
    * @throws IOException if the output stream cannot be acquired
    */ 
   public BufferedOutputStream(Socket sock) throws IOException{
      this(sock, 1024);           
   }
   
   /**
    * Constructor for the <code>BufferOutputStream</code> object.
    * This creates an output stream that basically wraps the socket
    * output stream. This will use a buffer of the specified length,
    * which ensures that bytes can be accumulated before being 
    * written to the underlying socket.
    *
    * @param sock this is the socket this pipeline is to use
    * @param size this is the size of the buffer for packets
    *
    * @throws IOException if the output stream cannot be acquired
    */   
   public BufferedOutputStream(Socket sock, int size) throws IOException{
      this.out = sock.getOutputStream();
      this.buf = new byte[size];      
   }

   /**
    * This <code>write</code> method will write the provided data to
    * the buffer if it has not yet reached capacity. If however the
    * buffer has reached its capacity then this will write the
    * contents of the buffer to the underlying output stream and
    * buffer the data in the cleared buffer.
    * 
    * @param b this is the data to be written to the output buffer
    *
    * @throws IOException this is thrown if there is an I/O error
    */ 
   public void write(int b) throws IOException {
      int size = buf.length;
      
      if(count >= size) {
         out.write(buf, 0, count);
         count = 0;
      }         
      buf[count++] = (byte)b;              
   }
   
   /**
    * This <code>write</code> method will write the provided data to
    * the buffer if it has not yet reached capacity. If however the
    * buffer has reached its capacity then this will write the
    * contents of the buffer to the underlying output stream and
    * buffer the data in the cleared buffer.
    * 
    * @param b this is the data to be written to the output buffer
    *
    * @throws IOException this is thrown if there is an I/O error
    */ 
   public void write(byte[] b) throws IOException {
      write(b, 0, b.length);           
   }
   
   /**
    * This <code>write</code> method will write the provided data to
    * the buffer if it has not yet reached capacity. If however the
    * buffer has reached its capacity then this will write the
    * contents of the buffer to the underlying output stream and
    * buffer the data in the cleared buffer.
    * 
    * @param b this is the data to be written to the output buffer
    * @param off this is the region to begin taking the data from
    * @param len this is the number of bytes that are to be written
    *
    * @throws IOException this is thrown if there is an I/O error
    */ 
   public void write(byte[] b, int off, int len) throws IOException {
      int size = buf.length;
      
      if(len > size -count) {
         out.write(buf, 0, count);
         count = 0;
      }
      if(len > buf.length) {
         out.write(b, off, len);         
      } else {
         System.arraycopy(b, off, buf, count, len);              
         count += len;
      }           
   }

   /**
    * This <code>flush</code> method will write the buffered bytes to
    * the underlying socket, if any bytes have been buffered. This is
    * use to ensure data is delivered immediately. This method is
    * typically used when a HTTP message has completed and delivery 
    * to the client application is required without a socket closure.
    * 
    * @throws IOException this is thrown if there is an I/O error
    */ 
   public void flush() throws IOException {
      if(count > 0) {           
         out.write(buf,0,count);
         count = 0;
      }
      out.flush();           
   }

   /**
    * This <code>close</code> method will write the buffered bytes to
    * the underlying socket before closing the underlying stream. This
    * is used when HTTP/1.0 is used and the end of the message is
    * delimeted with a closure of the socket connection.
    * 
    * @throws IOException this is thrown if there is an I/O error
    */ 
   public void close() throws IOException {
      if(count > 0) {
         out.write(buf,0,count);
         count = 0;         
      }
      out.close();           
   }   
}
