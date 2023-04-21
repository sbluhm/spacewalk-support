package org.stringtree.jms;

import java.util.Enumeration;
import java.util.Properties;

import javax.jms.ConnectionMetaData;
import javax.jms.JMSException;

public class InMemoryConnectionMetaData implements ConnectionMetaData {
    
    private static Properties properties = new Properties();

    public String getJMSVersion() throws JMSException {
        return "1.1";
    }

    public int getJMSMajorVersion() throws JMSException {
        return 1;
    }

    public int getJMSMinorVersion() throws JMSException {
        return 1;
    }

    public String getJMSProviderName() throws JMSException {
        return "Stringtree In-Memory JMS";
    }

    public String getProviderVersion() throws JMSException {
        return "1.1.0";
    }

    public int getProviderMajorVersion() throws JMSException {
        return 1;
    }

    public int getProviderMinorVersion() throws JMSException {
        return 1;
    }

    public Enumeration getJMSXPropertyNames() throws JMSException {
        return properties.propertyNames();
    }
}
