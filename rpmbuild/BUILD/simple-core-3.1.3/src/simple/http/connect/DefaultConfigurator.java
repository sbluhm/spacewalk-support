/*
 * DefaultConfigurator.java August 2005
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

package simple.http.connect;

import java.io.IOException;
import java.net.Socket;

/**
 * The <code>DefaultConfigurator</code> provides generic socket
 * configuration, that should suit a wide variety of platforms.
 * This is used by default if no specific implementation is
 * suggested. Configuration provided by this is such that the
 * socket will not linger and so that a read is interrupted if
 * after one minute nothing is produced from the read. This
 * configuration may not be best for some Linux distrubutions.
 * 
 * @author Niall Gallagher
 */ 
final class DefaultConfigurator implements Configurator {

   /**
    * This configures each TCP connection for use with HTTP 
    * applications. This has a wait time of 1 minute for a read 
    * before an there is an <code>InterruptedIOException</code> 
    * is thrown from the <code>SocketInputStream</code>.
    * <p>
    * This configures the specified <code>Socket</code> with no
    * delay. Also, although the SO_LINGER has been set to false 
    * this might cause problems with various Linux distributions
    * as it may leave sockets in a CLOSE_WAIT state. This seems
    * to be a Linux kernel bug rather than a configuration error.
    *
    * @param sock this is the socket that is to be configured
    * 
    * @exception IOException thrown if there is an I/O problem
    */       
   public void configure(Socket sock) throws IOException{
      if(sock.getSoTimeout() <= 0){
         sock.setSoTimeout(60000);
      }
      sock.setTcpNoDelay(true);
      sock.setSoLinger(false,0);
   }
}
