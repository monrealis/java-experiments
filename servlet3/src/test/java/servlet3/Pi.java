package servlet3;

import static java.lang.Math.E;
import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static servlet3.Factorials.factorial;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Pi {
    private static double pi = PI;

    @ParameterizedTest
    @CsvSource({ "0.001" })
    public void wallis(double tolerance) {
        double result = 1;
        for (int i = 1; i <= 1000; i++) {
            double nominator = 4 * i * i;
            double denumerator = 4 * i * i - 1;
            result *= nominator / denumerator;
        }

        assertEquals(pi, result * 2, tolerance);
    }

    @ParameterizedTest
    @CsvSource({ "0.05" })
    public void wallisFactorial(double tolerance) {
        int n = 30;
        double nominator = pow(2, 4 * n) * pow(factorial(n), 4);
        double denumerator = factorial(2 * n) * factorial(2 * n + 1);
        double result = nominator / denumerator;

        assertEquals(pi, result * 2, tolerance);
    }

    @ParameterizedTest
    @CsvSource("3")
    public void stirling(double tolerance) {
        int n = 50;
        double nominator = pow(factorial(n), 2) * pow(2, 2 * n + 1);
        double denumerator = factorial(2 * n + 1);
        double result = nominator / denumerator;

        assertEquals(pi, result * 2, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.1")
    public void stirlingApproximation(double tolerance) {
        int n = 50;
        double factorial = factorial(n);
        double approximation = sqrt(2 * pi * n) * pow(1.0 * n / E, n);

        assertEquals(factorial, approximation, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.05")
    public void ramanujan(double tolerance) {
        double result = 0;
        double factor = 2 * sqrt(2) / (99 * 99);
        for (int k = 0; k < 5; ++k) {
            double f = factorial(k);
            double numerator = factorial(4 * k) * (1103 + 26390 * k);
            double denominator = f * f * f * f * pow(396, 4 * k);
            double added = numerator / denominator;
            result += added;
        }
        double temp = result * factor;
        double temp1 = 1 / temp;
        assertEquals(pi, temp1, tolerance);
    }
}
