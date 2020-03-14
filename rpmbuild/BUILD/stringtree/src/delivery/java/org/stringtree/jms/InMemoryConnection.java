package org.stringtree.jms;

import java.util.ArrayList;
import java.util.List;

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

public class InMemoryConnection implements Connection, QueueConnection, TopicConnection {

    protected List sessions = new ArrayList();
    private String clientID;
    private ExceptionListener exceptionListener;
    private ConnectionMetaData metadata = new InMemoryConnectionMetaData();

    public Session createSession(boolean transacted, int acknowledgeMode) {
        Session ret = new InMemorySession(transacted, acknowledgeMode);
        sessions.add(ret);
        return ret;
    }

    public QueueSession createQueueSession(boolean transacted,
            int acknowledgeMode) throws JMSException {
        return (QueueSession) createSession(transacted, acknowledgeMode);
    }

    public TopicSession createTopicSession(boolean transacted,
            int acknowledgeMode) throws JMSException {
        return (TopicSession) createSession(transacted, acknowledgeMode);
    }

    public String getClientID() throws JMSException {
        return clientID;
    }

    public void setClientID(String clientID) throws JMSException {
        this.clientID = clientID;
    }

    public ConnectionMetaData getMetaData() throws JMSException {
        return metadata;
    }

    public ExceptionListener getExceptionListener() throws JMSException {
        return exceptionListener;
    }

    public void setExceptionListener(ExceptionListener exceptionListener)
            throws JMSException {
        this.exceptionListener = exceptionListener;
    }

    public void start() throws JMSException {
        updateSessions(true);
    }

    public void stop() throws JMSException {
        updateSessions(false);
    }

    private void updateSessions(boolean running) {
        for (int i = 0; i < sessions.size(); ++i) {
            Session session = (Session) sessions.get(i);
            JmsHelper.updateSession(session, running);
        }
    }

    public void close() throws JMSException {
    }

    public ConnectionConsumer createConnectionConsumer(Destination arg0,
            String arg1, ServerSessionPool arg2, int arg3) {
        return null;
    }

    public ConnectionConsumer createDurableConnectionConsumer(Topic arg0,
            String arg1, String arg2, ServerSessionPool arg3, int arg4)
            throws JMSException {
        return null;
    }

    public ConnectionConsumer createConnectionConsumer(Queue queue,
            String messageSelector, ServerSessionPool sessionPool,
            int maxMessages) throws JMSException {
        return null;
    }

    public ConnectionConsumer createConnectionConsumer(Topic topic,
            String messageSelector, ServerSessionPool sessionPool,
            int maxMessages) throws JMSException {
        return null;
    }
}
