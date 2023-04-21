package org.stringtree.mock.jms;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.jms.RecordingMockMessage;


public class MockTextMessage extends RecordingMockMessage implements TextMessage {

	public String text;

	public MockTextMessage(String text, String id) {
		this.text = text;
		correlationID = id;
	}
	
	public MockTextMessage(String text) {
		this(text, (String)null);
	}
	
	public MockTextMessage() {
		this("unknown text", "unknown id");
	}

	public void setText(String text) throws JMSException {
		record(new MockAction(this, "setText", new Object[] { text }));
		this.text = text;
	}

	public String getText() throws JMSException {
		record(new MockAction(this, "getText"));
		return text;
	}

	public void clearBody() throws JMSException {
		record(new MockAction(this, "clearBody"));
		text = "";
	}
}
