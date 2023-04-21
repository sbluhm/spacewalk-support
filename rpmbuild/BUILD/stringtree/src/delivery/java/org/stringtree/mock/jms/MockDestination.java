package org.stringtree.mock.jms;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TemporaryQueue;
import javax.jms.TemporaryTopic;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.RecordingMock;


public class MockDestination extends RecordingMock
	implements Queue, Topic, TemporaryQueue, TemporaryTopic {
	
	public String name;
	public List messages;
	
	public MockDestination(String name) {
		this.name = name;
		this.messages = new ArrayList();
	}

	public String getQueueName() throws JMSException {
		record(new MockAction(this, "getQueueName"));
		return name;
	}
	
	public void sendMessage(Message message) {
		record(new MockAction(this, "sendMessage", new Object[] { message }));
		messages.add(message);
	}

	public String getTopicName() throws JMSException {
		record(new MockAction(this, "getTopicName"));
		return name;
	}

	public void delete() throws JMSException {
		record(new MockAction(this, "delete"));
	}
	
	public String toString() {
		return super.toString() + "(" + name + ")";
	}
	
	public TextMessage getMessage(int index) {
		return (TextMessage)messages.get(index);
	}
}
