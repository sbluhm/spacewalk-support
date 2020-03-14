/*
 * PlainLoader.java May 2005
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

import simple.util.parse.PropertyBuffer;
import simple.util.parse.ParseBuffer;
import simple.util.parse.Parser;
import java.io.InputStreamReader;
import java.util.Properties;
import java.io.InputStream;
import java.io.Reader;

/**
 * The <code>PlainLoader</code> is used to load properties in the
 * standard format. This loader is capable of loading properties
 * using the standard Java properties format, however this will
 * read the contents using the UTF-8 charset by default. This is
 * done so that internationalized content can be added easily. 
 * 
 * @author Niall Gallagher
 *
 * @see simple.util.PropertyLoader
 */
final class PlainLoader extends Parser implements PropertyLoader{
        
   /**
    * Used to consume the characters for the value token.
    */
   private PropertyBuffer value;

   /**
    * Used to store the contents of the Java properties.
    */
   private ParseBuffer text;

   /**
    * Used to consume the characters for the name token.
    */
   private ParseBuffer name;

   /**
    * This is the table that will be populated by this.
    */
   private Properties table;

   /** 
    * Constructor for the <code>PlainLoader</code> object. This 
    * is used to load a set of properties from an Java properties
    * stream. The properties loaded using the <code>load</code> 
    * method will be inserted into the properties object issued.
    *
    * @param table this is the properties object to populate
    */    
   public PlainLoader(Properties table){
      this.value = new PropertyBuffer();           
      this.name = new ParseBuffer();
      this.text = new ParseBuffer();
      this.table = table;
   }

   /**
    * This will parse the properties from the issued stream. This
    * is used so that the Java properties can be parsed from the 
    * specified stream using the UTF-8 charset. If the properties 
    * stream cannot be read an <code>Exception</code> occurs. 
    *
    * @param source this is Java properties stream to be loaded
    *
    * @exception Exception thrown if there is an I/O problem
    */
   public void load(InputStream source) throws Exception{
      load(source, "utf-8");
   }

   /**
    * This will parse the properties from the given stream. This
    * is used so that a Java properties can be parsed from the 
    * stream using the charset specified. Typiclly the charset
    * will be UTF-8 as it is compatable with ISO-8859-1.
    *
    * @param source this is Java properties stream to be loaded 
    * @param charset this enables the charset to be specified
    *
    * @exception Exception thrown if there is an I/O problem
    */
   public void load(InputStream source, String charset) throws Exception{
      load(new InputStreamReader(source, charset));
   }

   /**
    * This will parse the properties from the given reader. This
    * is used so that a Java properties can be parsed from the 
    * reader and buffered so that it can be parsed as a single
    * sequence of characters.
    *
    * @param source this is the reader that has the properties
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
    * This is a simple convinience method that delegates to
    * the <code>parse(String)</code> method. This is used 
    * because the stream is read in chunks from the properties
    * source using the UTF-8 charset and the length is unknown.
    *
    * @param text contains the Java properties text to parse
    * */
   private void parse(ParseBuffer text){
      parse(text.toString());
   }

   /**
    * This initializes the parser so that it can be used several
    * times. This clears any previous tokens extracted. This
    * ensures that when the next <code>parse(String)</code> is
    * invoked the list of matches used can be updated safely.
    */ 
   protected void init(){
      table.clear();
      name.clear();
      value.clear();
      text.clear();
   }

   /**
    * This will parse the Java properties text line by line. This
    * ensures that all comments are ignored. A comment is any 
    * line that begins with a '!' or '#' character. These comment
    * characters may appear in a name value as long as it is not
    * the first character. Values are seperated from names with
    * an '=' or ':' character.
    */
   protected void parse(){
      while(off < count){
         char ch = buf[off];
         
         if(comment(ch)){
            line();
         }else {
            entry();
         }
      }
   }

   /**
    * This will simply skip a line from the Java properties text
    * checking for a carrage return or line feed character. The
    * use of either to terminate a line is supported, this will
    * enable *NIX and Windows platforms to work equally well.
    */
   private void line(){
      while(off < count){
         char ch = buf[off++];

         if(terminal(ch)){
            break;
         }
      } 
   }

   /** 
    * This is an expression that is used by a Java properties text
    * to specify a property name and value. This will enable the
    * name and value to be extracted as a one line expression that
    * is seperated by an equal character, which is '=' or ':'.
    * <p>
    * This will only consider parameters that have values greater
    * than zero, this means that null values will never be used
    * to define a property to be inserted in to the table.
    */
   private void entry(){
      name();
      if(skip("=")){
         value();
      }else if(skip(":")){
         value();
      }
      insert();
   }

   /**
    * This method adds the name and value in to the table so 
    * that the next name and value can be collected. The name and
    * value are added to the map as string objects. Once inserted
    * in to the table <code>ParseBuffer.clear</code> is used
    * so the they can be reused to collect further values. 
    */
   private void insert(){
      if(value.length() > 0){
         insert(name,value);
      }
      name.clear();
      value.clear();
   }

   /**
    * This will insert the given name and value to the table.
    * The value is stored in the table as a string that is
    * trimmed to have no trailing or leading whitespace data 
    * as is specified by the Java properties description.
    *
    * @param name this is the name of the value to be inserted
    * @param value this is the value of a that is to be inserted
    */
   private void insert(ParseBuffer name, ParseBuffer value){
      insert(name.toString(), value.toString());
   }

   /**
    * This will insert the given name and value to the table.
    * The value is stored in the table as a string that is
    * trimmed to have no trailing or leading whitespace data 
    * as is specified by the Java properties description.
    *
    * @param name this is the name of the value to be inserted
    * @param value this is the value of a that is to be inserted
    */
   private void insert(String name, String value) {
      table.put(name.trim(), value.trim());
   }

   /**
    * This extracts the name from the Java properties text. This
    * will basically ready any text up to the first occurance of
    * an equal character or a terminal. If an equal character is
    * extracted is is put back so that it is the next one read.
    */
   private void name(){
      while(off < count){
         char ch = buf[off++];
         
         if(terminal(ch)){
            break;
         }else if(equal(ch)){
            off--;
            break;
         }
         name.append(ch);
      }
   }

   /**
    * This extracts the value from the Java properties text. This
    * will basically ready any text up to the first occurance of
    * an equal of a terminal. If a terminal character is read
    * this returns without adding the terminal to the value.
    */
   private void value(){
      while(off < count){
         char ch = buf[off++];

         if(terminal(ch)){
            break;
         }
         value.append(ch);
      }
   }

   /**
    * This is used to determine the line terminal for the Java
    * properties text. Terminal are either the carrage return or
    * line feed characters, '\r' and '\n' respectively.
    *
    * @param ch this is the character that is to be examined
    *
    * @return true if the character is Java properties terminal    
    */
   private boolean terminal(char ch){
      return ch =='\r' || ch == '\n';  
   }

   /**
    * This is used to determine the line comments for the Java
    * properties text. Comments are lines that begin with either
    * the hash or exclamation characters, which are '#' or '!'.
    *
    * @param ch this is the character that is to be examined
    *
    * @return true if the character is Java properties comment
    */
   private boolean comment(char ch){
      return ch =='#' || ch == '!';
   }

   /**
    * This is used to determine the line comments for the Java
    * properties text. Comments are lines that begin with either
    * the equal or colon characters, which are '=' or ':'.
    *
    * @param ch this is the character that is to be examined
    *
    * @return true if the character is Java properties equal
    */
   private boolean equal(char ch){
      return ch =='=' || ch == ':';
   }
}
