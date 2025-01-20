package servlet3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class VariousTests {
    @Test
    public void palyndrome() {
        String palyndrome = "madam";

        String s = new StringBuilder(palyndrome).reverse().toString();

        assertEquals(s, palyndrome);
    }

    @Test
    public void nonPalyndrome() {
        String nonPalyndrome = "Madam";

        String s = new StringBuilder(nonPalyndrome).reverse().toString();

        assertNotEquals(s, nonPalyndrome);
    }

    @Test
    public void reversesString() {
        String s = "ABC";

        String reversed = new StringBuilder(s).reverse().toString();

        assertEquals(reversed, "CBA");
    }
}
