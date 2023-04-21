/*
 * URLProperties.java December 2003
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
 
package simple.util;

import simple.util.PropertyParser;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/** 
 * The <code>URLProperties</code> object is used as a convienience
 * class that is used to create a <code>Properties</code> object
 * from a URL. This will automatically load the Java properties
 * file once instantiated. This is used so that the creation and 
 * use of a <code>java.util.Properties</code> file is much cleaner.
 *
 * @author Niall Gallagher
 */ 
public class URLProperties extends Properties {

   /**    
    * Used to load the properties from the specified file.
    */
   private PropertyParser parser;        

   /**
    * Constructor for the <code>URLProperties</code> object. The
    * constructor will use the specified URL as the contents of
    * its properties. The URL source must point to a valid Java
    * properties file, using a URL scheme such as HTTP or FTP.
    * For example "http://host/data.properties" will use HTTP.
    *
    * @param source this is the URL that contains the properties
    *
    * @exception IOException if the properties can not be loaded
    */
   public URLProperties(String source) throws IOException {
      this(new URL(source));
   }
   
   /**
    * Constructor for the <code>URLProperties</code> object. The
    * constructor will use the specified URL as the contents of
    * its properties. The URL source must point to a valid Java
    * properties file, using a URL scheme such as HTTP or FTP.
    * For example "http://host/data.properties" will use HTTP.
    *
    * @param source this is the URL that contains the properties
    *
    * @exception IOException if the properties can not be loaded
    */
   public URLProperties(URL source) throws IOException {
      this(source.openStream());
   }

   /**
    * Constructor for the <code>URLProperties</code> object. The
    * constructor will use the given <code>InputStream</code> to
    * load Java properties for this instance. This is used by the
    * other constructor methods to keep the object simple.
    *
    * @param source this is the URL that contains the properties
    *
    * @exception IOException if the properties can not be loaded
    */
   private URLProperties(InputStream source) throws IOException {
      this.parser = new PropertyParser(this);           
      this.load(source);
   }
   
   /**
    * This overloads the <code>Properties.load</code> so that XML
    * properties can be loaded as well as standard properties. 
    * Once this method is invoked the stream is examined to see
    * if the properties format is in XML. If the file is a valid
    * XML file then the properties are loaded int he XML format.
    * Otherwise they are loaded using the traditional format.
    *
    * @param source the stream that contains the properties
    */ 
   public synchronized void load(InputStream source) throws IOException{
      try {           
         parser.load(source);           
      }catch(Exception e) {
         throw new PropertyException(e);              
      }         
   }
}
