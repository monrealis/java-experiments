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
        int gcd = gcd(a, b);

        assertEquals(expected, gcd);
    }

    @ParameterizedTest
    @CsvSource({ "10,15,30", "2,3,6", "2,-3,6", "-2,3,6", "-2,-3,6" })
    public void lcm(int a, int b, int expected) {
        int product = nonNegative(a) * b;

        int gcd = gcd(a, b);

        assertEquals(expected, product / gcd);
    }

    private int nonNegative(int a) {
        return a < 0 ? -a : a;
    }

    private int gcd(int a, int b) {
        a = a < 0 ? -a : a;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
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
    @CsvSource({ "2 ! 3", "2 # 3" })
    public void simpleCalculator_Throws(String expression) {
        scan(expression, null);
    }

    private void scan(String expression, Integer expectedResult) {
        try (Scanner sc = new Scanner(expression)) {
            int first = sc.nextInt();
            char operation = sc.next().charAt(0);
            int second = sc.nextInt();
            if (expectedResult == null)
                assertThrows(IllegalArgumentException.class, () -> result(first, operation, second));
            else
                assertEquals(expectedResult, result(first, operation, second));
        }
    }

    @ParameterizedTest
    @CsvSource({ "2 + 3,5", "2 - 3, -1", "2 * 3, 6", "6 / 3, 2" })
    public void simpleCalculator(String expression, int expectedResult) {
        scan(expression, expectedResult);
    }

    private int result(int first, char operation, int second) {
        switch (operation) {
        case '+':
            return first + second;
        case '-':
            return first - second;
        case '*':
            return first * second;
        case '/':
            return first / second;
        default:
            throw new IllegalArgumentException();
        }
    }

    @ParameterizedTest
    @CsvSource({ "12345,15", "123456,21", "222,6", "0,0", "5,5", "223,7" })
    public void sumOfDigits(int num, int expectedResult) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        assertEquals(sum, expectedResult);
    }

    @ParameterizedTest
    @CsvSource({ "0,1", "1,1", "3,6", "5,120" })
    public void factorialRecursively(int num, int expectedResult) {
        assertEquals(factorialRecurse(num), expectedResult);
    }

    private int factorialRecurse(int n) {
        if (n <= 0)
            return 1;
        return n * factorialRecurse(n - 1);
    }

    @ParameterizedTest
    @CsvSource({ "1984,true", "1983,false", "1982,false", "2000,true", "0,true", "-4,true", "-6,false" })
    public void leapYear(int year, boolean expectedResult) {
        boolean leap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

        assertEquals(leap, expectedResult);
    }

    @ParameterizedTest
    @CsvSource({ "97,true,false", "2,true,false", "3,true,false", "4,false,false", "5,true,false", "6,false,false",
            "98,false,false", "1,true,false", "0,false,true", "-1,false,true" })
    public void eratostenesSieve(int prime, boolean isPrime, boolean exception) {
        if (exception) {
            assertThrows(IllegalArgumentException.class, () -> {
                throw new IllegalArgumentException();
            });
            return;
        }
        boolean[] nonPrimes = new boolean[prime + 1];

        for (int i = 2; i <= prime; ++i)
            for (int j = 2 * i; j <= prime; j += i)
                nonPrimes[j] = true;

        assertEquals(nonPrimes[prime], !isPrime);
    }

}
