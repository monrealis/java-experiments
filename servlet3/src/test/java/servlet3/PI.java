package servlet3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PI {
    private static double pi = Math.PI;

    @ParameterizedTest
    @CsvSource({ "0.001" })
    public void wallis(double tolerance) {
        double sum = 0;
        for (int i = 1; i <= 30; i++) {
            double nom = 4 * i * i;
            double den = 4 * i * i - 1;
            double added = 1.0 * nom / den;
            sum += added;
        }
        assertEquals(pi / 2, sum, tolerance);
    }

    public void stirling(double tolerance) {

    }

    public void ramanujan(double tolerance) {

    }
}
