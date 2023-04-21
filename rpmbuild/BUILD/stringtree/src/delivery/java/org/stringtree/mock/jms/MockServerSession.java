package org.stringtree.mock.jms;

import javax.jms.JMSException;
import javax.jms.ServerSession;
import javax.jms.Session;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.RecordingMock;


public class MockServerSession extends RecordingMock implements ServerSession {
    
	public Session getSession() throws JMSException {
		record(new MockAction(this, "getSession"));
		return new MockSession();
	}

	public void start() throws JMSException {
		record(new MockAction(this, "start"));
	}
}
