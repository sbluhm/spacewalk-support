package org.stringtree.mock.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.RecordingMock;

public class MockConnectionFactory extends RecordingMock 
	implements ConnectionFactory, QueueConnectionFactory, TopicConnectionFactory {

    public Connection createConnection() {
		record(new MockAction(this, "createConnection"));
		return new MockJMSConnection();
	}

	public Connection createConnection(String userName, String password) {
		record(new MockAction(this, "createConnection", new Object[] { userName, password}));
		return new MockJMSConnection(userName, password);
	}

	public QueueConnection createQueueConnection() throws JMSException {
		record(new MockAction(this, "createQueueConnection"));
		return new MockJMSConnection();
	}

	public QueueConnection createQueueConnection(String userName, String password) throws JMSException { 
		record(new MockAction(this, "createQueueConnection", new Object[] { userName, password}));
		return new MockJMSConnection(userName, password);
	}

	public TopicConnection createTopicConnection() throws JMSException {
		record(new MockAction(this, "createTopicConnection"));
		return new MockJMSConnection();
	}

	public TopicConnection createTopicConnection(String userName, String password) throws JMSException {
		record(new MockAction(this, "createTopicConnection", new Object[] { userName, password}));
		return new MockJMSConnection(userName, password);
	}
}
