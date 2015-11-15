package coding.hashtables;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HashTest {
    Hash<Integer, String> hash = new Hash<>(10);

    @Test
    public void empty_containsNoElement() {
        assertFalse(hash.contains(0));
    }

    @Test
    public void afterAdding_containsAdded() {
        hash.add(0);
        assertTrue(hash.contains(0));
    }

    @Test
    public void afterAdding_doesNotContainElementThatHasNotBeenAdded() {
        hash.add(0);
        assertFalse(hash.contains(10));
    }

    @Test
    public void afterAddingTwoToTheSameBucket_containsBoth() {
        hash.add(0);
        hash.add(10);
        assertTrue(hash.contains(0));
        assertTrue(hash.contains(10));
    }
}
