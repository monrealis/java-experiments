package java8.mrs;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SortingTest {
    private List<Integer> ints = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

    @Before
    public void before() {
        Collections.shuffle(ints);
    }

    @Test
    public void usingMethodReferences_sorted() {
        ints.sort(comparing(Object::toString));
        assertSorted();
    }

    @Test
    public void usingLambdas_sorted() {
        ints.sort(comparing(a -> a.toString()));
        assertSorted();
    }

    private void assertSorted() {
        assertThat(ints.subList(0, 3), equalTo(asList(1, 10, 2)));
    }
}
