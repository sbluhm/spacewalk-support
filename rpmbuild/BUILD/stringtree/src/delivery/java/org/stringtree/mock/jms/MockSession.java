package org.stringtree.mock.jms;

import java.io.Serializable;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TemporaryQueue;
import javax.jms.TemporaryTopic;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.jms.MockDestination;
import org.stringtree.mock.RecordingMock;

public class MockSession extends RecordingMock 
	implements Session, QueueSession, TopicSession {

    public BytesMessage createBytesMessage() throws JMSException {
		record(new MockAction(this, "createBytesMessage"));
		return null;
	}

	public MapMessage createMapMessage() throws JMSException {
		record(new MockAction(this, "createMapMessage"));
		return null;
	}

	public Message createMessage() throws JMSException {
		record(new MockAction(this, "createMessage"));
		return null;
	}

	public ObjectMessage createObjectMessage() throws JMSException {
		record(new MockAction(this, "createObjectMessage"));
		return null;
	}

	public ObjectMessage createObjectMessage(Serializable object) throws JMSException {
		record(new MockAction(this, "createObjectMessage", new Object[] { object }));
		return null;
	}

	public StreamMessage createStreamMessage() throws JMSException {
		record(new MockAction(this, "createStreamMessage"));
		return null;
	}

	public TextMessage createTextMessage() throws JMSException {
		record(new MockAction(this, "createTextMessage"));
		return new MockTextMessage();
	}

	public TextMessage createTextMessage(String text) throws JMSException {
		record(new MockAction(this, "createTextMessage", new Object[] { text }));
		return new MockTextMessage(text);
	}

	public boolean getTransacted() throws JMSException {
		record(new MockAction(this, "getTransacted"));
		return false;
	}

	public int getAcknowledgeMode() {
		record(new MockAction(this, "getAcknowledgeMode"));
		return 0;
	}

	public void commit() throws JMSException {
		record(new MockAction(this, "commit"));
	}

	public void rollback() throws JMSException {
		record(new MockAction(this, "rollback"));
	}

	public void close() throws JMSException {
		record(new MockAction(this, "close"));
	}

	public void recover() throws JMSException {
		record(new MockAction(this, "recover"));
	}

	public MessageListener getMessageListener() throws JMSException {
		record(new MockAction(this, "getMessageListener"));
		return null;
	}

	public void setMessageListener(MessageListener listener) throws JMSException {
		record(new MockAction(this, "setMessageListener", new Object[] { listener }));
	}

	public void run() {
		record(new MockAction(this, "run"));
	}

	public MessageProducer createProducer(Destination destination) {
		record(new MockAction(this, "createProducer", new Object[] { destination }));
		return new MockMessageProducer(destination);
	}

	public MessageConsumer createConsumer(Destination destination) {
		record(new MockAction(this, "createConsumer", new Object[] { destination }));
		return new MockMessageConsumer();
	}

	public MessageConsumer createConsumer(Destination destination,
		String messageSelector) {
		record(new MockAction(this, "createConsumer", new Object[] { destination, messageSelector }));
		return new MockMessageConsumer();
	}

	public MessageConsumer createConsumer(Destination destination,
		String messageSelector, boolean NoLocal) {
		record(new MockAction(this, "createConsumer", new Object[] { destination, messageSelector, new Boolean(NoLocal) }));
		return new MockMessageConsumer();
	}

	public Queue createQueue(String queueName) throws JMSException {
		record(new MockAction(this, "createQueue", new Object[] { queueName }));
		return new MockDestination(queueName);
	}

	public Topic createTopic(String topicName) throws JMSException {
		record(new MockAction(this, "createTopic", new Object[] { topicName }));
		return new MockDestination(topicName);
	}

	public TopicSubscriber createDurableSubscriber(Topic topic, String name) throws JMSException {
		record(new MockAction(this, "createDurableSubscriber", new Object[] { topic, name }));
		return new MockSubscriber();
	}

	public TopicSubscriber createDurableSubscriber(Topic topic, String name,
		String messageSelector, boolean noLocal) throws JMSException {
		record(new MockAction(this, "createDurableSubscriber", new Object[] { topic, name, messageSelector, new Boolean(noLocal) }));
		return new MockSubscriber();
	}

	public QueueBrowser createBrowser(Queue queue) throws JMSException {
		record(new MockAction(this, "createBrowser", new Object[] { queue }));
		return new MockBrowser();
	}

	public QueueBrowser createBrowser(Queue queue, String messageSelector) throws JMSException {
		record(new MockAction(this, "createBrowser", new Object[] { queue, messageSelector }));
		return new MockBrowser();
	}

	public TemporaryQueue createTemporaryQueue() throws JMSException {
		record(new MockAction(this, "createTemporaryQueue"));
		return new MockDestination("temporary");
	}

	public TemporaryTopic createTemporaryTopic() throws JMSException {
		record(new MockAction(this, "createTemporaryTopic"));
		return new MockDestination("temporary");
	}

	public void unsubscribe(String name) throws JMSException {
		record(new MockAction(this, "unsubscribe", new Object[] { name }));
	}

	public QueueReceiver createReceiver(Queue queue) throws JMSException {
		record(new MockAction(this, "createReceiver", new Object[] { queue }));
		return new MockMessageConsumer();
	}

	public QueueReceiver createReceiver(Queue queue, String messageSelector) throws JMSException {
		record(new MockAction(this, "createReceiver", new Object[] { queue, messageSelector }));
		return new MockMessageConsumer();
	}

	public QueueSender createSender(Queue queue) throws JMSException {
		record(new MockAction(this, "createSender", new Object[] { queue }));
		return new MockMessageProducer(queue);
	}

	public TopicSubscriber createSubscriber(Topic topic) throws JMSException {
		record(new MockAction(this, "createSubscriber", new Object[] { topic }));
		return new MockMessageConsumer();
	}

	public TopicSubscriber createSubscriber(Topic topic, String messageSelector, boolean noLocal) throws JMSException {
		record(new MockAction(this, "createSubscriber", new Object[] { topic, messageSelector, new Boolean(noLocal) }));
		return new MockMessageConsumer();
	}

	public TopicPublisher createPublisher(Topic topic) throws JMSException {
		record(new MockAction(this, "createPublisher", new Object[] { topic }));
		return new MockMessageProducer(topic);
	}
}
