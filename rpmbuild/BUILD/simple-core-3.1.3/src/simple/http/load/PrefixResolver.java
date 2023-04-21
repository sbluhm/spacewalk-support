/*
 * PrefixResolver.java July 2003
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

import simple.util.xml.Node;
import simple.util.xml.Traverser;
import simple.http.serve.Locator;
import simple.util.PriorityQueue;
import java.io.IOException;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.File;

/**
 * The <code>PrefixResolver</code> is used to extract service names
 * and types from an XML configuration file. Each service name can
 * be associated with match and prepare XML elements, which can be 
 * used to determine the URI targets used to locate the services 
 * and the properties that are be used to initialize the service. 
 * <p> 
 * This is used to implement a scheme similar to the Java Servlet
 * context path mapping scheme. In this scheme a prefix path is 
 * used to resolve a Servlet, and the remaining path part is then
 * used to acquire a resource relative the the Servlet context.
 *
 * @author Niall Gallagher
 */
public class PrefixResolver extends Traverser {
 
   /**
    * This is the configuration setup for a service instance.
    */ 
   private Configuration setup;
   
   /**
    * This is used to collect properties taken from the document.
    */         
   private Properties table;

   /**
    * This contains the paths ordered by length decreasing.
    */ 
   private String[] list;

   /**
    * This contains a list of offsets used for optimization.
    */
   private int[] skip;

   /**
    * This is used to store the properties for each service.
    */    
   private Map data;
   
   /**
    * This map contains the service name to class name pairs.
    */ 
   private Map load;
   
   /**
    * This map that contains the prefix to service name pairs.
    */
   private Map map;

   /**
    * Constructor for the <code>PrefixResolver</code>. This uses
    * a configuration file located with the <code>Locator</code>
    * object supplied. Once the configuration file is located the 
    * service names can be resolved for arbitrary URI paths.
    *
    * @param lookup the locator used to find the configuration
    */
   public PrefixResolver(Locator lookup) {
      this(lookup, 256);
   }
   
   /**
    * Constructor for the <code>PrefixResolver</code>. This uses
    * a configuration file located with the <code>Locator</code>
    * object supplied. Once the configuration file is located the 
    * service names can be resolved for arbitrary URI paths. 
    * <p>
    * This includes a parameter that enables a maximum expected
    * path length to be entered. This helps to optimize the
    * resolution of a path prefix. This should typically be at
    * least big enough to include the maximum possible path.
    *
    * @param lookup the object used to perform configuration
    * @param max this is the maximum path length expected
    */
   public PrefixResolver(Locator lookup, int max) {
      this.setup = new Configuration();
      this.table = new Properties();
      this.data = new HashMap();
      this.load = new HashMap();  
      this.map = new HashMap();           
      this.skip = new int[max];
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
    * so that international characters can be used for prefixes 
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
   public Configuration getConfiguration(String name) {
      return (Configuration)data.get(name);           
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
      return (String)load.get(name);
   }
   
   /**
    * Used to resolve the service name using a path prefix. This is
    * required to resolve the service name once the prefix of the
    * path is acquired from the <code>getPrefix</code> method. If
    * there is no match for the prefix then null is returned. 
    *
    * @param prefix the path prefix to acquire a service name for
    *
    * @return the service name that matches the prefix path given
    */  
   public String getName(String prefix){
      return (String)map.get(prefix);
   }

   /**
    * Used to get the prefix path for the given relative URI path,
    * which must be normalized. This will attempt to match the
    * start of the given path to the highest directory path. For
    * example, given the URI path <code>/pub/bin/README</code>,
    * the start of the path will be compared for a prefix. So it
    * should match <code>/pub/bin/</code>, <code>/bin/</code>,
    * and finally <code>/</code> in that order. 
    *
    * @param normal the normalized URI path to get a prefix for
    *
    * @return the highest matched directory for the given path
    */
   public String getPrefix(String normal) {
      int size = normal.length();
      int off = 0;
      
      if(size < skip.length){
         off = skip[size];
      }
      for(int i = off; i < list.length; i++){
         if(normal.startsWith(list[i])){
            return list[i];
         }
      }
      return "/";
   }

   /**
    * Used to acquire the path relative to the prefix. This will
    * return the path as it is relative to the prefix resolved 
    * for the given normalized path. This will remove the start
    * of the given normalized path if it matches a prefix path.
    *
    * @param normal the normalized URI path to get a path for
    *
    * @return the full path once its prefix has been removed 
    */
   public String getPath(String normal){
      String prefix = getPrefix(normal); 
      int size = prefix.length() - 1;
      
      return normal.substring(size);
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
      map.clear();
      data.clear();
   }

   /**
    * This is used to process a element node extracted from the XML
    * document. It will be given each element that exists within
    * the document. The elements of interest to this implementation
    * are the "property", "match", "section", and "service" elements.
    *
    * @param node this is the node to be evaluated by this method
    */   
   protected void process(Node node) {
      String name = node.getName();

      if(name.equals("match")) {
         match(node);              
      }
      if(name.equals("service")) {
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
    * and "path" attributes. The path represents the prefix used to
    * resolve to a specific service. The "name" attribute represents
    * an identifier for the service instance.
    *
    * @param node this represents a match element from the XML tree
    */
   private void match(Node node) {
      String name = node.getAttribute("name");           
      String path = node.getAttribute("path");

      if(path != null){
         map.put(path, name);
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

   /**
    * Used to prepare the prefix paths so that they can be matched
    * with relative URI paths quickly. The XML configuration file
    * used to specify the prefix paths with the service and class 
    * names will be loaded unordered into a <code>HashMap</code>.
    * This ensures the acquired keys are sorted for searching.
    */
   protected void finish() {
      index(map.keySet());
   }

   /**
    * Used to prepare the prefix paths so that they can be matched
    * with relative URI paths quickly. The XML configuration file
    * used to specify the prefix paths with the service and class 
    * names will be loaded unordered into a <code>HashMap</code>.
    * This ensures the acquired keys are sorted for searching. 
    *
    * @param set this contains the acquired keys to be sorted
    */
   private void index(Set set){
      list = new String[set.size()];
      set.toArray(list);
      prepare(list);
      sort(list);
      optimize(skip);
   }

   /**
    * This is used to prepare the prefix paths so that they all
    * end with the <code>/</code> character. If the prefix paths
    * within the XML configuration file do not correspond to a
    * directory path this will simply append a <code>/</code>.
    * For example if the configuration file was as follows.
    *
    * <pre>
    * &lt;resolve match="/demo" name="demo" type="demo.Demo"/&gt;
    * &lt;resolve match="/test/" name="test" type="test.Test"/&gt;
    * </pre>
    *
    * The prefix <code>/demo</code>, which does not end in the
    * <code>/</code> character, becomes <code>/path/</code>. 
    * This ensures that relative paths will be predictable.
    *
    * @param list this is the list of prefix paths to be fixed  
    */
   private void prepare(String[] list){
      for(int i = 0; i < list.length; i++){
         Object data = map.remove(list[i]);
         
         if(!list[i].endsWith("/")){
            list[i] += "/";
         }
         map.put(list[i],data);
      }
   }

   /**
    * This method is used to sort the list of strings by length. 
    * Sorting the strings by length is done so that the selection 
    * of a suitable path prefix will match the highest matching
    * directory. For example if <code>/path/bin/index.html</code>
    * was the path and the prefix paths loaded were as follows.
    *
    * <pre>
    *    "/path/"="package.PathService"
    *    "/path/bin/"="package.BinSerivce"
    *    "/path/doc/"="package.DocService"
    * </pre>
    *
    * Then the path prefix match should be the highest directory,
    * which would be <code>/path/bin/</code>. In order to make
    * the match rapidly then the paths should be searched in
    * order of length, so that when a prefix matches it is used.
    *
    * @param list contains the strings that are to be sorted
    */
   private void sort(String[] list){
      PriorityQueue queue = new PriorityQueue();

      for(int i = 0; i < list.length; i++){
         queue.add(list[i], list[i].length());
      }
      for(int i = 0; i < list.length; i++){
         list[i] = (String)queue.remove();
      }
   }

   /**
    * This method is used to optimize the searching for prefixes
    * by setting a list of offsets within a skip list. The skip
    * list contains an offset within each index. Each index in
    * the skip list corrosponds to a path length and the offset
    * within that index corrosponds to an offset into the list
    * of prefix paths. Setting up a skip list in this manner is
    * useful in determining where to start resolutions.
    * <p>
    * Taking the path <code>/pub/index.html</code> for example.
    * This path cannot possibly have a prefix path that has a
    * length larger than it, like <code>/pub/bin/example/</code>
    * as it is longer than it. So the skip list will basically
    * allow a path to determine how many prefixes it can skip
    * before the prefix size is less than or equal to its size.
    *
    * @param skip this is the list of offsets to be prepared
    */
   private void optimize(int[] skip) {
      int size = skip.length - 1; 
      int off = 0;
    
      while(off < list.length){
         if(list[off].length() < size){
            skip[size--] = off;
         }else {  
            while(off < list.length){
               if(list[off].length() < size) {               
                  break;
               }
               skip[size] = off++;
            }
            size--;
         }
      }
      while(size > 0){
         skip[size--] = off-1;
      }
   }
}
