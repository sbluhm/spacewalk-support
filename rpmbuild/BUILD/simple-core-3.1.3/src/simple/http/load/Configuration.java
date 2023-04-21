/*
 * Configuration.java May 2005
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

import java.util.Properties;

/**
 * The <code>Configuration</code> object is used to collect property
 * values for services loaded using the mapper engine. The mapper
 * engine uses an XML configuration file that allows properties to
 * be specified for a service instance. These properties can be 
 * grouped into named sections, this represents that structure.
 *
 * @author Niall Gallagher
 *
 * @see simple.http.load.MapperEngine
 */ 
public class Configuration extends Properties {

   /**
    * Constructor for the <code>Configuration</code> object. This
    * is used to create an empty configuration object. Property
    * values and sections can be added using setter methods.
    */ 
   public Configuration() {
      super();           
   }
        
   /**
    * Constructor for the <code>Configuration</code> object. This
    * is used to create a configuration object that copies the
    * details from the provided properties object. This can also
    * be used as a copy constructor.
    *
    * @param data this is a collection of properties to add
    */ 
   public Configuration(Properties data) {
      super(data);               
   }        

   /**
    * This is used to acquire the properties for a named section.
    * If the configuration does not contain the section then this
    * will return an empty set of properties rather than null.
    *
    * @param name this is the name of the section to acquire
    *
    * @return this returns the properties for the section
    */ 
   public Properties getSection(String name) {
      if(!this.containsKey(name)) {
         return new Properties();              
      }           
      return (Properties)get(name);            
   }
}
