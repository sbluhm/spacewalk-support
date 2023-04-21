/*
 * Redirect.java May 2005
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

package simple.http.load;

import simple.http.serve.Component;
import simple.http.serve.Context;
import simple.http.serve.Resource;
import simple.http.Response;
import simple.http.Request;

/**
 * The <code>Redirect</code> object provides a redirectable
 * implementation of the <code>Service</code> object. This is 
 * used to implement controllers that ultimately redirect to
 * another service or site to complete the client request.
 * Typically the <code>redirect</code> method is implemented
 * to perform some processing before being redirected.
 * </p>
 * The <code>lookup</code> and <code>resolve</code> methods are
 * used to acquire the desired resource object. This must then
 * be returned for the redirection to complete. If at any stage 
 * during processing and error occurs then an exception may be
 * thrown to the calling method to indicate the problem.
 *
 * @author Niall Gallagher
 */ 
public abstract class Redirect extends Service {
   
   /**
    * Constructor for the <code>Redirect</code> object. This is
    * used to provide a service implementation that can be used
    * used as a controller service. Any subclass of this can 
    * introduce initialization using the constructor or using 
    * the flexible <code>prepare</code> initializer method.
    *
    * @param context the context this controller is rooted at
    */   	
   public Redirect(Context context){
      super(context);
   }
   
   /**
    * This <code>process</code> method is used to drive the 
    * <code>redirect</code> method. This will simply invoke the
    * method and forward the client request to the resulting
    * <code>Resource</code> object, which completes the request.
    * 
    * @param req the HTTP request object representing the client
    * @param resp the HTTP response object to send a reply with
    * 
    * @throws Exception thrown if there is a problem processing  
    */    
   protected void process(Request req, Response resp) throws Exception{
      redirect(req, resp).handle(req, resp);
   }
  
   /**
    * This method is used to retrieve services using the name 
    * for that service. This method delegates directly to the
    * <code>LoaderEngine.lookup</code> method implemented. This
    * method can be subclassed to provide a naming scheme, such
    * that resources can be acquired using aliases.
    *
    * @param target the target name referencing the resource
    *
    * @return the <code>Resource</code> that has been located
    */   
   public Resource lookup(String target) throws Exception {
      return engine.lookup(target);
   }

   /**
    * This method is used to retrieve services using a specific
    * URI. The URI format is not important, this method is able
    * to handle absolute and realitive URI formats. Like the
    * <code>lookup</code> method this maps directly to the
    * the <code>LoaderEngine</code> implementaion for resolving
    * resources given a URI target. If the target URI is not
    * relative, that is, if the URI does not begin with the
    * root path, "/", then a HTTP redirect will be employed.
    *
    * @param target the URI string referencing the resource
    *
    * @return the <code>Resource</code> that has been located
    */  
   public Resource resolve(String target) throws Exception {
      if(target.startsWith("/")) {
         return engine.resolve(target);
      }
      return new Delegate(context,target);
   }

   /**
    * The <code>redirect</code> method is used to perform various
    * operations before a request or client is redirected. This is
    * useful when no specific view is associated with a target
    * service or resource. It allows delegation to other resources,
    * which can then render the view for the HTTP transaction.
    * 
    * @param req the HTTP request object representing the client
    * @param resp the HTTP response object to send a reply with
    * 
    * @return returns the resource used to handle the request
    *  
    * @throws Exception thrown if there is a problem processing 
    */ 
   public abstract Resource redirect(Request req, Response resp) throws Exception;
   
   /**
    * This <code>Delegate</code> object will redirect the client
    * to a specific URI location. This is used to redirect the 
    * HTTP client to a site that is not local, that is, a site 
    * that cannot be located on the same domain or port.
    *
    * @see simple.http.serve.Resource
    */
   private class Delegate extends Component {

      /**
       * This is the location that the client is redirected to.
       */ 
      private String target;

      /**
       * Constructor for the <code>Delegate</code> object. This
       * requires both a resource context and the URI that is 
       * to be used to redirect the client. The target given
       * must be a valid URI for the redirect to be successful.
       *
       * @param context this is the context for this resource
       * @param target this is the target URI to redirect to
       */ 
      public Delegate(Context context, String target){
         this.target = target.replaceFirst("\\?.*","");
         this.context = context;
      }

      /**
       * This provides a simple implementation of a HTTP redirect.
       * Once the correct "Location" header has been set the 302
       * HTTP response code is issued and the client is notified.
       * 
       * @param req the request object representing the client
       * @param resp the response object to send a reply with
       */ 
      protected void process(Request req, Response resp) throws Exception{
         String query = "?"+req.getParameters();

         if(query.length() >1){
            target += query;
         }
         resp.set("Location", target);
         handle(req, resp, 302);	   
      }
   }
}
