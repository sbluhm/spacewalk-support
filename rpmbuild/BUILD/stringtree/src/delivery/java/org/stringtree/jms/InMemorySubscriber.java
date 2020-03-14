package org.stringtree.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

public class InMemorySubscriber implements TopicSubscriber {
    
    protected Topic topic;
    protected MessageListener listener;

    public InMemorySubscriber(Topic topic) {
        this.topic = topic;
    }

    public Topic getTopic() throws JMSException {
        return topic;
    }

    public boolean getNoLocal() throws JMSException {
        return false;
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
        JmsHelper.subscribe(topic, listener);
    }

    public Message receive() throws JMSException {
        return null;
    }

    public Message receive(long timeout) throws JMSException {
        return null;
    }

    public Message receiveNoWait() throws JMSException {
        return null;
    }

    public void close() throws JMSException {
    }
}
