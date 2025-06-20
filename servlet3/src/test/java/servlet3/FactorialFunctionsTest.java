package servlet3;

import static java.lang.Math.abs;
import static java.lang.Math.log;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FactorialFunctionsTest {
    private static final BigDecimal THREE = new BigDecimal("3");
    private static final BigDecimal TWO = new BigDecimal("2");

    @ParameterizedTest
    @CsvSource({ "0,0", "1,0.841471", "1.1,0.89120736", "-1,-0.841471", "6.283185307,0" })
    public void sinX(double x, double expectedResult) {
        BigDecimal sin = ZERO;
        BigDecimal factorial = ONE;
        final double xSquared = x * x;

        for (int i = 0; i < 20; ++i) {
            BigDecimal added = oneIfEven(i).multiply(timesX(x)).divide(factorial, 100, RoundingMode.UP);
            x = x * xSquared;
            factorial = factorial.multiply(twice(i).add(TWO)).multiply(twice(i).add(THREE));
            sin = sin.add(added);
        }
        double d = Double.valueOf(sin.toString());
        assertTrue(abs(d - expectedResult) < 0.0001, "sin(" + x + "): " + expectedResult + ". Instead was : " + d);
    }

    @ParameterizedTest
    @CsvSource({ "0,1", "1,0.540302305", "-1,0.540302305", "3.141592654,-1", "6.283185307,1", "12.56637061,1" })
    public void cosX(double x, double expectedResult) {
        double currentX = 1;
        BigDecimal cos = ONE;
        BigDecimal factorial = ONE;
        final double xSquared = x * x;

        for (int i = 0; i < 20; ++i) {
            factorial = factorial.multiply(twice(i).add(TWO));
            currentX = currentX * xSquared;
            BigDecimal added = oneIfOdd(i).multiply(timesX(currentX)).divide(factorial, 100, RoundingMode.UP);
            factorial = factorial.multiply(twice(i).add(THREE));
            cos = cos.add(added);
        }
        double d = Double.valueOf(cos.toString());
        assertTrue(abs(d - expectedResult) < 0.0001, "cos(" + x + "): " + expectedResult + ". Instead was : " + d);
    }

    private BigDecimal oneIfOdd(int i) {
        return i % 2 == 1 ? ONE : ONE.negate();
    }

    private BigDecimal oneIfEven(int i) {
        return i % 2 == 0 ? ONE : ONE.negate();
    }

    private BigDecimal timesX(double x) {
        return new BigDecimal(Double.valueOf(x));
    }

    private BigDecimal twice(int i) {
        return new BigDecimal(i).multiply(TWO);
    }

    double factorial(int n) {
        double f = 1;
        for (int i = 1; i < n; ++i)
            f *= i + 1;
        return f;
    }

    @ParameterizedTest
    @CsvSource({ "2.718281826,1,2.718281826", "2,3,8" })
    public void powerX(double base, double x, double expectedResult) {
        double initial = x;
        double ln = log(base);
        BigDecimal pow = TWO;
        BigDecimal factorial = ONE;
        for (int i = 1; i < 20; i++) {
            x *= initial * x;
            factorial = factorial.multiply(timesX(i + 1));
            BigDecimal added = ONE.multiply(timesX(x * ln)).divide(factorial, 100, RoundingMode.UP);
            pow = pow.add(added);
        }
        double d = Double.valueOf(pow.toString());
        assertTrue(abs(d - expectedResult) < 0.0001, "e^" + x + ": " + expectedResult + ". Instead was : " + pow);
    }
}
