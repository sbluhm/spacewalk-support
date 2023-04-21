/*
 * Node.java May 2005
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

import org.kxml2.kdom.Element;

/**
 * The <code>Node</code> object acts as a wrapper for a KDOM element
 * that contains various convinience methods. In general this object
 * is preferred to the <code>org.kxml2.kdom.Element</code> object
 * for acquiring elements and text values. 
 * <p>
 * The primary convinience offered by the <code>Node</code> object is
 * the ability to acquire a transformed representation of eithier an
 * element text block or attribute. This provides property getters
 * which will transform "${property}" values with system properties.
 *  
 * @author Niall Gallagher
 *
 * @see simple.util.parse.PropertyBuffer
 */ 
public interface Node {

   /**
    * This method is used to provide the source element that this
    * object wraps. This is provided so that should the traverser
    * implementation wish to acquire details not provided by 
    * the <code>Node</code> object it can do so.
    *
    * @return this provides the source element that this wraps 
    */           
   public Element getElement();        

   /**
    * This method is used to acquire the name of the element that
    * this <code>Node</code> instance wraps. This is used to that 
    * the traverser can determine how to handle the node object.
    *
    * @return this returns the name of the element this wraps
    */ 
   public String getName();

   /**
    * This method is used to acquire an attribute from the wrapped
    * element object. If the element does not exist within the
    * node then this will return null, otherwise its string value.
    *
    * @param name this is the element attribute name to acquire
    *
    * @return this is the string value of the named attribute
    */ 
   public String getAttribute(String name);

   /**
    * This method is used to acquire a transformed value for the
    * named attribute. This will will acquire the named attribute
    * and transform all occurances of "${property}" with its
    * value from the set <code>System</code> properties.
    *
    * @param name this is the element attribute name to acquire
    *
    * @return this is the transformed value of the attribute
    */ 
   public String getProperty(String name);

   /**
    * This is used to acquire the transformed value of a text 
    * element. This will acquire the element block and transform 
    * all occurances of "${property}" with its value from the set
    * <code>System</code> properties, or null if the text is null.
    *
    * @return this returns the transformed value of the text
    */ 
   public String getProperty();
   
   /**
    * This is used to acquire the string value for the element text.
    * If there is no text value within the element then this will
    * return null. The <code>getProperty</code> can be used instead.
    *
    * @return this returns the raw string value for the text
    */ 
   public String getText();

   /**
    * This is used to check for the name of the element that this
    * node object wraps. This is used by the traverser to determine
    * what action is to be taken when processing the given node.
    *
    * @param name this is the name to be compared to the element
    *
    * @return this returns true if the element name matches
    */            
   public boolean isName(String name);           

   /**
    * This method is used to determine the type of node this object
    * represents. Typically an element is a usable XML element, 
    * however it can be a CDATA block or an XML comment block.
    *
    * @return this returns true if this is not an XML comment
    */ 
   public boolean isElement();
}




