package servlet3;

import static java.lang.Double.parseDouble;
import static java.lang.Math.E;
import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.log;
import static java.lang.String.format;
import static java.math.BigDecimal.ONE;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FactorialFunctionsTest {
    private static final BigDecimal THREE = new BigDecimal("3");
    private static final BigDecimal TWO = new BigDecimal("2");

    @ParameterizedTest(name = "sin({1}) ≈ {2} (tolerance: {3})")
    @CsvSource({ "0,0,0.0001", "1,0.841471,0.0001", "1.1,0.89120736,0.0001", "-1,-0.841471,0.0001",
            "6.283185307,0,0.0001" })
    public void sinX(double x, double expectedValue, double tolerance) {
        double sin = sin(x);
        double error = abs(sin - expectedValue);
        String msg = format("sin(%.2f) → approx = %.6f, error = %.6f exceeds tolerance %.6f", x, expectedValue, error,
                tolerance);
        assertTrue(error < tolerance, msg);
    }

    private double sin(double x) {
        double sin = 0;
        BigDecimal factorial = ONE;
        final double xSquared = x * x;

        for (int i = 0; i < 20; ++i) {
            BigDecimal sign = oneIfEven(i);
            BigDecimal added = divide(sign.multiply(toBigDecimal(x)), factorial);
            x = x * xSquared;
            factorial = factorial.multiply(twice(i).add(TWO)).multiply(twice(i).add(THREE));
            sin += parseDouble(added.toString());
        }
        return sin;
    }

    private BigDecimal divide(BigDecimal numerator, BigDecimal denominator) {
        return numerator.divide(denominator, 100, RoundingMode.UP);
    }

    @ParameterizedTest(name = "cos({1}) ≈ {2} (tolerance: {3})")
    @CsvSource({ "0,1,0.0001", "1,0.540302305,0.0001", "-1,0.540302305,0.0001", "3.141592654,-1,0.0001",
            "6.283185307,1,0.0001", "12.56637061,1,0.0001" })
    public void cosX(double x, double expectedValue, double tolerance) {
        double currentX = 1;
        double cos = 1;
        BigDecimal factorial = ONE;
        final double xSquared = x * x;

        for (int i = 0; i < 20; ++i) {
            factorial = factorial.multiply(twice(i).add(TWO));
            currentX = currentX * xSquared;
            BigDecimal added = oneIfOdd(i).multiply(toBigDecimal(currentX)).divide(factorial, 100, RoundingMode.UP);
            factorial = factorial.multiply(twice(i).add(THREE));
            cos += parseDouble(added.toString());
        }

        double error = abs(cos - expectedValue);
        String msg = format("cos(%.2f) → approx = %.6f, error = %.6f exceeds tolerance %.6f", x, expectedValue, error,
                tolerance);
        assertTrue(error < tolerance, msg);
    }

    private BigDecimal oneIfOdd(int i) {
        return i % 2 == 1 ? ONE : ONE.negate();
    }

    private BigDecimal oneIfEven(int i) {
        return i % 2 == 0 ? ONE : ONE.negate();
    }

    private int odd(int i) {
        return i % 2 == 1 ? 1 : -1;
    }

    private BigDecimal toBigDecimal(double x) {
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

    @ParameterizedTest(name = "{0}^{1} ≈ {2} (tolerance: {3})")
    @CsvSource({ "2,3,8,0.0001", "1,1,1,0.0001", "2,2,4,0.0001" })
    public void powerX(double base, double x, double expectedResult, double tolerance) {
        power(base, x, expectedResult, tolerance);
    }

    @ParameterizedTest(name = "e^{0} ≈ {1} (tolerance: {2})")
    @CsvSource({ "1,2.718281826,0.0001", "2,7.389056099,0.0001", "2.5,12.18249396,0.0001" })
    public void eX(double x, double expectedResult, double tolerance) {
        power(E, x, expectedResult, tolerance);
    }

    private void power(double base, double x, double expectedResult, double tolerance) {
        double ln = log(base);
        double initial = x;
        double pow = 1;
        long factorial = 1;
        for (int i = 1; i < 20; i++) {
            factorial *= i;
            double added = x * ln / factorial;
            x *= initial * ln;
            pow += added;
        }
        double error = abs(pow - expectedResult);
        String msg = format("e^%.2f → approx = %.6f, actual = %.6f, error = %.6f exceeds tolerance %.6f", x, pow,
                expectedResult, error, tolerance);
        assertTrue(error < tolerance, msg);
    }

    @ParameterizedTest(name = "ln({0}) ≈ {1} (tolerance: {2})")
    @CsvSource({ "2.0, 0.693147, 0.1", "1.5, 0.405465, 0.05", "1.25, 0.223143, 0.01", "1.1, 0.095310, 0.005",
            "1.0, 0.000000, 0.0001" })
    public void lnX(double x, double expected, double tolerance) {
        double approx = lnX(x - 1);
        double actual = log(x);
        double error = abs(approx - actual);

        String msg = format("x = %.2f → approx = %.6f, actual = %.6f, error = %.6f exceeds tolerance %.6f", x, approx,
                actual, error, tolerance);
        assertTrue(error < tolerance, msg);
    }

    private double lnX(double x) {
        double initialX = x;
        double result = 0;
        long numeratorFact = 1;
        long denominatorFact = 1;
        for (int i = 1; i <= 5; i++) {
            denominatorFact *= i;
            double term = odd(i) * ((double) numeratorFact / denominatorFact) * x;
            x *= initialX;
            result += term;
            numeratorFact = denominatorFact;
        }
        return result;
    }

    @ParameterizedTest(name = "sinh({0}) ≈ {1} (tolerance: {2})")
    @CsvSource({ "1,1.1752,0.0001", "0,0,0.0001", "-1,-1.1752,0.0001", "2,3.6268,0.01" })
    public void sinh(double x, double expected, double tolerance) {
        double sinh = 0;
        final double xSquared = x * x;
        double denominatorFact = 1;
        for (int i = 1; i < 5; i++) {
            double added = x / denominatorFact;
            x *= xSquared;
            denominatorFact *= (i * 2) * (i * 2 + 1);
            sinh += added;
        }
        double error = abs(sinh - expected);
        String msg = format("sinh(%f) → approx %.6f, error = %.6f exceeds tolerance %.6f", x, expected, error,
                tolerance);
        assertTrue(error < tolerance, msg);
    }

    @ParameterizedTest(name = "cosh({0}) ≈ {1} (tolerance: {2})")
    @CsvSource({ "1,1.5430,0.0001", "0,1,0.0001", "-1,1.5430,0.0001", "2,3.7621,0.001" })
    public void cosh(double x, double expected, double tolerance) {
        double cosh = 1;
        final double xSq = x * x;
        double xSquared = x * x;
        double denominatorFact = 1;
        for (int i = 1; i < 5; i++) {
            denominatorFact *= (i * 2 - 1) * i * 2;
            double added = xSquared / denominatorFact;
            xSquared = xSquared * xSq;
            cosh += added;
        }
        double error = abs(cosh - expected);
        String msg = format("cosh(%f) → approx %.6f, error = %.6f exceeds tolerance %.6f", x, expected, error,
                tolerance);
        assertTrue(error < tolerance, msg);
    }

    @ParameterizedTest(name = "asin({0}) ≈ {1} (tolerance: {2})")
    @CsvSource({ "0.5,0.5235,0.001", "0,0,0.001", "1,1.57079,0.1", "-1,-1.57079,0.1" })
    public void asin(double x, double expected, double tolerance) {
        arcFunction(x, expected, tolerance, 0, "arcsin");
    }

    private void arcFunction(double x, double expected, double tolerance, double delta, String function) {
        double asin = 0;
        final double xSq = x * x;
        double factorialNom = 1;
        double factorialDen = 1;
        double fourToTheN = 1;
        for (int i = 1; i <= 40; i++) {
            double denominator = factorialDen * factorialDen * fourToTheN * (i * 2 - 1);
            double added = x * factorialNom / denominator;
            factorialNom *= (i * 2 - 1) * (i * 2);
            factorialDen = factorialDen * i;
            fourToTheN *= 4;
            x = xSq * x;
            asin += added;
        }
        double error = abs(asin - expected + delta);
        String msg = format("%s(%f) → approx %.6f, error = %.6f exceeds tolerance %.6f", function, x, expected, error,
                tolerance);
        assertTrue(error < tolerance, msg);
    }

    @ParameterizedTest(name = "acos({0}) ≈ {1} (tolerance: {2})")
    @CsvSource({ "1,0,0.1", "0.5,1.0472111,0.001", "0,1.5707,0.001", "-0.5,2.094395102,0.001", "-1,3.141596,0.1" })
    public void acos(double x, double expected, double tolerance) {
        double piOver2 = PI / 2;
        arcFunction(-x, expected, tolerance, piOver2, "arccos");
    }

    @ParameterizedTest(name = "tgx({0}) ≈ {1} (tolerance: {2})")
    @CsvSource({ "1,1.5574,0.001","0,0,0.001","-1,-1.5574,0.001" })
    public void tgx(double x, double expected, double tolerance) {
        double tgx = sin(x) / cos(x);
        double error = abs(tgx - expected);

        String msg = format("tg(%f) → approx %.6f, error = %.6f exceeds tolerance %.6f", x, expected, error, tolerance);
        assertTrue(error < tolerance, msg);
    }
}
