/*
 * MapperEngine.java May 2003
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
  
package simple.http.load;

import simple.http.serve.StatusReport;
import simple.http.serve.Component;
import simple.http.serve.ErrorReport;
import simple.http.serve.CacheContext;
import simple.http.serve.Context;
import simple.http.serve.Report;
import simple.http.serve.Resource;
import simple.http.Response;
import simple.http.Request;
import java.io.IOException;
import java.net.URL;
import java.io.File;

/**
 * The <code>MapperEngine</code> provides an implementation of the
 * <code>LoaderEngine</code> that does not require administration.
 * It enables <code>Service</code> objects to be loaded and then
 * executed without the need to use manual <code>load</code>
 * invocations. This ability means that byte codes are taken from
 * the class path once they have been referenced.
 * <p>
 * The <code>MapperEngine</code> makes use of a system wide 
 * <code>Mapper</code> to determine what references, that is, what
 * URI references, map to a <code>Service</code> implementation.
 * If a URI maps to a service then this will check to determine
 * if it has been previously loaded, if so then it will simply
 * return that instance. However if it has not been loaded then
 * it will load the object and return a reference to it.
 * <p>
 * The loaded <code>Service</code> objects have an instance name
 * that is used to reference a specific object, this name is taken
 * from the <code>Mapper.getName</code> method. The service name
 * can also be used to acquire the fully qualified class name of
 * the service, this is useful when a service needs to be loaded.
 * This capability allows multiple instances of the same type to 
 * be loaded and referenced individually using the service name.
 * 
 * @author Niall Gallagher
 *
 * @see simple.http.load.MapperFactory
 * @see simple.http.load.Mapper
 */
public class MapperEngine extends LoaderEngine {

   /**
    * This is the mapper used by this engine to resolve URIs.
    */
   protected Mapper mapper;

   /**
    * Contains the object that is passed to each service object.
    */
   protected Object data;
   
   /**
    * Constructor for the <code>MapperEngine</code>. This creates 
    * an implementation of the <code>LoaderEngine</code> that does
    * not require manual loading of service instances. This allows
    * URI references that contain a service implementation name
    * to load the byte codes. This constructor uses a context for
    * the current working directory as a <code>CacheContext</code>.
    */
   public MapperEngine() throws IOException{
      this(new CacheContext());
   }   
   
   /**
    * Constructor for the <code>MapperEngine</code>. This creates 
    * an implementation of the <code>LoaderEngine</code> that does
    * not require manual loading of service instances. This allows
    * URI references that contain a service implementation name
    * to load the byte codes.
    * <p>
    * This will load the class byte codes from the base path of
    * the supplied <code>Context</code> object. If the byte codes
    * cannot be found using the inherited or system class loader
    * the base path is checked, failing that this will return a
    * service object that can supply an HTTP 404 Not Found.
    *
    * @param context the <code>Context</code> for this instance
    */
   public MapperEngine(Context context) throws IOException {
      this(context, context.getBasePath());
   }
   
   /**
    * Constructor for the <code>MapperEngine</code>. This creates 
    * an implementation of the <code>LoaderEngine</code> that does
    * not require manual loading of service instances. This allows
    * URI references that contain a service implementation name
    * to load the byte codes.
    * <p>
    * This will load the class byte codes from the base path of
    * the supplied <code>Context</code> object. If the byte codes
    * cannot be found using the inherided or system class loader
    * the base path is checked, failing that this will return a
    * service object that can supply an HTTP 404 Not Found.
    * <p>
    * This enables an arbitrary object to be issused, which is
    * what is used by this <code>LoaderEngine</code> to load the
    * <code>Service</code> objects. Each instance that is loaded
    * is given this object via its <code>prepare</code> method.
    *
    * @param context the <code>Context</code> for this instance
    * @param data this is the data that is given to each service
    */   
   public MapperEngine(Context context, Object data) throws IOException {
      this(context, context.getBasePath(), data);      
   }

   /**
    * Constructor for the <code>MapperEngine</code>. This creates 
    * an implementation of the <code>LoaderEngine</code> that does
    * not require manual loading of service instances. This allows
    * URI references that contain a service implementation name
    * to load the byte codes.
    * <p>
    * This will load the class byte codes from the supplied path,
    * if they cannot be found within the inherited or system class
    * path. Providing a path other than the <code>Context</code>
    * base path can be useful in seperating services from content.
    * If a service cannot be found an HTTP 404 Not Found is used.
    *
    * @param context the <code>Context</code> for this instance
    * @param path this is added to the classpath of the engine
    */ 
   public MapperEngine(Context context, String path) throws IOException{
      this(context, path, null);
   }

   /**
    * Constructor for the <code>MapperEngine</code>. This creates 
    * an implementation of the <code>LoaderEngine</code> that does
    * not require manual loading of service instances. This allows
    * URI references that contain a service implementation name
    * to load the byte codes.
    * <p>
    * This will load the class byte codes from the supplied path,
    * if they cannot be found within the inherited or system class
    * path. Providing a path other than the <code>Context</code>
    * base path can be useful in seperating services from content.
    * If a service cannot be found an HTTP 404 Not Found is used.
    * <p>
    * This enables an arbitrary object to be issused, which is
    * what is used by this <code>LoaderEngine</code> to load the
    * <code>Service</code> objects. Each instance that is loaded
    * is given this object via its <code>prepare</code> method.
    *
    * @param context the <code>Context</code> for this instance
    * @param path this is added to the classpath of the engine
    * @param data this is the data that is given to each service
    */ 
   public MapperEngine(Context context, String path, Object data) throws IOException{
      this(context, new File(path), data);
   }

   /**
    * Constructor for the <code>MapperEngine</code>. This creates 
    * an implementation of the <code>LoaderEngine</code> that does
    * not require manual loading of service instances. This allows
    * URI references that contain a service implementation name
    * to load the byte codes.
    * <p>
    * This will load the class byte codes from the supplied path,
    * if they cannot be found within the inherited or system class
    * path. Providing a path other than the <code>Context</code>
    * base path can be useful in seperating services from content.
    * If a service cannot be found an HTTP 404 Not Found is used.
    *
    * @param context the <code>Context</code> for this instance
    * @param path this is added to the classpath of the engine
    */ 
   public MapperEngine(Context context, File path) throws IOException{
      this(context, path, null);
   }

   /**
    * Constructor for the <code>MapperEngine</code>. This creates 
    * an implementation of the <code>LoaderEngine</code> that does
    * not require manual loading of service instances. This allows
    * URI references that contain a service implementation name
    * to load the byte codes.
    * <p>
    * This will load the class byte codes from the supplied path,
    * if they cannot be found within the inherited or system class
    * path. Providing a path other than the <code>Context</code>
    * base path can be useful in seperating services from content.
    * If a service cannot be found an HTTP 404 Not Found is used.
    * <p>
    * This enables an arbitrary object to be issused, which is
    * what is used by this <code>LoaderEngine</code> to load the
    * <code>Service</code> objects. Each instance that is loaded
    * is given this object via its <code>prepare</code> method.
    *
    * @param context the <code>Context</code> for this instance
    * @param path this is added to the classpath of the engine
    * @param data this is the data that is given to each service
    */ 
   public MapperEngine(Context context, File path, Object data) throws IOException{
      this(context, path.getCanonicalFile().toURL(), data);
   }
   
   /**
    * Constructor for the <code>MapperEngine</code>. This creates 
    * an implementation of the <code>LoaderEngine</code> that does
    * not require manual loading of service instances. This allows
    * URI references that contain a service implementation name
    * to load the byte codes.
    * <p>
    * This enables an arbitrary object to be issused, which is
    * what is used by this <code>LoaderEngine</code> to load the
    * <code>Service</code> objects. Each instance that is loaded
    * is given this object via its <code>prepare</code> method.
    *
    * @param context the <code>Context</code> for this instance
    * @param codebase this is added to the classpath of the engine
    * @param data this is the data that is given to each service
    */ 
   private MapperEngine(Context context, URL codebase, Object data) throws IOException{
      super(context, new URL[]{codebase});
      this.mapper = MapperFactory.getInstance(context);
      this.data = data;
   }
   
   /**
    * This will look for and retrieve the requested resource. The 
    * target given must be the actual name for the resource. This 
    * will locate the resource and return the <code>Resource</code>
    * implementation that will handle the target. 
    * <p>
    * This attempts to retrieve a service that has been previously
    * loaded using the <code>load</code> method. If the named
    * service has been previously loaded then the loaded instance
    * is returned from this method. However, if the service name
    * does not corrospond to any previously loaded service then 
    * this will attempt to use the given name to acquire a fully
    * qualified class name to load a service implementation. If 
    * this does not result in sucess, then a report resource that
    * can display the cause and status of the error is returned.
    *
    * @param name this is than name of the service to retrieve
    *
    * @return the service implementation that has been retrieved
    */
   public synchronized Resource lookup(String name) {
      try {   
         String type = mapper.getClass(name);
         
         if(registry.contains(name)) {
            return registry.retrieve(name);
         }
         Object[] list = new Object[] {
            mapper.getConfiguration(name), data};

         if(data == null) {
            list = new Object[] {list[0]};
         }            
         load(name, type, list);
      } catch(Throwable cause) {
         return new Delegate(context, cause);
      }
      return registry.retrieve(name);
   }

   /**
    * This will detetmine whether the URI string issued contains 
    * a reference to a service object. This uses the system wide
    * implementation of the <code>Mapper</code> object to check
    * whether a mapping exists. If a service name can be retrieved
    * from the URI then it is used to load the service. If there 
    * is a failure loading the service then a report is returned.
    * <p>
    * Service objects are loaded the first time they are mapped. 
    * The instance name of a loaded object is used to acquire an
    * implementation class name. This enables multiple service
    * types to be loaded and referenced individually.
    *
    * @param target this is the request URI to be resolved
    *
    * @return the service implementation that has been resolved    
    */
   public synchronized Resource resolve(String target) {
      String path = context.getRequestPath(target);
      String name = mapper.getName(path);

      if(name == null) {
         name = resolver.resolve(path);      
      }
      if(name != null) {
         return lookup(name);
      }
      return new Delegate(context,404); 
   }

   /**
    * This <code>Delegate</code> is used to generate a report of
    * any problems that occur when a service is requested. This 
    * will make use of the <code>Format</code> object to generate
    * formatted reports of errors that occur during a request.
    */ 
   private class Delegate extends Component {

      /**
       * This is the exception that this resource will be report.
       */ 
      private Report report;

      /**
       * Constructor for the <code>Delegate</code> object. This
       * uses a HTTP status code to generate a the  report object
       * describing why the service instance could not be served.
       *
       * @param context this is the context of the mapper engine
       * @param code this is the code that the will be reported
       */
      public Delegate(Context context, int code) { 
         this(context, new StatusReport(code));
      }

      /**
       * Constructor for the <code>Delegate</code> object. This
       * uses a <code>Throwable</code> to generate a report
       * describing why the service instance could not be served.
       *
       * @param context this is the context of the mapper engine
       * @param cause this is the exception used for the report
       */
      public Delegate(Context context, Throwable cause) {
         this(context, new ErrorReport(cause, 500));
      }

      /**
       * Constructor for the <code>Delegate</code> object. This
       * uses the  <code>Report</code> object that will describe
       * an event that has occured while serving the request.
       * 
       * @param context this is the context of the mapper engine
       * @param report this is the report that will be used
       */ 
      public Delegate(Context context, Report report) {
         this.context = context;
         this.report = report;
      }

      /**
       * This will use the provided <code>Throwable</code> to
       * describe the problem retrieving the service. The report
       * is generated using the given <code>Report</code> object.
       *
       * @param req the HTTP request object to be processed
       * @param resp the HTTP response object to be processed
       */  
      protected void process(Request req, Response resp) {
         handle(req, resp, report);
      }
   }
}
