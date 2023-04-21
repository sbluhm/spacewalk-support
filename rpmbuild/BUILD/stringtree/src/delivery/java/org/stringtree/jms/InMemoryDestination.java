package org.stringtree.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TemporaryQueue;
import javax.jms.Topic;

public abstract class InMemoryDestination implements Destination, Queue, Topic, TemporaryQueue {

    protected String name;

    public InMemoryDestination(String name) {
        this.name = name;
    }

    public InMemoryDestination() {
        this("unnamed");
    }

    public void add(Message message) {
        Message clone = (Message) ((InMemoryMessage) message).clone();
        publish(clone);
    }

    public String getQueueName() throws JMSException {
        return name;
    }

    public String getTopicName() throws JMSException {
        return name;
    }

    public void delete() throws JMSException {
    }

    protected abstract void publish(Message message);

    public abstract int size();

    public abstract Message peek();

    public abstract void reset();
}
