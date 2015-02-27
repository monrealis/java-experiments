package java8.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class PeekTest {
    @Test
    public void five() {
        List<String> sensor = new ArrayList<>();
        List<String> result = stream(new String[]{"one", "two"}).peek(sensor::add).collect(toList());
        assertEquals("[one, two]", sensor.toString());
        assertEquals("[one, two]", result.toString());
    }
}
