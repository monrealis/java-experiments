package servlet3;

import static java.lang.Math.E;
import static java.lang.Math.PI;
import static java.lang.Math.exp;
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
    @CsvSource({ "0.05,30" })
    public void wallisFactorial(double tolerance, int iterations) {
        int n = iterations;
        double nominator = pow(2, 4 * n) * pow(factorial(n), 4);
        double denumerator = factorial(2 * n) * factorial(2 * n + 1);
        double result = nominator / denumerator;

        assertEquals(pi, result * 2, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.01")
    public void stirling(double tolerance) {
        int n = 75;
        double nominator = factorial(n) * factorial(n) * exp(2 * n);
        double denumerator = 2 * pow(n, 2 * n + 1);
        double result = nominator / denumerator;

        assertEquals(pi, result, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.01")
    public void stirlingApproximation(double tolerance) {
        int n = 10;
        double factorial = factorial(n);
        double approximation = sqrt(2 * pi * n) * pow(1.0 * n / E, n);

        assertEquals(factorial, approximation, factorial * tolerance);
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

    @ParameterizedTest
    @CsvSource("0.05")
    public void ramanujan1(double tolerance) {
        double sum = 0;
        for (int n = 0; n < 5; ++n) {
            double numerator = (6 * n + 1) * pow(0.5, 3);
            double denominator = pow(4, n) / pow(factorial(n), 3);
            double added = numerator / denominator;
            sum += added;
        }
        double result = 4 / sum;
        assertEquals(pi, result, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.05")
    public void ramanujan2(double tolerance) {
        double sum = 0;
        for (int n = 0; n < 5; ++n) {
            double added = (15 * n + 2) * 1.0 * 1.0 * 1.0 / factorial(n) * pow(2.0 / 27, n);
            sum += added;
        }
        double result = 27.0 / 4 / sum;
        assertEquals(pi, result, tolerance);
    }
}
