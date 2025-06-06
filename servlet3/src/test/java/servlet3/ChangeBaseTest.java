package servlet3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ChangeBaseTest {
    @ParameterizedTest
    @CsvSource({ "(10,11", "0),10", "0(,10", "a,10", "((),10" })
    public void changeBaseToN(String initial, int initialBase) {
        assertThrows(IllegalArgumentException.class, () -> new Parser(initial, initialBase).parse());
    }

    @ParameterizedTest
    @CsvSource({ "0,10,0,2", "1,10,1,2", "2,10,10,2", "2,10,2,3", "3,10,11,2", "3,10,10,3", "4,10,100,2", "5,10,101,2",
            "5,5,5,10", "10,10,(10),11", "11,10,10,11", "12,10,11,11", "24,10,22,11", "120,10,(10)(10),11", "30,4,22,5",
            "31,4,23,5", "(10),11,10,10", "(10)(10),11,120,10", "(11),12,11,10", "(11)(10)0,12,1704,10",
            "(1)(0)01,2,9,10", "1(),10,10,10", "(),10,0,1" })
    public void changeBaseToN(String intial, int initialBase, String baseN, int n) {
        int d = new Parser(intial, initialBase).parse();
        int bN;
        String bNString = "";

        do {
            bN = d % n;
            bNString = digit(bN, n) + bNString;
            d /= n;
        } while (d != 0);

        assertEquals(baseN, bNString);
    }

    private static class Parser {
        private final String number;
        private final int fromBase;
        private int sum;
        private int sumInParentheses;
        private boolean opened;

        public Parser(String number, int fromBase) {
            this.number = number;
            this.fromBase = fromBase;
        }

        private int parse() {
            for (char c : number.toCharArray()) {
                if (c == '(')
                    open();
                else if (c == ')')
                    close();
                else
                    digit(c);
            }
            ensureNotOpened();
            return sum;
        }

        private void digit(char c) {
            int cc = c - '0';
            if (cc < 0 || cc > fromBase)
                throw new IllegalArgumentException();
            if (opened) {
                sumInParentheses *= 10;
                sumInParentheses += cc;
            } else {
                sum *= fromBase;
                sum += cc;
            }
        }

        private void open() {
            if (opened)
                throw new IllegalArgumentException();
            opened = true;
        }

        private void close() {
            if (!opened)
                throw new IllegalArgumentException();
            opened = false;
            sum *= fromBase;
            sum += sumInParentheses;
            sumInParentheses = 0;
        }

        private void ensureNotOpened() {
            if (opened)
                throw new IllegalArgumentException();
        }
    }

    private String digit(int bN, int toBase) {
        if (bN >= 10 && toBase > 10)
            return "(" + Integer.toString(bN) + ")";
        return Integer.toString(bN);
    }
}
