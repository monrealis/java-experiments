package eu.vytenis.patterns.creational.factory.collections;

import eu.vytenis.patterns.creational.factory.api.CollectionsFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.singleton;
import static java.util.Collections.singletonMap;
import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CollectionsFactoryTest {
    private final Set<Object> set;
    private final Map<Object, Object> map;

    public CollectionsFactoryTest(CollectionsFactory factory) {
        set = factory.createSet();
        map = factory.createMap();
    }

    @Parameters
    public static List<Object[]> getParameters() {
        Object[] hash = {new HashCollectionsFactory()};
        Object[] tree = {new TreeCollectionsFactory()};
        return asList(hash, tree);
    }

    @Test
    public void set() {
        set.add("X");
        assertEquals(singleton((Object) "X"), set);
    }

    @Test
    public void map() {
        map.put("K", "V");
        assertEquals(singletonMap((Object) "K", (Object) "V"), map);
    }
}
