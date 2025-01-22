package servlet3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

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

    @Test
    public void fibonacci() {
        assertEquals(4181, fibonaci(20));
        assertEquals(34, fibonaci(10));
        assertEquals(0, fibonaci(1));
        assertEquals(1, fibonaci(2));
        assertEquals(1, fibonaci(3));
        assertEquals(2, fibonaci(4));
        assertEquals(3, fibonaci(5));
        assertThrows(IllegalArgumentException.class, () -> fibonaci(0));
    }

    private int fibonaci(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        if (n == 1)
            return 0;
        int i = 0;
        int j = 1;
        for (int ii = 2; ii < n; ++ii) {
            int l = i + j;
            i = j;
            j = l;
        }
        return j;
    }
}
