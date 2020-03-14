package org.stringtree.mock.jms;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;

import org.stringtree.mock.MockAction;
import org.stringtree.mock.RecordingMock;
import org.stringtree.util.enumeration.IteratorEnumeration;


public abstract class RecordingMockMessage extends RecordingMock implements Message {
    
	public String messageID;
	public long timestamp;
	public byte[] correlationIDAsBytes;
	public String correlationID;
	public Destination jMSReplyTo;
	public Destination destination;
	public int deliveryMode;
	public boolean redelivered;
	public String type;
	public long expiration;
	public int priority;

	public Map properties = new HashMap();

	public String getJMSMessageID() throws JMSException {
		record(new MockAction(this, "getJMSMessageID"));
		return messageID;
	}

	public void setJMSMessageID(String id) throws JMSException {
		record(new MockAction(this, "setJMSMessageID", new Object[] { id }));
	}

	public long getJMSTimestamp() throws JMSException {
		record(new MockAction(this, "getJMSTimestamp"));
		return timestamp;
	}

	public void setJMSTimestamp(long timestamp) throws JMSException {
		record(new MockAction(this, "setJMSTimestamp", new Object[] { new Long(timestamp) }));
	}

	public byte[] getJMSCorrelationIDAsBytes() throws JMSException {
		record(new MockAction(this, "getJMSCorrelationIDAsBytes"));
		return correlationIDAsBytes;
	}

	public void setJMSCorrelationIDAsBytes(byte[] bytes) throws JMSException {
		record(new MockAction(this, "setJMSCorrelationIDAsBytes", new Object[] { bytes }));
		this.correlationIDAsBytes = bytes;
	}

	public void setJMSCorrelationID(String correlationID) throws JMSException {
		record(new MockAction(this, "setJMSCorrelationID", new Object[] { correlationID }));
		this.correlationID = correlationID;
	}

	public String getJMSCorrelationID() throws JMSException {
		record(new MockAction(this, "getJMSCorrelationID"));
		return correlationID;
	}

	public Destination getJMSReplyTo() throws JMSException {
		record(new MockAction(this, "getJMSReplyTo"));
		return jMSReplyTo;
	}

	public void setJMSReplyTo(Destination jMSReplyTo) throws JMSException {
		record(new MockAction(this, "setJMSReplyTo", new Object[] { jMSReplyTo }));
		this.jMSReplyTo = jMSReplyTo;
	}

	public Destination getJMSDestination() throws JMSException {
		record(new MockAction(this, "getDestination"));
		return destination;
	}

	public void setJMSDestination(Destination destination) throws JMSException {
		record(new MockAction(this, "setJMSDestination", new Object[] { destination }));
		this.destination = destination;
	}

	public int getJMSDeliveryMode() throws JMSException {
		record(new MockAction(this, "getJMSDeliveryMode"));
		return deliveryMode;
	}

	public void setJMSDeliveryMode(int deliveryMode) throws JMSException {
		record(new MockAction(this, "setJMSDdeliveryMode", new Object[] { new Integer(deliveryMode) }));
		this.deliveryMode = deliveryMode;
	}

	public boolean getJMSRedelivered() throws JMSException {
		record(new MockAction(this, "getJMSRedelivered"));
		return redelivered;
	}

	public void setJMSRedelivered(boolean redelivered) throws JMSException {
		record(new MockAction(this, "setJMSRedelivered", new Object[] { new Boolean(redelivered) }));
		this.redelivered = redelivered;
	}

	public String getJMSType() throws JMSException {
		record(new MockAction(this, "getJMSType"));
		return type;
	}

	public void setJMSType(String type) throws JMSException {
		record(new MockAction(this, "setJMSType", new Object[] { type }));
		this.type = type;
	}

	public long getJMSExpiration() throws JMSException {
		record(new MockAction(this, "getJMSExpiration"));
		return expiration;
	}

	public void setJMSExpiration(long expiration) throws JMSException {
		record(new MockAction(this, "setJMSType", new Object[] { new Long(expiration) }));
		this.expiration = expiration;
	}

	public int getJMSPriority() throws JMSException {
		record(new MockAction(this, "getJMSPriority"));
		return priority;
	}

	public void setJMSPriority(int priority) throws JMSException {
		record(new MockAction(this, "setJMSPriority", new Object[] { new Integer(priority) }));
		this.priority = priority;
	}

	public void clearProperties() throws JMSException {
		record(new MockAction(this, "clearProperties"));
		properties.clear();
	}

	public boolean propertyExists(String name) throws JMSException {
		record(new MockAction(this, "propertyExists", new Object[] { name } ));
		return properties.containsKey(name);
	}

	public boolean getBooleanProperty(String name) throws JMSException {
		record(new MockAction(this, "getBooleanProperty", new Object[] { name } ));
		return ((Boolean)properties.get(name)).booleanValue();
	}

	public byte getByteProperty(String name) throws JMSException {
		record(new MockAction(this, "getByteProperty", new Object[] { name } ));
		return ((Byte)properties.get(name)).byteValue();
	}

	public short getShortProperty(String name) throws JMSException {
		record(new MockAction(this, "getShortProperty", new Object[] { name } ));
		return ((Short)properties.get(name)).shortValue();
	}

	public int getIntProperty(String name) throws JMSException {
		record(new MockAction(this, "getIntProperty", new Object[] { name } ));
		return ((Integer)properties.get(name)).intValue();
	}

	public long getLongProperty(String name) throws JMSException {
		record(new MockAction(this, "getLongProperty", new Object[] { name } ));
		return ((Long)properties.get(name)).longValue();
	}

	public float getFloatProperty(String name) throws JMSException {
		record(new MockAction(this, "getFloatProperty", new Object[] { name } ));
		return ((Float)properties.get(name)).floatValue();
	}

	public double getDoubleProperty(String name) throws JMSException {
		record(new MockAction(this, "getDoubleProperty", new Object[] { name } ));
		return ((Double)properties.get(name)).doubleValue();
	}

	public String getStringProperty(String name) throws JMSException {
		record(new MockAction(this, "getStringProperty", new Object[] { name } ));
		return (String)properties.get(name);
	}

	public Object getObjectProperty(String name) throws JMSException {
		record(new MockAction(this, "getObjectProperty", new Object[] { name } ));
		return properties.get(name);
	}

	public Enumeration getPropertyNames() throws JMSException {
		record(new MockAction(this, "getPropertyNames"));
		return new IteratorEnumeration(properties.keySet().iterator());
	}

	public void setBooleanProperty(String name, boolean value) throws JMSException {
		Boolean obj = new Boolean(value);
		record(new MockAction(this, "setBooleanProperty", new Object[] { name, obj } ));
		properties.put(name, obj);
	}

	public void setByteProperty(String name, byte value) throws JMSException {
		Byte obj = new Byte(value);
		record(new MockAction(this, "setByteProperty", new Object[] { name, obj } ));
		properties.put(name, obj);
	}

	public void setShortProperty(String name, short value) throws JMSException {
		Short obj = new Short(value);
		record(new MockAction(this, "setShortProperty", new Object[] { name, obj } ));
		properties.put(name, obj);
	}

	public void setIntProperty(String name, int value) throws JMSException {
		Integer obj = new Integer(value);
		record(new MockAction(this, "setIntProperty", new Object[] { name, obj } ));
		properties.put(name, obj);
	}

	public void setLongProperty(String name, long value) throws JMSException {
		Long obj = new Long(value);
		record(new MockAction(this, "setLongProperty", new Object[] { name, obj } ));
		properties.put(name, obj);
	}

	public void setFloatProperty(String name, float value) throws JMSException {
		Float obj = new Float(value);
		record(new MockAction(this, "setFloatProperty", new Object[] { name, obj } ));
		properties.put(name, obj);
	}

	public void setDoubleProperty(String name, double value) throws JMSException {
		Double obj = new Double(value);
		record(new MockAction(this, "setDoubleProperty", new Object[] { name, obj } ));
		properties.put(name, obj);
	}

	public void setStringProperty(String name, String obj) throws JMSException {
		record(new MockAction(this, "setShortProperty", new Object[] { name, obj } ));
		properties.put(name, obj);
	}

	public void setObjectProperty(String name, Object obj) throws JMSException {
		record(new MockAction(this, "setShortProperty", new Object[] { name, obj } ));
		properties.put(name, obj);
	}

	public void acknowledge() throws JMSException {
		record(new MockAction(this, "acknowledge"));
	}
}
