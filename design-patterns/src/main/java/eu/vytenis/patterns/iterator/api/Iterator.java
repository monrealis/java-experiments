package eu.vytenis.patterns.iterator.api;

public interface Iterator<T> {
    boolean finished();

    T get();
}
