package java8.util;

import org.junit.Test;

import java.util.NoSuchElementException;

import static java.util.Optional.*;
import static org.junit.Assert.assertSame;

public class OptionalsTest {
    @Test(expected = NoSuchElementException.class)
    public void forEmpty_get_throwsException() {
        empty().get();
    }

    @Test(expected = NullPointerException.class)
    public void givenNull_of_throwsException() {
        of(null);
    }

    @Test
    public void givenValue_get_returnsSameValue() {
        String value = "x";
        assertSame(value, of(value).get());
    }

    @Test
    public void givenNull_ofNullable_returnsEmpty() {
        assertSame(ofNullable(null), empty());
    }
}
