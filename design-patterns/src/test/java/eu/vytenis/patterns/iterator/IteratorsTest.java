package eu.vytenis.patterns.iterator;

import eu.vytenis.patterns.iterator.api.Iterator;
import eu.vytenis.patterns.iterator.impl.ArrayIterator;
import eu.vytenis.patterns.iterator.impl.ListIterator;
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
