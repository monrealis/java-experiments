package java8.streams;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.generate;
import static java.util.stream.Stream.iterate;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GeneratorsTest {
    @Test
    public void iterateWithFPair_generatesFibonacciNumbers() {
        List<Integer> actual = iterate(new FPair(), FPair::next).limit(5).map(FPair::first).collect(toList());

        assertEquals(asList(1, 1, 2, 3, 5), actual);
    }

    @Test
    public void generateMathRandom_generatesStreamOfRandom() {
        assertThat(generate(Math::random).limit(10).collect(toList()).size(), equalTo(10));
    }

    public static class FPair {
        private final int first;
        private final int second;

        public FPair() {
            this(1, 1);
        }

        private FPair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public FPair next() {
            return new FPair(second, first + second);
        }

        public Integer first() {
            return first;
        }
    }
}
