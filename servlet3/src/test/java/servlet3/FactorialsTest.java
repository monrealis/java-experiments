package servlet3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FactorialsTest {
    @ParameterizedTest
    @CsvSource({ "0,1", "1,1", "2,2", "3,6" })
    public void factorial(int n, int expectedResult) {
        assertEquals(Factorials.factorial(n), expectedResult);
    }

    @ParameterizedTest
    @CsvSource({ "6,3,4,24", "2,2,4,24", "1,1,4,24", "1,0,4,24" })
    public void factorial(int initial, int fromN, int n, int expectedResult) {
        assertEquals(Factorials.factorial(initial, fromN, n), expectedResult);
    }
}
