package org.stringtree.jms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

public class InMemorySession implements Session, QueueSession, TopicSession {

    private boolean transacted;
    private int acknowledgeMode;
    protected List producers = new ArrayList();

    public InMemorySession(boolean transacted, int acknowledgeMode) {
        this.transacted = transacted;
        this.acknowledgeMode = acknowledgeMode;
    }

    public BytesMessage createBytesMessage() throws JMSException {
        return null;
    }

    public MapMessage createMapMessage() throws JMSException {
        return null;
    }

    public Message createMessage() throws JMSException {
        return new InMemoryNullMessage();
    }

    public ObjectMessage createObjectMessage() throws JMSException {
        return null;
    }

    public ObjectMessage createObjectMessage(Serializable object)
            throws JMSException {
        return null;
    }

    public StreamMessage createStreamMessage() throws JMSException {
        return null;
    }

    public TextMessage createTextMessage() throws JMSException {
        return new InMemoryTextMessage();
    }

    public TextMessage createTextMessage(String text) throws JMSException {
        return new InMemoryTextMessage(text);
    }

    public boolean getTransacted() throws JMSException {
        return transacted;
    }

    public int getAcknowledgeMode() {
        return acknowledgeMode;
    }

    public void commit() throws JMSException {
    }

    public void rollback() throws JMSException {
    }

    public void close() throws JMSException {
    }

    public void recover() throws JMSException {
    }

    public MessageListener getMessageListener() throws JMSException {
        return null;
    }

    public void setMessageListener(MessageListener listener)
            throws JMSException {
    }

    public void run() {
    }

    public MessageProducer createProducer(Destination destination) {
        return createInMemoryProducer(destination);
    }

    public MessageConsumer createConsumer(Destination destination) {
        return new InMemoryConsumer(destination);
    }

    public MessageConsumer createConsumer(Destination destination,
            String messageSelector) {
        return null;
    }

    public MessageConsumer createConsumer(Destination destination,
            String messageSelector, boolean NoLocal) {
        return null;
    }

    public Queue createQueue(String queueName) throws JMSException {
        return null;
    }

    public Topic createTopic(String topicName) throws JMSException {
        return null;
    }

    public TopicSubscriber createDurableSubscriber(Topic topic, String name)
            throws JMSException {
        return null;
    }

    public TopicSubscriber createDurableSubscriber(Topic topic, String name,
            String messageSelector, boolean noLocal) throws JMSException {
        return null;
    }

    public QueueBrowser createBrowser(Queue queue) throws JMSException {
        return null;
    }

    public QueueBrowser createBrowser(Queue queue, String messageSelector)
            throws JMSException {
        return null;
    }

    public TemporaryQueue createTemporaryQueue() throws JMSException {
        return new InMemoryQueue();
    }

    public TemporaryTopic createTemporaryTopic() throws JMSException {
        return null;
    }

    public void unsubscribe(String name) throws JMSException {
    }

    public QueueReceiver createReceiver(Queue queue) throws JMSException {
        return new InMemoryConsumer(queue);
    }

    public QueueReceiver createReceiver(Queue queue, String messageSelector)
            throws JMSException {
        return null;
    }

    public QueueSender createSender(Queue queue) throws JMSException {
        return (QueueSender) createInMemoryProducer(queue);
    }

    public TopicSubscriber createSubscriber(Topic topic) throws JMSException {
        return new InMemoryConsumer(topic);
    }

    public TopicSubscriber createSubscriber(Topic topic,
            String messageSelector, boolean noLocal) throws JMSException {
        return null;
    }

    public TopicPublisher createPublisher(Topic topic) throws JMSException {
        return (TopicPublisher) createInMemoryProducer(topic);
    }

    protected MessageProducer createInMemoryProducer(Destination destination) {
        QueueSender ret = new InMemoryProducer(destination);
        producers.add(ret);
        return ret;
    }

    protected void updateProducers(boolean running) {
        for (int i = 0; i < producers.size(); ++i) {
            MessageProducer producer = (MessageProducer) producers.get(i);
            JmsHelper.updateProducer(producer, running);
        }
    }
}
