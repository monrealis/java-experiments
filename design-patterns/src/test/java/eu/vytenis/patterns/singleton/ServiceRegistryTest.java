package eu.vytenis.patterns.singleton;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ServiceRegistryTest {
    @Test
    public void assertSameObject() {
        assertSame(ServiceRegistry.get(), ServiceRegistry.get());
    }
}
