package servlet3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class VariousTests {
    @Test
    public void palyndrome() {
        String palyndrome = "madam";

        String s = reverse(palyndrome);

        assertEquals(s, palyndrome);
    }

    @Test
    public void nonPalyndrome() {
        String nonPalyndrome = "Madam";

        String s = reverse(nonPalyndrome);

        assertNotEquals(s, nonPalyndrome);
    }

    private String reverse(String nonPalyndrome) {
        return new StringBuilder(nonPalyndrome).reverse().toString();
    }

    @Test
    public void reversesString() {
        String s = "ABC";

        String reversed = reverse(s);

        assertEquals(reversed, "CBA");
    }

    @ParameterizedTest
    @CsvSource({ "4181,20", "34,10", "0,1", "1,2", "1,3", "2,4", "3,5" })
    public void fibonacci(int expected, int nTh) {
        assertEquals(expected, fibonacci(nTh));
    }

    @ParameterizedTest
    @CsvSource({ "-1", "0", "-1" })
    public void fibonacci_Throws(int nTh) {
        assertThrows(IllegalArgumentException.class, () -> fibonacci(nTh));
    }

    private int fibonacci(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        if (n == 1)
            return 0;
        return fibonacciNoChecks(n);
    }

    private int fibonacciNoChecks(int n) {
        int i = 0;
        int j = 1;
        for (int ii = 2; ii < n; ++ii) {
            int l = i + j;
            i = j;
            j = l;
        }
        return j;
    }

    @ParameterizedTest
    @CsvSource({ "true,2", "true,3", "false,4", "true,5", "false,99", "true,97" })
    public void primeNumbers(boolean expectedResult, int n) {
        assertEquals(expectedResult, primeNumber(n));
    }

    @ParameterizedTest
    @CsvSource({ "-1", "0", "1" })
    public void primeNumbers_Throws(int n) {
        assertThrows(IllegalArgumentException.class, () -> primeNumber(n));
    }

    private boolean primeNumber(int n) {
        if (n < 2)
            throw new IllegalArgumentException();
        for (int i = 2; i < n; ++i) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    @ParameterizedTest
    @CsvSource({ "1,0", "1,1", "2,2", "6,3", "24,4", "120,5" })
    public void factorial(int expected, int n) {
        int f = factorial(n);

        assertEquals(expected, f);
    }

    @ParameterizedTest
    @CsvSource({ "-1" })
    public void factorial_Throws(int n) {
        assertThrows(IllegalArgumentException.class, () -> factorial(n));
    }

    private int factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        int f = 1;
        for (int i = 1; i < n; ++i) {
            f *= i + 1;
        }
        return f;
    }
}
