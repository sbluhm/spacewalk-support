package org.stringtree.fetcher;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.stringtree.Fetcher;
import org.stringtree.Tract;
import org.stringtree.finder.FetcherStringKeeper;
import org.stringtree.util.MethodCallUtils;

public class BeanFetcher implements Fetcher {
    protected Object obj;
    protected Map methods;
    protected Map fields;
    protected Fetcher context;

    public BeanFetcher(Object obj, Fetcher context) {
        this.obj = obj;
        this.context = context;
        methods = new HashMap();
        fields = new HashMap();

        try {
            BeanInfo info = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] props = info.getPropertyDescriptors();

            for (int i = 0; i < props.length; ++i) {
                PropertyDescriptor prop = props[i];
                methods.put(prop.getName(), prop.getReadMethod());
            }
        } catch (IntrospectionException ie) {
            ie.printStackTrace();
        }

        Field[] ff = obj.getClass().getDeclaredFields();

        for (int i = 0; i < ff.length; ++i) {
            Field field = ff[i];
            fields.put(field.getName(), field);
        }
    }

    public BeanFetcher(Object obj) {
        this(obj, null);
    }

    private Object invoke(String key) {
        Object ret = null;

        // first try a "JavaBean" style property
        // (usually "getXXX()", but can be overridden by property descriptor)
        Method method = (Method) methods.get(key);
        if (method != null) {
            try {
                ret = method.invoke(obj, (Object[])null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        FetcherStringKeeper stringKeeper = new FetcherStringKeeper(context);

        // if that fails, try a regular method, with or without a context
        if (ret == null) {
            ret = MethodCallUtils.call(obj, key, stringKeeper, false);
        }
        
        // keep going, try a "get" method, with or without a context
        if (ret == null) {
            ret = MethodCallUtils.callOptionalContext(stringKeeper, obj, "get", key);
        }

        // if that fails, look for a public field
        if (ret == null) {
            Field field = (Field) fields.get(key);
            if (field != null) {
                try {
                    int modifiers = field.getModifiers();
                    if (Modifier.isPublic(modifiers)) {
                        ret = field.get(obj);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return ret;
    }

    public Object getObject(String key) {
        Object ret = null;

        if (Tract.CONTENT.equals(key)) {
            ret = obj;
        } else {
            ret = invoke(key);
        }

        return ret;
    }

    public boolean contains(String key) {
        return "this".equals(key) || methods.containsKey(key);
    }
}