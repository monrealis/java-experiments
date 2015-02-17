package eu.vytenis.patterns.factory.api;

import java.util.Map;
import java.util.Set;

public interface CollectionsFactory {
    Set<Object> createSet();

    Map<Object, Object> createMap();
}
