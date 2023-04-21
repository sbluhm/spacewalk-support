/*
 * PatternResolver.java May 2005
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

package simple.http.load;

import simple.util.xml.Node;
import simple.util.xml.Traverser;
import simple.util.Resolver;
import simple.http.serve.Locator;
import simple.util.Resolver;
import java.io.IOException;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map;
import java.io.File;

/**
 * The <code>PatternResolver</code> is used to extract service names
 * and types from an XML configuration file. Each service name can
 * be associated with match and prepare XML elements, which can be 
 * used to determine the URI targets used to locate the services 
 * and the properties that are be used to initialize the service.
 * <p> 
 * This is used to implement a scheme similar to the Java Servlet
 * wild card path mapping scheme. In this scheme a wild card text
 * string such as <code>*.html</code> are used to resolve targets.
 *
 * @author Niall Gallagher
 *
 * @see simple.util.Resolver
 */  
final class PatternResolver extends Traverser {

   /**
    * This is the configuration setup for a service instance.
    */ 
   private Configuration setup;
   
   /**
    * This is used to collect properties taken from the document.
    */         
   private Properties table;
   
   /**
    * This is used to resolve service instance names from paths.
    */ 
   private Resolver list;

   /**
    * This is used to store the properties for each service.
    */ 
   private Map data;
   
   /**
    * This is used to store the fully qualified class names.
    */ 
   private Map load;
   
   /**
    * Constructor for the <code>PatternResolver</code>. This uses
    * a configuration file located with the <code>Locator</code>
    * object supplied. Once the XML configuration file is located
    * it is parsed and the patterns extracted are used to resolve 
    * the URI paths to service instance names.
    *
    * @param lookup the locator used to find the configuration
    */
   public PatternResolver(Locator lookup) {
      this.setup = new Configuration();      
      this.table = new Properties();           
      this.list = new Resolver();  
      this.data = new HashMap();
      this.load = new HashMap();
      this.init(lookup);
            
   }
   
   /** 
    * This will attempt to acquire an XML configuration file that 
    * is used to resolve relative URI paths to service names. The 
    * configuration file is located using the <code>Locator</code>
    * supplied. This will search for the file using the names
    * "Mapper.xml" and "mapper.xml" in that sequence.
    *
    * @param lookup the locator used to find the configuration
    */   
   private void init(Locator lookup) {
      try {
         load(lookup);
      }catch(Exception e){
         e.printStackTrace();
      }
   }
   
   /** 
    * This <code>load</code> method attempts to load the XML file
    * file <code>Mapper.xml</code> using the given locator. If
    * the configuration file exists then it is used to describe
    * mappings used to load the service instances.
    * <p>
    * This will attempt to load the file using the UTF-8 charset
    * so that international characters can be used for patterns 
    * that can be used. This is compatible with ISO-8859-1.
    *
    * @param lookup this is the locator used to find the file
    *
    * @exception Exception thrown if there is an I/O problem
    */
   private void load(Locator lookup) throws Exception {
      try {
         load(lookup,"Mapper.xml");
      }catch(IOException e) {
         load(lookup,"mapper.xml");
      }
   }

   /**
    * This will load the named file from within the given path. This
    * is used so that a configuration file can be loaded by a locator
    * using the specified file name. If the XML configuration file
    * cannot be loaded this will throw an <code>Exception</code>. 
    *
    * @param lookup this is the locator used to discover the file
    * @param name this is the name of the configuration file loaded
    *
    * @exception Exception thrown if there is an I/O problem
    */
   private void load(Locator lookup, String name) throws Exception{
      parse(lookup.getFile(name), "utf-8");
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
      return (Configuration)data.get(name);           
   }
   
   /**
    * This method is used to retrieve the fully qualified class
    * name from the service instance name. This is provided such
    * that if a service has not been loaded, the class name can 
    * be retrieved from the service instance name, which will
    * enable the service to be loaded into the system from a URI
    * path provided with a HTTP request. If the service instance
    * name does not exist this method will return null.
    *
    * @param name this is the service instance being queried
    *
    * @return the fully qualified class name for the service
    */ 
   public String getClass(String name){     
      return (String)load.get(name);           
   }
   
   /**
    * This performs the resolution using the loaded configuration
    * file. This uses the <code>simple.util.Resolver</code> to
    * determine whether a wild card pattern matches a specified
    * URI path. If a match is found the service name is returned.
    * <p>
    * For example, if a pattern such as <code>*.vm</code> was
    * loaded with the value <code>example</code> then URI paths 
    * such as <code>/path/demo.vm</code> would be resolved to that
    * service name. For details of how the resolving is performed
    * see the <code>simple.util.Resolver</code> object.
    * 
    * @param path this is the URI path that is to be resolved
    *
    * @return the service name that is resolved from the path
    */
   public String getName(String path){
      return list.resolve(path);           
   }

   /**
    * This method is used to initialize this resolver. This will
    * clear out all data structures used in the parsing process. 
    * It is invoked before the <code>process</code> method is used.
    * to evaluate the element nodes extracted from the XML document.
    */ 
   protected void start(){
      setup.clear();           
      table.clear();
      load.clear();
      data.clear();
      list.clear();
   }
  
   /**
    * This is used to process an element node extracted from the XML
    * document. It will be given each element that exists within
    * the document. The elements of interest to this implementation
    * are the "property", "match", and "service" elements.
    *
    * @param node this is the node to be evaluated by this method
    */ 
   protected void process(Node node) {
      String name = node.getName();

      if(name.equals("match")) {
         match(node);              
      }
      if(name.equals("service")){
         setup.clear();              
         table.clear();              
      }
      if(name.equals("section")) {
         setup.putAll(table);
         table.clear();              
      }      
   }

   /**
    * This is used to commit any data that has been collected during
    * the processing of an element node. The elements of interest to
    * this method are the "service" and "property" elements. This
    * will save the properties collected for each "service" element.
    *
    * @param node this is the node to be committed by this method
    */ 
   protected void commit(Node node) {
      String name = node.getName();

      if(name.equals("service")) {
         service(node);              
      } 
      if(name.equals("property")) {
         property(node);              
      }
      if(name.equals("section")){
         section(node);              
      }      
   }

   /**
    * This method is used to add the collected properties into the
    * configuration using a section identity. This allows properties
    * to be grouped, which enables services to use certain property
    * values to perform specific configuration operations.
    *
    * @param node this is the node that represents a section 
    */ 
   private void section(Node node) {
      String name = node.getAttribute("id");

      if(name != null) {           
         setup.put(name, table.clone());
         table.clear();
      }
   }   

   /**
    * This method is used to save a service definition along with 
    * all properties collected for that service. This will collect
    * the "name" and "type" attributes from the "service" element
    * before saving all properties collected and then storing the
    * properties and type under the service "name" attribute.
    *
    * @param node this is the node that represents a service
    */ 
   private void service(Node node) {
      String name = node.getAttribute("name");
      String type = node.getAttribute("type");

      if(name != null) {
         setup.putAll(table);              
         data.put(name, setup.clone());
         load.put(name, type);              
      }         
   }
   
   /**
    * This is used to store the matches extracted from the document.
    * The attributes taken from the provided element are the "name"
    * and "path" attributes. The path represents the pattern used to
    * resolve to a specific service. The "name" attribute represents
    * an identifier for the service instance.
    *
    * @param node this represents a match element from the XML tree
    */ 
   private void match(Node node) {
      String name = node.getAttribute("name");
      String path = node.getAttribute("path");

      if(path != null){
         list.insert(path, name);
      }      
   }

   /**
    * This method will extract property XML tags from the provided
    * text. This expression must contain a key attribute and must
    * also contain a value to be extracted sucessfully. The node,
    * should look like the XML BNF expression described below.
    * <pre>
    * 
    *    node = "&lt;property" key "&gt;" *TEXT "&lt;/property&gt;"
    *    key  = "key" "=" token
    *
    * </pre>
    * If the element does not contain text between the opening
    * and closing tags then the property will not be saved. Also
    * if the key attribute is null the entry is not committed.
    *
    * @param node the node that represents a property element
    */     
   private void property(Node node) {
      String name = node.getAttribute("key");

      if(name != null) {
         table.put(name, node.getProperty());              
      }      
   }
}
