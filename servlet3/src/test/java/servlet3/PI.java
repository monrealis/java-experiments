package servlet3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PI {
    private static double pi = Math.PI;

    @ParameterizedTest
    @CsvSource({ "0.001" })
    public void wallis(double tolerance) {
        double result = 1;
        for (int i = 1; i <= 1000; i++) {
            double nom = 4 * i * i;
            double den = 4 * i * i - 1;
            double product = 1.0 * nom / den;
            result *= product;
        }
        assertEquals(pi, result * 2, tolerance);
    }

    public void stirling(double tolerance) {

    }

    public void ramanujan(double tolerance) {

    }
}
