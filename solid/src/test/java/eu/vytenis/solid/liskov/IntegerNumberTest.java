package eu.vytenis.solid.liskov;

import org.junit.Test;

public class IntegerNumberTest {
    @Test(expected = StackOverflowError.class)
    public void construction_fails() {
        new IntegerNumber(0);
    }
}