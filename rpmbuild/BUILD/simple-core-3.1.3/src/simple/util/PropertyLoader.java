/*
 * PropertyLoader.java May 2005
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

import java.io.InputStream;

/**
 * This is the <code>PropertyLoader</code> used to load properties
 * from the specified stream. This is used to allow a pluggable 
 * loader for properties. There may be several formats for a set
 * of properties that have to be loaded, this will allows those
 * formats to be loaded using an implementation of this interface.
 * <p>
 * For example the current <code>Properties</code> implementation
 * can load only the ISO-8859-1 character set using Java 1.4. It
 * may be useful or desirable to have an XML loader that can 
 * handle a properties format other that the traditional format.
 * 
 * @author Niall Gallagher
 *
 * @see simple.util.XMLLoader
 */ 
interface PropertyLoader {

   /**
    * This method is used to load the properties from a given
    * stream source. Typically this will load the properties
    * using the UTF-8 character set, which allows characters
    * other than those supported by ISO-8859-1. If there is a
    * problem loading the properties an exception is thrown.
    * 
    * @param source where the properties are loaded from
    *
    * @exception Exception if there is an problem reading
    */ 
   public void load(InputStream source) throws Exception;

   /**
    * This method is used to load the properties from a given
    * stream source. This will load the properties using the
    * specified character set, which allows characters other 
    * than those supported by ISO-8859-1. If there is a 
    * problem loading the properties an exception is thrown.
    * 
    * @param source where the properties are loaded from
    * @param charset this is the character encoding to use
    *
    * @exception Exception if there is an problem reading 
    */ 
   public void load(InputStream source, String charset) throws Exception;
}
