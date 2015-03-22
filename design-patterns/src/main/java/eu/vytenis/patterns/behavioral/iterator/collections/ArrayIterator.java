package eu.vytenis.patterns.behavioral.iterator.collections;

import eu.vytenis.patterns.behavioral.iterator.api.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[] array;
    private int nextIndex;

    @SafeVarargs
    public ArrayIterator(T... array) {
        this.array = array;
    }

    @Override
    public boolean finished() {
        return nextIndex >= array.length;
    }

    @Override
    public T get() {
        return array[nextIndex++];
    }
}
