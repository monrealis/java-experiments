package servlet3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class E {
    @ParameterizedTest
    @CsvSource({ ".001" })
    public void e(double tolerance) {
        double result = 1;
        for (int i = 1; i < 5; i++) {

        }
        assertEquals(Math.E, result, tolerance);
    }
}
