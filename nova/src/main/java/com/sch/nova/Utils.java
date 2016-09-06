package com.sch.nova;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class Utils {
    private static final Map<Class<?>, Object> DEFAULT_VALUES;
    private static final InvocationHandler DEFAULT_VALUE_HANDLER = new DefaultValueInvocationHandler();

    static {
        final Map<Class<?>, Object> map = new HashMap<>();
        map.put(boolean.class, false);
        map.put(char.class, '\0');
        map.put(byte.class, (byte) 0);
        map.put(short.class, (short) 0);
        map.put(int.class, 0);
        map.put(long.class, 0L);
        map.put(float.class, 0f);
        map.put(double.class, 0d);
        DEFAULT_VALUES = Collections.unmodifiableMap(map);
    }

    public static <T> T createStub(Class<T> interfaceClass) {
        if (!interfaceClass.isInterface()) {
            throw new IllegalArgumentException(interfaceClass + " is not an interface");
        }
        final Object stub = Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass}, DEFAULT_VALUE_HANDLER);
        return interfaceClass.cast(stub);
    }

    static class DefaultValueInvocationHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return DEFAULT_VALUES.get(method.getReturnType());
        }
    }
}
