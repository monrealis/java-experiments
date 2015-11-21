package coding.hashtables;

import org.junit.Ignore;
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
    public void afterAddingAndRemoving_doesNotContain() {
        hash.add(10);
        hash.remove(10);
        assertFalse(hash.contains(10));
    }

    @Test
    public void afterAddingAndRemovingShiftedElement_doesNotContainShiftedElement() {
        hash.add(8);
        hash.add(18);
        hash.remove(18);
        assertTrue(hash.contains(8));
        assertFalse(hash.contains(18));
    }


    @Test
    public void afterAddingAndRemovingElement_containsShiftedElement() {
        hash.add(8);
        hash.add(18);
        hash.remove(8);
        assertFalse(hash.contains(8));
        assertTrue(hash.contains(18));
    }

    @Test
    public void afterAddingWithManyShiftedElementsAndRemovingUnshifted_containsAllNotRemoved() {
        hash.add(8);
        hash.add(18);
        hash.add(28);
        hash.remove(8);
        assertFalse(hash.contains(8));
        assertTrue(hash.contains(18));
        assertTrue(hash.contains(28));
    }

    @Test
    public void afterRemovingElement_nextRemainsInItsPlaceAndIsFound() {
        hash.add(8);
        hash.add(9);
        hash.remove(8);
        assertFalse(hash.contains(8));
        assertTrue(hash.contains(9));
    }

    @Test
    public void doesNotAddDuplicates() {
        for (int i = 0; i < 10 + 1; ++i)
            hash.add(10);
        assertTrue(hash.contains(10));
    }

    @Test
    public void growsInSize() {
        int n = 10 + 1;
        for (int i = 0; i < n; ++i)
            hash.add(i);
        for (int i = 0; i < n; ++i)
            assertTrue(hash.contains(i));
        assertFalse(hash.contains(n));
    }
}