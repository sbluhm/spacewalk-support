/*
 * StreamContent.java November 2002
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
 
package simple.http.serve;

import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;

/**
 * The <code>StreamContent</code> object wraps a file which is
 * too large to be buffered fully. Buffering resources requires a 
 * large amount of memory, this <code>Content</code> implementation 
 * ensures that the entire file is not stored in memory. 
 * <p>
 * This allocates a buffer two kilobytes in size which is used to 
 * transfer the contents of a <code>File</code> object to the 
 * issued <code>OutputStream</code>. The <code>getContentType</code> 
 * method returns the value of <code>Context.getContentType</code>.
 * 
 * @author Niall Gallagher
 */      
final class StreamContent extends IndexedContent{

   /**
    * Constructor for the <code>StreamContent</code> creates an
    * instance of the <code>Content</code> for large files. This uses
    * the <code>Context.doIndex</code> method to retrieve a the meta
    * information of the <code>File</code> represented by this.
    *
    * @param context the <code>Context</code> used for indexing
    * @param target this is the request URI that refers to the file
    */
   public StreamContent(Context context, String target){
      super(context, target);
   }

   /**
    * The <code>write</code> method writes the contents of the file
    * to the issued output stream provided. This is done by acquiring
    * an input stream for the file and transferring the contents of
    * that stream in two kilobyte chunks to the given output stream.
    *
    * @param out the <code>OutputStream</code> to write the contents
    *
    * @exception IOException this is thrown if the issued stream has
    * an I/O problem writing the contents
    */
   public void write(OutputStream out) throws IOException{
      int size = getLength();
      
      if(size > 0) {
         write(out,size);
      }
   }

   /**
    * This <code>write</code> method writes a specific number of bytes
    * from the contents of the file. This is simply used as a driver
    * for piping the contents of the file to the provided stream. The
    * number of bytes to be streamed must be greater than zero.
    * 
    * @param out the <code>OutputStream</code> to write the contents
    * @param size this is the number of bytes to read from the file
    *
    * @exception IOException this is thrown if the issued stream has
    * an I/O problem writing the contents
    */ 
   private void write(OutputStream out, int size) throws IOException{
      InputStream in = getInputStream();

      if(size > 0) {
         write(out, in,size);                                   
      }
      in.close();
   }                 
   
   /**
    * The <code>write</code> method acts as a pipe, in that it will
    * transfer the contents of the provided input stream to the ouput
    * stream. This will transfer the contents of the file in chunks
    * of two kilobytes in size. The provided input stream is closed
    * once the contents of the file have been transferred.
    *
    * @param out the <code>OutputStream</code> to write the contents
    * @param in this is the <code>InputStream</code> to read from
    *
    * @exception IOException this is thrown if the issued stream has
    * an I/O problem writing the contents
    */
   private void write(OutputStream out, InputStream in, int size) throws IOException{
      byte[] swap = new byte[2048];

      while(true) {
         int len = in.read(swap);

         if(len < 0){
            break;                 
         }        
         out.write(swap,0,len); 
      }
   }
}
