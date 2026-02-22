package servlet3;

import static java.lang.Math.E;
import static java.lang.Math.PI;
import static java.lang.Math.exp;
import static java.lang.Math.log;
import static java.lang.Math.random;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static servlet3.Factorials.factorial;
import static servlet3.Powers.power;
import static servlet3.Powers.power2;

import java.util.Random;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Pi {
    private static double pi = PI;

    @ParameterizedTest
    @CsvSource({ "0.0008" })
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
    @CsvSource({ "0.0008" })
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
    @CsvSource({ "0.03,30" })
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
    @CsvSource("0.007")
    public void stirling(double tolerance) {
        int n = 75;
        double factorial = factorial(n);
        double nominator = factorial * factorial * exp(2 * n);
        double denumerator = 2 * power(n, 2 * n + 1);
        double result = nominator / denumerator;

        assertEquals(pi, result, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.009")
    public void stirlingApproximation(double tolerance) {
        int n = 10;
        double factorial = factorial(n);
        double approximation = sqrt(2 * pi * n) * power(1.0 * n / E, n);

        assertEquals(factorial, approximation, factorial * tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.008")
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
    public void basel(double tolerance) {
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

    @ParameterizedTest
    @CsvSource("0.01")
    public void eulerBasel(double tolerance) {
        Random random = new Random(42);
        int samples = 5000000;
        int max = 1000000;
        int coprime = 0;
        for (int i = 0; i < samples; i++) {
            int a = random.nextInt(max);
            int b = random.nextInt(max);
            if (VariousTests.gcd(a, b) == 1)
                coprime++;
        }
        double probability = (double) coprime / samples;
        double piEstimate = sqrt(6 / probability);
        assertEquals(pi, piEstimate, tolerance);
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
    @CsvSource("0.00001")
    public void archimedesPolygon2(double tolerance) {
        int n = 6;
        double s = 1;
        double halfPerimeter;
        do {
            halfPerimeter = n * s / 2;
            s = getNextSide(s);
            n *= 2;
        } while (n <= 96 * 96);
        assertEquals(pi, halfPerimeter, tolerance);
    }

    private double getNextSide(double s) {
        return sqrt(2 - sqrt(4 - s * s));
    }

    @ParameterizedTest
    @CsvSource("0.00001")
    public void vieteInfiniteProduct(double tolerance) {
        double product = 1;
        double lastVal = 0;
        for (int i = 0; i < 10; i++) {
            double lastSquareRoot = sqrt(2 + lastVal);
            double term = lastSquareRoot / 2;
            product *= term;
            lastVal = lastSquareRoot;
        }
        assertEquals(2 / pi, product, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.00001")
    public void vieteInfiniteProduct2(double tolerance) {
        double product = 2;
        double lastVal = 0;
        for (int i = 0; i < 10; i++) {
            double numerator = 2;
            double denominator = sqrt(2 + lastVal);
            lastVal = denominator;
            double term = numerator / denominator;
            product *= term;
        }
        assertEquals(pi, product, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.1")
    public void monteCarlo(double tolerance) {
        int n = 1000;
        int insideUnitCircle = 0;
        for (int i = 0; i < n; i++) {
            double x = random() * 2 - 1;
            double y = random() * 2 - 1;
            double r = sqrt(x * x + y * y);
            if (r < 1)
                insideUnitCircle++;
        }
        double expectedPi = 1.0 * insideUnitCircle / n * 4;
        assertEquals(pi, expectedPi, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.1")
    public void buffonNeedle(double tolerance) {
        double l = 1; // needle length
        double d = 2; // distance between lines
        double drops = 5000000;
        Random random = new Random(42);
        int crossings = 0;
        for (int i = 0; i < drops; i++) {
            double theta = random.nextDouble() * PI / 2;
            double x = random.nextDouble() * d / 2;
            if (x <= (l / 2) * sin(theta))
                crossings++;
        }
        double piEstimate = (2 * l * drops) / (d * crossings);
        assertEquals(pi, piEstimate, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.1")
    public void gaussLegender(double tolerance) {
        double a = 1;
        double b = 1 / sqrt(2);
        double t = .25;
        double p = 1;
        for (int i = 0; i < 4; i++) {
            double aNext = (a + b) / 2;
            double bNext = sqrt(a * b);
            double tNext = t - p * (a - aNext) * (a - aNext);
            a = aNext;
            b = bNext;
            t = tNext;
            p *= 2;
        }
        double piEstimate = (a + b) * (a + b) / (4 * t);
        assertEquals(pi, piEstimate, tolerance);
    }

    @ParameterizedTest
    @CsvSource("0.04")
    public void brouckerPi(double tolerance) {
        double cf = 0;
        for (int i = 200; i >= 1; --i) {
            double odd = 2 * i - 1;
            cf = odd * odd / (cf + 2);
        }
        double piEstimate = 4 / (1 + cf);
        assertEquals(pi, piEstimate, tolerance);
    }
}
