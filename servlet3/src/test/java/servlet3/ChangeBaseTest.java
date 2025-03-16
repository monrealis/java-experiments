package servlet3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ChangeBaseTest {
    @ParameterizedTest
    @CsvSource({ "(10,11" })
    public void changeBaseToN(String decimal, int fromBase) {
        assertThrows(IllegalArgumentException.class, () -> parse(decimal, fromBase));
    }

    @ParameterizedTest
    @CsvSource({ "0,10,0,2", "1,10,1,2", "2,10,10,2", "2,10,2,3", "3,10,11,2", "3,10,10,3", "4,10,100,2", "5,10,101,2",
            "5,5,5,10", "10,10,(10),11", "11,10,10,11", "12,10,11,11", "24,10,22,11", "120,10,(10)(10),11", "30,4,22,5",
            "31,4,23,5", "(10),11,10,10", "(10)(10),11,120,10", "(11),12,11,10", "(11)(10)0,12,1704,10", "(9),2,9,10",
            "1(),10,10,10", "(),10,0,1" })
    public void changeBaseToN(String decimal, int fromBase, String baseN, int toBase) {
        int d = parse(decimal, fromBase);
        int bN;
        String bNString = "";

        do {
            bN = d % toBase;
            bNString = digit(bN, toBase) + bNString;
            d /= toBase;
        } while (d != 0);

        assertEquals(baseN, bNString);
    }

    private int parse(String number, int fromBase) {
        int sum = 0;
        int sumInParen = 0;
        char[] chars = number.toCharArray();
        boolean opened = false;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '(') {
                assertEquals(opened, false);
                opened = true;
            } else if (chars[i] == ')') {
                assertEquals(opened, true);
                opened = false;
                sum *= fromBase;
                sum += sumInParen;
                sumInParen = 0;
            } else if (opened) {
                int charInParen = chars[i] - '0';
                sumInParen *= 10;
                sumInParen += charInParen;
            } else {
                int cc = chars[i] - '0';
                if (cc < 0 || cc > fromBase)
                    throw new IllegalArgumentException();
                sum *= fromBase;
                sum += cc;
            }
        }
        if (opened)
            throw new IllegalArgumentException();
        return sum;
    }

    private String digit(int bN, int toBase) {
        if (bN >= 10 && toBase > 10)
            return "(" + Integer.toString(bN) + ")";
        return Integer.toString(bN);
    }
}
