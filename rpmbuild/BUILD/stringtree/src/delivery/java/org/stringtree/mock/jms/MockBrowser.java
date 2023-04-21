package org.stringtree.mock.jms;

import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.RecordingMock;


public class MockBrowser extends RecordingMock implements QueueBrowser {
	public Queue getQueue() throws JMSException {
		record(new MockAction(this, "getQueue"));
		return null;
	}

	public String getMessageSelector() throws JMSException {
		record(new MockAction(this, "getMessageSelector"));
		return null;
	}

	public Enumeration getEnumeration() throws JMSException {
		record(new MockAction(this, "getEnumeration"));
		return null;
	}

	public void close() throws JMSException {
		record(new MockAction(this, "close"));
	}
}
