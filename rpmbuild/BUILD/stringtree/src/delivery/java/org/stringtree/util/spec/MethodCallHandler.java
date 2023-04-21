package org.stringtree.util.spec;

import org.stringtree.util.MethodCallUtils;
import org.stringtree.util.MethodWrapper;

public abstract class MethodCallHandler extends ContextHandler {
    
    static Class[] objectType = new Class[] { Object.class };

    protected String methodName;

    public MethodCallHandler(String methodName) {
        this.methodName = methodName;
    }

    public Object parseString(String name, String text) {
        Object ret = null;
        Object old = context.getObject(name);

        if (old == null) {
            addDefault(name);
            old = context.getObject(name);
        }

        if (old != null) {
            MethodWrapper method = MethodCallUtils.findObjectMethod(old,
                    methodName, objectType, new Object[] { text });
            if (method != null && method.isCallable()) {
                MethodCallUtils.call(old, method);
                ret = old;
            }
        }
        return ret;
    }

    public abstract void addDefault(String name);
}
