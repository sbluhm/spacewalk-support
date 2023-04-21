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

package net.sf.jpam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Performs tests on the Pam class using the SecurId service.
 * <p/>
 * Before running this test please:
 * <p/>
 * 1. Add the net-sf-jpam-securid config file to /etc/pam.d
 * 2. Create a user called test in the ACE Server and enable for this host.
 * 3. Have a SecurId token setup on the ACE Server
 * 4. Have a VAR_ACE pointing to the location of your sdconf.rec. Consider adding to /etc/profile so that it is set for IDE support
 * 5. Verify that the agent and ACE Server are communicating using acestatus and acetest
 * 6. Verify that the pam_securid.so PAM module is working. Change a service like login to use it and test it.
 * 7. make sure the user has permission to all of the files in /opt/pam and /lib/security/ace
 *
 * @author <a href="mailto:gluck@thoughtworks.com">Greg Luck</a>
 * @version $Id: SecurIdTest.java,v 1.2 2004/08/20 03:16:52 gregluck Exp $
 */
public class SecurIdTest extends AbstractPamTest {

    private static final String SECURID_SERVICE = "net-sf-jpam-securid";

    private static final Log LOG = LogFactory.getLog(SecurIdTest.class.getName());



    /**
     * A positive test that a known correct username and credentials are authenticated
     *
     * You need to replace the key with the number from the token and run the test before it changes
     * which is a maximum of 1 minute.
     * <p/>
     * The Pam.c needs to have the following line
     * <code>if (! strcmp(msg[replies]->msg,"Password: ")) {</code>
     * changed to:
     * <code>//if (! strcmp(msg[replies]->msg,"Enter PASSCODE: ")) {</code>
     */
    public void xTestUserAuthenticated() {
        Pam pam = new Pam(SECURID_SERVICE);
        assertTrue("Test user authenticated: ", pam.authenticateSuccessful(user1Name, "655635"));
    }


    /**
     * A negative test that a known correct username and and known incorrect
     * credentials are  not authenticated
     */
    public void testUserWithBadCredentialsNotAuthenticated() {
        Pam pam = new Pam(SECURID_SERVICE);
        assertFalse("Test user authenticated: ", pam.authenticateSuccessful(user1Name, user1BadCredentials));
    }


    /**
     * A negative test that a known correct username and and known incorrect
     * credentials are  not authenticated
     */
    public void testUserWithUnkownUserName() {
        Pam pam = new Pam(SECURID_SERVICE);
        assertFalse("Test user authenticated: ", pam.authenticateSuccessful("zzzunknown", user1Credentials));
    }
}
