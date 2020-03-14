package org.stringtree.jms;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueSender;
import javax.jms.Topic;
import javax.jms.TopicPublisher;

class Defer {
    
    public Destination destination;
    public Message message;

    public Defer(Destination destination, Message message) {
        this.destination = destination;
        this.message = message;
    }
}

public class InMemoryProducer implements MessageProducer, QueueSender, TopicPublisher {

    protected Destination destination;
    protected List deferred = new ArrayList();
    protected long timeToLive;
    protected int priority;
    protected int deliveryMode;
    protected boolean disableMessageTimestamp;
    protected boolean disableMessageID;
    private boolean running = false;

    public InMemoryProducer(Destination destination) {
        this.destination = destination;
    }

    public void setDisableMessageID(boolean disableMessageID)
            throws JMSException {
        this.disableMessageID = disableMessageID;
    }

    public boolean getDisableMessageID() throws JMSException {
        return disableMessageID;
    }

    public void setDisableMessageTimestamp(boolean disableMessageTimestamp)
            throws JMSException {
        this.disableMessageTimestamp = disableMessageTimestamp;
    }

    public boolean getDisableMessageTimestamp() throws JMSException {
        return disableMessageTimestamp;
    }

    public void setDeliveryMode(int deliveryMode) throws JMSException {
        this.deliveryMode = deliveryMode;
    }

    public int getDeliveryMode() throws JMSException {
        return deliveryMode;
    }

    public void setPriority(int defaultPriority) throws JMSException {
        this.priority = defaultPriority;
    }

    public int getPriority() throws JMSException {
        return priority;
    }

    public void setTimeToLive(long timeToLive) throws JMSException {
        this.timeToLive = timeToLive;
    }

    public long getTimeToLive() throws JMSException {
        return timeToLive;
    }

    public Destination getDestination() {
        return destination;
    }

    public void close() throws JMSException {
    }

    public void send(Message message) throws JMSException {
        produceOrDefer(destination, message);
    }

    public void send(Message message, int deliveryMode, int priority,
            long timeToLive) throws JMSException {
        produceOrDefer(destination, message);
    }

    public void send(Destination destination, Message message) {
        produceOrDefer(destination, message);
    }

    public void send(Destination destination, Message message,
            int deliveryMode, int priority, long timeToLive) {
        produceOrDefer(destination, message);
    }

    public Queue getQueue() throws JMSException {
        return (Queue) destination;
    }

    public void send(Queue queue, Message message) throws JMSException {
        produceOrDefer(queue, message);
    }

    public void send(Queue queue, Message message, int deliveryMode,
            int priority, long timeToLive) throws JMSException {
        produceOrDefer(queue, message);
    }

    public Topic getTopic() throws JMSException {
        return (Topic) destination;
    }

    public void publish(Message message) throws JMSException {
        produceOrDefer(destination, message);
    }

    public void publish(Message message, int deliveryMode, int priority,
            long timeToLive) throws JMSException {
        produceOrDefer(destination, message);
    }

    public void publish(Topic topic, Message message) throws JMSException {
        produceOrDefer(topic, message);
    }

    public void publish(Topic topic, Message message, int deliveryMode,
            int priority, long timeToLive) throws JMSException {
        produceOrDefer(topic, message);
    }

    public void setStatus(boolean running) {
        this.running = running;
        if (running)
            flush();
    }

    private void produceOrDefer(Destination destination, Message message) {
        if (running) {
            JmsHelper.produce(destination, message);
        } else {
            deferred.add(new Defer(destination, message));
        }
    }

    private void flush() {
        while (deferred.size() > 0) {
            Defer defer = (Defer) deferred.remove(0);
            JmsHelper.produce(defer.destination, defer.message);
        }
    }

}
