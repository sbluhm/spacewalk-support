package org.stringtree.jms;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;

public class InMemoryTopic extends InMemoryDestination {

    protected List listeners;

    public InMemoryTopic(String name) {
        super(name);
        reset();
    }

    public InMemoryTopic() {
        this("unnamed topic");
    }

    protected void publish(Message message) {
        if (listeners != null) {
            for (int i = 0; i < listeners.size(); ++i) {
                MessageListener listener = (MessageListener) listeners.get(i);
                listener.onMessage(message);
            }
        }
    }

    public void subscribe(MessageListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(MessageListener listener) {
        listeners.remove(listener);
    }

    public void reset() {
        listeners = new ArrayList();
    }

    public int size() {
        return listeners.size();
    }

    public Message peek() {
        return null;
    }
}
