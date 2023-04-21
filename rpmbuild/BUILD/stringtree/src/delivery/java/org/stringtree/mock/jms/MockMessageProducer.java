package org.stringtree.mock.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueSender;
import javax.jms.Topic;
import javax.jms.TopicPublisher;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.jms.MockDestination;
import org.stringtree.mock.RecordingMock;


public class MockMessageProducer extends RecordingMock
	implements MessageProducer, QueueSender, TopicPublisher {
    
	private MockDestination destination;
	
	public MockMessageProducer(Destination destination) {
		this.destination = (MockDestination)destination;
	}

	public void setDisableMessageID(boolean value) throws JMSException {
		record(new MockAction(this, "setDisableMessageID", new Object[] { new Boolean(value) } ));
	}

	public boolean getDisableMessageID() throws JMSException {
		record(new MockAction(this, "getDisableMessageID"));
		return false;
	}

	public void setDisableMessageTimestamp(boolean value) throws JMSException {
		record(new MockAction(this, "setDisableMessageTimestamp", new Object[] { new Boolean(value) } ));
	}

	public boolean getDisableMessageTimestamp() throws JMSException {
		record(new MockAction(this, "getDisableMessageTimestamp"));
		return false;
	}

	public void setDeliveryMode(int deliveryMode) throws JMSException {
		record(new MockAction(this, "setDeliveryMode", new Object[] { new Integer(deliveryMode) } ));
	}

	public int getDeliveryMode() throws JMSException {
		record(new MockAction(this, "getDeliveryMode"));
		return 0;
	}

	public void setPriority(int defaultPriority) throws JMSException {
		record(new MockAction(this, "setPriority", new Object[] { new Integer(defaultPriority) } ));
	}

	public int getPriority() throws JMSException {
		record(new MockAction(this, "getPriority"));
		return 0;
	}

	public void setTimeToLive(long timeToLive) throws JMSException {
		record(new MockAction(this, "setTimeToLive", new Object[] { new Long(timeToLive) } ));
	}

	public long getTimeToLive() throws JMSException {
		record(new MockAction(this, "getTimeToLive"));
		return 0;
	}

	public Destination getDestination() {
		record(new MockAction(this, "getDestination"));
		return destination;
	}

	public void close() throws JMSException	{
		record(new MockAction(this, "close"));
	}

	public void send(Message message) throws JMSException {
		record(new MockAction(this, "send", new Object[] { message }));
		destination.sendMessage(message);
	}

	public void send(Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
		record(new MockAction(this, "send", new Object[] { message, 
			new Integer(deliveryMode), new Integer(priority), new Long(timeToLive) }));
		destination.sendMessage(message);
	}

	public void send(Destination destination, Message message) {
		record(new MockAction(this, "send", new Object[] { destination, message }));
		((MockDestination)destination).sendMessage(message);
	}

	public void send(Destination destination, Message message,
		int deliveryMode, int priority, long timeToLive) {
		record(new MockAction(this, "send", new Object[] { destination, message, 
				new Integer(deliveryMode), new Integer(priority), new Long(timeToLive) }));
		((MockDestination)destination).sendMessage(message);
	}

	public Queue getQueue() throws JMSException {
		record(new MockAction(this, "getQueue"));
		return destination;
	}

	public void send(Queue queue, Message message) throws JMSException {
		record(new MockAction(this, "send", new Object[] { queue, message }));
		((MockDestination)queue).sendMessage(message);
	}

	public void send(Queue queue, Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
		record(new MockAction(this, "send", new Object[] { queue, message, 
				new Integer(deliveryMode), new Integer(priority), new Long(timeToLive) }));
		((MockDestination)queue).sendMessage(message);
	}

	public Topic getTopic() throws JMSException {
		record(new MockAction(this, "getTopic"));
		return destination;
	}

	public void publish(Message message) throws JMSException {
		record(new MockAction(this, "publish", new Object[] { message }));
		destination.sendMessage(message);
	}

	public void publish(Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
		record(new MockAction(this, "publish", new Object[] { message, 
				new Integer(deliveryMode), new Integer(priority), new Long(timeToLive) }));
		destination.sendMessage(message);
	}

	public void publish(Topic topic, Message message) throws JMSException {
		record(new MockAction(this, "publish", new Object[] { topic, message }));
		((MockDestination)topic).sendMessage(message);
	}

	public void publish(Topic topic, Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
		record(new MockAction(this, "send", new Object[] { topic, message, 
				new Integer(deliveryMode), new Integer(priority), new Long(timeToLive) }));
		((MockDestination)topic).sendMessage(message);
	}
}
