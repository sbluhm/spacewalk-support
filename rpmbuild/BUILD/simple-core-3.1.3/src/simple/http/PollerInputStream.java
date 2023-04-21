/*
 * PollerInputStream.java November 2005
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

package simple.http;

import java.io.InterruptedIOException;
import java.io.InputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * The <code>PollerInputStream</code> object is used to poll a HTTP
 * pipeline for message headers. This is used so that a non-blocking
 * mechanism for reading can be established. This acts much like the
 * implementation of the <code>PushbackInputStream</code>, except 
 * that it is optimised to unread frequently.
 * <p>
 * The need to unread, or reset, the bytes read from the stream is 
 * so that data can be read in reasonable size chunks. This however
 * can cause the read to over shoot the end of the HTTP request 
 * header. So, to ensure that the next request is not corrupted it
 * needs to be pushed back into the stream for use in the next poll.
 * <p>
 * This is a specialised stream and provides a distinct behaviour. 
 * In essence it acts much like an <code>Iterator</code> as it
 * requires the <code>available</code> method to be used in the 
 * same manner as an iterator would requires <code>hasMore</code>.
 * The available method reads from the underlying input stream and
 * fills a buffer, which is used in the next read invocation. If 
 * the <code>available</code> method is not used the read cannot
 * be pushed back onto the stream via a <code>reset</code> call.
 * 
 * @author Niall Gallagher
 *
 * @see simple.http.Poller
 */ 
final class PollerInputStream extends InputStream  {

   /**
    * This streams provides the source for the HTTP message.
    */         
   private InputStream data;        
   
   /**
    * This socket represents the connection to the client.
    */ 
   private Socket sock;

   /**
    * This is used to accumulate data from the HTTP message.
    */ 
   private byte[] buf;

   /**
    * This is the number of bytes currently accumulated.
    */ 
   private int size;
   
   /**
    * This is the offset within the buffer to read from.
    */ 
   private int pos;        

   /**
    * Constructor for the <code>PollerInputStream</code> object. This
    * creates a stream that can be used to acquire bytes from the
    * provided pipeline in such a way that reads can be rolled back.
    * This constructor imposes a maximum read size of 1024 bytes.
    *
    * @param pipe this is the pipeline that will be polled
    */ 
   public PollerInputStream(Pipeline pipe) throws IOException {
      this(pipe, 1024);
   }

   /**
    * Constructor for the <code>PollerInputStream</code> object. This
    * creates a stream that can be used to acquire bytes from the
    * provided pipeline in such a way that reads can be rolled back.
    * This constructor imposes the maximum read size specified.
    *
    * @param pipe this is the pipeline that will be polled
    * @param size this is the maximum read size for this stream
    */    
   public PollerInputStream(Pipeline pipe, int size) throws IOException {
      this.data = pipe.getInputStream();
      this.buf = new byte[size * 2];
      this.sock = pipe.sock;
   }

   /**
    * This method is used to read from the underlying stream. If the
    * data requires resetting then the <code>available</code> method
    * should be used before using this. If this is not done then the
    * data read may not be resettable. This method may block if the
    * buffer contains no data, this is up to the underlying stream.
    *
    * @return this returns the next byte read from the stream
    */ 
   public int read() throws IOException {
      if(size > 0) {
         size--;
         return buf[pos++]&0xff;              
      }
      return data.read();
   }
   
   /**
    * This method is used to read from the underlying stream. If the
    * data requires resetting then the <code>available</code> method
    * should be used before using this. If this is not done then the
    * data read may not be resettable. This method may block if the
    * buffer contains no data, this is up to the underlying stream.
    * <p>
    * If the <code>available</code> method is not called before this
    * method then this may have an empty buffer, in which case the
    * underlying stream is used to acquire the requested bytes. This
    * is ensures that bytes can always be read using this stream.
    *
    * @param b this is the bytes buffer to read the bytes into
    * @param off this is the offset within the buffer to start
    * @param len this is the maximum number of bytes to read
    * 
    * @return this returns the next byte read from the stream
    */ 
   public int read(byte[] b, int off, int len) throws IOException {
      int last = pos + size;
              
      if(pos < last) {
         int min = Math.min(len, size); 
      
         if(min > 0) {
            System.arraycopy(buf, pos, b, off, min);
         }      
         size -= min; 
         pos += min; 
      
         return min;      
      } 
      return data.read(b, off, len);
   }
   
   /**
    * This provides the primary means of reading data from the
    * underlying HTTP stream. This method ensures that regardless of
    * the input stream implementation, the available method will
    * always indicate whether there are bytes ready for reading.
    * <p>
    * This performs a <code>read</code> from the underlying stream,
    * so that if there are bytes read the available method will
    * indicate the number of bytes buffered. This generally will 
    * not block, however the <code>available(int)</code> method can 
    * be used to provide a timeout for a blocking socket read.
    *
    * @return this returns the number of bytes that can be read
    */ 
   public int available() throws IOException {
      return available(1);
   }
   
   /**
    * This provides the primary means of reading data from the
    * underlying HTTP stream. This method ensures that regardless of
    * the input stream implementation, the available method will
    * always indicate whether there are bytes ready for reading.
    * <p>
    * This performs a <code>read</code> from the underlying stream,
    * so that if there are bytes read the available method will
    * indicate the number of bytes buffered. This generally will 
    * not block, however a timeout can be specified which imposes
    * a maximum length of time the read will block for.
    *
    * @param timeout this is the maximum blocking time imposed
    *
    * @return this returns the number of bytes that can be read
    */ 
   public int available(int timeout) throws IOException {
      if(size > 0) {
         return size;              
      }      
      return peek(timeout);           
   }
           
   /**
    * This method is used to read and buffer data from the underlying
    * input stream. This ensures that the <code>available</code>
    * method can work correctly regardless of the implementation of
    * the underlying stream. For instance take JSSE streams. In
    * general these will return zero for the number of available 
    * bytes. This is not very useful when trying to perform polling.
    *
    * @return this returns the number of bytes that are buffered
    */ 
   private int peek() throws IOException {
      try {
         int free = buf.length - (pos + size);  
         
         if(pos > buf.length/4) {
            free += compact();
         } 
         int last = pos + size;
         int read = data.read(buf,last,free);
         
         if(read > 0) {
            size += read; 
         }  
         if(read < 0) {
            close();                 
         }         
      }catch(InterruptedIOException e) {
      }
      return size;
   }

   /**
    * This method is used to read and buffer data from the underlying
    * input stream. This ensures that the <code>available</code>
    * method can work correctly regardless of the implementation of
    * the underlying stream. For instance take JSSE streams. In
    * general these will return zero for the number of available 
    * bytes. This is not very useful when trying to perform polling.
    * <p>
    * A timeout can be specified to this method will allows a maximum 
    * blocking time to be imposed. This is useful when the underlying
    * stream is suspected of blocking on a read operation. 
    *
    * @param timeout this is the maximum blocking time imposed
    *
    * @return this returns the number of bytes that are buffered
    */ 
   private int peek(int timeout) throws IOException {
      int wait = sock.getSoTimeout();

      if(timeout > 0) {
         sock.setSoTimeout(timeout);              
      }      
      int size = peek();

      if(size != -1) {
         sock.setSoTimeout(wait);
      }
      return size;      
   }

   /**
    * When the buffer has used up most of the available space this
    * method will ensure that existing unread data is moved closer to
    * the start of the buffer. This ensures that there is more space
    * with which to copy further data. This will return the number of
    * extra bytes available after the compacting has completed.
    *
    * @return this returns the number of bytes that were freed
    */ 
   private int compact() {
      int space = pos;
      
      if(pos > 0) {
         System.arraycopy(buf,pos,buf,0,size); 
         pos = 0;            
      }
      return space;
   }
   
   /**
    * This will perform a rollback from the previous read. This is
    * used to that if a read over shoots the end of the HTTP header
    * the bytes that form the next header can be pushed back into 
    * the stream. This is used after a <code>read</code> invocation
    * only. If two reads are performed this can rollback only the
    * last, and only up to the number of bytes most recently read.
    *
    * @param count this is the number of bytes to rollback 
    * 
    * @return returns the number of bytes that were rolled back
    */ 
   public int reset(int count) throws IOException {
      int mark = pos;
      
      if(pos - count > 0) {
         size += count;              
         pos -= count;  
      } else {         
         size += pos;              
         pos = 0;
      }
      return mark - pos;            
   }

   /**
    * This will close the underlying stream. This closes the stream 
    * in such a way that any previously buffered bytes can be read,
    * however no further bytes can be buffered or read from the
    * underlying input stream due to exceptions being thrown.
    */ 
   public void close() throws IOException {
      data.close();           
   }

}
