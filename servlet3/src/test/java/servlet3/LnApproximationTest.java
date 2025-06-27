package servlet3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LnApproximationTest {

    @ParameterizedTest(name = "ln(1 + {0}) ≈ {1} (tolerance: {2})")
    @CsvSource({ "1.0, 0.693147, 0.1", // ln(2)
            "0.5, 0.405465, 0.05", // ln(1.5)
            "0.25, 0.223143, 0.01", // ln(1.25)
            "0.1, 0.095310, 0.005", // ln(1.1)
            "0.0, 0.000000, 0.0001" // ln(1) = 0
    })
    public void testLnApproximation(double x, double expected, double tolerance) {
        double approx = LnApproximation.lnApprox(x);
        double actual = Math.log(1 + x);
        double error = Math.abs(approx - actual);

        assertTrue(error < tolerance,
                String.format("x = %.2f → approx = %.6f, actual = %.6f, error = %.6f exceeds tolerance %.6f", x, approx,
                        actual, error, tolerance));
    }
}