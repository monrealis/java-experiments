package eu.vytenis.patterns.iterator.impl;

import eu.vytenis.patterns.iterator.api.Iterator;

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
