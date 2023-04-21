package org.stringtree.mock.jms;

import java.util.Enumeration;

import javax.jms.ConnectionMetaData;
import javax.jms.JMSException;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.RecordingMock;
import org.stringtree.util.enumeration.EmptyEnumeration;


public class MockConnectionMetadata extends RecordingMock implements ConnectionMetaData {
    
	public String getJMSVersion() throws JMSException {
		record(new MockAction(this, "getJMSVersion"));
		return "unknown JMS version";
	}

	public int getJMSMajorVersion() throws JMSException {
		record(new MockAction(this, "getJMSMajorVersion"));
		return 0;
	}

	public int getJMSMinorVersion() throws JMSException {
		record(new MockAction(this, "getJMSMinorVersion"));
		return 0;
	}

	public String getJMSProviderName() throws JMSException {
		record(new MockAction(this, "getJMSProviderName"));
		return "unknown JMS provider name";
	}

	public String getProviderVersion() throws JMSException {
		record(new MockAction(this, "getProviderVersion"));
		return "unknown provider version";
	}

	public int getProviderMajorVersion() throws JMSException {
		record(new MockAction(this, "getProviderMajorVersion"));
		return 0;
	}

	public int getProviderMinorVersion() throws JMSException {
		record(new MockAction(this, "getProviderMinorVersion"));
		return 0;
	}

	public Enumeration getJMSXPropertyNames() throws JMSException {
		record(new MockAction(this, "getJMSXPropertyNames"));
		return new EmptyEnumeration();
	}
}
