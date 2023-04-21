/*
 * PropertyParser.java May 2005
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

import simple.util.parse.ParseBuffer;
import java.io.InputStreamReader;
import java.util.Properties;
import java.io.InputStream;
import java.io.Reader;

/**
 * The <code>PropertyParser</code> is used to load properties for
 * multiple formats. This is capable of loading the traditional
 * Java properties format, as well as other formats, such an XML.
 * The properties loaded by this are typically read using the
 * UTF-8 character set, which will accomodate international 
 * characters as well as those in the ISO-8859-1 character set.
 * <p> 
 * This identifies the format using the opening XML tag for well
 * formed XML documents. So if the file begins with &lt;?xml it
 * will be loaded in the XML format, otherwise the format used
 * is the traditional Java properties format.
 * 
 * @author Niall Gallagher
 */ 
class PropertyParser implements PropertyLoader {
 
   /**
    * This is used to accumulate the contents of the source.
    */        
   private ParseBuffer text;

   /**
    * This is the loader that can handle the standard format.
    */ 
   private PlainLoader plain;
   
   /**
    * This is the loader that can handle the XML format.
    */ 
   private XMLLoader xml;

   /**
    * Constructor for the <code>PropertyParser</code>. This is
    * used to populate a properties object from the specified 
    * source. The source can use the standard Java properties
    * format or an XML format, the format used is dependant on
    * whether the file contains the opening "&lt;?xml" token.
    *
    * @param table this is populated with the exteacted values
    */ 
   public PropertyParser(Properties table){
      this.plain = new PlainLoader(table);
      this.xml = new XMLLoader(table);      
      this.text = new ParseBuffer();
   }
  
   /**
    * This method is used to load the properties from the stream
    * provided. The charset used read the content is UTF-8, this
    * ensures that a large range of languages are supported. 
    * The <code>Properties</code> object is poplulated with the
    * values loaded and parsed from the specified source.
    * 
    * @param source the stream to load the properties data from
    *
    * @exception Exception thrown if there is an I/O problem 
    */  
   public void load(InputStream source) throws Exception{
      load(source, "utf-8");           
   }
   
   /**
    * This method is used to load the properties from the stream
    * provided. The charset used can be specified, which allows
    * charsets other than UTF-8 to be used for the properties.
    * The <code>Properties</code> object is poplulated with the
    * values loaded and parsed from the specified source.
    * 
    * @param source the stream to load the properties data from
    * @param charset this is the charset used by the properties
    *
    * @exception Exception thrown if there is an I/O problem 
    */    
   public void load(InputStream source, String charset) throws Exception{
      load(new InputStreamReader(source, charset));
   }
   
   /**
    * This method is used to load the properties from the reader
    * provided. The reader will buffer the contents before the
    * format of the properties is determined. Once the format 
    * has been establised the properties is parsed from the text
    * accumulated within the bufer, the format can be in XML or
    * the traditional ISO-8859-1 Java properties format.
    * 
    * @param source the reader to load the properties data from
    *
    * @exception Exception thrown if there is an I/O problem 
    */   
   private void load(Reader source) throws Exception{
      char[] buf = new char[64];

      while(true){
         int num = source.read(buf);
         if(num < 0){
            break;
         }
         text.append(buf,0,num);
      }
      parse(text);
   }
  
   /**
    * This method is used to parse the loaded properties text. If
    * the format is understood and can be parsed correctly the 
    * provided <code>Properties</code> obejct is populated with
    * the values extracted. If format is not understood then the
    * properties object will be empty and this returns quietly.
    *
    * @param text this contains the source for the properties
    */  
   private void parse(ParseBuffer text) throws Exception{
      if(text.length() > 0){           
         parse(text.toString());
      }
      text.clear();
   }
   /**
    * This method is used to parse the loaded properties text. If
    * the format is understood and can be parsed correctly the 
    * provided <code>Properties</code> obejct is populated with
    * the values extracted. If format is not understood then the
    * properties object will be empty and this returns quietly.
    * The format for the properties is determined using the XML
    * opening tag for well formed documents, "&lt;?xml".
    *
    * @param source this contains the source for the properties
    */ 
   private void parse(String source) throws Exception{
      if(source.startsWith("<?xml ")){         
         xml(source);              
      } else {
         plain(source);              
      }
   }
   /**
    * This method is used to parse the loaded properties text. If
    * the format is understood and can be parsed correctly the 
    * provided <code>Properties</code> obejct is populated with
    * the values extracted. If format is not understood then the
    * properties object will be empty and this returns quietly.
    *
    * @param source this contains the source for the properties
    */ 
   private void plain(String source) throws Exception{
      plain.parse(source);           
   }
   
   /**
    * This method is used to parse the loaded properties text. If
    * the format is understood and can be parsed correctly the 
    * provided <code>Properties</code> obejct is populated with
    * the values extracted. If format is not understood then the
    * properties object will be empty and this returns quietly.
    *
    * @param source this contains the source for the properties
    */ 
   private void xml(String source) throws Exception{
      xml.parse(source);           
   }
}
