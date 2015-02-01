package java8.streams;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.naturalOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

public class ParallelPerformanceTest {
    private final int max = 1000000;
    private final List<Integer> list = IntStream.range(0, max).boxed().collect(Collectors.toList());

    @Test
    public void maxFromListAndMaxFromStream_returnSameValue() {
        assertEquals(maxFromList(), maxFromStream());
    }

    @Test
    public void maxFromList_takesLongerThanMaxFromStream() {
        assumeFalse("Theory does not work", true);
        maxFromListAndMaxFromStream_returnSameValue();
        long list = measureTime(this::maxFromList);
        long stream = measureTime(this::maxFromStream);
        System.out.println(list + " " + stream);
        assertTrue(String.format("Got: %d, %d", list, stream), list > stream);
    }

    private long measureTime(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - start;

    }

    private Integer maxFromList() {
        return Collections.max(list);
    }

    private Integer maxFromStream() {
        return list.parallelStream().max(naturalOrder()).get();
    }
}
