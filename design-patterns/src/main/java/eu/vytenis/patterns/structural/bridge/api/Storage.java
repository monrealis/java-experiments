package eu.vytenis.patterns.structural.bridge.api;

public interface Storage {
    int store(Object o);

    Object get(int index);
}
