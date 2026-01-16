package servlet3;

import static java.lang.Math.E;
import static java.lang.Math.PI;
import static java.lang.Math.exp;
import static java.lang.Math.log;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static servlet3.Factorials.factorial;
import static servlet3.Powers.power;
import static servlet3.Powers.power2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Pi {
    private static double pi = PI;

    @ParameterizedTest
    @CsvSource({ "0.001" })
    public void wallisProduct(double tolerance) {
        double result = 1;
        for (int i = 1; i <= 1000; i++) {
            double nominator = 4 * i * i;
            double denumerator = 4 * i * i - 1;
            result *= nominator / denumerator;
        }

        assertEquals(pi, result * 2, tolerance);
    }

    @ParameterizedTest
    @CsvSource({ "0.001" })
    public void wallis(double tolerance) {
        double result = 0;
        for (int i = 1; i <= 1000; i++) {
            double nTimes2 = i * 2;
            double part = log(nTimes2 / (nTimes2 - 1)) + log(nTimes2 / (nTimes2 + 1));
            result += part;
        }
        double expected = exp(result);
        assertEquals(pi, expected * 2, tolerance);
    }

    @ParameterizedTest
    @CsvSource({ "0.05,30" })
    public void wallisFactorial(double tolerance, int iterations) {
        int n = iterations;
        double fact = factorial(n);
        double fact2 = factorial(fact, n, 2 * n);
        double fact3 = fact2 * (2 * n + 1);
        double nominator = power2(4 * n) * fact * fact * fact * fact;
        double denumerator = fact2 * fact3;
        double result = nominator / denumerator;
        assertEquals(pi, result * 2, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.01")
    public void stirling(double tolerance) {
        int n = 75;
        double factorial = factorial(n);
        double nominator = factorial * factorial * exp(2 * n);
        double denumerator = 2 * power(n, 2 * n + 1);
        double result = nominator / denumerator;

        assertEquals(pi, result, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.01")
    public void stirlingApproximation(double tolerance) {
        int n = 10;
        double factorial = factorial(n);
        double approximation = sqrt(2 * pi * n) * power(1.0 * n / E, n);

        assertEquals(factorial, approximation, factorial * tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.05")
    public void ramanujan(double tolerance) {
        double sum = 0;
        double factor = 2 * sqrt(2) / (99 * 99);
        for (int k = 0; k < 5; ++k) {
            double f = factorial(k);
            double numerator = factorial(4 * k) * (1103 + 26390 * k);
            double denominator = f * f * f * f * power(396, 4 * k);
            double added = numerator / denominator;
            sum += added;
        }
        double actual = 1 / (sum * factor);
        assertEquals(pi, actual, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.0001")
    public void ramanujan1(double tolerance) {
        double sum = 0;
        for (int n = 0; n < 5; ++n) {
            double f2 = factorial(2 * n);
            double numerator = f2 * f2 * f2 * (42 * n + 5);
            double f = factorial(n);
            double denominator = power2(12 * n + 4) * f * f * f * f * f * f;
            double added = numerator / denominator;
            sum += added;
        }
        double actual = 1 / sum;
        assertEquals(pi, actual, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.0001")
    public void ramanujan2(double tolerance) {
        double sum = 0;
        for (int n = 0; n < 5; ++n) {
            double numerator = power(-1, n) * factorial(4 * n) * (1123 + 21460 * n);
            double f = factorial(n);
            double denominator = power2(10 * n + 1) * f * f * f * f * power(441, 2 * n + 1);
            double added = numerator / denominator;
            sum += added;
        }
        double actual = 4 / sum;
        assertEquals(pi, actual, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.0001")
    public void ramanujan3(double tolerance) {
        double sum = 0;
        for (int n = 0; n < 5; ++n) {
            double factorial = factorial(n);
            double numerator = factorial(4 * n) * (1103 + 26390 * n);
            double denominator = power(factorial, 4) * power(396, 4 * n);
            double added = numerator / denominator;
            sum += added;
        }
        double actual = 9801 / sqrt(8) / sum;
        assertEquals(pi, actual, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.01")
    public void gregoryLeibniz(double tolerance) {
        double sum = 0;
        double num = 1;
        for (int n = 0; n < 199; ++n) {
            double numerator = num;
            double denominator = 2 * n + 1;
            double added = numerator / denominator;
            num *= -1;
            sum += added;
        }
        double actual = 4 * sum;
        assertEquals(pi, actual, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.01")
    public void nilakantha(double tolerance) {
        double sum = 0;
        double num = 1;
        for (int n = 1; n < 5; ++n) {
            double numerator = num;
            double denominator = (2 * n) * (2 * n + 1) * (2 * n + 2);
            double added = numerator / denominator;
            num *= -1;
            sum += added;
        }
        double actual = 3 + 4 * sum;
        assertEquals(pi, actual, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.01")
    public void eulerBasel(double tolerance) {
        double sum = 0;
        for (int n = 1; n < 97; ++n) {
            double numerator = 6;
            double denominator = n * n;
            double added = numerator / denominator;
            sum += added;
        }
        double actual = sqrt(sum);
        assertEquals(pi, actual, tolerance);
    }

    double arctan(double x) {
        double sum = 0;
        double nom = 1;
        for (int n = 0; n < 3; ++n) {
            double numerator = nom * power(x, 2 * n + 1);
            double denominator = 2 * n + 1;
            double added = numerator / denominator;
            nom *= -1;
            sum += added;
        }
        return sum;
    }

    @ParameterizedTest
    @CsvSource("0.01")
    public void machinLike(double tolerance) {
        double actual = 16 * arctan(1.0 / 5) - 4 * arctan(1.0 / 239);

        assertEquals(pi, actual, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.01")
    public void machinLike2(double tolerance) {
        double actual = 16 * arctan1over5() - 4 * arctan1over239();

        assertEquals(pi, actual, tolerance);
    }

    private double arctan1over239() {
        double sum = 0;
        double nom = 1;
        for (int n = 0; n < 5; ++n) {
            double numerator = nom;
            double denominator = (2 * n + 1) * power(239, 2 * n + 1);
            double added = numerator / denominator;
            nom *= -1;
            sum += added;
        }
        return sum;
    }

    private double arctan1over5() {
        double sum = 0;
        double nom = 1;
        for (int n = 0; n < 5; ++n) {
            double numerator = nom;
            double denominator = (2 * n + 1) * power(5, 2 * n + 1);
            double added = numerator / denominator;
            nom *= -1;
            sum += added;
        }
        return sum;
    }

    @ParameterizedTest
    @CsvSource("0.01")
    public void archimedesPolygon(double tolerance) {
        int n = 50;
        double actual = n * sin(PI / n);

        assertEquals(pi, actual, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.01")
    public void archimedesPolygon2(double tolerance) {
        int n = 50;
        double actual = n * sin(PI / n);

        assertEquals(pi, actual, tolerance);
    }
}
