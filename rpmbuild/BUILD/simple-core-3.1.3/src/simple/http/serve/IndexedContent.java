/*
 * IndexedContent.java December 2002
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

import simple.util.net.Path;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.io.File;

/**
 * The <code>IndexedContent</code> is used to provide any specific
 * meta data for any file based <code>Content</code>s. This provides 
 * methods that allow the <code>Content</code> to be indexed by the
 * <code>Context</code> object, this allows the server to build meta
 * information on a resource without having to refer to a centralized 
 * table that matches the resource with its meta information. 
 * <p>
 * Such approaches are used with servers like Apache that can have 
 * information stored in a file to describe the Language, Type etc. 
 * of a resource. This however uses a scheme that discovers the meta 
 * information of the <code>Content</code> by parsing the request URI.
 * The <code>File</code>s that are indexed can have locale extensions 
 * to that the <code>Content</code>s can be discriminated upon based 
 * on preferred Language.
 *
 * @author Niall Gallagher
 */ 
abstract class IndexedContent implements Content {
   
   /**
    * This represents a cache of the buffered contents.
    */ 
   protected volatile String cache;
        
   /**
    * This is the HTTP URI that references this content.
    */ 
   protected String target;
   
   /**
    * This is the index that contains all the meta data.
    */      
   protected Index index;
   
   /**
    * Creates a default indexed object that is indexed based on 
    * the path name that it is given. The <code>Context</code> is
    * used to parse the path and set the meta data. The meta data
    * of the <code>Content</code> is set based on a set of rules
    * specified by the <code>Context</code>. The path is broken 
    * into its separate components like its name, type, path etc. 
    * This will create the <code>Content</code> relative to the 
    * specified directory. i.e. the <code>Content</code> is 
    * created from a file that is rooted at the base directory.
    *
    * @param context the context that this resource is relative to
    * @param target this is the HTTP request URI this represents
    */    
   protected IndexedContent(Context context, String target) {
      this.index = context.getIndex(target);
      this.target = target;
   }
   
   /**
    * This allows the name for this object to be acquired. The
    * name usually refers to the last entry in the path. So if
    * the index target path was "/usr/bin/" the name is "bin".
    *
    * @return this returns the name of this index target
    */         
   public String getName() {
      return index.getName();           
   }
   
   /**
    * This allows the MIME type of this <code>Index</code> to
    * be acquired. The MIME type of a file is retrieved by the
    * <code>Context.getContentType</code> method for a specific
    * request URI. This should have a value and perhaps some
    * parameters like the charset, "text/html; charset=UTF-8".
    *
    * @return the MIME type this object has been set to
    */    
   public String getContentType() {
      return index.getContentType();           
   }
   
   /**
    * This gets the locale for this index object the locale is
    * set to the <code>Locale.getDefault</code> if there is no
    * locale information available for the index target. This
    * will provide the <code>Context.getLocale</code> object.
    *
    * @return this returns the locale for this index target
    */ 
   public Locale getLocale() {
      return index.getLocale();           
   }

   /**
    * This is used to get the path that this object refers to. 
    * This should be the fully qualified normalized path. This
    * refers to the OS system specific path that this represents.
    *
    * @return this returns the OS specific path for the target
    */    
   public String getRealPath() {
      return index.getRealPath();           
   }

   /**
    * This is used to acquire the normalized URI style path for
    * the index target. This allows the path to be used within
    * the <code>Mapper</code> and other such objects that need
    * a normalized URI style path to resolve resources.
    *
    * @return this returns the normalized path for the target
    */ 
   public String getRequestPath() {
      return index.getRequestPath();           
   }

   /**
    * This is used to acquire the <code>File</code> directory
    * for the index target. This is typically rooted at a
    * base path, for instance the <code>Context</code> root
    * is typically used. This allows resources within the 
    * same directory to be acquired easily.
    *
    * @return this returns the OS file for the directory
    */ 
   public File getDirectory() {
      return index.getDirectory();           
   }
   
   /**
    * This is used to acquire the <code>File</code> reference
    * for the index target. This is typically rooted at a
    * base path, for instance the <code>Context</code> root
    * is typically used. This allows the file to be opened,
    * deleted, or read should the need arise in a service.
    *
    * @return this returns the OS file for the resource
    */ 
   public File getFile() {
      return index.getFile();           
   }

   /**
    * This is used to acquire the <code>Path</code> object that 
    * exposes various parts of the URI path. This can be used 
    * to extract the individual path segments as strings as 
    * well as the file extension and various other details.
    *
    * @return this returns a path object with various details
    */ 
   public Path getPath() {
      return index.getPath();           
   }
   
   /**
    * This is a simple convienience method that enables subclasses
    * to retrieve the <code>FileInputStream</code> for the file.
    * 
    * @return this returns the <code>FileInputStream</code> that
    * represents the targeted file
    *
    * @throws IOException thrown if the file does not exist
    */
   protected InputStream getInputStream() throws IOException{
      return new FileInputStream(getFile());
   }
  
   /**
    * This method is used to convert the contents of this object to
    * a UTF-8 string. This is primarily used as a means to provide
    * the text for the <code>toString</code> method in a thread 
    * safe manner by creating a privately scoped buffer object.
    *
    * @return this returns a UTF-8 representation of the contents
    */  
   protected String getContent() {
      return new ContentBuffer(this).toString();           
   }

   /**
    * This returns the date of the last modification of the file.
    * This date is returned as the long, this is the number of
    * milliseconds since January 1 1970. This is equivelant to
    * using the <code>File.lastModified</code> method.
    *
    * @return the date of the last modification of the file
    */
   protected long getLastModified(){
      return getFile().lastModified();
   }
   
   /**
    * This method is used to retrieve the length of the file that
    * this <code>Content</code> represents. The size of the file
    * is assumed not to be larger than the maximum integer value,
    * if it is possible for the length to exceed this length the
    * <code>File.length</code> method should be used.
    *
    * @return this returns the length of the file as an integer  
    */
   protected int getLength(){
      return (int)getFile().length();
   }

   /**
    * This acquires the contents of the file as a UTF-8 encoded
    * string. This will also ensure that the contents of the file
    * are cached as a string, thus avoiding the need to reconvert
    * the contents into a UTF-8 string on each use of this.
    *
    * @return this returns a UTF-8 encoding of the file contents
    */    
   public String toString() {
      if(cache == null){
         cache = getContent();              
      }           
      return cache;
   }
}
