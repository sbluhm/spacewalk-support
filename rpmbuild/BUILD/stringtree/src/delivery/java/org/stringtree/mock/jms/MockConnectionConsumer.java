package org.stringtree.mock.jms;

import javax.jms.ConnectionConsumer;
import javax.jms.JMSException;
import javax.jms.ServerSessionPool;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.RecordingMock;

public class MockConnectionConsumer extends RecordingMock implements ConnectionConsumer {
    
	public ServerSessionPool getServerSessionPool() throws JMSException	{
		record(new MockAction(this, "getServerSessionPool"));
		return new MockServerSessionPool();
	}

	public void close() throws JMSException {
		record(new MockAction(this, "close"));
	}
}
