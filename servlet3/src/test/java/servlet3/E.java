package servlet3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static servlet3.Powers.power;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class E {
    @ParameterizedTest
    @CsvSource({ "0.001" })
    public void e(double tolerance) {
        int pow = 10000;

        double result = power(1 + 1.0 / pow, pow);

        assertEquals(Math.E, result, tolerance);
    }

    @ParameterizedTest
    @CsvSource({ "0.001" })
    public void sum(double tolerance) {
        int pow = 10000;

        double result = power(1 + 1.0 / pow, pow);

        assertEquals(Math.E, result, tolerance);
    }
}
