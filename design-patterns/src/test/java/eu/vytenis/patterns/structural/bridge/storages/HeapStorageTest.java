package eu.vytenis.patterns.structural.bridge.storages;

import eu.vytenis.patterns.structural.bridge.api.Storage;
import eu.vytenis.patterns.structural.bridge.serializers.SerializerToByteArray;
import eu.vytenis.patterns.structural.bridge.serializers.SerializerToClone;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class HeapStorageTest {
    private Storage s1 = new HeapStorage<>(new SerializerToByteArray());
    private Storage s2 = new HeapStorage<>(new SerializerToClone());
    private List<String> storeableObject = new PubliclyCloneableList(asList("Test"));

    @Test
    public void shouldLoadStoredObjectUsingByteArraySerializer() {
        assertStoredObjectGetsLoaded(s1);
    }

    @Test
    public void shouldLoadStoredObjectUsingPubliclyCloneableSerializer() {
        assertStoredObjectGetsLoaded(s2);
    }

    private void assertStoredObjectGetsLoaded(Storage s) {
        s.store(storeableObject);
        int idx = s.store(storeableObject);
        assertNotSame(storeableObject, s.get(idx));
        assertEquals(storeableObject, s.get(idx));
    }
}
