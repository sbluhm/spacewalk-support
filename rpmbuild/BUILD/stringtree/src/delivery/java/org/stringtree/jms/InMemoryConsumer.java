package org.stringtree.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueReceiver;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

public class InMemoryConsumer implements MessageConsumer, QueueReceiver,
        TopicSubscriber, MessageListener {

    protected Destination destination;
    private MessageListener listener;

    public InMemoryConsumer(Destination destination) {
        this.destination = destination;
        JmsHelper.subscribe(destination, this);
    }

    public String getMessageSelector() throws JMSException {
        return null;
    }

    public MessageListener getMessageListener() throws JMSException {
        return listener;
    }

    public void setMessageListener(MessageListener listener)
            throws JMSException {
        this.listener = listener;
    }

    public Message receive() throws JMSException {
        return JmsHelper.receive((Queue) destination);
    }

    public Message receive(long timeout) throws JMSException {
        return JmsHelper.receive((Queue) destination);
    }

    public Message receiveNoWait() throws JMSException {
        return JmsHelper.receive((Queue) destination);
    }

    public void close() throws JMSException {
    }

    public Queue getQueue() throws JMSException {
        return (Queue) destination;
    }

    public Topic getTopic() throws JMSException {
        return (Topic) destination;
    }

    public boolean getNoLocal() throws JMSException {
        return false;
    }

    public void onMessage(Message message) {
        if (listener != null) {
            listener.onMessage(message);
        }
    }
}
