package org.stringtree.jms;

import java.util.Enumeration;
import java.util.Properties;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;

import org.stringtree.util.BooleanUtils;
import org.stringtree.util.FloatNumberUtils;
import org.stringtree.util.IntegerNumberUtils;
import org.stringtree.util.LongNumberUtils;
import org.stringtree.util.SmallNumberUtils;

public abstract class InMemoryMessage implements Message {

    private Properties properties;
    private String messageID;
    private long timestamp;
    private String correlationID;
    private byte[] correlationIDBytes;
    private Destination replyTo;
    private Destination destination;
    private int deliveryMode;
    private boolean redelivered;
    private String type;
    private long expiration;
    private int priority;
    public abstract Object clone();

    public String getJMSMessageID() throws JMSException {
        return messageID;
    }

    public void setJMSMessageID(String messageID) throws JMSException {
        this.messageID = messageID;
    }

    public long getJMSTimestamp() throws JMSException {
        return timestamp;
    }

    public void setJMSTimestamp(long timestamp) throws JMSException {
        this.timestamp = timestamp;
    }

    public byte[] getJMSCorrelationIDAsBytes() throws JMSException {
        return correlationIDBytes;
    }

    public void setJMSCorrelationIDAsBytes(byte[] correlationIDBytes)
            throws JMSException {
        this.correlationIDBytes = correlationIDBytes;
    }

    public void setJMSCorrelationID(String correlationID) throws JMSException {
        this.correlationID = correlationID;
    }

    public String getJMSCorrelationID() throws JMSException {
        return correlationID;
    }

    public Destination getJMSReplyTo() throws JMSException {
        return replyTo;
    }

    public void setJMSReplyTo(Destination replyTo) throws JMSException {
        this.replyTo = replyTo;
    }

    public Destination getJMSDestination() throws JMSException {
        return destination;
    }

    public void setJMSDestination(Destination destination) throws JMSException {
        this.destination = destination;
    }

    public int getJMSDeliveryMode() throws JMSException {
        return deliveryMode;
    }

    public void setJMSDeliveryMode(int deliveryMode) throws JMSException {
        this.deliveryMode = deliveryMode;
    }

    public boolean getJMSRedelivered() throws JMSException {
        return redelivered;
    }

    public void setJMSRedelivered(boolean redelivered) throws JMSException {
        this.redelivered = redelivered;
    }

    public String getJMSType() throws JMSException {
        return type;
    }

    public void setJMSType(String type) throws JMSException {
        this.type = type;
    }

    public long getJMSExpiration() throws JMSException {
        return expiration;
    }

    public void setJMSExpiration(long expiration) throws JMSException {
        this.expiration = expiration;
    }

    public int getJMSPriority() throws JMSException {
        return priority;
    }

    public void setJMSPriority(int priority) throws JMSException {
        this.priority = priority;
    }

    public void clearProperties() throws JMSException {
        properties.clear();
    }

    public boolean propertyExists(String name) throws JMSException {
        return properties.containsKey(name);
    }

    public boolean getBooleanProperty(String name) throws JMSException {
        return BooleanUtils.booleanValue(properties.get(name));
    }

    public byte getByteProperty(String name) throws JMSException {
        return SmallNumberUtils.byteValue(properties.get(name));
    }

    public short getShortProperty(String name) throws JMSException {
        return SmallNumberUtils.shortValue(properties.get(name));
    }

    public int getIntProperty(String name) throws JMSException {
        return IntegerNumberUtils.intValue(properties.get(name));
    }

    public long getLongProperty(String name) throws JMSException {
        return LongNumberUtils.longValue(properties.get(name));
    }

    public float getFloatProperty(String name) throws JMSException {
        return FloatNumberUtils.floatValue(properties.get(name));
    }

    public double getDoubleProperty(String name) throws JMSException {
        return FloatNumberUtils.doubleValue(properties.get(name));
    }

    public String getStringProperty(String name) throws JMSException {
        return properties.getProperty(name);
    }

    public Object getObjectProperty(String name) throws JMSException {
        return properties.get(name);
    }

    public Enumeration getPropertyNames() throws JMSException {
        return properties.propertyNames();
    }

    public void setBooleanProperty(String name, boolean value)
            throws JMSException {
        properties.put(name, new Boolean(value));
    }

    public void setByteProperty(String name, byte value) throws JMSException {
        properties.put(name, new Byte(value));
    }

    public void setShortProperty(String name, short value) throws JMSException {
        properties.put(name, new Short(value));
    }

    public void setIntProperty(String name, int value) throws JMSException {
        properties.put(name, new Integer(value));
    }

    public void setLongProperty(String name, long value) throws JMSException {
        properties.put(name, new Long(value));
    }

    public void setFloatProperty(String name, float value) throws JMSException {
        properties.put(name, new Float(value));
    }

    public void setDoubleProperty(String name, double value)
            throws JMSException {
        properties.put(name, new Double(value));
    }

    public void setStringProperty(String name, String value)
            throws JMSException {
        properties.setProperty(name, value);
    }

    public void setObjectProperty(String name, Object value)
            throws JMSException {
        properties.put(name, value);
    }

    public void acknowledge() throws JMSException {
    }

    public abstract void clearBody() throws JMSException;

    /**
     * copy the fields from this message into another freshly-created one
     */
    public void cloneFields(InMemoryMessage message) {
        message.messageID = messageID;
        message.timestamp = timestamp;
        message.correlationID = correlationID;
        message.correlationIDBytes = correlationIDBytes;
        message.destination = destination;
        message.replyTo = replyTo;
        message.deliveryMode = deliveryMode;
        message.redelivered = redelivered;
        message.type = type;
        message.expiration = expiration;
        message.priority = priority;
        message.properties.putAll(properties); // TODO warning, only a shallow copy
    }
}
