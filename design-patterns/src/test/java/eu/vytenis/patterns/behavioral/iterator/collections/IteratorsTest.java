package eu.vytenis.patterns.behavioral.iterator.collections;

import eu.vytenis.patterns.behavioral.iterator.api.Iterator;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class IteratorsTest {
    private Iterator<String> arrayIterator = new ArrayIterator<>("a", "b");
    private Iterator<String> listIterator = new ListIterator<>(asList("a", "b"));

    @Test
    public void arrayIterator_iteratesOverAllElements() {
        assertEquals("ab", toString(arrayIterator));
    }

    @Test
    public void listIterator_iteratesOverAllElements() {
        assertEquals("ab", toString(listIterator));
    }

    private String toString(Iterator<String> it) {
        String r = "";
        while (!it.finished())
            r += it.get();
        return r;
    }
}
