/*
 * FileContext.java March 2002
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

import simple.util.FileProperties;
import simple.util.net.Path;
import java.util.Properties;
import java.io.IOException;
import java.util.Locale;
import java.io.File;

/**
 * The <code>FileContext</code> provides an implementation of the 
 * <code>Context</code> object that provides a direct mapping from
 * a request URI as defined in RFC 2616 to an OS specific target.
 * This uses a <code>File</code> object to define the mapping
 * for the request URI paths. Using a <code>File</code> object 
 * allows the <code>FileContext</code> to be easily used with both
 * DOS and UNIX systems.
 * <p>
 * This <code>Indexer</code> implementation uses an MIME database
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
 * this will match all files ending with the ".jpg" extenstion to
 * the MIME type "image/jpeg". Also, all files within the "/gif/"
 * folder will be considered GIF images with a MIME type of 
 * "image/gif". By default most of the common file extensions 
 * already have mappings, however overriding these can be useful.
 *
 * @author Niall Gallagher
 *
 * @see simple.http.serve.FileIndexer
 */
public class FileContext implements Context {

   /**
    * This is used to extract any user specified MIME types.
    */ 
   protected FileIndexer indexer;

   /**
    * This is used to locate the configuration information.
    */
   protected Locator locator;

   /**
    * This is the format instance used by this instance.
    */
   protected Format format;

   /**
    * This will be used to fetch the real OS system paths.
    */
   protected File base;
   
   /**
    * Constructor for creating an instance that operates from
    * the given current working path. This instance will use
    * the current path to translate the HTTP request URIs
    * into the OS specific path. This will load configuration
    * files from the current working directory.
    */
   public FileContext() {
      this(new File("."));
   }

   /**
    * Constructor for creating an instance that operates from
    * the given OS specific base path. This instance will use
    * the given base path to translate the HTTP request URIs
    * into the OS specific path. This will load configuration
    * files from the specified directory path. 
    *
    * @param base this is the OS specific base path for this
    */
   public FileContext(File base) {
      this(base, base);
   }
  
   /**
    * Constructor for creating an instance that operates from
    * the given OS specific base path. This instance will use
    * the given base path to translate the HTTP request URIs
    * into the OS specific path. This allows configuration 
    * files to be loaded from the file directory provided.
    *
    * @param base this is the OS specific base path for this
    * @param path this is the path used to load configuration
    */
   public FileContext(File base, File path) {
      this(base, new File[]{path});
   }    
   
   /**
    * Constructor for creating an instance that operates from
    * the given OS specific base path. This instance will use
    * the given base path to translate the HTTP request URIs
    * into the OS specific path. This allows configuration 
    * files to be loaded from the file range provided.
    *
    * @param base this is the OS specific base path for this
    * @param list this path list used to load configuration
    */
   public FileContext(File base, File[] list) {
      this(base, new FileLocator(list));
   }   
   
   /**
    * Constructor for creating an instance that operates from
    * the given OS specific base path. This instance will use
    * the given base path to translate the HTTP request URIs
    * into the OS specific path. This uses the locator object
    * provided, which can be used to acquire configuration.
    *
    * @param base this is the OS specific base path for this
    * @param locator this is the configuration file locator
    */
   public FileContext(File base, Locator locator) {
      this.indexer = new FileIndexer(locator, base);
      this.format = FormatFactory.getInstance();
      this.locator = locator;
      this.base = base;
   }
   
   /**
    * This is used to retrieve the base path of the context. The
    * base path of the context is that path that that this will
    * retrieve system information from. This represents a base
    * that the request URI paths are served from on the system.
    * For instance a base of "c:\path" would translate a URI
    * path of "/index.html" into "c:\path\index.html". Every
    * resource request must be relative to the context path
    * this allows the <code>FileEngine</code> to map the URIs
    * onto the specific OS. The base path is the OS file system
    * specific path. So on UNIX it could be "/home/user/" and
    * on a DOS system it could be "c:\web\html" for example.
    *
    * @return this returns the base path of the context
    */
   public String getBasePath() {
      return base.getAbsolutePath();
   }

   /**
    * This is used to translate the HTTP request URI into the OS
    * specific path that it represents. This will convert the 
    * URI to a format that the system can use and also represents
    * the resource path on that system. So if for example the
    * context path was "c:\path" on a DOS system and the HTTP URI 
    * given was "/index.html" this returns "c:\path\index.html".
    * If a UNIX system was running the VM and the context base
    * was for example "/home/" then this would return the UNIX
    * path "/home/index.html" for the same request URI.
    *
    * @param target this is the HTTP request URI path that is to 
    * be translated into the OS specific path
    * 
    * @return this returns the OS specific path name for the 
    * translate request URI
    */
   public String getRealPath(String target){
      return getIndex(target).getRealPath();
   }
  
   /**
    * This is used to translate the HTTP request URI into the URI
    * path normalized and without query or parameter parts. This
    * is used so that the resource requested by the client can be
    * discovered. For example this will convert the HTTP request
    * URI "http://hostname/bin;param=value/../index.html?query" 
    * into the relative URI path /index.html. This is useful if 
    * a logging mechanism requires the name of the resource that
    * was requested, it can also be used help find the resource.
    *
    * @param target this is the HTTP request URI that is to be
    * converted into a normalized relative URI path
    *
    * @return the HTTP request URI as a normalized relative path
    */
   public String getRequestPath(String target){
      return getIndex(target).getRequestPath();
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
   public File getFile(String target) {
      return getIndex(target).getFile();
   }

   /**
    * This is used to translate the HTTP request URI into the
    * <code>File</code> object that it represent the parent directory
    * of the URI. This will convert the URI to a format that the host
    * system can use and then create the <code>File</code> object for
    * that path. So if for example the context path was "c:\path" on
    * a DOS system and the HTTP URI given was "/index.html" this 
    * returns the <code>File</code> "c:\path\". This is basically 
    * for convenience as the same could be achieved using the file
    * retrieved from <code>getFile</code> and acquiring the parent.
    *
    * @param target this is the HTTP request URI path that is used
    * to retrieve the <code>File</code> object
    * 
    * @return returns the <code>File</code> for the directory
    */ 
   public File getDirectory(String target) {
      return getIndex(target).getDirectory();
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
   public Path getPath(String target){
      return getIndex(target).getPath();
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
   public Locale getLocale(String target){      
      return getIndex(target).getLocale();
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
   public String getContentType(String target){
      return getIndex(target).getContentType();
   }
   
   /**
    * This will parse and return the file name that this request URI
    * references. The name for the <code>Context</code> is the last 
    * path segment is the token defined by RFC 2396 as path_segments. 
    * So for example if the target was "some.host:8080/home/user/"
    * then the name for that resource would be "user". If the path 
    * references the root path "/" then null should be returned.
    *
    * @param target the request URI to be parsed for its name
    *
    * @return this will return the name that this references
    */ 
   public String getName(String target){
      return getIndex(target).getName();
   }

   /**
    * This is an all in one method that allows all the information 
    * on the target URI to be gathered at once. The motivation for
    * this method is primarily convenience. However it is also used
    * to increase the performance of the <code>FileEngine</code>
    * when the <code>Context</code> implementation is synchronized.
    * This will enable the <code>FileEngine</code> to gather the
    * information on the target by acquiring the lock for the object
    * instance only once.
    *
    * @param target this is the request URI that is to be parsed
    */
   public Index getIndex(String target){
      return indexer.getIndex(target);
   }

   /**
    * This retrieves a <code>Content</code> instance that wraps the
    * specified resource. This returns a <code>Content</code> instance
    * that transfers the contents of the referenced file in one 
    * kilobyte chunks. This does not cache the file, however if the
    * files need to be cached the <code>FileContentFactory</code> can
    * be used to act as a hot spot cache for heavly accessed files.
    * 
    * @param target this is the request URI that identifies the file
    *
    * @throws IOException this is thrown if the file resource does
    * not exist or cannot be accessed 
    */
   public Content getContent(String target) throws IOException{
      return new StreamContent(this,target);           
   }
   
   /**
    * This provides a convenient way for an XML configuration file
    * to be loaded. This resolves the target URI to a relative file
    * within the context to be the same as the <code>getFile</code>
    * method would return. Once the file has been acquired the Java
    * properties file is loaded, each time, there is no caching of
    * the loaded properties. This ensures that changes to a loaded
    * object does not affect other users of the properties file.
    *
    * @param target the request URI that refers to the properties
    *
    * @return returns a populated <code>Properties</code> object
    * using the specified Java properties file
    *
    * @throws IOException this is thrown if the resource does not
    * exist or cannot be accessed     
    */
   public Properties getProperties(String target) throws IOException{
      return new FileProperties(getFile(target));
   }

   /**
    * Each <code>Context</code> must supply a <code>Locator</code> to
    * enable the system to locate configuration information and other
    * resources that reside outside the context path. This is useful 
    * when there are Java properties and XML configuration files
    * required by objects interacting with a <code>Context</code>.
    * The <code>Locator</code> employs a search to locate resources,
    * which are identified either by name or using aliases. 
    *
    * @return this returns the locator used by this context object 
    */
   public Locator getLocator() {
      return locator;
   }

   /**
    * Each <code>Context</code> object must be coupled with an instance
    * of the <code>Format</code> object. This is required because each
    * <code>FileEngine</code> needs to serve the directory listing and
    * the error messages in a consistent format. The resources of the
    * instances can thus be pooled by comparing the equality of the
    * various <code>Context</code> objects. When there is an object 
    * that requires a <code>FileEngine</code> it can create an instance
    * of the <code>Context</code> and using the static factory method 
    * <code>FileEngine.getInstance</code> with the context object there
    * is a search for an active instance of the <code>FileEngine</code>.
    * If one is found that uses a similar context object then it is
    * returned to the caller. This enables instances and thus resources 
    * to be shared transparently.
    *
    * @return this returns the format used with this context object
    */
   public Format getFormat() {
      return format;
   }  
}

