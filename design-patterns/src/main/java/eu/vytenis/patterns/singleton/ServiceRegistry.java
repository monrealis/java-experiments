package eu.vytenis.patterns.singleton;

public class ServiceRegistry {
    private static ServiceRegistry instance = new ServiceRegistry();

    private ServiceRegistry() {
    }

    public static ServiceRegistry get() {
        return instance;
    }
}
