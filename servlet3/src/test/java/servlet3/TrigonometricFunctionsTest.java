package servlet3;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TrigonometricFunctionsTest {
    @ParameterizedTest
    @CsvSource({ "0,0", "1,0.841", "-1,-0.841" })
    public void sinX(double x, double expectedResult) {
        double sin = 0;
        int inverse = 1;
        for (int i = 1; i < 10; i += 2) {
            double added = inverse * pow(x, i) / factorial(i);
            sin += added;
            inverse = -inverse;
        }
        assertTrue(abs(sin - expectedResult) < 0.001, sin + " " + expectedResult);
    }

    private double factorial(int n) {
        double f = 1;
        for (int i = 1; i < n; ++i)
            f *= i + 1;
        return f;
    }
}
