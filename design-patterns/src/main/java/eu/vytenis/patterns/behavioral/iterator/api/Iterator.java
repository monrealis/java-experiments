package eu.vytenis.patterns.behavioral.iterator.api;

public interface Iterator<T> {
    boolean finished();

    T get();
}
