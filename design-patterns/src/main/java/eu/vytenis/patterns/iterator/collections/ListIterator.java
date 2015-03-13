package eu.vytenis.patterns.iterator.collections;

import eu.vytenis.patterns.iterator.api.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListIterator<T> implements Iterator<T> {
    private List<T> list;
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
