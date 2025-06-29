package servlet3;

import static java.lang.Math.E;
import static java.lang.Math.abs;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.UP;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Disabled;
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
            BigDecimal multiply = oneIfEven(i).multiply(timesX(x));
            BigDecimal added = divide(multiply, factorial);
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
            BigDecimal multiply = oneIfOdd(i).multiply(timesX(currentX));
            BigDecimal added = divide(multiply, factorial);
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
    @CsvSource({ "2,3,8", "1,1,1", "2,2,4" })
    public void powerX(double base, double x, double expectedResult) {
        power(base, x, expectedResult);
    }

    @ParameterizedTest
    @CsvSource({ "1,2.718281826", "2,7.389056099", "2.5,12.18249396" })
    public void eX(double x, double expectedResult) {
        power(E, x, expectedResult);
    }

    private void power(double base, double x, double expectedResult) {
        double ln = log(base);
        double initial = x;
        BigDecimal pow = ONE;
        BigDecimal factorial = ONE;
        for (int i = 1; i < 20; i++) {
            factorial = factorial.multiply(timesX(i));
            BigDecimal timesX = timesX(x * ln);
            BigDecimal added = divide(timesX, factorial);
            x *= initial * ln;
            pow = pow.add(added);
        }
        double d = Double.valueOf(pow.toString());
        assertTrue(abs(d - expectedResult) < 0.0001, "e^" + x + ": " + expectedResult + ". Instead was : " + pow);
    }

    @ParameterizedTest
    @CsvSource({ "2,1" })
    @Disabled
    public void lnX(double x, double expectedResult) {
        double y = x - 1;
        double initial = x - 1;
        BigDecimal factorial = ONE;
        BigDecimal ln = ONE;

        for (int i = 1; i < 2; i++) {
            factorial = factorial.multiply(timesX(i));
            BigDecimal multiply = oneIfEven(i).multiply(timesX(i));
            BigDecimal added = divide(multiply, factorial);
            y *= initial * y;
            ln = ln.add(added);
        }

        double d = Double.valueOf(ln.toString()) - 1;
        assertTrue(abs(d - expectedResult) < 0.0001, "ln " + x + ": " + expectedResult + ". Instead was : " + d);
    }

    @ParameterizedTest(name = "ln({0}) ≈ {1} (tolerance: {2})")
    @CsvSource({ "2.0, 0.693147, 0.1", 
            "1.5, 0.405465, 0.05",     
            "1.25, 0.223143, 0.01",    
            "1.1, 0.095310, 0.005",    
            "1.0, 0.000000, 0.0001"    
    })
    public void lnX(double x, double expected, double tolerance) {
        double approx = lnX(x - 1);
        double actual = Math.log(x);
        double error = Math.abs(approx - actual);

        assertTrue(error < tolerance,
                String.format("x = %.2f → approx = %.6f, actual = %.6f, error = %.6f exceeds tolerance %.6f", x, approx,
                        actual, error, tolerance));
    }

    private double lnX(double x) {
        BigDecimal result = ZERO;
        BigDecimal numeratorFact = ONE;
        BigDecimal denominatorFact = ONE;
        for (int n = 1; n <= 20; n++) {
            denominatorFact = denominatorFact.multiply(timesX(n));
            BigDecimal term = oneIfOdd(n).multiply(divide(numeratorFact, denominatorFact));
            term = term.multiply(new BigDecimal(pow(x, n)));
            result = result.add(term);
            numeratorFact = denominatorFact;
        }
        return result.doubleValue();
    }

    private BigDecimal divide(BigDecimal nominator, BigDecimal denominator) {
        return nominator.divide(denominator, 100, UP);
    }
}
