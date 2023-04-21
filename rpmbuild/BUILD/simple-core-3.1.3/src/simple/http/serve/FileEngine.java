/*
 * FileEngine.java February 2001
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
import java.io.File;

/**
 * The <code>FileEngine</code> is used to produce implementations
 * of the <code>Resource</code> object to represent files on the
 * underlying filesystem. This will produce <code>Resource</code>
 * objects that map on to the suggested URI relative to some
 * given <code>Context</code>. The <code>Context</code> must be 
 * given as a root so all requests for <code>Resource</code>'s are 
 * retrieved relative to that root. 
 * <p>
 * The meaning of HTTP URI in this instance is the request URI
 * from a HTTP/x.x request, as RFC 2616 and RFC 2396 defines it
 *
 * <pre> 
 * Request-Line = Method SP Request-URI SP HTTP-Version CRLF
 *
 * Request-URI = "*" | absoluteURI | abs_path | authority
 * absoluteURI = "http:" "//" host [":" port] [abs_path ["?" query]] 
 * abs_path = "/" path_segments         
 * path_segments = segment *( "/" segment )
 * </pre> 
 *
 * So the <code>FileEngine</code> object will accept the request URI 
 * that come in the form outlined above. These can include formats 
 * like 
 *
 * <pre> 
 * http://some.host/pub;param=value/bin/index.html?name=value
 * http://some.host:8080/index.en_US.html
 * some.host:8080/index.html
 * /usr/bin;param=value/README.txt
 * /usr/bin/compress.tar.gz
 * </pre>
 *
 * The <code>FileEngine</code> object will directly take a request 
 * URI as defined in RFC 2616 and translate this into a system 
 * specific <code>Resource</code>. This keeps the objects semantics 
 * simple and explicit, although at the expense of performance. 
 *
 * @author Niall Gallagher
 *
 * @see simple.http.serve.CacheContext
 */
public class FileEngine implements ResourceEngine{

   /**
    * Each <code>FileEngine</code> operates using a context.
    */
   protected Context context;
    
   /**
    * Constructor for the <code>FileEngine</code>. This uses the 
    * current working directory to serve the <code>Resource</code>.
    * This will retrieve and represent OS specific resources such 
    * as files using <code>Resource</code> implementations. This
    * also keeps a cache of the file contents requested.
    */    
   public FileEngine() {
      this(new CacheContext());
   }

   /**
    * Constructor takes a <code>Context</code> implementation and
    * operates relative to that implementation. This will retrieve
    * and represent OS specific resources such as files using 
    * <code>Resource</code> implementations. This relies on the 
    * provided context to perform caching for this implementation.
    *
    * @param context this is the context the file engine will use
    */ 
   public FileEngine(Context context){
      this.context = context;
   }

   /**
    * This will look for and retrieve the requested resource. The 
    * target given must be in the form of a request URI. This will
    * locate the resource and return the <code>Resource</code>
    * implementation that will handle the target.
    *
    * @param target the URI style path that represents the target 
    *
    * @return returns the resource instance to handle the target
    */
   public Resource resolve(String target){
      return resolve(target,context.getFile(target));
   }

   /**
    * This will look for and retrieve the requested resource. The 
    * target given must be in the form of a request URI. This will
    * locate the resource and return the <code>Resource</code>
    * implementation that will handle the target.
    *
    * @param target the URI style path that represents the target
    * @param file this is the file that represents the resource 
    *
    * @return returns the resource instance to handle the target 
    */
   protected Resource resolve(String target, File file){
      if(file.isDirectory()) {
         return new DirectoryComponent(context,target);
      }else if(file.isFile()){
         return new FileComponent(context,target);
      } else return new Component(context){
         protected void process(Request req, Response resp){
            handle(req, resp, 404);
         }
      }; 
   }
}
