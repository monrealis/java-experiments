package coding.hashtables;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OpenAddressingHashTest {
    @Test
    public void empty_doesNotContainValue() {
        OpenAddressingHash hash = new OpenAddressingHash(10);
        assertFalse(hash.contains(10));
    }

    @Test
    public void afterAddingOne_doesNotContainTheOther() {
        OpenAddressingHash hash = new OpenAddressingHash(10);
        hash.add(1);
        assertFalse(hash.contains(10));
    }

    @Test
    public void afterAddingOne_doesNotContainOtherWithSameReducedHash() {
        OpenAddressingHash hash = new OpenAddressingHash(10);
        hash.add(0);
        assertFalse(hash.contains(10));
    }

    @Test
    public void afterAddingTwoWithSameReducedHash_containsTwo() {
        OpenAddressingHash hash = new OpenAddressingHash(10);
        hash.add(0);
        hash.add(10);
        assertTrue(hash.contains(0));
        assertTrue(hash.contains(10));
    }

    @Test
    public void afterAdding_containsThatValue() {
        OpenAddressingHash hash = new OpenAddressingHash(10);
        hash.add(10);
        assertTrue(hash.contains(10));
    }
}