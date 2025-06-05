package servlet3;

import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TrigonometricFunctionsTest {
    @ParameterizedTest
    @CsvSource({ "0,0", "1,0.841471", "-1,-0.841471" })
    public void sinX(double x, double expectedResult) {
        double sin = 0;
        double factorial = 1;

        for (int i = 0; i < 10; ++i) {
            double added = (i % 2 == 0 ? 1 : -1) * x / factorial;
            x *= x * x;
            factorial = factorial * (2 * i + 2) * (2 * i + 3);
            sin += added;
        }
        assertTrue(abs(sin - expectedResult) < 0.0001, sin + " " + expectedResult);
    }

    double factorial(int n) {
        double f = 1;
        for (int i = 1; i < n; ++i)
            f *= i + 1;
        return f;
    }
}
