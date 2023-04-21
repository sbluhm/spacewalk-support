/*
 * Processor.java October 2002
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
 
package simple.http.connect;

import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The <code>Processor</code> object is used in conjunction with 
 * the <code>Connection</code> to accept incoming TCP connections.
 * This uses the <code>ServerSocket</code> given to create 
 * <code>Socket</code> objects which are then given to the 
 * <code>SocketHandler</code> for further processing.
 * <p>
 * This is started in a thread by the <code>Connection</code>
 * so that it can listen for incoming connections asynchronously.
 * The <code>run</code> method accepts incoming TCP connections 
 * and dispatches them to the <code>SocketHandler</code>, once 
 * they have been configured for performance with HTTP.
 *
 * @author Niall Gallagher
 */  
final class Processor extends Thread {
        
   /**
    * This manages the socket configuration for pipelines.
    */ 
   private Configurator configurator;

   /** 
    * The handler that manages the incoming HTTP requests.
    */ 
   private SocketHandler handler;
   
   /**
    * This is the socket that will listen for connections.
    */    
   private ServerSocket server;
   
   /**
    * Creates a <code>Processor</code> that is used to listen 
    * to a port. The <code>Processor</code> will accept TCP 
    * connections and configure the <code>Socket</code>
    * objects accepted for performance with HTTP.
    *
    * @param handler this is the <code>SocketHandler</code> 
    * that will handle the connected <code>Socket</code>'s
    * @param server this is the <code>ServerSocket</code> that 
    * listens for and accepts connections from clients 
    */
   public Processor(SocketHandler handler, ServerSocket server){
      this.configurator = ConfiguratorFactory.getInstance();
      this.handler = handler;
      this.server = server;
      this.start();
   }

   /**
    * The main processing done by this object is done using a 
    * thread calling the <code>run</code> method. Here the TCP 
    * connections are accepted by the <code>ServerSocket</code> 
    * which creates the <code>Socket</code> objects. Each 
    * <code>Socket</code> is then dispatched to the 
    * <code>SocketHandler</code> instance.
    */
   public void run(){   
      while(true){
         try {  
            execute();
         }catch(Throwable e){
            if(server.isClosed())
               break;
         }
      }
   } 
   
   /**
    * This method is used to distinguish <code>Exception</code>
    * occurrences related to the <code>ServerSocket</code> from
    * those related to the accepted <code>Socket</code> objects.
    * <p>
    * This enables critical actions to be taken when the server
    * socket fails. This will ignore failures with individual
    * sockets, as these are specific to the connections.
    *
    * @exception IOException this is thrown if the is a problem
    * accepting connections from the <code>ServerSocket</code>
    */
   private void execute() throws IOException {
      while(true) {
         Socket sock = server.accept();
         try {
            handshake(sock);
            configure(sock);
            process(sock);
         } catch(Exception e){
            sock.close();
         }
      }
   }

   /**
    * This method is used to check to see if the socket connected 
    * is an <code>SSLSocket</code> implementation. If the socket 
    * is a JSSE SSL socket then this performs the handshake in a
    * blocking manner so that the socket is ready to read from. If
    * the socket is a plain <code>Socket</code> then this returns.
    * 
    * @param sock this is the socket that has been connected
    */ 
   private void handshake(Socket sock) throws IOException {
      SSLSocket secure = null;

      if(sock instanceof SSLSocket) {
         secure = (SSLSocket) sock;              
      }      
      if(secure != null) {
         secure.startHandshake();              
      }
   }

   /**
    * This is used to configure the TCP connection before it is
    * dispatched to be processed. This uses an implementation
    * of the <code>Configurator</code> insterface, which will
    * allow pluggable configuration of the connected sockets.
    *
    * @param sock this is the connected socket to configure
    */ 
   private void configure(Socket sock) throws IOException {
      configurator.configure(sock);           
   }

   /**
    * This method is used to dispatch the socket for processing.
    * The socket will be configured and connected to the client,
    * this will hand processing to the <code>SocketHandler</code>
    * which will create the pipeline implementation to use.
    *
    * @param sock this is the connected socket to be processed
    */ 
   private void process(Socket sock) throws Exception {
      handler.process(sock);           
   }
}
