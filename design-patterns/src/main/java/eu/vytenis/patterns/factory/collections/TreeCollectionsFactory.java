package eu.vytenis.patterns.factory.collections;

import eu.vytenis.patterns.factory.api.CollectionsFactory;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeCollectionsFactory implements CollectionsFactory {
    @Override
    public Set<Object> createSet() {
        return new TreeSet<>();
    }

    @Override
    public Map<Object, Object> createMap() {
        return new TreeMap<>();
    }
}
