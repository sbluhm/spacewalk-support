/*
 * FileIndex.java December 2005
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

import simple.util.parse.URIParser;
import simple.util.net.URI;
import simple.util.net.Path;
import java.util.Locale;
import java.io.File;

/**
 * The <code>FileIndex</code> provides an implementation of an index
 * that makes use of the OS file system to acquire meta data. This
 * will acquire information directly from the URI target, as well as
 * a MIME database maintained within the <code>Content.xml</code> file.
 * This caches all meta data acquired so that there is no expense in
 * re-acquiring the data. This allows for faster meta data retrieval
 * and facilitates the implementation of the meta data cache used.
 * 
 * @author Niall Gallagher
 *
 * @see simple.http.serve.FileIndexer
 */ 
final class FileIndex implements Index {

   /**
    * This is the source indexer used to acquire the meta data.
    */         
   private Indexer indexer;

   /**
    * This is the path portion of the specified URI target.
    */ 
   private Path path;

   /**
    * This is the OS specific file referencing the resource. 
    */ 
   private File file;

   /**
    * This is the MIME type resolved for the resource.
    */ 
   private String type;

   /**
    * This is the locale specific to the URI specified.
    */ 
   private Locale locale;

   /**
    * This contains all the information regarding the URI.
    */ 
   private URI target;

   /**
    * Constructor for the <code>FileIndex</code> object. This uses a
    * URI target to acquire the meta data for the resource. The URI
    * provides the resource name and path and also provides a hint
    * for the MIME type of the resource from the file extension.
    *
    * @param indexer this is the source indexer for this instance
    * @param target this is the URI target that is to be indexed
    */  
   public FileIndex(Indexer indexer, String target) {
      this(indexer, new URIParser(target));
   }

   /**
    * Constructor for the <code>FileIndex</code> object. This uses a
    * URI target to acquire the meta data for the resource. The URI
    * provides the resource name and path and also provides a hint
    * for the MIME type of the resource from the file extension.
    *
    * @param indexer this is the source indexer for this instance
    * @param target this is the URI target that is to be indexed
    */     
   public FileIndex(Indexer indexer, URI target) {
      this.indexer = indexer;
      this.target = target;      
   }   

   /**
    * This is used to get the path that this object refers to. 
    * This should be the fully qualified normalized path. This
    * refers to the OS system specific path that this represents.
    *
    * @return this returns the OS specific path for the target
    */    
   public String getContentType() {
      if(type == null) {
         type = getContentType(target);              
      }           
      return type;
   }

   /**
    * This is used to get the path that this object refers to. 
    * This should be the fully qualified normalized path. This
    * refers to the OS system specific path that this represents.
    *
    * @param target the index target to get the real path for
    * 
    * @return this returns the OS specific path for the target
    */    
   public String getContentType(URI target) {
      return indexer.getContentType(target);           
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
      if(locale == null) {
         locale = getLocale(target);              
      }           
      return locale;
   }

   /**
    * This gets the locale for this index object the locale is
    * set to the <code>Locale.getDefault</code> if there is no
    * locale information available for the index target. This
    * will provide the <code>Context.getLocale</code> object.
    *
    * @param target the index target to get the locale for
    * 
    * @return this returns the locale for this index target
    */    
   public Locale getLocale(URI target) {
      return indexer.getLocale(target);           
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
      if(file == null) {
         file = getFile(target);              
      }           
      return file;
   }

   /**
    * This is used to acquire the <code>File</code> reference
    * for the index target. This is typically rooted at a
    * base path, for instance the <code>Context</code> root
    * is typically used. This allows the file to be opened,
    * deleted, or read should the need arise in a service.
    *
    * @param target the index target to get the OS file for
    * 
    * @return this returns the OS file for the resource
    */    
   public File getFile(URI target) {
      return indexer.getFile(target);           
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
      if(path == null) {
         path = getPath(target);
      }
      return path;      
   }

   /**
    * This is used to acquire the <code>Path</code> object that 
    * exposes various parts of the URI path. This can be used 
    * to extract the individual path segments as strings as 
    * well as the file extension and various other details.
    *
    * @param target the index target to get the URI path for
    * 
    * @return this returns a path object with various details
    */    
   public Path getPath(URI target) {
      return indexer.getPath(target);           
   }

   /**
    * This is used to get the path that this object refers to. 
    * This should be the fully qualified normalized path. This
    * refers to the OS system specific path that this represents.
    *
    * @return this returns the OS specific path for the target
    */    
   public String getRealPath() {
      return getFile().getAbsolutePath();           
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
      return getFile().getParentFile();
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
      return getPath().getPath();
   }

   /**
    * This allows the name for this object to be acquired. The
    * name usually refers to the last entry in the path. So if
    * the index target path was "/usr/bin/" the name is "bin".
    *
    * @return this returns the name of this index target
    */           
   public String getName() {
      return getPath().getName();
   }
}
