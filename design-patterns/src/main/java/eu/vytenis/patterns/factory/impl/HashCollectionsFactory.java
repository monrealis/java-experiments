package eu.vytenis.patterns.factory.impl;

import eu.vytenis.patterns.factory.api.CollectionsFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashCollectionsFactory implements CollectionsFactory {
    @Override
    public Set<Object> createSet() {
        return new HashSet<>();
    }

    @Override
    public Map<Object, Object> createMap() {
        return new HashMap<>();
    }
}
