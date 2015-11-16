package coding.hashtables;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HashTest {
    Hash<Integer> hash = new Hash<>(10);

    @Test
    public void empty_containsNoElement() {
        assertFalse(hash.contains(0));
        assertFalse(hash.contains(null));
    }

    @Test
    public void afterAdding_containsAdded() {
        hash.add(0);
        assertTrue(hash.contains(0));
    }

    @Test
    public void afterAddingAndRemovingFirst_doesNotContain() {
        hash.add(0);
        hash.remove(0);
        assertFalse(hash.contains(0));
    }

    @Test
    public void afterAddingTwiceAndRemoving_doesNotContain() {
        hash.add(0);
        hash.add(0);
        hash.remove(0);
        assertFalse(hash.contains(0));
    }

    @Test
    public void afterAddingNull_containsNull() {
        hash.add(null);
        assertTrue(hash.contains(null));
    }

    @Test
    public void afterAddingAndRemovingNull_contains() {
        hash.add(null);
        hash.remove(null);
        assertFalse(hash.contains(null));
    }
    @Test
    public void afterAddingAndRemovingSecond_doesNotContain() {
        hash.add(0);
        hash.add(10);
        hash.remove(10);
        assertFalse(hash.contains(10));
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
