package java8.lambdas;

import org.junit.Test;

import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

public class LambdasTest {
    @Test
    public void supplier_works() {
        assertEquals("x", echo(() -> "x"));
    }

    private String echo(Supplier<String> s) {
        return s.get();
    }
}
