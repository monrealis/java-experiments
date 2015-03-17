package eu.vytenis.patterns.proxy.person;

import eu.vytenis.patterns.proxy.api.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProtectionProxyBuilder {
    public static final Class[] CLASSES = new Class[]{Person.class};
    private static ClassLoader CL = ProtectionProxyBuilder.class.getClassLoader();
    private final Person person;

    public ProtectionProxyBuilder(Person person) {
        this.person = person;
    }

    public Person protect() {
        return (Person) Proxy.newProxyInstance(CL, CLASSES, new ProtectingHandler());
    }

    private class ProtectingHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().contains("Salary"))
                throw new UnsupportedOperationException();
            return method.invoke(person, args);
        }
    }
}
