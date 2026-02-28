package servlet3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static servlet3.Powers.power;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PowersTest {
    @ParameterizedTest
    @CsvSource({ "2,1,2", "2,3,8", "2,0,1", "3,2,9", "3,3,27", "4,2,16" })
    public void factorial(int n, int exponent, int expectedResult) {
        assertEquals(power(n, exponent), expectedResult);
    }
}
