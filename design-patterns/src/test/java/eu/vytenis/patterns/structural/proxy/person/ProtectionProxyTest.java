package eu.vytenis.patterns.structural.proxy.person;

import eu.vytenis.patterns.structural.proxy.api.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProtectionProxyTest {
    private Person insecure = new SimplePerson("X", 10);
    private Person secure = new ProtectionProxyBuilder(insecure).protect();

    @Test
    public void callingInsecureMethods_givesResults() {
        assertEquals("X", insecure.getName());
        assertEquals("X", secure.getName());
        assertEquals(10, insecure.getSalary());
    }

    @Test(expected = RuntimeException.class)
    public void callingSecuredMethod_throwsException() {
        secure.getSalary();
    }
}
