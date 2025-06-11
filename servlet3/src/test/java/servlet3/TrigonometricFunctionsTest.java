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
        BigDecimal x = BigDecimal.ONE;
        BigDecimal cos = BigDecimal.ONE;
        BigDecimal factorial = BigDecimal.ONE;

        for (int i = 0; i < 10; ++i) {
            BigDecimal times2 = new BigDecimal(i).multiply(new BigDecimal("2"));
            factorial = factorial.multiply(times2.add(new BigDecimal("2")));
            BigDecimal sign = i % 2 == 1 ? BigDecimal.ONE : BigDecimal.ONE.negate();
            BigDecimal multiply = sign.multiply(x);
            BigDecimal substracted = multiply.divide(factorial, 100, RoundingMode.UP);
            factorial = factorial.multiply(times2.add(new BigDecimal("3")));
            x = x.multiply(new BigDecimal(Double.valueOf(xx)).multiply(BigDecimal.valueOf(xx)));
            cos = cos.add(substracted);
        }
        // assertTrue(abs(cos - expectedResult) < 0.0001, cos + " " + x + ": " +
        // expectedResult);
    }

    @ParameterizedTest
    @CsvSource({ "1,0.540302305"/* , "-1,0.540302305" */ })
    public void cosXX(double x, double expectedResult) {
        double cos = 1;
        double factorial = 1;

        for (int i = 0; i < 5; ++i) {
            x *= x * x;
            factorial *= 2 * i + 2;
            double substracted = (i % 2 == 1 ? 1 : -1) * x / factorial;
            factorial *= 2 * i + 3;
            cos += substracted;
        }
        assertTrue(abs(cos - expectedResult) < 0.0001, cos + " " + x + ": " + expectedResult);
    }

    double factorial(int n) {
        double f = 1;
        for (int i = 1; i < n; ++i)
            f *= i + 1;
        return f;
    }
}
