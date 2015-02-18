package java8.collectors;

import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ArrayListCollectorTest {
    @Test
    public void collectsEmptyList() {
        assertEquals(new ArrayList<Integer>(), collect(0));
    }

    @Test
    public void collectsListOfTwo() {
        assertEquals(asList(0, 1), collect(2));
    }

    private ArrayList<Integer> collect(int to) {
        return IntStream.range(0, to).boxed().collect(new ArrayListCollector<>());
    }
}
