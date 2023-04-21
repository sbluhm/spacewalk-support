package org.stringtree.jms;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public class InMemoryTextMessage extends InMemoryMessage implements TextMessage {

    private String text;

    public InMemoryTextMessage(String text) {
        setText(text);
    }

    public InMemoryTextMessage() {
        this(null);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Object clone() {
        InMemoryTextMessage ret = new InMemoryTextMessage();
        super.cloneFields(ret);
        ret.text = text;
        return ret;
    }

    public void clearBody() throws JMSException {
        text = null;
    }
}
