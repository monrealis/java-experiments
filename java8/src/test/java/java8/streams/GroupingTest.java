package java8.streams;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.range;
import static org.junit.Assert.assertEquals;

public class GroupingTest {
    private final Stream<Integer> stream = range(0, 10).boxed();

    @Test
    public void collectGroupingBy_groupsByEvenFlag() {
        Map<Boolean, List<Integer>> expected = new HashMap<>();
        expected.put(false, asList(1, 3, 5, 7, 9));
        expected.put(true, asList(0, 2, 4, 6, 8));
        assertEquals(expected, stream.collect(groupingBy(i -> i % 2 == 0)));
    }

    @Test
    public void collectGroupingByCollectingAndThen_groupsByEvenFlagAndFindsMax() {
        Map<Boolean, Integer> expected = new HashMap<>();
        expected.put(false, 9);
        expected.put(true, 8);
        Map<Boolean, Integer> actual = stream.collect(groupingBy(i -> i % 2 == 0, collectingAndThen(toList(), Collections::max)));
        assertEquals(expected, actual);
    }
}
