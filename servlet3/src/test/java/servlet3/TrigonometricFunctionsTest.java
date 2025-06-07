package servlet3;

import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TrigonometricFunctionsTest {
    @ParameterizedTest
    @CsvSource({ "0,0", "1,0.841471", "-1,-0.841471"/* , "6.283185307,0" */ })
    public void sinX(double x, double expectedResult) {
        double sin = 0;
        double factorial = 1;

        for (int i = 0; i < 5; ++i) {
            double added = (i % 2 == 0 ? 1 : -1) * x / factorial;
            x *= x * x;
            factorial = factorial * (2 * i + 2) * (2 * i + 3);
            sin += added;
        }
        assertTrue(abs(sin - expectedResult) < 0.0001, sin + " " + x + ": " + expectedResult);
    }

    // TODO
    @ParameterizedTest
    @CsvSource({ /* "0,1", "1,0.540302305" , "-1,0.540302305" */ "6.283185307,1" })
    public void cosX(double xx, double expectedResult) {
        BigDecimal x = new BigDecimal(Double.valueOf(xx));
        BigDecimal cos = BigDecimal.ONE;
        BigDecimal factorial = BigDecimal.ONE;

        for (int i = 0; i < 10; ++i) {
            x = x.multiply(x);
            factorial = factorial.multiply(new BigDecimal("2")).add(new BigDecimal("0"));
            BigDecimal bd = (i % 2 == 1 ? BigDecimal.ONE : BigDecimal.ONE.negate());
            BigDecimal multiply = bd.multiply(new BigDecimal(x.toString()));
            BigDecimal substracted = multiply.divide(factorial, 10, RoundingMode.UP);
            factorial = factorial.multiply(new BigDecimal("2")).add(new BigDecimal("2"));
            cos = cos.add(substracted);
        }
        // assertTrue(abs(cos - expectedResult) < 0.0001, cos + " " + x + ": " +
        // expectedResult);
    }

    double factorial(int n) {
        double f = 1;
        for (int i = 1; i < n; ++i)
            f *= i + 1;
        return f;
    }
}
