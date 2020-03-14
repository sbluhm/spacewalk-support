/*
 * ContentBuffer.java December 2005
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

import java.io.OutputStream;
import java.io.IOException;
import simple.util.Buffer;

/**
 * The <code>ContentBuffer</code> object is used to encapsulate a
 * resources contents, such that the <code>Content</code> data
 * can be easily converted to a string. This is provided so that
 * the <code>Content.toString</code> method can produce a UTF-8
 * string encoding of the targeted resource, which can be useful 
 * if a template object is to be embedded within another string.
 *
 * @author Niall Gallagher 
 */
final class ContentBuffer extends OutputStream {
        
   /**
    * The content object used to fill this buffers contents.
    */         
   private Content out;
        
   /**   
    * This is the stream used to capture the content output.
    */
   private Buffer buf;

   /**
    * Constructor for the <code>ContentBuffer</code>. This is
    * used to capture the output of the issued content, which
    * can be acquired from UTF-8 using <code>toString</code>.
    *
    * @param out the content to capture the output from
    */     
   public ContentBuffer(Content out) {
      this.buf = new Buffer();           
      this.out = out;           
   }   

   /**
    * This method is used to accumulate the bytes for the content
    * object. The bytes that are buffered are used to convert
    * the resource to a string using UTF-8. This allows the data
    * to be embedded into other stringsa and manipulated easily.
    * 
    * @param b this is the byte to append to the byte buffer
    */ 
   public void write(int b) {
      buf.append(b);           
   }

   /**
    * This method is used to accumulate the bytes for the content
    * object. The bytes that are buffered are used to convert
    * the resource to a string using UTF-8. This allows the data
    * to be embedded into other stringsa and manipulated easily.
    * 
    * @param b this is the byte array to append to the buffer
    * @param off this is the index to bytes must be taken from
    * @param len this is the number of bytes to be taken
    */ 
   public void write(byte[] b, int off, int len) {
      buf.append(b, off, len);           
   }

   /**
    * This method is used so that if there is an exception the
    * stack trace can be printed in place of the content. This
    * is very important when it comes to tracking down bugs
    * within a web application as it highlights the problem.
    *
    * @param cause this is the cause of the content error
    *
    * @return returns a string representation of the error
    */ 
   public String toString(Exception cause) {
      return new ExceptionBuffer(cause).getCause();              
   }

   /**
    * This method will use the specified <code>Content</code> to
    * provide a UTF-8 encoding of its contents. This will capture
    * the contents of the object only once, subsequent requests
    * will use a cached value of the contents. This is done to
    * reduce the I/O required to capture the resource contents.
    *
    * @return this returns a UTF-8 decoding of the content
    */ 
   public String toString() {
      if(buf.length() > 0) {
         return buf.toString();
      }           
      try {
         out.write(this);              
      } catch(Exception cause){
         return toString(cause);              
      }
      return buf.toString();           
   }
}
