/*
 * ContentComponent.java February 2001
 *
 * Copyright (C) 2001, Niall Gallagher <niallg@users.sf.net>
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

import java.io.OutputStream;
import java.io.IOException;

/**
 * The <code>ContentComponent</code> object is used to provide a
 * resource that delegates to the <code>Context</code> for acquiring
 * content. The performance of a content resource is dependant on
 * the provided context implementation as all resources within the
 * host file system will be taken from the provided instance. For 
 * high performance the <code>CacheContext</code> is recommended.
 * <p>
 * This is also an <code>IndexedComponent</code>, which means all 
 * meta data related to the target can be acquired. This provides
 * information such as the locale, file length, path, and other
 * such useful information. It the content for a required resource
 * cannot be acquired a <code>ContentException</code> is thrown.
 *  
 * @author Niall Gallagher
 *
 * @see simple.http.serve.CacheContext
 */
abstract class ContentComponent extends IndexedComponent{

   /**
    * Constructor for the <code>ContentComponent</code> object. This
    * requires the context to locate the resource and the name of 
    * the target that this instance is to emit. The target name is
    * given to the context to acquire the <code>Content</code>.
    *
    * @param target the HTTP request URI that represents this
    * @param context this is the root context of the resource
    */
   protected ContentComponent(Context context, String target){
      super(context, target);
   }

   /**
    * This method is provided so that subclasses can write content
    * easily. This will acquire the targeted <code>Content</code>
    * object and use its <code>write</code> method to emit it. If
    * the content for the target resource cannot be acquired then
    * a <code>ContentException</code> will be thrown.
    *
    * @param out this is the output stream to the content to
    * 
    * @exception IOException thrown if there is a I/O error    
    */
   protected void write(OutputStream out) throws IOException {
      context.getContent(target).write(out);
   }
}
