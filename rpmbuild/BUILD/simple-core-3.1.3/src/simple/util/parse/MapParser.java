/*
 * MapParser.java February 2005
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

package simple.util.parse;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * The <code>MapParser</code> object represents a parser for name
 * value pairs. Any parser extending this will typically be parsing
 * name=value tokens or the like, and inserting these pairs into 
 * the internal map. This type of parser is useful as it exposes all
 * pairs extracted using the <code>java.util.Map</code> interface
 * and as such can be used with the Java collections framework. The
 * internal map used by this is a <code>Hashtable</code>, however
 * subclasses are free to assign a different type to the map used.
 * 
 * @author Niall Gallagher
 */ 
public abstract class MapParser extends Parser implements Map {

   /**
    * This is the internal map that provides storage for tokens.
    */         
   protected Hashtable map;        

   /**
    * Constructor for the <code>MapParser</code> object. This is 
    * used to create a new parser that makes use of a thread safe
    * map implementation. The <code>Hashtable</code> is used so
    * that the resulting parser can be accessed in a concurrent
    * environment with the fear of data corruption.
    */ 
   protected MapParser(){
      this.map = new Hashtable();                
   }

   /**
    * This obviously enough provides the number of tokens that
    * have been inserted into the internal map. This acts as
    * a proxy method for the internal map <code>size</code>.
    *
    * @return this returns the number of tokens are available
    */ 
   public int size() {
      return map.size();           
   }

   /**
    * Thsi method is used to determine whether the parser has any
    * tokens available. If the <code>size</code> is zero then the
    * parser is empty and this returns true. The is acts as a
    * proxy the the <code>isEmpty</code> of the internal map.
    * 
    * @return this is true if there are no available tokens
    */ 
   public boolean isEmpty() {
      return map.isEmpty();           
   }

   /**
    * This is used to determine whether a token representing the
    * name of a pair has been inserted into the internal map. The
    * object passed into this method should be a string, as all
    * tokens stored within the map will be stored as strings.
    *  
    * @param name this is the name of a pair within the map
    *
    * @return this returns true if the pair of that name exists
    */ 
   public boolean containsKey(Object name) {
      return map.containsKey(name);           
   }

   /**
    * This method is used to determine whether any pair that has
    * been inserted into the internal map had the presented value.
    * If one or more pairs within the collected tokens contains
    * the value provided then this method will return true.
    * 
    * @param value this is the value that is to be searched for
    *
    * @return this returns true if any value is equal to this
    */    
   public boolean containsValue(Object value) {
      return map.containsValue(value);           
   }

   /**
    * The <code>get</code> method is used to acquire the value for
    * a named pair. So if a pair of name=value has been parsed and
    * inserted into the collection of tokens this will return the
    * value given the name. The value returned will be a string.
    *
    * @param name this is a string used to search for the value
    *
    * @return this is the value, as a string, that has been found 
    */ 
   public Object get(Object name) {
      return map.get(name);           
   }
   
   /**
    * The <code>token</code> method is used to acquire the value 
    * as a string. So if a pair of name=value has been parsed and
    * inserted into the collection of tokens this will return the
    * value given the name. The value returned will be a string.
    *
    * @param name this is a string used to search for the value
    *
    * @return this is the value, as a string, that has been found 
    */ 
   public String token(Object name) {
      Object token = get(name);

      if(token != null){
         return token.toString();              
      }      
      return null;
   }
   
   /**
    * The <code>put</code> method is used to insert the name and
    * value provided into the collection of tokens. Although it is
    * up to the parser to decide what values will be inserted it
    * is generally the case that the inserted tokens will be text.
    *
    * @param name this is the name token from a name=value pair
    * @param value this is the value token from a name=value pair
    *
    * @return this returns the previous value if there was any
    */ 
   public Object put(Object name, Object value) {
      return map.put(name, value);           
   }

   /**
    * The <code>remove</code> method is used to remove the named
    * token pair from the collection of tokens. This acts like a
    * take, in that it will get the token value and remove if 
    * from the collection of tokens the parser has stored.
    *
    * @param name this is a string used to search for the value
    *
    * @return this is the value, as a string, that is removed
    */ 
   public Object remove(Object name) {
      return map.remove(name);           
   }

   /**
    * This method is used to insert a collection of tokens into 
    * the parsers map. This is used when another source of tokens
    * is required to populate the connection currently maintained
    * within this parsers internal map. Any tokens that currently
    * exist with similar names will be overwritten by this.
    * 
    * @param data this is the collection of tokens to be added
    */ 
   public void putAll(Map data) {
      map.putAll(data);           
   }

   /**
    * This is used to acquire the names for all the tokens that 
    * have currently been collected by this parser. This is used
    * to determine which tokens have been extrected from the 
    * source. It is useful when the tokens have to be gathered.
    *
    * @return the set of name tokens that have been extracted
    */ 
   public Set keySet() {
      return map.keySet();           
   }

   /**
    * This method is used to acquire the value for all tokens that
    * have currently been collected by this parser. This is used
    * to determine which tokens have been extracted from the
    * source. It is useful when the tokens have to be gathered.
    *
    * @return the list of value tokens that have been extracted
    */ 
   public Collection values() {
      return map.values();           
   }

   /**
    * This method is used to acquire the name and value pairs that
    * have currently been collected by this parser. This is used
    * to determine which tokens have been extracted from the 
    * source. It is useful when the tokens have to be gathered.
    *
    * @return thie set of token pairs that have been extracted
    */ 
   public Set entrySet() {
      return map.entrySet();           
   }

   /**
    * The <code>clear</code> method is used to wipe out all the
    * currently existing tokens from the collection. This is used
    * to recycle the parser so that it can be used to parse some
    * other source of tokens without any lingering state.
    */ 
   public void clear() {
      map.clear();           
   }   
}
