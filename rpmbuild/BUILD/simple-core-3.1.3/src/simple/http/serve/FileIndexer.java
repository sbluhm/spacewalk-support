/*
 * FileIndexer.java December 2005
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

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import simple.util.cache.Cache;
import simple.util.net.Path;
import simple.util.net.URI;
import java.io.IOException;
import java.util.Locale;
import java.io.File;

/**
 * The <code>FileIndexer</code> provides an implementation of the 
 * <code>Indexer</code> object that provides a direct mapping from
 * a request URI as defined in RFC 2616 to the resources meta data.
 * This uses a <code>File</code> object to define the mapping
 * for the request URI paths. Using a <code>File</code> object 
 * allows the <code>FileIndexer</code> to be easily used with both
 * DOS and UNIX systems.
 * <p>
 * This <code>Indexer</code> implementation uses a MIME database
 * to obtain mappings for the <code>getContentType</code> method. 
 * The file used is "Content.properties", which is packaged within
 * <code>simple.http.serve</code>. This determines the MIME type
 * of the request URI by matching file extension of the resource
 * with the MIME type as defined in the "Content.properties" file.
 * The mappings in the "Content.properties" file can be overridden 
 * by any XML file named "Content.xml" within reach of the
 * <code>Locator</code> object, this configuration file requires 
 * the mappings to be in the form of wild card patterns. 
 * <code><pre>
 *
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;
 * &lt;content&gt;
 *    &lt;resolve match="*.jpg" type="image/jpeg"&gt;
 *    &lt;resolve match="/gif/*" type="image/gif"&gt;
 * &lt;/content&gt;
 *
 * </pre></code>  
 * For example, taking the XML configuration file described above,
 * this will match all files ending with the ".jpg" extension to
 * the MIME type "image/jpeg". Also, all files within the "/gif/"
 * folder will be considered GIF images with a MIME type of 
 * "image/gif". By default most of the common file extensions 
 * already have mappings, however overriding these can be useful.
 *
 * @author Niall Gallagher
 *
 * @see simple.http.serve.ContentResolver 
 * @see simple.util.parse.URIParser
 * @see simple.util.parse.PathParser
 */
final class FileIndexer implements Indexer {

   /**
    * This is used to load the Content.properties file for the 
    * list of the matching MIME types and file extensions.
    */ 
   private static ResourceBundle content;   
   
   static {      
      try { 
         content = ResourceBundle.getBundle("simple.http.serve.Content");
      }catch(MissingResourceException e){
         e.printStackTrace();
      }   
   }

   /**
    * This is used to extract any user specified MIME types.
    */ 
   private ContentResolver resolver;

   /**
    * This is used to cache the meta information acquired.
    */ 
   private Cache cache;

   /**
    * This will be used to fetch the real OS system paths.
    */
   private File base;
   
   /**
    * Constructor for the <code>FileIndexer</code> object. This is
    * used to create a centralized store for meta data. The meta
    * data created by this is acquired from the context frequently,
    * so in order to improve performance all indexes are cached,
    * except those URI targets that contain query parameters.
    *
    * @param lookup this is used to load the configuration files
    * @param base this is the root of the context that is used
    */ 
   public FileIndexer(Locator lookup, File base) {
      this.resolver = new ContentResolver(lookup);      
      this.cache = new Cache(20, 100);
      this.base = base;
   }
  
   /**
    * This is an all in one method that allows all the information 
    * on the target URI to be gathered at once. The motivation for
    * this method is primarily convenience. However it is also used
    * to increase the performance of the <code>FileIndexer</code>
    * by using a cache of the most recently used indexes. This will
    * help to reduce the amount or parsing and memory required.
    *
    * @param target this is the request URI that is to be parsed
    *
    * @return this is the index of meta data for the URI target
    */   
   public Index getIndex(String target) {
      Object data = cache.lookup(target);
      Index index = (Index)data;
      
      if(index == null) {
         index = getIndex(this, target);
      }      
      return index;
   }

   /**
    * This is an all in one method that allows all the information 
    * on the target URI to be gathered at once. The motivation for
    * this method is primarily convenience. However it is also used
    * to increase the performance of the <code>FileIndexer</code>
    * by using a cache of the most recently used indexes. This will
    * help to reduce the amount or parsing and memory required.
    * This is used as a convinience method for caching indexes.
    *
    * @param indexer this is typically the current indexer object
    * @param target this is the request URI that is to be parsed
    *
    * @return this is the index of meta data for the URI target
    */    
   public Index getIndex(Indexer indexer, String target) {
      Index index = new FileIndex(indexer, target);
      
      if(target.indexOf('?') < 0) {
         cache.cache(target, index);              
      }      
      return index;
   }
  
   /**
    * This is used to translate the HTTP request URI into the 
    * <code>File</code> object that it represents. This will convert 
    * the URI to a format that the system can use and then create    
    * the <code>File</code> object for that path. So if for example 
    * the context path was "c:\path" on a DOS system and the HTTP 
    * URI given was "/index.html" this returns the <code>File</code> 
    * "c:\path\index.html". This is basically for convenience as the
    * same could be achieved using the <code>getRealPath</code> and
    * then creating the <code>File</code> from that OS specific path.
    *
    * @param target this is the HTTP request URI path that is used
    * to retrieve the <code>File</code> object
    * 
    * @return returns the <code>File</code> for the given path
    */     
   public File getFile(URI target) {
      return getFile(target.getPath());
   }

   /**
    * This is used to translate the HTTP request URI into the 
    * <code>Path</code> object that it represents. This enables the
    * HTTP request URI to be examined thoroughly an allows various
    * other files to be examined relative to it. For example if the
    * URI referenced a path "/usr/bin/file" and some resource
    * in the same directory is required then the <code>Path</code>
    * can be used to acquire the relative path. This is useful if
    * links within a HTML page are to be dynamically generated. The
    * <code>Path.getRelative</code> provides this functionality.
    * 
    * @param target this is the HTTP request URI path that is used
    * to retrieve the <code>Path</code> object
    *
    * @return returns the <code>Path</code> for the given path
    */   
   public Path getPath(URI target){
      return target.getPath();
   }
   
   /**
    * This is used to translate the request URI path into the 
    * <code>File</code> object that it represents. This will convert 
    * the path to a format that the system can use and then create    
    * the <code>File</code> object for that path. So if for example 
    * the context path was "c:\path" on a DOS system and the request
    * URI given was "/index.html" this returns the <code>File</code> 
    * "c:\path\index.html". This is basically for convenience as the
    * same could be achieved using the <code>getRealPath</code> and
    * then creating the <code>File</code> from that OS specific path.
    *
    * @param path this is the URI path that is used to retrieve the
    * <code>File</code> object
    * 
    * @return returns the <code>File</code> for the given path
    */   
   private File getFile(Path path) {
      return new File(base, path.toString().replace(
         '/', File.separatorChar));  
   }
   
   /**
    * This will parse the HTTP request URI specified and return the 
    * <code>Locale</code> for that resource. The <code>Locale</code>
    * is extracted from the target by examining the path segment of
    * the HTTP request URI. The path segment is the abs_path token
    * defined in RFC 2396. It is extracted from a second extension
    * in the file name. So for example if the HTTP request URI was
    * "http://some.host/usr;param=value/index.en_US.html" then the
    * file name "index.en_US.html" would have the second file
    * extension en_US converted into a <code>Locale</code>. This
    * will not interfere if the file name was "compressed.tar.gz",
    * it will simply ignore the "tar" second file extension and
    * return <code>Locale.getDefault</code>. 
    *
    * @param target the request URI to be parsed for its locale
    *
    * @return this will return the locale for the specified URI
    */    
   public Locale getLocale(URI target){
      return getLocale(target.getPath());           
   }

   /**
    * This will parse the request URI path specified and return the 
    * <code>Locale</code> for that resource. The <code>Locale</code>
    * is extracted from the target by examining the path segment of
    * the HTTP request URI. The path segment is the abs_path token
    * defined in RFC 2396. It is extracted from a second extension
    * in the file name. So for example if the HTTP request URI was
    * "http://some.host/usr;param=value/index.en_US.html" then the
    * file name "index.en_US.html" would have the second file
    * extension en_US converted into a <code>Locale</code>. This
    * will not interfere if the file name was "compressed.tar.gz",
    * it will simply ignore the "tar" second file extension and
    * return <code>Locale.getDefault</code>. 
    *
    * @param path the path part of the request URI to have its     
    * locale determined
    *
    * @return this will return the locale for the specified path
    */    
   private Locale getLocale(Path path){   
      String place = path.getCountry();
      String talk = path.getLanguage();

      if(talk == null){
         return Locale.getDefault();
      }else if(place == null){
         return new Locale(talk);
      }
      return new Locale(talk, place);  
   }
   
   /**
    * This method will extract the type attribute of this URI. The
    * MIME type of the request URI is extracted from the name of the
    * target. The name for the <code>Context</code> is the last path
    * segment in the token defined by RFC 2396 as path_segments. So
    * for example if the target was "some.host:8080/bin/index.html"
    * then the name for that resource would be "index.html". Once
    * the name has been extracted the MIME is defined by the file
    * extension, which for the example is text/html. The MIME type
    * mappings can be directly specified in a configuration file
    * named either "Content.xml" or "content.xml".
    *
    * @param target the request URI to be parsed for its type    
    *
    * @return the type of the given request URI path refers to
    */    
   public String getContentType(URI target){
      return getContentType(target.getPath());
   }
   
   /**
    * This method will extract the type attribute of this path. The
    * MIME type of the request path is extracted from the name of the
    * target. The name for the <code>Context</code> is the last path
    * segment in the token defined by RFC 2396 as path_segments. So
    * for example if the target was "some.host:8080/bin/index.html"
    * then the name for that resource would be "index.html". Once
    * the name has been extracted the MIME is defined by the file
    * extension, which for the example is text/html. The MIME type
    * mappings can be directly specified in a configuration file
    * named either "Content.xml" or "content.xml".
    *
    * @param path path that is to have its MIME type determined
    *
    * @return the type of the given resource path refers to
    */    
   private String getContentType(Path path){
      String ext = path.getExtension();
      String target = path.getPath();
      
      return getContentType(target, ext);
   }  

   /**
    * This method will extract the type attribute of this path. The
    * MIME type of the request path is extracted from the name of the
    * target. The name for the <code>Context</code> is the last path
    * segment is the token defined by RFC 2396 as path_segments. So
    * for example if the target was "some.host:8080/bin/index.html"
    * then the name for that resource would be "index.html". Once
    * the name has been extracted the MIME is defined by the file
    * extension, which for the example is text/html. The MIME type
    * mappings can be directly specified in a configuration file
    * named either "Content.xml" or "content.xml".
    *
    * @param path path that is to have its MIME type determined
    * @param ext this is the file extension for the given path
    *
    * @return the type of the given resource path refers to
    */    
   private String getContentType(String path, String ext) {
      try {
         String type = resolver.getContentType(path);         
         
         if(type != null){
            return type;                 
         }else if(ext != null){ 
            return content.getString(ext);
         }         
      }catch(MissingResourceException e){
      }
      return "application/octetstream";          
   }
}

