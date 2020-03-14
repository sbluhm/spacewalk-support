package org.stringtree.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

public class RecordingMock {
    
    public boolean verbose = false;
    public List recorded = new ArrayList();
    public Throwable exception;

    protected void record(MockAction action) {
        if (verbose) System.out.println(action);
        recorded.add(action);
    }
    
    public void clear() {
        recorded.clear();
    }

    protected void record(Object destination, String message, Object[] arguments) {
        record(new MockAction(destination, message, arguments));
    }

    protected void record(Object destination, String message) {
        record(new MockAction(destination, message));
    }
    
    public void setException(Throwable throwable) {
        this.exception = throwable;
    }
    
    public void assertCalled(int nTimes, String message, Object[] args) {
        int count = 0;
        Iterator it = recorded.iterator();
        while (it.hasNext()) {
            MockAction action = (MockAction)it.next();
            if (action.message.equals(message) && Arrays.equals(args, action.arguments)) {
                ++count;
            }
        }
        Assert.assertEquals(nTimes, count);
    }

    public void assertCalled(String message, Object[] args) {
    	assertCalled(1, message, args);
    }

    public void assertNotCalled(String message, Object[] args) {
        assertCalled(0, message, args);
    }
    
    public void assertCalled(int nTimes, String message) {
        int count = 0;
        Iterator it = recorded.iterator();
        while (it.hasNext()) {
            MockAction action = (MockAction)it.next();
            if (action.message.equals(message)) {
                ++count;
            }
        }
        Assert.assertEquals(nTimes, count);
    }

    public void assertCalled(String message) {
        assertCalled(1, message);
    }

    public void assertNotCalled(String message) {
        assertCalled(0, message);
    }
}
