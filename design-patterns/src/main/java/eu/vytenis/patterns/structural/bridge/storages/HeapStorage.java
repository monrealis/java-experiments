package eu.vytenis.patterns.structural.bridge.storages;

import eu.vytenis.patterns.structural.bridge.api.Serializer;
import eu.vytenis.patterns.structural.bridge.api.Storage;

import java.util.ArrayList;
import java.util.List;

public class HeapStorage<T> implements Storage {
    private final Serializer<T> serializer;
    private List<T> items = new ArrayList<>();

    public HeapStorage(Serializer<T> serializer) {
        this.serializer = serializer;
    }

    @Override
    public int store(Object o) {
        int r = items.size();
        items.add(serializer.save(o));
        return r;
    }

    @Override
    public Object get(int index) {
        return serializer.load(items.get(index));
    }
}
