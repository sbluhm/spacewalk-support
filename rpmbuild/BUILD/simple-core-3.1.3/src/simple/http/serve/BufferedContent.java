/*
 * BufferedContent.java November 2002
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
 * The <code>BufferedContent</code> represents content that is stored 
 * within an internal buffer. This acquires the meta data of the file
 * using the issued <code>Context</code> object and buffers the
 * contents using a byte array. This is provided so that files can 
 * be cached in memory so that repeated requests for a popular file 
 * can be done quicker.
 * <p>
 * This implementation of the <code>Content</code> interface is used
 * when the <code>FileContentFactory.getInstance</code> method is 
 * given a size that is less than the size of the file. For a caching
 * scheme the file size should not be too large to conserve memory.
 *
 * @author Niall Gallagher
 *
 * @see simple.http.serve.CacheContentFactory
 */
final class BufferedContent extends IndexedContent{  
 
   /**
    * The buffer that contains the contents of the file.
    */
   private volatile byte[] cache;

   /**
    * Constructor for the <code>BufferedContent</code> acquires the
    * bytes for the specified file using an <code>InputStream</code>
    * retrieved from the <code>IndexedContent</code>. This is then
    * used to acquire the bytes of the file and cache them in main 
    * memory so that invocations of the <code>write</code> method 
    * can be done without refering to the file system.
    *
    * @param context the <code>Context</code> used for indexing
    * @param target the request URI that refers to the file
    */
   public BufferedContent(Context context, String target){
      super(context, target);
   }

   /**
    * The <code>write</code> method writes the contents of the file
    * to the issued <code>OutputStream</code>. This is done using the
    * allocated buffer to which involves a single write operation.
    *
    * @param out the <code>OutputStream</code> to write the contents
    *
    * @exception IOException this is thrown if the issued stream has
    * an I/O problem writing the contents
    */   
   public void write(OutputStream out) throws IOException{
      if(cache == null) {
         int size = getLength();
      
         if(size > 0) {
            write(out,size);
         }
      } else {
         out.write(cache);              
      }
   }

   /**
    * This <code>write</code> method writes a specific number of bytes
    * from the contents of the file. This is simply used as a driver
    * for acquiring the cache of the file. This will acquire the file
    * input stream, delegate to the caching write and close the file.
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
    * stream. As this transfers the contents of the resource to the
    * provided output stream it will buffer the contents of the file
    * within its internal byte buffer so future requests are quicker.
    *
    * @param out the <code>OutputStream</code> to write the contents
    * @param in this is the <code>InputStream</code> to read from
    * @param size this is the number of bytes to read from the file 
    *
    * @exception IOException this is thrown if the issued stream has
    * an I/O problem writing the contents
    */
   private void write(OutputStream out, InputStream in, int size) throws IOException{   
      byte[] buf = new byte[size];

      for(int off = 0; size > 0;){
         int len = in.read(buf,off,size);
                 
         if(len < 0){  
            break;
         }
         out.write(buf,off,len);
         size -= len;
         off += len;
      }
      cache = buf;
   }
}
