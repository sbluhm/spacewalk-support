/* ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 - 2004 Greg Luck.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by Greg Luck
 *       (http://sourceforge.net/users/gregluck) and contributors.
 *       See http://jpam.sourceforge.net for a list of contributors"
 *    Alternately, this acknowledgement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "jpam" must not be used to endorse or promote products
 *    derived from this software without prior written permission. For written
 *    permission, please contact Greg Luck (gregluck at users.sourceforge.net).
 *
 * 5. Products derived from this software may not be called "jpam"
 *    nor may "jpam" appear in their names without prior written
 *    permission of Greg Luck.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL GREG LUCK OR OTHER
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by contributors
 * and individuals on behalf of the jpam project.  For more
 * information on jpam, please see <http://jpam.sourceforge.net/>.
 *
 */

package net.sf.jpam.jaas;

import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.io.IOException;

/**
 * Performs tests on the JPamLoginModule. These tests can be used as an example to follow
 * to use jpam from JAAS.
 * <p/>
 * Create the following users before running tests:
 * <ol>
 * <li>user test with password test01
 * <li>user test2 with password test02
 * </ol>
 *
 * @author <a href="mailto:gregluck@users.sourceforge.net">Greg Luck</a>
 * @version $Id: LoginContextTest.java,v 1.2 2004/09/04 11:52:05 gregluck Exp $
 */
public class LoginContextTest extends TestCase {
    private static final Log LOG = LogFactory.getLog(LoginContextTest.class.getName());
    /**
     * user 1 name
     */
    protected String user1Name = "test";
    /**
     * user 1 credentials
     */
    protected String user1Credentials = "test01";
    /**
     * user 1 bad credentials
     */
    protected String user1BadCredentials = "test01bad";
    /**
     * user 2 name
     */
    protected String user2Name = "test2";
    /**
     * user 2 credentials
     */
    protected String user2Credentials = "test02";
    /**
     * user 2 bad credentials
     */
    protected String user2BadCredentials = "test02bad";

    private String callbackCredentials;

    /**
     * Sets up the test
     * @throws Exception
     */
    protected void setUp() throws Exception {
        callbackCredentials = user1Credentials;
    }

    /**
     * Checks that we can login.
     * <p/>
     * In this test, login is successful and commit is called.
     * @throws LoginException
     */
    public void testLoginContext() throws LoginException {
        LoginContext loginContext;
        loginContext = new LoginContext("net-sf-jpam", new JpamCallbackHandler());
        loginContext.login();
    }

    /**
     * Checks what happens if a bad password is given
     * <p/>
     * In this test, login is unsuccessful and abort is called.
     * @throws LoginException
     */
    public void testLoginContextBadPassword() throws LoginException {
        LoginContext loginContext;
        callbackCredentials = user1BadCredentials;
        loginContext = new LoginContext("net-sf-jpam", new JpamCallbackHandler());
        try {
            loginContext.login();
            fail();
        } catch (FailedLoginException e) {
            //
        }
    }

    /**
     * The application must implement the CallbackHandler.
     * <p/>
     * <p> This application is text-based.  Therefore it displays information
     * to the user using the OutputStreams System.out and System.err,
     * and gathers input from the user using the InputStream, System.in.
     */
    class JpamCallbackHandler implements CallbackHandler {

        /**
         * Invoke an array of Callbacks.
         * <p/>
         * <p/>
         *
         * @param callbacks an array of <code>Callback</code> objects which contain
         *                  the information requested by an underlying security
         *                  service to be retrieved or displayed.
         * @throws java.io.IOException          if an input or output error occurs. <p>
         * @throws UnsupportedCallbackException if the implementation of this
         *                                      method does not support one or more of the Callbacks
         *                                      specified in the <code>callbacks</code> parameter.
         */
        public void handle(Callback[] callbacks)
                throws IOException, UnsupportedCallbackException {

            for (int i = 0; i < callbacks.length; i++) {
                if (callbacks[i] instanceof TextOutputCallback) {

                    // display the message according to the specified type
                    TextOutputCallback toc = (TextOutputCallback) callbacks[i];
                    switch (toc.getMessageType()) {
                        case TextOutputCallback.INFORMATION:
                            System.out.println(toc.getMessage());
                            break;
                        case TextOutputCallback.ERROR:
                            System.out.println("ERROR: " + toc.getMessage());
                            break;
                        case TextOutputCallback.WARNING:
                            System.out.println("WARNING: " + toc.getMessage());
                            break;
                        default:
                            throw new IOException("Unsupported message type: "
                                    + toc.getMessageType());
                    }

                } else if (callbacks[i] instanceof NameCallback) {

                    // prompt the user for a username
                    NameCallback nc = (NameCallback) callbacks[i];
                    nc.setName(user1Name);

                } else if (callbacks[i] instanceof PasswordCallback) {

                    // prompt the user for sensitive information
                    PasswordCallback pc = (PasswordCallback) callbacks[i];
                    pc.setPassword(callbackCredentials.toCharArray());

                } else {
                    throw new UnsupportedCallbackException
                            (callbacks[i], "Unrecognized Callback");
                }
            }
        }

    }
}
