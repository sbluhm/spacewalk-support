/*
 * PrefixMapper.java July 2003
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

import simple.util.parse.URIParser;
import simple.http.serve.Context;
import simple.http.serve.Locator;
import simple.util.net.Path;
import simple.util.net.URI;

/**
 * The <code>PrefixMapper</code> provides a mapper that is used to
 * perform mapping using prefix paths. This provides a scheme like
 * the Servlet context mapping scheme. This <code>Mapper</code> 
 * allows arbitrary path configurations to be mapped directly to
 * a service name, which can be autoloaded to serve content.
 * <p>
 * This can break the URI path into four components, the prefix,
 * the service name, the class name, and the relative path. The 
 * prefix is the path part that is used to acquire the service 
 * name. A prefix is a URI directory, such as <code>/path/</code>,
 * which is unique. The relative path is the remaining path, after
 * the prefix is removed. So a path of <code>/path/bin/file</code> 
 * has the relative path of <code>/bin/file</code>.
 * <p>
 * The specification of prefix paths to service instance names is
 * done using the XML configuration file <code>Mapper.xml</code>.
 * This must is used by a <code>MapperEngine</code> to resolve
 * services to be loaded, and can also be used by the services to
 * acquire the location of resources using the relative paths.
 *
 * @author Niall Gallagher
 *
 * @see simple.http.load.MapperEngine
 */
public class PrefixMapper implements Mapper {

   /**
    * This determines the prefix for arbitrary URI paths.
    */
   private PrefixResolver resolver;

   /**
    * Constructor for the <code>PrefixMapper</code>. This is used
    * to create a <code>Mapper</code> that can be used to resolve
    * service instance names given an arbitrary URI path. This uses
    * a configuration file located using the <code>Context</code> 
    * object supplied with the context. The configuration file is
    * used to acquire the mappings for URI path to service names.
    *
    * @param context used to find the mapping configuration file
    */
   public PrefixMapper(Context context) {
      this(context.getLocator());
   }

   /**
    * Constructor for the <code>PrefixMapper</code>. This is used
    * to create a <code>Mapper</code> that can be used to resolve
    * service instance names given an arbitrary URI path. This uses
    * a configuration file located using the <code>Locator</code> 
    * object supplied with the context. The configuration file is
    * used to acquire the mappings for URI path to service names. 
    *
    * @param lookup used to find the mapping configuration file
    */
   private PrefixMapper(Locator lookup){
      this.resolver = new PrefixResolver(lookup);
   }
   
   /**
    * This method is used to acquire a path relative to the prefix
    * path. This will accept all HTTP URI formats, including an
    * absolute URI. However, the relative path is determined with
    * only the path part of the URI. If there is no mapping found
    * for the issued path the normalized path part is returned.
    *
    * @param path the HTTP URI to extract a relative path with
    *
    * @return the URI path relative to the resolved path prefix
    */
   public String getPath(String path){
      return resolver.getPath(path);
   }

   /**
    * This will resolve the service instance name given a URI path.
    * This will determine the service name by matching the URI with
    * the loaded prefix paths. If no match is found then this will
    * return null, otherwise the service instance name is returned.
    *
    * @param path the URI path to extract a relative path with
    *
    * @return this returns the service instance name thats matched
    */
   public String getName(String path){
      return resolver.getName(getPrefix(path));
   }

   /**
    * This will determine the prefix path that matches the given
    * URI path. The relative path is determined using the path
    * part of the URI. If no prefix is matched for the URI path
    * then this will return the root path, <code>/</code>.
    *
    * @param path the URI path to resolve a path prefix for
    *
    * @return this returns the prefix path that is resolved  
    */
   public String getPrefix(String path){
      return resolver.getPrefix(path);
   }

   /** 
    * This method is used retrieve properties for a service by
    * using the service name. This will acquire the properties
    * if any for the named service instance. The properties will
    * contain zero or more name value pairs. If no properties
    * are associated with the service the instance returned
    * will be an empty map rather than a null object.
    *
    * @param name this is the name of the service instance
    *
    * @return returns a properties object for configuration
    */ 
   public Configuration getConfiguration(String name){
      return resolver.getConfiguration(name);           
   } 
   
   /**
    * Used to resolve the class name using a service name. This is
    * required to resolve the class name once the service name has
    * been acquired from the <code>getName</code> method. If there
    * is no match for the service name then null is returned. 
    *
    * @param name this is the service name to get a class name for
    *
    * @return the class name that matches the service name given
    */ 
   public String getClass(String name){
      return resolver.getClass(name);           
   }
}
