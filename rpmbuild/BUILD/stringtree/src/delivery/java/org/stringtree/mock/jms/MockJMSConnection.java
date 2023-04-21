package org.stringtree.mock.jms;

import javax.jms.Connection;
import javax.jms.ConnectionConsumer;
import javax.jms.ConnectionMetaData;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.ServerSessionPool;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.RecordingMock;


public class MockJMSConnection extends RecordingMock
	implements Connection, ExceptionListener, QueueConnection, TopicConnection {
	
	public String userName;
	public String password;
	public String clientID;

	public MockJMSConnection(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public MockJMSConnection() {
		this("unspecified name", "unspecified password");
	}

	public Session createSession(boolean transacted, int acknowledgeMode) {
		record(new MockAction(this, "createSession", new Object[] { new Boolean(transacted), new Integer(acknowledgeMode)}));
		return new MockSession();
	}

	public String getClientID() throws JMSException {
		record(new MockAction(this, "getClientID"));
		return clientID;
	}

	public void setClientID(String clientID) throws JMSException {
		record(new MockAction(this, "setClientID", new Object[] { clientID }));
		this.clientID = clientID;
	}

	public ConnectionMetaData getMetaData() throws JMSException {
		record(new MockAction(this, "getMetaData"));
		return new MockConnectionMetadata();
	}

	public ExceptionListener getExceptionListener() throws JMSException {
		record(new MockAction(this, "getExceptionListener"));
		return this;
	}

	public void setExceptionListener(ExceptionListener listener) throws JMSException {
		record(new MockAction(this, "setExceptionListener", new Object[] { listener }));
	}

	public void start() throws JMSException {
		record(new MockAction(this, "start"));
	}

	public void stop() throws JMSException {
		record(new MockAction(this, "stop"));
	}

	public void close() throws JMSException {
		record(new MockAction(this, "close"));
	}

	public ConnectionConsumer createConnectionConsumer(Destination destination,
			String messageSelector, ServerSessionPool sessionPool,
			int maxMessages) {
		record(new MockAction(this, "createConnectionConsumer", 
				new Object[] { destination, messageSelector, sessionPool, new Integer(maxMessages) }));
		return new MockConnectionConsumer();
	}

	public ConnectionConsumer createDurableConnectionConsumer(Topic topic,
			String subscriptionName, String messageSelector,
			ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		record(new MockAction(this, "createDurableConnectionConsumer", 
				new Object[] { topic, messageSelector, sessionPool, new Integer(maxMessages) }));
		return new MockConnectionConsumer();
	}

	public void onException(JMSException exception) {
		record(new MockAction(this, "onException", new Object[] { exception }));
	}

	public QueueSession createQueueSession(boolean transacted, int acknowledgeMode) throws JMSException {
		record(new MockAction(this, "createQueueSession", 
				new Object[] { new Boolean(transacted), new Integer(acknowledgeMode)}));
		return new MockSession();
	}

	public ConnectionConsumer createConnectionConsumer(Queue queue, String messageSelector, 
			ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		record(new MockAction(this, "createConnectionConsumer", 
				new Object[] { queue, messageSelector, sessionPool, new Integer(maxMessages) }));
		return new MockConnectionConsumer();
	}

	public TopicSession createTopicSession(boolean transacted, int acknowledgeMode) throws JMSException {
		record(new MockAction(this, "createTopicSession", new Object[] { new Boolean(transacted), new Integer(acknowledgeMode)}));
		return new MockSession();
	}

	public ConnectionConsumer createConnectionConsumer(Topic topic, String messageSelector, 
			ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		record(new MockAction(this, "createConnectionConsumer", 
				new Object[] { topic, messageSelector, sessionPool, new Integer(maxMessages) }));
		return new MockConnectionConsumer();
	}
}
