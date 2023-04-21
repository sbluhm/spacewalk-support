/*
 * LoaderEngine.java February 2001
 *
 * Copyright (C) 2001, Niall Gallagher <niallg@users.sf.net>
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

import simple.http.serve.Component;
import simple.http.serve.ResourceEngine;
import simple.http.serve.StatusReport;
import simple.http.serve.CacheContext;
import simple.http.serve.Context;
import simple.http.serve.Resource;
import simple.http.Response;
import simple.http.Request;
import simple.util.Resolver;
import simple.util.Match;
import java.io.IOException;
import java.net.URL;
import java.io.File;

/**
 * The <code>LoaderEngine</code> is used to load <code>Service</code>
 * implementations into the system so that they can be executed by 
 * a <code>ProtocolHandler</code>. The <code>LoaderEngine</code> is 
 * a <code>LoaderManager</code> and thus can be exported to a remote
 * process where it can be managed/administered. 
 * <p>
 * This will retrieve linked <code>Service</code> objects based on 
 * the <code>simple.util.Resolver</code> object. So the later the 
 * link is made the higher its priority. Each of the methods of the
 * <code>LoaderManager</code> are governed by access control. This
 * is so that <code>Service</code> objects cannot access the methods 
 * of the <code>LoaderEngine</code> and change the configuration.
 * <p>
 * The permission required for access to the <code>LoaderEngine</code>
 * is the <code>LoaderPermission</code>. There are three actions that
 * can be granted using this permission. First is "load" permission
 * which grants permission for the <code>load</code> methods and the
 * <code>unload</code> method. The second is "link" this grants the
 * permission to use the <code>link</code> and <code>unlink</code>
 * methods. The final action token is "update" which grants permission
 * for the <code>update</code> and <code>remove</code> methods.
 * <p>
 * Monitoring activity within the <code>LoaderEngine</code> can be
 * done by registering a <code>Loader</code>. This enables the
 * loader to recieve updates on the configuration of the loader
 * engine as it changes. This needs <code>LoaderPermission</code>
 * with the "update" action.
 *
 * @author Niall Gallagher
 *
 * @see simple.http.load.Service
 * @see simple.util.Resolver
 */
public class LoaderEngine extends LoaderStub implements ResourceEngine{

   /**
    * The <code>Resolver</code> for the linked classes.
    */
   protected Resolver resolver;

   /**
    * This is used to update any <code>Loader</code> objects.
    */
   protected Processor delegate;

   /**
    * This is the context this loader engine operates from.
    */
   protected Context context;

   /**
    * This contains the loaded <code>Service</code>'s.
    */
   protected Registry registry;

   /**
    * This contains the configuration of the loader engine.
    */
   protected Profile profile;
  
   /**
    * Constructor for the <code>LoaderEngine</code> that uses the
    * class loader of the current instance to load the services.    
    * The semantics will be similar to <code>Class.forName</code>.
    * <p>
    * This will use an empty array of <code>URL</code> objects 
    * so that this instances loader is always used to retrieve
    * the byte codes for referenced <code>Service</code> objects.
    *
    * @exception IOException this is thrown if the is an I/O 
    * problem with the RMI runtime or generating the classpath
    */
   public LoaderEngine() throws IOException{
      this(new CacheContext());
   }
  
   /**
    * Constructor for the <code>LoaderEngine</code> that uses the
    * class loader of the current instance to load the services.    
    * The semantics will be similar to <code>Class.forName</code>.
    * <p>
    * This will use an array of <code>URL</code> objects, which
    * contains only the current working directory as the codebase
    * to load the referenced <code>Service</code> objects.    
    *
    * @param context used to acquire the codebase and to provide
    * <code>Service</code> objects with a view of the file system
    *
    * @exception IOException this is thrown if the is an I/O 
    * problem with the RMI runtime or generating the classpath
    */
   public LoaderEngine(Context context) throws IOException {
      this(context, new File(context.getBasePath()));      
   }
   
   /**
    * Constructor for the <code>LoaderEngine</code> takes a file 
    * classpath. This will load the code with the semantics of
    * the <code>Class.forName</code> before trying to load the 
    * code from the specified classpath. To keep consistant the 
    * <code>LoaderEngine(Context, URL)</code> should be used to
    * specify a single codebase source instead of this.
    * <p>
    * This will use an array of <code>URL</code> objects, which
    * contains only the specified local directory as a codebase
    * to load the referenced <code>Service</code> objects. 
    *
    * @param context used to provide a view of the file system
    * @param path this is the file classpath that all the code
    * for the <code>Service</code> implementations is loaded
    *
    * @exception IOException this is thrown if the is an I/O 
    * problem with the RMI runtime or generating the classpath
    */   
   protected LoaderEngine(Context context, File path) throws IOException{
      this(context, path.getCanonicalFile().toURL());
   }
   
   /**
    * Constructor for the <code>LoaderEngine</code> that uses the
    * class loader of the current instance to load the services.
    * The semantics will be similar to <code>Class.forName</code>.
    * When a <code>ProtocolHandler</code> wants to create an 
    * instance it only needs to provide the codebase and context.
    * <p>
    * This will use an array of <code>URL</code> objects, which
    * contains only the specified codebase URL as the codebase
    * to load the referenced <code>Service</code> objects. 
    *
    * @param context used to provide a view of the file system
    * @param codebase this is the URL classpath that all the code
    * for the <code>Resource</code> implementations is loaded
    *
    * @exception IOException this is thrown if the is an I/O 
    * problem with the RMI runtime or generating the classpath    
    */   
   public LoaderEngine(Context context, URL codebase) throws IOException{
      this(context, new URL[]{codebase});
   }
   
   /**
    * Constructor for the <code>LoaderEngine</code> takes a URL 
    * classpath. This URL classpath is where the implementation
    * objects are loaded from. If the suggested URL classpath is
    * not well formed then a <code>MalformedURLException</code>
    * is thrown. This will load the code with the semantics of
    * the <code>Class.forName</code> before trying to load the 
    * code from a URL. When a <code>ProtocolHandler</code> wants 
    * to create an instance it only need create a list of URL
    * locations, which can be used to act as the classpath.
    * </p>
    * This will create a <code>URLClassLoader</code> using the
    * given set of <code>URL</code> objects. The loading of the
    * <code>Resource</code> objects will follow the semantics of
    * the <code>URLClassLoader(URL[])</code> instance.
    *
    * @param context used to provide a view of the file system
    * @param codebase this is the URL classpath that all the code
    * for the <code>Resource</code> implementations is loaded
    *
    * @exception IOException this is thrown if the is an I/O 
    * problem with the RMI runtime or generating the classpath    
    */
   public LoaderEngine(Context context, URL[] codebase) throws IOException{
      this.registry = new Registry(context, codebase);
      this.resolver = new Resolver();
      this.delegate = new Processor(this);
      this.profile = new Profile(this);
      this.context = context;
   }

   /**
    * This is used to insert a <code>Loader</code> object which 
    * is used to recieve updates on the configuration. The loader
    * can be a remote object which enables the local instance to
    * to communicate its state to a remote administration utility.
    * Once registered the <code>Loader</code> will recieve an
    * immedidate update of the managers layout.
    * <p>
    * This throws a <code>SecurityException</code> if the caller
    * does not have the <code>LoaderPermission</code> with the 
    * "update" token. This ensures that any <code>Loader</code>        
    * instances from an untrusted codebase cannot register.
    *    
    * @param loader this is the <code>Loader</code> object that 
    * will recieve updates on state changes
    *
    * @exception SecurityException if the caller does not have 
    * the permission to register the <code>Loader</code>
    */
   public synchronized void update(String name, Loader loader){
      SecurityManager manager = System.getSecurityManager();
      if(manager != null){
         manager.checkPermission(new LoaderPermission("update"));
      }    
      delegate.add(name, loader);
      delegate.update(profile);
   }

   /**
    * This is used to terminate updates on a <code>Loader</code> 
    * object which has previously registered for updates. If the
    * <code>Loader</code> wishes to resume updates it must 
    * register again using the <code>update</code> method.
    * <p>
    * This throws a <code>SecurityException</code> if the caller
    * does not have the <code>LoaderPermission</code> with the 
    * "update" token. This ensures that any <code>Loader</code>        
    * instances from an untrusted codebase cannot remove objects
    * that have registered.
    *    
    * @param name this is the name of the <code>Loader</code> 
    * that is terminating updates
    *
    * @exception SecurityException if the caller does not have 
    * the permission to register the <code>Loader</code>
    */  
   public synchronized void remove(String name) {
      SecurityManager manager = System.getSecurityManager();
      if(manager != null){
         manager.checkPermission(new LoaderPermission("update"));
      }    
      delegate.remove(name);
   }

   /**
    * This loads the class into the system. This will attempt to
    * locate and load the byte codes for a <code>Resource</code>
    * implementation identified by the class name. If the class
    * can not be loaded <code>ClassNotFoundException</code> is
    * thrown. The fully qualified package name must be given.
    * <p>
    * Once the <code>Service</code> class has been loaded it is
    * used to create an instance. This instance can then have 
    * links established to it. The link is created using the 
    * unique name of the instance specified and a wild pattern.
    *
    * @param name this is the unique name given to the instance
    * @param className the fully qualified service class name
    *
    * @exception LoadingException thrown if the class cannot be
    * located or loaded
    */
   public synchronized void load(String name, String className)
      throws LoadingException{
      load(name, className, new Object[]{});
   }
   
   /**
    * This loads the class into the system. This will attempt to
    * locate and load the byte codes for a <code>Resource</code>
    * implementation identified by the class name. If the class
    * can not be loaded <code>ClassNotFoundException</code> is
    * thrown. The fully qualified package name must be given.
    * <p>
    * Once the <code>Service</code> class has been loaded it is
    * used to create an instance. This instance can then have 
    * links established to it. The link is created using the 
    * unique name of the instance specified and a wild pattern.
    *
    * @param name this is the unique name given to the instance
    * @param className the fully qualified service class name
    * @param data this is a parameter used for initialization
    *
    * @exception LoadingException thrown if the class cannot be
    * located or loaded
    */
   public synchronized void load(String name, String className, Object data)
      throws LoadingException{
      load(name, className, new Object[]{data});
   }

   /**
    * This loads the class into the system. This will attempt to
    * locate and load the byte codes for a <code>Resource</code>
    * implementation identified by the class name. If the class
    * can not be loaded <code>ClassNotFoundException</code> is
    * thrown. The fully qualified package name must be given.
    * <p>
    * Once the <code>Service</code> class has been loaded it is
    * used to create an instance. This instance can then have 
    * links established to it. The link is created using the 
    * unique name of the instance specified and a wild pattern.
    * This method also allows an object to be issued to the new
    * service instance for configuration purposes.
    *
    * @param name this is the unique name given to the instance
    * @param className the fully qualified service class name
    * @param data the configuration objects used by the service
    *
    * @exception LoadingException thrown if the class cannot be 
    * located or loaded
    */  
   public synchronized void load(String name, String className, Object[] data)
      throws LoadingException {
      SecurityManager manager = System.getSecurityManager();
      if(manager != null){
         manager.checkPermission(new LoaderPermission("load"));
      } 
      Service service = registry.load(name, className);            
      service.prepare(this, data);
      delegate.update(profile);   
   }

   /**
    * When an instance has been loaded by the <code>load</code>
    * method this can be used to purge it from the system and
    * subsequently remove all links to it. If the class name
    * specified does not correspond to a <code>Service</code>
    * that had be previously loaded this will return quietly.
    * The fully qualified package name must be given.
    *
    * @param name this is the name of the service object
    */
   public synchronized void unload(String name) {
      SecurityManager manager = System.getSecurityManager();
      if(manager != null){
         manager.checkPermission(new LoaderPermission("load"));
      }    
      Match[] list = resolver.getMatches();             
      for(int i = 0; i < list.length; i++){               
         if(list[i].getMatch().equals(name)){
            resolver.remove(list[i]);            
         }
      }
      registry.remove(name);
      delegate.update(profile);
   }   
   
   /** 
    * This is used to link a <code>Service</code> to a wild card 
    * pattern. The <code>Service</code> can be linked using the 
    * patterns '*' and '?'. This will enable the resource to be 
    * isolated using a string that matches the suggested pattern.
    * <p>
    * Patterns can take the form of a string with wild characters 
    * embedded in it, for instance "*.html". Also if the class 
    * name does not belong to a previously loaded
    * <code>Service</code> this should return quietly.
    * <p>
    * This throws a <code>SecurityException</code> if the caller
    * does not have the <code>LoaderPermission</code> with the 
    * "link" action. This ensures that any <code>Service</code>        
    * instances loaded from an untrusted codebase cannot change
    * the configuration settings.
    *
    * @param pattern this is a wild string used for matching
    * @param name this is the <code>Service</code> that will be
    * identified by the pattern
    *
    * @exception SecurityException if the caller does not have 
    * the permission to link the pattern   
    */   
   public synchronized void link(String pattern, String name){
      SecurityManager manager = System.getSecurityManager();
      if(manager != null){
         manager.checkPermission(new LoaderPermission("link"));
      }  
      if(registry.contains(name)) {
         resolver.insert(pattern, name);
         delegate.update(profile);
      }    
   }
   
   /** 
    * This is used to link a <code>Service</code> to a wild card 
    * pattern. The <code>Service</code> can be linked using the 
    * patterns '*' and '?'. This will enable the resource to be 
    * isolated using a string that matches the suggested pattern.
    * <p>
    * Patterns can take the form of a string with wild characters 
    * embedded in it, for instance "*.html". Also if the class 
    * name does not belong to a previously loaded
    * <code>Service</code> this should return quietly.
    * <p>
    * This throws a <code>SecurityException</code> if the caller
    * does not have the <code>LoaderPermission</code> with the 
    * "link" action. This ensures that any <code>Service</code>        
    * instances loaded from an untrusted codebase cannot change
    * the configuration settings.
    *
    * @param pattern this is a wild string used for matching
    * @param name this is the <code>Service</code> that will be 
    * identified by the pattern
    * @param pos the position within the list of patterns to add
    * the new match    
    *
    * @exception SecurityException if the caller does not have 
    * the permission to link the pattern    
    */
   public synchronized void link(String pattern, String name, int pos){
      SecurityManager manager = System.getSecurityManager();
      if(manager != null){
         manager.checkPermission(new LoaderPermission("link"));
      }  
      if(registry.contains(name)) {
         resolver.insert(pattern,name,pos);
         delegate.update(profile);
      }      
   }
      
   /**
    * This is used to unlink a loaded <code>Service</code> that
    * was linked to the specified pattern. If that pattern was 
    * not used to match a <code>Service</code> then this returns
    * quietly.
    * <p>
    * This throws a <code>SecurityException</code> if the caller
    * does not have the <code>LoaderPermission</code> with the 
    * "link" action. This ensures that any <code>Service</code>        
    * instances loaded from an untrusted codebase cannot change 
    * the configuration settings.    
    *
    * @param pattern this is a wild string used for matching
    *
    * @exception SecurityException if the caller does not have 
    */
   public synchronized void unlink(String pattern) {
      SecurityManager manager = System.getSecurityManager();
      if(manager != null){
         manager.checkPermission(new LoaderPermission("link"));
      } 
      if(resolver.contains(pattern)){
         resolver.remove(pattern);
         delegate.update(profile);
      }
   }

   /**
    * This is used to unlink a loaded <code>Service</code> that
    * was linked to the specified match. If that pattern was 
    * not used to match a <code>Service</code> then this returns
    * quietly.
    * <p>
    * This throws a <code>SecurityException</code> if the caller
    * does not have the <code>LoaderPermission</code> with the 
    * "link" action. This ensures that any <code>Service</code>        
    * instances loaded from an untrusted codebase cannot change 
    * the configuration settings.    
    *
    * @param match this is the pattern match to remove from this
    *
    * @exception SecurityException if the caller does not have 
    */
   public synchronized void unlink(Match match) {
      SecurityManager manager = System.getSecurityManager();
      if(manager != null){
         manager.checkPermission(new LoaderPermission("link"));
      } 
      if(resolver.contains(match)){      
         resolver.remove(match);
         delegate.update(profile);
      }   
   }
   
   /**
    * This will look for and retrieve the requested resource. The 
    * target given must be the actual name for the resource. This 
    * will locate the resource and return the <code>Resource</code>
    * implementation that will handle the target. 
    * <p>
    * If the named service does not corrospond to a previously
    * loaded service then this will return a resource object that
    * will report the appropriate HTTP status and description. 
    *
    * @param name this is than name of the service to retrieve
    *
    * @return the service implementation that has been retrieved
    */
   public synchronized Resource lookup(String name) {
      if(registry.contains(name)) {
         return registry.retrieve(name);
      }
      return new Delegate(context);
   }
   
   /**
    * This will look for and retrieve the requested resource. The 
    * target given must be in the form of a request URI. This will
    * locate the resource and return the <code>Resource</code>
    * implementation that will handle the target. 
    * <p>
    * The path will be matched with a pattern that was linked to a 
    * <code>Resource</code> object. This uses <code>Resolver</code> 
    * to match the target with the <code>Resource</code>. This will
    * thus match on priority of last entry. So if a resource can 
    * match two or more patterns then the last entered pattern
    * is the one that resolves the <code>Resource</code>. 
    * <p>
    * This will attempt to resolve the path given without striping
    * the query of parameters. If the link does not accomodate for
    * paths with querys or parameters the resolver will skip past
    * the match. Some default * link should be made so that if all
    * links fail there is some fallback resource.
    *
    * @param target the URI style path that represents the target 
    * <code>Resource</code>
    *
    * @return this returns the <code>Resource</code> object to
    * handle the desired target
    */    
   public synchronized Resource resolve(String target) {
       String path = context.getRequestPath(target);
       String name = resolver.resolve(path);

      if(registry.contains(name)) {
         return registry.retrieve(name);
      }
      return new Delegate(context);
   }

   /**
    *  This <code>Delegate</code> is used as a replacement for an
    *  actual service that has been loaded. This implementation 
    *  is needed when a service that has been requested cannot be
    *  either found or resolved. It reports a HTTP 404 Not Found.    
    *
    *  @see simple.http.serve.Resource
    */  
   private class Delegate extends Component {

      /**
       * Constructor for the <code>Delegate</code> object. This
       * is basically used to generate the HTTP 404 Not Found
       * report, so that the client knows why a request failed.
       *
       * @param context this is the context of the loader engine
       */ 
      public Delegate(Context context) {
         this.context = context;
      }

      /**
       * This will generate a HTTP 404 Not Found error message
       * to indicate to the client that the requested service
       * cound not be found. This could be either due to the
       * face that it did not match a pattern, or because it did
       * match the name of a previously loaded service object.
       *
       * @param req the HTTP request object to be processed
       * @param resp the HTTP response object to be processed
       */ 
      public void process(Request req, Response resp) {
         handle(req, resp, new StatusReport(404));
      }
   }   

}
