package servlet3;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static java.util.Collections.sort;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class VariousTests {
    @Test
    public void palyndrome() {
        String palyndrome = "madam";

        String s = reverse(palyndrome);

        assertEquals(s, palyndrome);
    }

    @Test
    public void nonPalyndrome() {
        String nonPalyndrome = "Madam";

        String s = reverse(nonPalyndrome);

        assertNotEquals(s, nonPalyndrome);
    }

    private String reverse(String nonPalyndrome) {
        return new StringBuilder(nonPalyndrome).reverse().toString();
    }

    @Test
    public void reversesString() {
        String s = "ABC";

        String reversed = reverse(s);

        assertEquals(reversed, "CBA");
    }

    @ParameterizedTest
    @CsvSource({ "4181,20", "34,10", "0,1", "1,2", "1,3", "2,4", "3,5" })
    public void fibonacci(int expected, int nTh) {
        assertEquals(expected, fibonacci(nTh));
    }

    @ParameterizedTest
    @CsvSource({ "-1", "0", "-1" })
    public void fibonacci_Throws(int nTh) {
        assertThrows(IllegalArgumentException.class, () -> fibonacci(nTh));
    }

    private int fibonacci(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        if (n == 1)
            return 0;
        return fibonacciNoChecks(n);
    }

    private int fibonacciNoChecks(int n) {
        int i = 0;
        int j = 1;
        for (int ii = 2; ii < n; ++ii) {
            int l = i + j;
            i = j;
            j = l;
        }
        return j;
    }

    @ParameterizedTest
    @CsvSource({ "true,2", "true,3", "false,4", "true,5", "false,9", "false,16", "false,25", "false,49", "false,64",
            "false,81", "false,99", "true,97" })
    public void primeNumbers(boolean expectedResult, int n) {
        assertEquals(expectedResult, isPrimeNumber(n));
    }

    @ParameterizedTest
    @CsvSource({ "-1", "0", "1" })
    public void primeNumbers_Throws(int n) {
        assertThrows(IllegalArgumentException.class, () -> isPrimeNumber(n));
    }

    private strictfp boolean isPrimeNumber(int n) {
        if (n < 2)
            throw new IllegalArgumentException();
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    @ParameterizedTest
    @CsvSource({ "1,0", "1,1", "2,2", "6,3", "24,4", "120,5", "720,6" })
    public void factorial(int expected, int n) {
        int f = factorial(n);

        assertEquals(expected, f);
    }

    @ParameterizedTest
    @CsvSource({ "-1", "-2" })
    public void factorial_Throws(int n) {
        assertThrows(IllegalArgumentException.class, () -> factorial(n));
    }

    private int factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        int f = 1;
        for (int i = 1; i < n; ++i) {
            f *= i + 1;
        }
        return f;
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 2, -1", "1,1,2,-1" })
    public void findsDuplicates(int first, int second, int third, int fourth) {
        List<Integer> l = asList(first, second, third, fourth);

        assertEquals(distinct(l), uniqueList(l));
    }

    private List<Integer> distinct(List<Integer> list) {
        List<Integer> distinct = new ArrayList<Integer>();
        for (Integer i : list)
            if (!distinct.contains(i))
                distinct.add(i);
        return new ArrayList<Integer>(distinct);
    }

    private List<Integer> uniqueList(List<Integer> list) {
        return new ArrayList<Integer>(new LinkedHashSet<Integer>(list));
    }

    @ParameterizedTest
    @CsvSource({ "-123", "-1", "0", "12", "123" })
    public void reversesANumber(int num) {
        int initial = num;
        int reversed = 0;
        int sign = num < 0 ? -1 : 1;

        while (sign * num > 0) {
            reversed *= 10;
            reversed += num % 10;
            num = num / 10;
        }

        assertEquals(parseInt(reverse("" + sign * initial)), sign * reversed);
    }

    @ParameterizedTest
    @CsvSource({ "60,48,12", "10,3,1", "10,3,1", "10,0,10", "0,9,9", "-2,4,2", "3,-6,3", "-4,-8,4" })
    public void gcd(int a, int b, int expected) {
        a = a < 0 ? -a : a;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        assertEquals(expected, a);
    }

    @ParameterizedTest
    @CsvSource({ "hello,world,false", "alus,sula,true", "'','',true" })
    public void anagram(String first, String second, boolean expected) {
        List<String> f = sortedList(first);
        List<String> s = sortedList(second);

        assertEquals(f.equals(s), expected);
    }

    private List<String> sortedList(String input) {
        List<String> l = new ArrayList<>();
        for (Character i : input.toCharArray())
            l.add(i.toString());
        sort(l);
        return l;
    }

    @ParameterizedTest
    @CsvSource({ "5,1,5", "0,0,1", "1,0,1", "1,1,1", "2,2,1", "3,3,1", "10,1,10", "10,2,45", "5,3,10", "5,4,5", "5,5,1",
            "6,2,15" })
    public void pascalsTriangle(int row, int col, int expected) {
        int result = 0;
        for (int i = 0; i <= row; i++) {
            int num = 1;
            for (int j = 0; j <= i; j++) {
                indent(num);
                if (row == i && col == j)
                    result = num;
                num = num * (i - j) / (j + 1);
            }
            newLine();
        }

        assertEquals(result, expected);
    }

    private void indent(Number num) {
        System.out.format("%4d", num);
    }

    private void newLine() {
        System.out.println();
    }

    @ParameterizedTest
    @CsvSource({ "2,false", "6,true", "28,true", "27,false", "496,true", "8128,true" })
    public void perfect(int n, boolean perfect) {
        int p = 0;
        for (int i = 1; i < n; ++i) {
            if (n % i == 0)
                p += i;
        }

        assertEquals(p == n, perfect);
    }

    @ParameterizedTest
    @CsvSource({ "2 + 3,5", "2 - 3, -1" })
    public void simpleCalculator(String expression, int expectedResult) {
        try (Scanner sc = new Scanner(expression)) {
            int first = sc.nextInt();
            char operation = sc.next().charAt(0);
            int second = sc.nextInt();
            assertEquals(expectedResult, result(first, operation, second));
        }
    }

    private int result(int first, char operation, int second) {
        switch (operation) {
        case '+':
            return first + second;
        case '-':
            return first - second;
        default:
            throw new IllegalArgumentException();
        }
    }
}
