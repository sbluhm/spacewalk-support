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
 * Performs tests on the Pam class using the other service.
 * <p/>
 * The "other" service should be a file in /etc/pam.d and contain the following chains:
 * <pre>
 * auth     required       /lib/security/$ISA/pam_deny.so
 * account  required       /lib/security/$ISA/pam_deny.so
 * password required       /lib/security/$ISA/pam_deny.so
 * session  required       /lib/security/$ISA/pam_deny.so
 * </pre>
 * pam_deny.so denies access. So all authentication tests should fail
 *
 * @author <a href="mailto:gregluck@users.sourceforge.net">Greg Luck</a>
 * @version $Id: OtherServiceTest.java,v 1.2 2005/04/16 22:35:15 gregluck Exp $
 * @see AbstractPamTest for other requirements
 */
public class OtherServiceTest extends AbstractPamTest {

    private static final Log LOG = LogFactory.getLog(OtherServiceTest.class.getName());

    private Pam pam;

    /**
     * Sets up each test, specifying "other" as the service.
     * @throws Exception
     */
    protected void setUp() throws Exception {
        pam = new Pam("other");
    }

    /**
     * A positive test that a known correct username and credentials are authenticated
     */
    public void testUserAuthenticated() {
        assertEquals(PamReturnValue.PAM_AUTH_ERR, pam.authenticate(user1Name, user1Credentials));
    }


    /**
     * A test which confirms that null credentials cause a NullPointerException
     * <p/>
     * This is important. If null gets through to the native code it causes a JVM crash
     */
    public void testUserWithNullCredentials() {
        try {
            PamReturnValue returnValue = pam.authenticate(user1Credentials, null);
            fail();
        } catch (NullPointerException e) {
            //do nothing;
        }
    }

    /**
     * A test that empty credentials cause an authentication error but no exception or
     * other type of error.
     */
    public void testUserWithEmptyCredentials() {
        PamReturnValue pamReturnValue = pam.authenticate(user1Credentials, "");
        assertTrue(pamReturnValue.equals(PamReturnValue.PAM_AUTH_ERR));
    }

    /**
     * A test which confirms that null usernames cause a NullPointerException
     * <p/>
     * This is important. If null gets through to the native code it causes a JVM crash
     */
    public void testUserWithNullUsername() {
        try {
            PamReturnValue returnValue = pam.authenticate(user1Name, null);
            fail();
        } catch (NullPointerException e) {
            //do nothing;
        }
    }

    /**
     * A test that empty usernames cause an authentication error but no exception or
     * other type of error.
     */
    public void testUserWithEmptyUsername() {
        PamReturnValue pamReturnValue = pam.authenticate(user1Name, "");
        assertTrue(pamReturnValue.equals(PamReturnValue.PAM_AUTH_ERR));
    }

    /**
     * Stress tests jpam with net-sf-jpam 
     * @throws InterruptedException
     */
    public void testJPamConcurrent() throws InterruptedException {
        concurrentPamStressTest(pam, PamReturnValue.PAM_AUTH_ERR);
    }
}
