package servlet3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static servlet3.Factorials.factorial;
import static servlet3.Powers.power;

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
        double factorial = factorial(n);
        double factorials[] = new double[n + 1];
        for (int i = 0; i < factorials.length; i++) {
            factorials[i] = factorial(n - i);
        }
        double fact = 1;
        double result = 0;
        for (int i = 0; i <= n; i++) {
            if (i > 0)
                fact *= i;
            double f = factorial(n - i);
            assertEquals(f, factorials[i]);
            double added = factorial / fact / f / power(n, i);
            result += added;
        }

        assertEquals(Math.E, result, tolerance);
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
}
