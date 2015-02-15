package java8.streams;

import org.junit.Test;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;

public class AggregationTest {
    private final IntStream ints = IntStream.rangeClosed(1, 100);

    @Test
    public void ints_getSummed() {
        int gaussianInt = 5050;
        assertEquals(gaussianInt, ints.boxed().collect(summingInt(Integer::intValue)).intValue());
    }

    @Test
    public void ints_getSummarized() {
        assertNotNull(ints.boxed().collect(summarizingInt(Integer::intValue)));
    }

    @Test
    public void strings_getJoined() {
        assertThat(ints.boxed().map(Object::toString).collect(joining(", ")), startsWith("1, 2, 3"));
    }
}
