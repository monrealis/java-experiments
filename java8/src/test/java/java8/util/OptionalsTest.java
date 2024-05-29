package java8.util;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.Optional.*;
import static org.junit.Assert.*;

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

    @Test
    public void givenTwoOptionals_join_returnsPresentOnlyIfBothPresent() {
        Optional<String> x = of("x");
        Optional<String> e = empty();

        assertEquals("xx", join(x, x).get());
        assertFalse(join(x, e).isPresent());
        assertFalse(join(e, x).isPresent());
        assertFalse(join(e, e).isPresent());
    }

    private Optional<String> join(Optional<String> first, Optional<String> second) {
        return first.flatMap(s -> second.map(x -> s + x));
    }

    @Test
    public void getName_returnsNameOrDefault() {
        Person p = new Person();
        assertEquals("-", getName(of(p)));
        p.parent = p;
        assertEquals("name", getName(of(p)));
    }

    private String getName(Optional<Person> o) {
        return o.map(Person::getParent).map(Person::getParent).map(Person::getParent).map(Person::getName).orElse("-");
    }

    public class Person {
        private Person parent;

        private String getName() {
            return "name";
        }

        public Person getParent() {
            return parent;
        }
    }
}
