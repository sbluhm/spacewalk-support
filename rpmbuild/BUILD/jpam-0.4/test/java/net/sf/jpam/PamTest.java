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

import java.io.File;

/**
 * Performs tests on the Pam class.
 * <p/>
 * Before running this test please:
 * <p/>
 * 1. Add the net-sf-jpam config file to /etc/pam.d
 * 2. Create a user called test with password test01 in the PAM module configured
 *
 * @author <a href="mailto:gluck@thoughtworks.com">Greg Luck</a>
 * @version $Id: PamTest.java,v 1.6 2005/04/16 22:35:15 gregluck Exp $
 */
public class PamTest extends AbstractPamTest {

    private static final Log LOG = LogFactory.getLog(PamTest.class.getName());

    /**
     * Checks that the shared object libjpam.so is installed in
     * the first path contained in java.library.path
     */
    public void testSharedLibraryInstalledInLibraryPath() {
        String libraryPath = System.getProperty("java.library.path");
        String pathSeparator = System.getProperty("path.separator");
        String libraryName = Pam.getLibraryName();
        String[] pathElements = libraryPath.split(pathSeparator);
        boolean found = false;
        for (int i = 0; i < pathElements.length; i++) {
            String pathElement = pathElements[i];
            File sharedLibraryFile = new File(pathElement + File.separator + libraryName);
            if (sharedLibraryFile.exists()) {
                found = true;
            }

        }
        assertTrue("Shared Library installed: ", found);
    }

    /**
     * Tests that we can call a simple method in the shared library
     */
    public void testJNIWorking() {
        Pam pam = new Pam();
        assertTrue("Pam working", pam.isSharedLibraryWorking());
    }

    /**
     * A positive test that a known correct username and credentials are authenticated
     */
    public void testUserAuthenticated() {
        Pam pam = new Pam();
        assertTrue("Test user authenticated: ", pam.authenticateSuccessful(user1Name, user1Credentials));
    }

    /**
     * A negative test that a known correct username and and known incorrect
     * credentials are  not authenticated
     */
    public void testUserWithBadCredentialsNotAuthenticated() {
        Pam pam = new Pam();
        assertFalse("Test user authenticated: ", pam.authenticateSuccessful(user1Name, user1BadCredentials));
    }

    /**
     * A test which confirms that null credentials cause a NullPointerException
     * <p/>
     * This is important. If null gets through to the native code it causes a JVM crash
     */
    public void testUserWithNullCredentials() {
        Pam pam = new Pam();
        try {
            PamReturnValue returnValue = pam.authenticate(user1Credentials, null);
            fail();
        } catch (NullPointerException e) {
            //do nothing;
        }
    }

    /**
     * A test that empty credentials cause an error.
     *
     * The actual error depends on the PAM modules involved. The test checks for the errors thrown
     * on Mac OS X and Linux.
     */
    public void testUserWithEmptyCredentials() {
        Pam pam = new Pam();
        PamReturnValue pamReturnValue = pam.authenticate(user1Credentials, "");
        assertTrue(pamReturnValue.equals(PamReturnValue.PAM_USER_UNKNOWN)
                || pamReturnValue.equals(PamReturnValue.PAM_AUTH_ERR));
    }

    /**
     * A test which confirms that null usernames cause a NullPointerException
     * <p/>
     * This is important. If null gets through to the native code it causes a JVM crash
     */
    public void testUserWithNullUsername() {
        Pam pam = new Pam();
        try {
            PamReturnValue returnValue = pam.authenticate(user1Name, null);
            fail();
        } catch (NullPointerException e) {
            //do nothing;
        }
    }

    /**
     * The actual error depends on the PAM modules involved. The test checks for the errors thrown
     * on Mac OS X and Linux.
     */
    public void testUserWithEmptyUsername() {
        Pam pam = new Pam();
        PamReturnValue pamReturnValue = pam.authenticate(user1Name, "");
        assertTrue(pamReturnValue.equals(PamReturnValue.PAM_PERM_DENIED)
            || pamReturnValue.equals(PamReturnValue.PAM_AUTH_ERR));
    }

    /**
     * A test which confirms that null usernames cause a NullPointerException
     * <p/>
     * This is important. If null gets through to the native code it causes a JVM crash
     */
    public void testNullService() {
        try {
            Pam pam = new Pam(null);
            fail();
        } catch (NullPointerException e) {
            //do nothing;
        }
    }

    /**
     * Tests that a null service name causes a {@link NullPointerException}
     * rather than a JVM crash
     */
    public void testNullServiceName() {
        try {
            Pam pam = new Pam(null);
            fail();
        } catch (NullPointerException e) {
            //do nothing;
        }
    }

    /**
     * Tests that not specifying a service name causes an IllegalArgumentException
     * not any other type of error.
     */
    public void testEmptyServiceName() {
        try {
            Pam pam = new Pam("");
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing;
        }
    }

    /**
     * Stress tests jpam with net-sf-jpam
     * @throws InterruptedException
     */
    public void testJPamConcurrent() throws InterruptedException {
        concurrentPamStressTest(new Pam(), PamReturnValue.PAM_SUCCESS);
    }
}
