package org.stringtree.jms;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

public class JmsHelper {

    public static void send(Destination destination, Message message) {
        ((InMemoryDestination) destination).add(message);
    }

    public static Message receive(Queue destination) {
        return ((InMemoryQueue) destination).recieve();
    }

    public static int size(Destination destination) {
        return ((InMemoryDestination) destination).size();
    }

    public static Message peek(Destination destination) {
        return ((InMemoryDestination) destination).peek();
    }

    public static void publish(Topic topic, Message message) {
        ((InMemoryDestination) topic).add(message);
    }

    public static void subscribe(Destination destination,
            MessageListener listener) {
        ((InMemoryTopic) destination).subscribe(listener);
    }

    public static void updateSession(Session session, boolean running) {
        ((InMemorySession) session).updateProducers(running);
    }

    public static void updateProducer(MessageProducer producer, boolean running) {
        ((InMemoryProducer) producer).setStatus(running);
    }

    public static void produce(Destination destination, Message message) {
        ((InMemoryDestination) destination).add(message);
    }
}
