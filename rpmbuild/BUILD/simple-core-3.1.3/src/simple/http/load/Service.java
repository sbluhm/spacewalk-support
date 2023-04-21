/*
 * Service.java July 2003
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
 
package simple.http.load;

import simple.http.serve.Component;
import simple.http.serve.Context;
import simple.util.Introspector;

/**
 * The <code>Service</code> is a loadable component that is used
 * to process requests. Typically services are loaded in to the
 * server using a <code>LoaderEngine</code> object. It can be
 * initialized using any number of arguments, these arguments are
 * passed from the <code>LoaderEngine.load</code> to the service
 * instance. This allows a flexible initialization of services 
 * to be achieved using arbitrary <code>prepare</code> methods. 
 * <p>
 * This will attempt to discover the <code>prepare</code> method 
 * implemented by the subclass before invoking it. The discovery 
 * is done using Java reflection to match the arguments to the 
 * <code>prepare</code> method signature. For example take
 * the <code>prepare</code> signatures illustrated below.
 * <pre>
 *
 *    public void prepare(Map) throws Exception
 *    public void prepare(List, String) throws Exception
 *
 * </pre>
 * The data passed into the <code>prepare</code> method from the
 * loader engine is a variable length argment list. So, this
 * enables any number of objects to be passed into the loader
 * engine <code>load</code> method. Once the arguments have
 * been passed into the service instance they are matched 
 * against all publicly declared <code>prepare</code> methods
 * for the implementation. So it is the task of the developer
 * to ensure the arguments to the <code>load</code> method
 * match the arguments to the implementation initializer. If
 * no initializer is declared, then initialization is ignored.
 *
 * @author Niall Gallagher
 *
 * @see simple.util.Introspector
 */
public abstract class Service extends Component {

   /**
    * This is the loader engine used to load this service object.
    */ 
   protected LoaderEngine engine;

   /**
    * Constructor to the <code>Service</code> object. This will
    * create a service that can have an arbitrary preparation
    * method. This will be used by a <code>LoaderEngine</code> to
    * create an instance using the context of that loader engine.
    *
    * @param context this is the context used by this instance.
    */
   public Service(Context context){
      super(context);
   }

   /**
    * This method is used as a driver to the <code>prepare</code>
    * method implemented by the subclass. The selection of the
    * <code>prepare</code> method is determined by the class of
    * the issued object, using <code>Object.getClass</code>. This
    * discovers the method using the class and its subclasses.
    *
    * @param engine this is the engine that this object loaded by
    * @param data this object's class determines the preparation
    *
    * @throws LoadingException thrown if preparation fails
    */
   public void prepare(LoaderEngine engine, Object[] data) throws LoadingException{
      try {
         prepare(getClass(), data);
      }catch(NoSuchMethodException cause){
      }catch(Exception cause){
         throw new LoadingException(cause);
      }
      this.engine = engine;
   }

   /**
    * This discovers the <code>prepare</code> method that will be
    * used to initialize this instance. This will attempt to find
    * a match for <code>prepare</code> using the class types of
    * the argument to this method.
    * <p>
    * Any exceptions that are thrown from the implemented method
    * will propagate from this method. If no method is matched
    * then this returns quietly assuming initialization is not
    * required for the subclass implementation.
    *
    * @param type this is the type of the subclass implementation
    * @param data contains the argument to use in an invocation
    *
    * @throws Exception this is thrown if the preparation fails
    */
   private void prepare(Class type, Object[] data) throws Exception{
      new Introspector(type).invoke("prepare", this, data);
   }
}
