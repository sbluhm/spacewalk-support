/*
 * FactoryContext.java December 2002
 *
 * Copyright (C) 2002, Niall Gallagher <niallg@users.sf.net>
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

import java.io.IOException;
import java.io.File;

/**e
 * The <code>FactoryContext</code> is a context implementation that can
 * be used to serve dynamic <code>Content</code> objects. This uses a
 * <code>ContentFactory</code> implementation to produce instances
 * from the <code>getInstance</code> method. This should be used if
 * content other than static files needs to be served from the
 * context. Also, this can be used as a caching implementation by
 * using the <code>FileContentFactory</code> object for static files. 
 *
 * @author Niall Gallagher
 *
 * @see simple.http.serve.CacheContext
 */
public class FactoryContext extends FileContext {

   /**
    * This is used to acquire <code>Content</code> implementations.
    */
   protected ContentFactory factory;

   /**
    * Constructor for the <code>FactoryContext</code>. This will
    * produce dynamic <code>Content</code> implementations. The
    * objects produced by the <code>getContent</code> method are
    * created using a <code>ContentFactory</code>. This loads all
    * configuration files from the current working directory.
    *
    * @param factory used to produce dynamic content objects    
    */
   public FactoryContext(ContentFactory factory) {
      this(factory, new File("."));
   }

   /**
    * Constructor for the <code>FactoryContext</code>. This will
    * produce dynamic <code>Content</code> implementations. The
    * objects produced by the <code>getContent</code> method are
    * created using a <code>ContentFactory</code>. This loads
    * all files and configuration from the specified path.
    *
    * @param base the OS specific base path for this instance
    * @param factory used to produce dynamic content objects
    */
   public FactoryContext(ContentFactory factory, File base){
      this(factory, base, base);
   }
  
   /**
    * Constructor for the <code>FactoryContext</code>. This will
    * produce dynamic <code>Content</code> implementations. The
    * objects produced by the <code>getContent</code> method are
    * created using a <code>ContentFactory</code>. This loads
    * all files from the specified base path. Configuration can
    * be loaded from the file range provided.
    *
    * @param base the OS specific base path for this instance
    * @param factory used to produce dynamic content objects
    * @param path this is the directory used for configuration 
    */ 
   public FactoryContext(ContentFactory factory, File base, File path){
      this(factory, base, new File[]{path});
   }
   
   /**
    * Constructor for the <code>FactoryContext</code>. This will
    * produce dynamic <code>Content</code> implementations. The
    * objects produced by the <code>getContent</code> method are
    * created using a <code>ContentFactory</code>. This loads
    * all files from the specified base path. Configuration can
    * be loaded from the file range provided.
    *
    * @param base the OS specific base path for this instance
    * @param factory used to produce dynamic content objects
    * @param list this is the range searched for configuration 
    */ 
   public FactoryContext(ContentFactory factory, File base, File[] list){
      super(base, list);
      this.factory = factory;
   }
   
   /**
    * This creates instances of the <code>Content</code> object using 
    * the issued <code>ContentFactory</code>. This will initially
    * attempt to acquire the content instance using the provided
    * factory. However, if this fails the super class method is used.
    *
    * @param target the request URI used to reference the resource
    *
    * @throws IOException this is thrown if there is an I/O problem
    */
   public Content getContent(String target) throws IOException {
      try {
         return factory.getInstance(this,target);
      }catch(ContentException e){
         return super.getContent(target);      
      }
   }
}
