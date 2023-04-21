/*
 * Block.java May 2005
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

package simple.util.xml;

import simple.util.parse.PropertyBuffer;
import org.kxml2.kdom.Element;

/**
 * The <code>Block</code> object provides an implementation of the
 * element wrapping node object. This wraps a KDOM element in such a
 * way that its attributes and details cab be acquired and examimed
 * easily. The primary convinience of this object is that it can
 * transform attribute and text values with the system properties.
 * 
 * @author Niall Gallagher
 *
 * @see simple.util.parse.ParseBuffer
 */ 
final class Block implements Node {

   /**
    * This is used to transform values with system properties.
    */         
   private PropertyBuffer parser;

   /**
    * This is the element that this block instance is wrapping.
    */ 
   private Element node;

   /**
    * This is the name of the element that this is wrapping.
    */ 
   private String name;
        
   /**
    * Constructor for the <code>Block</code> object. This is used to
    * create a block instance that will wrap the provided element.
    * The provided element is used to provide the attributes and 
    * text values for this block instance.
    * 
    * @param node this is the element that this instance will wrap
    */ 
   public Block(Element node) {
      this(node, node.getName());           
   }        

   /**
    * Constructor for the <code>Block</code> object. This is used to
    * create a block instance that will wrap the provided element.
    * The provided element is used to provide the attributes and 
    * text values for this block instance.
    * 
    * @param node this is the element that this instance will wrap
    * @param name this is the name of the element object provided
    */    
   public Block(Element node, String name) {
      this.parser = new PropertyBuffer();           
      this.node = node;
      this.name = name;
   }      

   /**
    * This method is used to provide the source element that this
    * object wraps. This is provided so that should the traverser
    * implementation wish to acquire details not provided by 
    * the <code>Node</code> object it can do so.
    *
    * @return this provides the source element that this wraps 
    */     
   public Element getElement() {
      return node;
   }

   /**
    * This is used to transform the value provided with properties
    * set within the <code>System</code> object. This is used so that
    * the attributes and text values within the element can have the
    * system properties set within their string values. For example
    * an attribute could have the value "${java.home}/lib/tools.jar"
    *
    * @param text the value to be transformed with system properties
    *
    * @return this is the value transformed from the text value
    */ 
   protected String getTransform(String text) {
      try {           
         if(text != null) {
            parser.append(text);              
         }    
         return parser.toString();
      }finally {
         parser.clear();              
      }      
   }   

   /**
    * This method is used to acquire an attribute from the wrapped
    * element object. If the element does not exist within the
    * node then this will return null, otherwise its string value.
    *
    * @param name this is the element attribute name to acquire
    *
    * @return this is the string value of the named attribute
    */    
   public String getAttribute(String name) {
      return node.getAttributeValue(null, name);           
   }

   /**
    * This method is used to acquire a transformed value for the
    * named attribute. This will will acquire the named attribute
    * and transform all occurances of "${property}" with its
    * value from the set <code>System<code> properties.
    *
    * @param name this is the element attribute name to acquire
    *
    * @return this is the transformed value of the attribute
    */ 
   public String getProperty(String name) {
      String text = null;
      
      if(name != null) {
         text = getAttribute(name);                       
      }           
      return getTransform(text);
   }           

   /**
    * This is used to acquire the string value for the element text.
    * If there is no text value within the element then this will
    * return null. The <code>getProperty<code> can be used instead.
    *
    * @return this returns the raw string value for the text
    */    
   public String getText() {
      return node.getText(0);           
   }

   /**
    * This is used to acquire the transformed value of a text 
    * element. This will acquire the element block and transform 
    * all occurances of "${property}" with its value from the set
    * <code>System<code> properties, or null if the text is null.
    *
    * @return this returns the transformed value of the text
    */ 
   public String getProperty() {
      String text = getText();

      if(text != null) {
         return getTransform(text);              
      }
      return text;
   }

   /**
    * This method is used to acquire the name of the element that
    * this <code>Node</code> instance wraps. This is used to that 
    * the traverser can determine how to handle the node object.
    *
    * @return this returns the name of the element this wraps
    */ 
   public String getName() {
      return name.toLowerCase();           
   }
   
   /**
    * This is used to check for the name of the element that this
    * node object wraps. This is used by the traverser to determine
    * what action is to be taken when processing the given node.
    *
    * @param name this is the name to be compared to the element
    *
    * @return this returns true if the element name matches
    */      
   public boolean isName(String text) {
      return name.equalsIgnoreCase(text);
   }

   /**
    * This method is used to determine the type of node this object
    * represents. Typically an element is a usable XML element, 
    * however it can be a CDATA block or an XML comment block.
    *
    * @return this returns true if this is not an XML comment
    */ 
   public boolean isElement() {
      return true;           
   }
}
