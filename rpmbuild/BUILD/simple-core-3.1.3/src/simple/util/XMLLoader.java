/*
 * XMLLoader.java May 2005
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

package simple.util;

import simple.util.xml.Node;
import simple.util.xml.Traverser;
import java.util.Properties;
import java.io.InputStream;

/**
 * The <code>XMLLoader</code> is used to parse a properties file 
 * in an XML format. For convinience, it can be useful to have
 * a set of properties specified in an XML format as it allows
 * for character encoding other than the traditional ISO-8859-1
 * to be used. This also allows a uniform format to be used for
 * configuration, as typically configuration files will be
 * specified in an XML format as it allows complex expressions. 
 *  
 * @author Niall Gallagher
 */ 
final class XMLLoader extends Traverser implements PropertyLoader {

   /**
    * This performs all the resolution for the URI paths.
    */
   private Properties table;

   /** 
    * Constructor for the <code>XMLLoader</code> object. This is 
    * used to load a set of properties from an XML configuration
    * file. The properties loaded using the <code>load</code> 
    * method will be inserted into the properties object issued.
    *
    * @param table this is the properties object to populate
    */ 
   public XMLLoader(Properties table){
      this.table = table;
   }
   
   /**
    * This will load the properties from the given stream. This
    * is used so that properties can be parsed from the provided
    * using the UTF-8 character set. If the stream cannot be 
    * read then there is an <code>Exception</code> thrown. 
    *
    * @param source this is XML properties stream to be loaded
    *
    * @exception Exception thrown if there is an I/O problem
    */ 
   public void load(InputStream source) throws Exception{
      parse(source, "utf-8");           
   }
   
   /**
    * This will load the properties from the given stream. This
    * is used so that a configuration file can be parsed from the 
    * provided stream using the issued charset. If the XML file
    * cannot be read an <code>Exception</code> is thrown. 
    *
    * @param source this is XML properties stream to be loaded
    * @param charset this enables the charset to be specified
    *
    * @exception Exception thrown if there is an I/O problem
    */    
   public void load(InputStream source, String charset) throws Exception{
      parse(source, charset);         
   }
   
   /**
    * This initializes the parser so that it can be used several
    * times. This clears any previous tokens extracted. This
    * ensures that when the next <code>parse(String)</code> is
    * invoked the list of matches used can be updated safely.
    */ 
   protected void start(){
      table.clear();           
   }

   /**
    * This is used to process the elements from the node object. This
    * is primarily interested in the entry elements. If the element
    * being processed is an entry node then this will delegate to
    * the <code>value</code> method. This is used to replace all of
    * the property tags within the value their respective properties.
    *
    * @param node the element node that is to be processed
    */
   protected void process(Node node) {
      String name = node.getName();

      if(name.equals("entry")) {
         entry(node);              
      }      
   }

   /**
    * This method will extract an entry XML tag from the provided
    * text. This expression must contain a key attribute and must
    * also contain a value to be extracted sucessfully. The node,
    * should look like the XML BNF expression described below.
    * <pre>
    * 
    *    parse = "&lt;entry" key "&gt;" *TEXT "&lt;/entry&gt;"
    *    key   = "key" "=" token
    *
    * </pre>
    * If the element does not contain text between the opening
    * and closing tags then the property will not be saved. Also
    * if the key attribute is null the entry is not committed.
    *
    * @param node the node that represents an XML entry element
    */    
   private void entry(Node node) {
      String name = node.getAttribute("key");

      if(name != null) {
         table.put(name, node.getProperty());      
      }         
   }
}
