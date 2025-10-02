package servlet3;

import static java.lang.Math.pow;
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
            result *= nom / den;
        }

        assertEquals(pi, result * 2, tolerance);
    }

    @ParameterizedTest
    @CsvSource({ "0.05" })
    public void wallisFactorial(double tolerance) {
        int n = 30;
        double nom = pow(2, 4 * n) * pow(factorial(n), 4);
        double den = factorial(2 * n) * factorial(2 * n + 1);
        double result = nom / den;

        assertEquals(pi, result * 2, tolerance);
    }

    private double factorial(int n) {
        double f = 1;
        for (int i = 1; i < n; ++i)
            f *= i + 1;
        return f;
    }

    public void stirling(double tolerance) {

    }

    public void ramanujan(double tolerance) {

    }
}
