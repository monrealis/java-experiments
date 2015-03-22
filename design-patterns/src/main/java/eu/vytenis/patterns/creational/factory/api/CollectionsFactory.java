package eu.vytenis.patterns.creational.factory.api;

import java.util.Map;
import java.util.Set;

public interface CollectionsFactory {
    Set<Object> createSet();

    Map<Object, Object> createMap();
}
