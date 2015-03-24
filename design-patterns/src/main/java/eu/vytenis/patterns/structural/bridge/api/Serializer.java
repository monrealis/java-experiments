package eu.vytenis.patterns.structural.bridge.api;

public interface Serializer<T> {
    Object load(T from);

    T save(Object o);
}
