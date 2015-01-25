package java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class StreamsTest {
    List<String> list1 = asList("a", "b");
    List<String> list2 = asList("c", "d", "e");
    List<List<String>> list = asList(list1, list2);
    Stream<List<String>> stream = list.stream();

    @Test
    public void toList_collectsListEqualToOriginal() {
        assertEquals(stream.collect(Collectors.toList()), list);
    }

    @Test
    public void flatMap_flattensItems() {
        assertEquals(stream.flatMap(Collection::stream).collect(Collectors.toList()), getFlatList());
    }

    private List<String> getFlatList() {
        List<String> expected = new ArrayList<>();
        for (List<String> l : list) {
            expected.addAll(l);
        }
        return expected;
    }
}
