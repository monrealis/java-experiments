package servlet3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VariousTests {
    @Test
    public void palyndrome() {
        String palyndrome = "madam";

        String s = new StringBuilder(palyndrome).reverse().toString();

        assertEquals(s, palyndrome);
    }
}
