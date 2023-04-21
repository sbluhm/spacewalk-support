package org.stringtree.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;

public class InMemoryConnectionFactory implements ConnectionFactory,
        QueueConnectionFactory, TopicConnectionFactory {
    
    public Connection createConnection() {
        return new InMemoryConnection();
    }

    public Connection createConnection(String userName, String password) {
        return null;
    }

    public QueueConnection createQueueConnection() throws JMSException {
        return new InMemoryConnection();
    }

    public QueueConnection createQueueConnection(String userName,
            String password) throws JMSException {
        return null;
    }

    public TopicConnection createTopicConnection() throws JMSException {
        return new InMemoryConnection();
    }

    public TopicConnection createTopicConnection(String userName,
            String password) throws JMSException {
        return null;
    }

}
