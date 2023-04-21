/*
 * Mapper.java May 2003
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

/**
 * The <code>Mapper</code> is intended to provide a mapping from 
 * a URI path to a service. This enables objects to be referenced
 * when a specific path format is used. The encoding of the path 
 * is known by the implementation so that it can parse and extract 
 * a fully qualified package name for a Java class.   
 * <p>
 * The format of the path is specific to the implementation. The
 * object is responsible for its own format, which could be, for
 * example, a format similar to one of the following.
 * <code><pre>
 *
 *    /ServiceObject.class/path/index.html
 *    /prefix/file.html
 *    /path/bin/index.extension
 *
 * </pre></code>
 * The <code>getName</code> method is required to take a full
 * URI path, this cannot include the URI query, domain or port 
 * of a URI. This should use a normalized path such as the path
 * retrieved from <code>Context.getRequestPath</code> methods. 
 * This method will return the instance name for the service. 
 * The <code>getClass</code> method is required to take the 
 * service instance name and produce the fully qualified class
 * name for the service that is to be loaded.
 *
 * @author Niall Gallagher
 *
 * @see simple.http.load.MapperEngine
 */
public interface Mapper {
 
   /**
    * This method is used to determine the normalized path
    * of the issued URI path. Encoding a class name into the
    * request path means that the path will have to be modified
    * in some way. To ensure that the modified paths can be
    * used to reference local resources this method can be
    * used to extract the normalized path from the URI path.
    *
    * @param path this is the path that is to be converted
    *
    * @return returns the normalized resolved URI path part
    */
   public String getPath(String path);

   /**
    * This method is used to transform a path to a service name.
    * If the path cannot be converted to a service name then a
    * null is returned. The returned service name can then be
    * used to acquire the class name of the service object.
    *
    * @param path this is the path that is to be converted
    *
    * @return name of the service instance mapped to the path
    */
   public String getName(String path);   
   
   /** 
    * This method is used retrieve properties for a service by
    * using the service name. This will acquire the properties
    * if any for the named service instance. The properties will
    * contain zero or more name value pairs. If no properties
    * are associated with the service the instance returned
    * should be an empty map rather than a null object.
    *
    * @param name this is the name of the service instance
    *
    * @return returns a properties object for configuration
    */ 
   public Configuration getConfiguration(String name);

   /**
    * This method is used to acquire the fully qualified class
    * name from the service instance name. This method is used
    * only when the service instance cannot be previously
    * loaded and therfore needs to be instantiated using the
    * fully qualified class name for the service object.
    *
    * @param name this is the name of the service instance
    *
    * @return a fully qualified class name, null otherwise
    */
   public String getClass(String name);
}
