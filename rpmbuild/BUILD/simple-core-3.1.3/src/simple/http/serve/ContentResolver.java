/*
 * ContentResolver.java February 2004
 *
 * Copyright (C) 2004, Niall Gallagher <niallg@users.sf.net>
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

import simple.util.xml.Node;
import simple.util.xml.Traverser;
import simple.util.Resolver;
import java.io.File;

/**
 * The <code>ContentResolver</code> is used to resolve a path to 
 * a specified MIME type using a pattern. The mappings used are
 * acquired from the <code>content.xml</code> XML file, which is
 * located using an instance of the <code>Locator</code> object.
 * <p> 
 * This is used to implement a method, which allows a specific 
 * target to be matched to a MIME type without having to rely on
 * the extension of the resource. For example, "index.xml" has
 * the extenstion "xml" which would typiclly resolve to the MIME
 * type "text/xml", however this type may not be desirable if 
 * the file was transformed to a type of "text/html" using XSLT. 
 *
 * @author Niall Gallagher
 *
 * @see simple.util.Resolver
 */
final class ContentResolver extends Traverser{

   /**
    * This performs all the resolution for the target paths.
    */
   private Resolver list;

   /**
    * This will determine if any patterns were loaded.
    */ 
   private int size;
   
   /**
    * Constructor for the <code>ContentResolver</code>. This uses
    * a configuration file located with the <code>Locator</code>
    * object supplied. Once the configuration file is located it 
    * is parsed and the patterns extracted are used to resolve 
    * the target paths to the matching MIME type.
    *
    * @param lookup the locator used to find the configuration
    */
   public ContentResolver(Locator lookup){
      this.list = new Resolver();
      this.init(lookup);
   }
   
   /** 
    * This will attempt to acquire an XML configuration file that 
    * is used to resolve target URI paths to their MIME types. The 
    * configuration file is located using the <code>Locator</code>
    * supplied. This will search for the configuration file using 
    * the names "Content.xml" and "content.xml".
    *    
    * @param lookup the locator used to find the configuration
    */   
   private void init(Locator lookup) {
      try {
         load(lookup);
      }catch(Exception e){
         return;
      }
   }
   
   /** 
    * This <code>load</code> method attempts to load the XML file
    * file <code>Content.xml</code> using the given locator. If 
    * the XML configuration file exists then it is used to resolve 
    * the specified MIME types from various target paths given.
    * <p>
    * This will attempt to load the file using the UTF-8 charset
    * so that international characters can be used for patterns 
    * that can be used. This is compatible with the traditional
    * Java properties format which used the ISO-8859-1 charset.
    *
    * @param lookup this is the locator used to discover the file
    *
    * @exception Exception thrown if there is an I/O problem
    */   
   private void load(Locator lookup) throws Exception {
      try {
         load(lookup,"content.xml");
      }catch(Exception e) {
         load(lookup,"Content.xml");
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
    * This performs the resolution using the loaded configuration
    * file. This uses the <code>simple.util.Resolver</code> to
    * determine whether a wild card pattern matches a specified
    * path. If a match is found the MIME type is returned.
    * <p>
    * For example, if a pattern such as <code>*.xml</code> was
    * loaded with the value <code>text/html</code> then paths
    * such as <code>/path/file.xml</code> would be resolved to
    * that MIME type. For details of how the resolving is done
    * see the <code>simple.util.Resolver</code> object.
    *
    * @param path this is the path that is to be resolved
    *
    * @return the MIME type that is resolved from the path
    */
   public String getContentType(String path) {
      if(size <= 0) {
         return null;
      }
      return list.resolve(path);
   } 
   
   /**
    * This initializes the parser so that it can be used several
    * times. This clears any previous tokens extracted. This
    * ensures that when the next <code>parse(String)</code> is
    * invoked the list of patterns used can be updated safely.
    */ 
   protected void start(){
      list.clear();
   }

   /**
    * This method is used to process the resolve elements from the
    * node object. If the element is a resolve node then this will
    * delegate to the <code>resolve</code> method, which will 
    * save the match and type within the internal resolver object.
    * 
    * @param node this is a node extracted from the node object
    */ 
   protected void process(Node node){
      String name = node.getName();
      
      if(name.equals("resolve")) {
         resolve(node);              
      }      
   }
   
   /**
    * This method will extract a series of match XML tags from a 
    * content block from the element node. This method requires
    * that there is a valid match and type attribute. The BNF for
    * the resolve element is shown below.
    * <pre> 
    * 
    *    parse   = *(resolve) "&lt;" "/" "content" "&gt;"
    *    resolve = "&lt;" "resolve" match type "/" "&gt;"
    *    match   = "match" "=" token
    *    type    = "type" "=" token
    *
    * </pre>
    * If there are no elements this will exit straight away and 
    * the resolver created will contain no data. Also, this is
    * capable of extracting XML comments and unkown tags.
    *
    * @param node this is a resolve node from the node object
    */ 
   private void resolve(Node node) {
      String match = node.getAttribute("match");
      String type = node.getAttribute("type");

      if(match != null) {      
         list.insert(match, type);
      }         
   }

   /**
    * Once all the resolve elements have been evaluated this will
    * be used to commit the configuration. This method is used to
    * acquire the number of elements that be be sucessfully read.
    * If the size is larger than zero the resolver is validated.
    */ 
   protected void finish() {
      size = list.size();
   }
}
