package eu.vytenis.patterns.structural.adapter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringBackedNumberTest {
    private Number number = new StringBackedNumber("5");

    @Test
    public void toInt() {
        assertEquals(5, number.intValue());
    }

    @Test
    public void toLong() {
        assertEquals(5, number.longValue());
    }

    @Test
    public void toFloat() {
        assertEquals(5, number.floatValue(), 0);
    }

    @Test
    public void toDouble() {
        assertEquals(5, number.doubleValue(), 0);
    }
}
