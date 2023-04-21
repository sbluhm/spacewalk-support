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

import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Performs tests on the Pam class.
 * <p/>
 * Create the following users before running tests:
 * <ol>
 * <li>user test with password test01
 * <li>user test2 with password test02
 * </ol>
 * Linux systems may need /etc/shadow to be made readable by the user
 *
 * @author <a href="mailto:gregluck@users.sourceforge.net">Greg Luck</a>
 * @version $Id: AbstractPamTest.java,v 1.4 2005/04/16 22:35:15 gregluck Exp $
 */
public class AbstractPamTest extends TestCase {
    private static final Log LOG = LogFactory.getLog(AbstractPamTest.class.getName());
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


    /**
     * An empty test to keep IntelliJ Test Runner happy
     */
    public void testPlaceHolder() {
        //
    }


    /**
     * Multi-threaded PAM test.
     */
    public void concurrentPamStressTest(final Pam pam, final PamReturnValue expectedReturnValue) throws InterruptedException {
        final long startingSize = measureMemoryUse();

        //Create a list of threads
        final List executables = new ArrayList();

        //Add threads for user1 authentication
        for (int i = 0; i < 15; i++) {
            final Executable executable = new Executable() {
                public void execute() throws Exception {
                    LOG.info("Running 1");
                    PamReturnValue value = pam.authenticate(user1Name, user1Credentials);
                    checkReturnValue(expectedReturnValue, value);
                }
            };
            executables.add(executable);
        }

        //Add threads for user2 authentication
        for (int i = 0; i < 15; i++) {
            final Executable executable1 = new Executable() {
                public void execute() throws Exception {
                    LOG.info("Running 2");
                    PamReturnValue value = pam.authenticate(user2Name, user2Credentials);
                    checkReturnValue(value, value);
                }
            };
            executables.add(executable1);
        }

        List errors = runThreads(executables);

        long finishingSize = measureMemoryUse();
        long difference = finishingSize - startingSize;
        LOG.info("Memory Change is: " + difference);

        // Throw any error that happened
        if (errors.size() != 0) {
            LOG.error("" + errors.size() + " failures in run.");
            for (int i = 0; i < errors.size(); i++) {
                Throwable throwable = (Throwable) errors.get(i);
                LOG.error("Error " + i + ": " + throwable);
            }
            assertEquals("Errors occurred during run", 0, errors.size());
        }
    }

    private void checkReturnValue(PamReturnValue value, PamReturnValue pamReturnValue) throws PamException {
        if (!value.equals(pamReturnValue)) {
            LOG.error("Test Failure on user2. PamReturnValue: " + value);
            throw new PamException(value.toString());
        }
    }

    /**
     * Measures the memory use. Because Garbage Collection is done, memory should
     * not increase.
     *
     * @return the memory increase/- decrease in bytes
     * @throws InterruptedException
     */
    protected long measureMemoryUse() throws InterruptedException {
        System.gc();
        Thread.sleep(3000);
        System.gc();
        long startingSize = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        return startingSize;
    }


    /**
     * Runs a set of threads, for a fixed amount of time.
     */
    protected List runThreads(final List executables) throws InterruptedException {
        final Counter counter = new Counter();
        final long endTime = System.currentTimeMillis() + 10000;
        final List errors = new ArrayList();

        // Spin up the threads
        final Thread[] threads = new Thread[executables.size()];
        for (int i = 0; i < threads.length; i++) {
            final Executable executable = (Executable) executables.get(i);
            threads[i] = new Thread() {
                public void run() {
                    try {
                        // Run the thread until the given end time
                        while (System.currentTimeMillis() < endTime) {
                            executable.execute();
                            counter.increment();
                        }
                    } catch (Throwable t) {
                        // Hang on to any errors
                        errors.add(t);
                    }
                }
            };
            threads[i].start();
        }

        // Wait for the threads to finish
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        LOG.info("Number of executes run: " + counter.counter);
        return errors;
    }

    /**
     * A runnable, that can throw an exception.
     */
    protected interface Executable {

        /**
         * Executes this object
         */
        void execute() throws Exception;
    }

    /**
     * Counts the tests
     */
    protected class Counter {
        private int counter;

        private synchronized void increment() {
            counter++;
        }
    }
}
