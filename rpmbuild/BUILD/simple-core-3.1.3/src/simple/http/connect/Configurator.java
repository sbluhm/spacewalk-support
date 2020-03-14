/*
 * Configurator.java August 2005
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
 * The <code>Configurator</code> object is used to allow custom
 * socket configurations to be used for the connected clients. 
 * This is provided as it is clear that a single configuration
 * cannot be suitable for all platforms. For example, it might
 * nessecary to change the SO_LINGER option which controls how
 * long the TCP socket remains lingering waiting for and ACK 
 * after the client closes the connection. On Linux, incorrect
 * configurations can lead to exhaustion of file handles.
 * 
 * @author Niall Gallagher
 */ 
public interface Configurator {
        
   /**
    * This method is used to configure the TCP connection
    * before the <code>Pipeline</code> is created. This will
    * enable custom implementations to be used that can set
    * various socket options that suit the server platform.
    *
    * @param sock this is the newly connected HTTP pipeline
    */ 
   public void configure(Socket sock) throws IOException;
}
