package by.example.infrastructure.config;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceProxyIfNeeded(Object t, Class implClass) {
        if (implClass.getInterfaces().length == 0) {
            return Enhancer.create(implClass, new net.sf.cglib.proxy.InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return getIvocationHandlerLogic(method, args, t);
                }
            });
        }


        if (implClass.isAnnotationPresent(Deprecated.class)) {
            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return getIvocationHandlerLogic(method, args, t);
                }
            });
        } else {
            return t;
        }
    }

    private Object getIvocationHandlerLogic(Method method, Object[] args, Object t) throws IllegalAccessException, InvocationTargetException {
        System.out.println("********** deprecated method ************");
        return method.invoke(t, args);
    }
}
