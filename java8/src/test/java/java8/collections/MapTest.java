package java8.collections;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class MapTest {
    private Map<Integer, Integer> squares = new TreeMap<>();
    private int numberOfTimesSquared = 0;

    @Test
    public void computeIfAbsent_reusesCachedValue() {
        assertEquals(new Integer(4), squares.computeIfAbsent(2, this::square));
        assertEquals(new Integer(4), squares.computeIfAbsent(2, this::square));
        assertEquals(1, numberOfTimesSquared);
    }

    private int square(int x) {
        ++numberOfTimesSquared;
        return x * x;
    }
}
