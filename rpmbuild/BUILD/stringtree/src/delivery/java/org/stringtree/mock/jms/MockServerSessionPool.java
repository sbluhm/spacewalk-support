package org.stringtree.mock.jms;

import javax.jms.JMSException;
import javax.jms.ServerSession;
import javax.jms.ServerSessionPool;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.RecordingMock;

public class MockServerSessionPool extends RecordingMock implements ServerSessionPool {
    
	public ServerSession getServerSession() throws JMSException {
		record(new MockAction(this, "getServerSession"));
		return new MockServerSession();
	}

}
