package servlet3;

import static java.lang.Math.abs;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TrigonometricFunctionsTest {
    private static final BigDecimal THREE = new BigDecimal("3");
    private static final BigDecimal TWO = new BigDecimal("2");

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

    @ParameterizedTest
    @CsvSource({ /* "0,0", */ "1,0.841471"/* , "-1,-0.841471"/* , "6.283185307,0" */ })
    public void sinXX(double x, double expectedResult) {
        BigDecimal sin = ZERO;
        BigDecimal factorial = ONE;
        BigDecimal currentFactorial = ONE;

        for (int i = 0; i < 5; ++i) {
            currentFactorial = currentFactorial.multiply(timesX(x));
            BigDecimal added = oneIfEven(i).divide(factorial, 100, RoundingMode.UP).multiply(currentFactorial);
            factorial = factorial.multiply(factorial.add(ONE)).multiply(factorial.add(TWO));
            sin = sin.add(added);
        }

    }

    @ParameterizedTest
    @CsvSource({ "0,1", "1,0.540302305", "-1,0.540302305", "3.141592654,-1", "6.283185307,1", "12.56637061,1" })
    public void cosX(double x, double expectedResult) {
        BigDecimal currentFactorial = ONE;
        BigDecimal cos = ONE;
        BigDecimal factorial = ONE;

        for (int i = 0; i < 20; ++i) {
            factorial = factorial.multiply(twice(i).add(TWO));
            currentFactorial = currentFactorial.multiply(timesXSquared(x));
            BigDecimal multiply = oneIfOdd(i).multiply(currentFactorial);
            BigDecimal substracted = multiply.divide(factorial, 100, RoundingMode.UP);
            factorial = factorial.multiply(twice(i).add(THREE));
            cos = cos.add(substracted);
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

    private BigDecimal timesXSquared(double x) {
        return new BigDecimal(Double.valueOf(x)).multiply(BigDecimal.valueOf(x));
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
}
