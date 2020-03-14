package org.stringtree.jms;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Message;

public class InMemoryQueue extends InMemoryDestination {

    protected List messages;

    public InMemoryQueue(String name) {
        super(name);
        reset();
    }

    public InMemoryQueue() {
        this("unnamed queue");
    }

    protected void publish(Message message) {
        messages.add(message);
    }

    public int size() {
        return messages.size();
    }

    public Message peek() {
        return (Message) messages.get(0);
    }

    public Message recieve() {
        return (Message) messages.remove(0);
    }

    public void reset() {
        messages = new ArrayList();
    }
}
