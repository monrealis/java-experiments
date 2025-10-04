package servlet3;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
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
    @CsvSource("0.05")
    public void stirling(double tolerance) {
        int n = 30;
        double nominator = pow(factorial(n), 2) * pow(2, 2 * n + 1);
        double denumerator = factorial(2 * n + 1);
        double result = nominator / denumerator;

        assertEquals(pi, result, tolerance);
    }

    public void ramanujan(double tolerance) {

    }
}
