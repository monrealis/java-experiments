package eu.vytenis.patterns.behavioral.iterator.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import eu.vytenis.patterns.behavioral.iterator.api.Iterator;

public class ListIterator<T> implements Iterator<T> {
    private final List<T> list;
    private int nextIndex;

    public ListIterator(Collection<T> collection) {
        this.list = new ArrayList<>(collection);
    }

    @Override
    public boolean finished() {
        return nextIndex >= list.size();
    }

    @Override
    public T get() {
        return list.get(nextIndex++);
    }
}
