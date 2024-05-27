package java8.streams;

import org.junit.Test;

import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static org.junit.Assert.assertEquals;

public class ReductionTest {
    private Stream<Integer> three = stream(new Integer[] { 1, 3, 2 });
    private Stream<Integer> two = stream(new Integer[] { 6, 7 });
    private Stream<Integer> one = stream(new Integer[] { 5 });
    private Stream<Integer> zero = stream(new Integer[] {});

    @Test
    public void givenStreamsOfVariousLengths_reduce_returnsSum() {
        assertEquals(6, three.reduce(Integer::sum).get().intValue());
        assertEquals(5, one.reduce(Integer::sum).get().intValue());
        assertEquals(false, zero.reduce(Integer::sum).isPresent());
    }

    @Test
    public void usingVariousMethodsOfCounting_reduce_countsStreamLength() {
        assertEquals(new Integer(2), two.map(i -> 1).reduce(0, Integer::sum));
        assertEquals(new Integer(3), three.reduce(0, (a, b) -> a + 1));
    }
}
