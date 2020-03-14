/*
 * FileComponent.java February 2001
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

import simple.http.Response;
import simple.http.Request;

/**
 * The <code>FileComponent</code> provides an implementation of the
 * <code>Component</code> that can be used to acquire generic files. 
 * The <code>FileComponent</code> is an <code>IndexedComponent</code>. 
 * This means that all the meta information on the file is acquired 
 * once the resource is instantiated.
 * <p>
 * This <code>Component</code> implementation delegates to the
 * provided context to acquire the contents of the file. This means
 * that all caching can be provided by the context, and thus it can
 * be shared amongst other interested objects. The performance of
 * this object is largely dependant on the context implementation.
 *
 * @author Niall Gallagher 
 *
 * @see simple.http.serve.CacheContext
 */
final class FileComponent extends ContentComponent {
   
   /**
    * The files meta information is taken from the path that is 
    * specified. The <code>IndexedComponent</code> constructor will 
    * provide the meta information for the specified resource. 
    * This delegates to the provided <code>Context</code> object
    * to acquire the content for the resource. This allows the 
    * context to determine the caching policy for all files.
    *
    * @param target this is the HTTP request URI for this resource
    * @param context the root context of this file resource
    */ 
   public FileComponent(Context context, String target){
      super(context, target);     
   }
   
   /**
    * This method handles the HTTP request and response. When a 
    * HTTP request is generated it is given to this method. This
    * will then either respond with the appropriate error message
    * or process the request.
    * <p>
    * If the file requested does not exist then this will use the
    * <code>Component.handle(Request,Response,int)</code> to
    * generate the appropriate response.
    * <p>
    * If the method used is HEAD then this will write only the
    * headers and will subsequently close the pipeline. However
    * this will not handle POST, OPTIONS, TRACE, DELETE or PUT
    * requests and will generate a "501 Not Implemented" message
    * if attempted, see RFC 2616 sec 5.1.1.
    *
    * @param req the <code>Request</code> to be processed
    * @param resp the <code>Response</code> to be processed
    *
    * @exception Exception throw if theres an I/O error
    */   
   protected void process(Request req, Response resp)throws Exception {
      if(req.getDate("If-Modified-Since")< getLastModified()){
         resp.setDate("Date", System.currentTimeMillis());
         resp.setDate("Last-Modified",getLastModified());
         resp.set("Content-Type",getContentType());
         resp.setContentLength(getLength());
      
         if(req.getMethod().equals("HEAD")){
            resp.commit(); 
         }else if(req.getMethod().equals("GET")){
            write(resp.getOutputStream());  
            resp.getOutputStream().close(); 
         }else{
            handle(req,resp,501); 
         }
      }else {
         handle(req,resp,304);
      }
   }    
}
