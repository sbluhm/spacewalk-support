/*
 * PropertyException.java May 2005
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

import java.io.IOException;

/**
 * The <code>PropertyException</code> is used to describe the error
 * that occurs when a properties file cannot be read. This can be
 * caused either by an I/O problem reading the file, or it the file
 * is written in an invalid syntax, particularly invalid XML.
 * 
 * @author Niall Gallagher
 */ 
public class PropertyException extends IOException {

   /**
    * Constructor for the <code>PropertyException</code>. This is
    * used when no message is required to describe the exception.
    */         
   public PropertyException() {
      super();
   }

   /**
    * Constructor for the <code>PropertyException</code>. This is
    * used when there is some exception relating to the parsing
    * or reading of the properties file thrown.
    *
    * @param cause this is the cause of the property exception
    */ 
   public PropertyException(Throwable cause) {
      this.initCause(cause);           
   }   
}
