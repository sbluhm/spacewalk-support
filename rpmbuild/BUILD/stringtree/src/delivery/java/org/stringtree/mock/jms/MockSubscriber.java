package org.stringtree.mock.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.RecordingMock;


public class MockSubscriber extends RecordingMock implements TopicSubscriber {

	public Topic getTopic() throws JMSException {
		record(new MockAction(this, "getTopic"));
		return null;
	}

	public boolean getNoLocal() throws JMSException {
		record(new MockAction(this, "getNoLocal"));
		return false;
	}

	public String getMessageSelector() throws JMSException {
		record(new MockAction(this, "getMessageSelector"));
		return null;
	}

	public MessageListener getMessageListener() throws JMSException {
		record(new MockAction(this, "getMessageListener" ));
		return null;
	}

	public void setMessageListener(MessageListener listener) throws JMSException {
		record(new MockAction(this, "setMessageListener", new Object[] { listener } ));
	}

	public Message receive() throws JMSException {
		record(new MockAction(this, "receive"));
		return null;
	}

	public Message receive(long timeout) throws JMSException {
		record(new MockAction(this, "receive", new Object[] { new Long(timeout) } ));
		return null;
	}

	public Message receiveNoWait() throws JMSException {
		record(new MockAction(this, "receiveNoWait"));
		return null;
	}

	public void close() throws JMSException {
		record(new MockAction(this, "close"));
	}
}
