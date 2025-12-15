package servlet3;

import static java.util.Collections.reverseOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static servlet3.Powers.power;

import java.util.Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class E {
    @ParameterizedTest
    @CsvSource({ "0.001" })
    public void definition(double tolerance) {
        int pow = 10000;

        double result = power(1 + 1.0 / pow, pow);

        assertEquals(Math.E, result, tolerance);
    }

    @ParameterizedTest
    @CsvSource({ "0.01" })
    public void binomial(double tolerance) {
        int n = 150;
        double[] factorials = reverseFactorials(n);
        double result = 0;
        for (int i = 0; i <= n; i++) {
            double added = factorials[0] / factorials[n - i] / factorials[i] / power(n, i);
            result += added;
        }
        assertEquals(Math.E, result, tolerance);
    }

    private double[] reverseFactorials(int n) {
        return Arrays.stream(factorials(n)).boxed().sorted(reverseOrder()).mapToDouble(Double::valueOf).toArray();
    }

    private double[] factorials(int n) {
        double factorials[] = new double[n + 1];
        double fact = 1;
        for (int i = 0; i < factorials.length; i++) {
            factorials[i] = fact;
            fact *= i + 1;
        }
        return factorials;
    }

    @ParameterizedTest
    @CsvSource({ "0.01" })
    public void product(double tolerance) {
        int n = 300;
        double factorial = 1;
        double result = 0;
        for (int i = 0; i <= n; i++) {
            double added = (1 - 1.0 * i / n) / factorial;
            factorial *= i + 1;
            result += added;
        }

        assertEquals(Math.E, result, tolerance);
    }

    @ParameterizedTest
    @CsvSource({ "0.001" })
    public void taylor(double tolerance) {
        int n = 6;
        double factorial = 1;
        double result = 0;
        for (int i = 0; i <= n; i++) {
            double term = 1.0 / factorial;
            factorial *= i + 1;
            result += term;
        }
        assertEquals(Math.E, result, tolerance);
    }

    @ParameterizedTest
    @CsvSource({ "0.1" })
    public void alternating(double tolerance) {
        int n = 10000;
        double minus1 = 1;
        double result = 2;
        double factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            double term = minus1 / factorial / i;
            minus1 *= -1;
            result += term;
        }
        assertEquals(Math.E, result, tolerance);
    }

    private int a(int n) {
        if (n == 0)
            return 2;
        if (n % 3 == 2)
            return 2 * (n / 3 + 1);
        return 1;
    }

    @ParameterizedTest
    @CsvSource("0.01")
    public void euler(double tolerance) {
        int p2 = 0;
        int p1 = 1;
        int q2 = 1;
        int q1 = 0;
        for (int i = 0; i < 10; i++) {
            int a = a(i);
            int p = a * p1 + p2;
            int q = a * q1 + q2;
            double v = 1. * p / q;
            System.out.println(v);
            p2 = p1;
            p1 = p;
            q2 = q1;
            q1 = q;
        }
    }
}
