/*
 * Indexer.java December 2005
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
 
package simple.http.serve;

import simple.util.net.Path;
import simple.util.net.URI;
import java.util.Locale;
import java.io.File;

/**
 * The <code>Indexer</code> object is used to acquire meta data for 
 * a URI target. This provides a centralized source for meta data
 * within the server. The need to acquire information such as MIME
 * type, locale, and various other details for a URI frequently
 * arises. In order to provide a consistant set of details for a
 * specific target an <code>Indexer</code> implementation is used.
 * This helps various services and resources acauire meta data
 * quickly by facilitating a meta data cache for a context.
 * 
 * @author Niall Gallagher
 *
 * @see simple.http.serve.Index
 */ 
interface Indexer {

   /**
    * This is used to acquire the <code>File</code> reference
    * for the index target. This is typically rooted at a
    * base path, for instance the <code>Context</code> root
    * is typically used. This allows the file to be opened,
    * deleted, or read should the need arise in a service.
    *
    * @param target the index target to get the OS file for
    * 
    * @return this returns the OS file for the resource
    */    
   public File getFile(URI target);

   /**
    * This is used to acquire the <code>Path</code> object that 
    * exposes various parts of the URI path. This can be used 
    * to extract the individual path segments as strings as 
    * well as the file extension and various other details.
    *
    * @param target the index target to get the URI path for
    * 
    * @return this returns a path object with various details
    */    
   public Path getPath(URI target);

   /**
    * This gets the locale for this index object the locale is
    * set to the <code>Locale.getDefault</code> if there is no
    * locale information available for the index target. This
    * will provide the <code>Context.getLocale</code> object.
    *
    * @param target the index target to get the locale for
    * 
    * @return this returns the locale for this index target
    */    
   public Locale getLocale(URI target);

   /**
    * This allows the MIME type of this <code>Index</code> to
    * be acquired. The MIME type of a file is retrieved by the
    * <code>Context.getContentType</code> method for a specific
    * request URI. This should have a value and perhaps some
    * parameters like the charset, "text/html; charset=UTF-8".
    *
    * @param target the index target to get the MIME type for
    * 
    * @return the MIME type this object has been set to
    */     
   public String getContentType(URI target);
}

