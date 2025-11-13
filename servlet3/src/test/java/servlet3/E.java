package servlet3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class E {
    @ParameterizedTest
    @CsvSource({ "0.001" })
    public void e(double tolerance) {

    }
}
