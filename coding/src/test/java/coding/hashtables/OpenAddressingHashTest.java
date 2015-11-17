package coding.hashtables;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OpenAddressingHashTest {
    private OpenAddressingHash hash = new OpenAddressingHash(10);
    @Test
    public void empty_doesNotContainValue() {
        assertFalse(hash.contains(10));
    }

    @Test
    public void empty_doesNotContainNull() {
        assertFalse(hash.contains(null));
    }

    @Test
    public void afterAddingOne_doesNotContainTheOther() {
        hash.add(1);
        assertFalse(hash.contains(10));
    }

    @Test
    public void afterAddingNull_containsNull() {
        hash.add(null);
        assertTrue(hash.contains(null));
    }

    @Test
    public void afterAddingOne_doesNotContainOtherWithSameReducedHash() {
        hash.add(0);
        assertFalse(hash.contains(10));
    }

    @Test
    public void afterAddingTwoWithSameReducedHash_containsTwo() {
        hash.add(0);
        hash.add(10);
        assertTrue(hash.contains(0));
        assertTrue(hash.contains(10));
    }

    @Test
    public void afterAddingTwoWithSameReducedHashWithWrappingAroundNeeded_containsTwo() {
        hash.add(9);
        hash.add(19);
        assertTrue(hash.contains(9));
        assertTrue(hash.contains(19));
    }


    @Test
    public void afterAdding_containsThatValue() {
        hash.add(10);
        assertTrue(hash.contains(10));
    }

    @Test
    public void doesNotAddDuplicates() {
        for (int i = 0; i < 10 + 1; ++i)
            hash.add(10);
        assertTrue(hash.contains(10));
    }
}