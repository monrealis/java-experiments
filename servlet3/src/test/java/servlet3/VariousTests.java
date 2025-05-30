package servlet3;

import static java.lang.Character.isLetter;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;
import static java.lang.String.join;
import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class VariousTests {
    @Test
    public void palyndrome() {
        String palyndrome = "madam";

        String s = reversed(palyndrome);

        assertEquals(s, palyndrome);
    }

    @Test
    public void nonPalyndrome() {
        String nonPalyndrome = "Madam";

        String s = reversed(nonPalyndrome);

        assertNotEquals(s, nonPalyndrome);
    }

    private String reversed(String nonPalyndrome) {
        return new StringBuilder(nonPalyndrome).reverse().toString();
    }

    @Test
    public void reversesString() {
        String s = "ABC";

        String reversed = reversed(s);

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
        for (int k = 2; k < n; ++k) {
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

    @Test
    public void primeNumbersInRange() {
        List<String> result = new ArrayList<>();
        for (int i = 10; i <= 20; ++i)
            if (isPrimeNumber(i))
                result.add(i + "");
        String joined = String.join(",", result.toArray(new String[] {}));

        assertEquals("11,13,17,19", joined);
    }

    @ParameterizedTest
    @CsvSource({ "-1", "0", "1" })
    public void primeNumbers_Throws(int n) {
        assertThrows(IllegalArgumentException.class, () -> isPrimeNumber(n));
    }

    private strictfp boolean isPrimeNumber(int n) {
        if (n < 2)
            throw new IllegalArgumentException();
        for (int i = 2; i <= Math.sqrt(n); ++i)
            if (n % i == 0)
                return false;
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
        for (int i = 1; i < n; ++i)
            f *= i + 1;
        return f;
    }

    @ParameterizedTest
    @CsvSource({ "1-2-2-1", "1-1-2-1" })
    public void findsDuplicates(String array) {
        List<Integer> l = stream(array.split("-")).map(Integer::parseInt).collect(toList());

        assertEquals(distinct(l), unique(l));
    }

    private List<Integer> distinct(List<Integer> list) {
        List<Integer> distinct = new ArrayList<>();
        for (Integer i : list)
            if (!distinct.contains(i))
                distinct.add(i);
        return new ArrayList<Integer>(distinct);
    }

    private List<Integer> unique(List<Integer> list) {
        return new ArrayList<>(new LinkedHashSet<Integer>(list));
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

        assertEquals(parseInt(reversed("" + sign * initial)), sign * reversed);
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
        for (int i = 1; i < n; ++i)
            if (n % i == 0)
                p += i;

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
    @CsvSource({ "97,true", "2,true", "3,true", "4,false", "5,true", "6,false", "98,false", "1,true" })
    public void eratostenesSieve(int prime, boolean isPrime) {
        boolean[] nonPrimes = new boolean[prime + 1];

        for (int i = 2; i <= prime; ++i)
            for (int j = 2 * i; j <= prime; j += i)
                nonPrimes[j] = true;

        assertEquals(nonPrimes[prime], !isPrime);
    }

    @ParameterizedTest
    @CsvSource({ "1-2-5,4-5,1-2-5-4-5" })
    public void mergeArrays(String array1, String array2, String expectedResult) {
        assertEquals(join("-", concat(stream(array1.split("-")), stream(array2.split("-"))).toArray(String[]::new)),
                expectedResult);
    }

    @ParameterizedTest
    @CsvSource({ "automation,6,4", "AUTOMATION,6,4", "/*-+ ,0,0" })
    public void countVowels(String string, int expectedVowelCount, int expectedConsonantCount) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (char a : string.toCharArray())
            if ("aoiueAOIUE".indexOf(a) >= 0)
                vowelCount++;
            else if (isLetter(a))
                consonantCount++;

        assertEquals(expectedVowelCount, vowelCount);
        assertEquals(expectedConsonantCount, consonantCount);
    }

    @ParameterizedTest
    @CsvSource({ "4-3-2-1,1-2-3-4" })
    public void sortAnArray(String array, String expectedResult) {
        assertEquals(join("-",
                stream(array.split("-")).map(Integer::parseInt).sorted().map(Object::toString).toArray(String[]::new)),
                expectedResult);
    }

    @ParameterizedTest
    @CsvSource({ "4-3-2-1,4" })
    public void findLargest(String array, int expectedLargest) {
        assertEquals(stream(array.split("-")).map(Integer::parseInt).sorted(reverseOrder()).findFirst().get(), 4);
    }

    @ParameterizedTest
    @CsvSource({ "4-4-2-2,4-2" })
    public void removeDuplicates(String array, String expectedResult) {
        assertEquals(join("-", stream(array.split("-")).distinct().toArray(String[]::new)), expectedResult);
    }

    @ParameterizedTest
    @CsvSource({ "0,true", "1,true", "2,false", "370,true", "371,true", "372,false", "373,false" })
    public void armstrongNumber(int n, boolean armstrong) {
        int sum = 0;
        int initial = n;
        while (n != 0) {
            int mod10 = n % 10;
            sum += mod10 * mod10 * mod10;
            n /= 10;
        }

        if (armstrong)
            assertEquals(initial, sum);
        else
            assertNotEquals(initial, sum);
    }

    @ParameterizedTest
    @CsvSource({ "0,1", "9,1", "100,3" })
    public void countDigits(int n, int expectedResult) {
        int count = 0;
        do {
            count++;
            n = n / 10;
        } while (n != 0);

        assertEquals(count, expectedResult);
    }

    @ParameterizedTest
    @CsvSource({ "1-2-9-3-5,5", "1-1-2,1", "1-2-2,2" })
    public void findSecondLargest(String inputArray, int result) {
        int[] array = stream(inputArray.split("-")).mapToInt(Integer::parseInt).toArray();
        if (array.length < 2)
            throw new IllegalArgumentException();
        int first = MIN_VALUE;
        int second = MIN_VALUE;

        for (int num : array)
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second)
                second = num;

        assertEquals(result, second);
    }

    @ParameterizedTest
    @CsvSource({ "1-2-9-3-5,5", "1-2-9-9-5,9" })
    public void findSecondLargestWithStreams(String inputArray, int expectedResult) {
        int[] array = stream(inputArray.split("-")).mapToInt(Integer::parseInt).toArray();

        int max = stream(array).boxed().reduce(Integer::max).get();
        int secondMax = stream(array).boxed().filter(new SkipOneGreatest(max)).reduce(Integer::max).get();

        assertEquals(expectedResult, secondMax);
    }

    private static class SkipOneGreatest implements Predicate<Integer> {
        private final int greatest;
        private boolean found;

        public SkipOneGreatest(int number) {
            this.greatest = number;
        }

        @Override
        public boolean test(Integer number) {
            if (found)
                return true;
            return handleNotFound(number);
        }

        private boolean handleNotFound(int number) {
            boolean result = number == greatest;
            if (result)
                found = true;
            return false;
        }
    }

    @ParameterizedTest
    @CsvSource({ "9-5-5,5", "7-7-7,7", "9-5-3,5", "1-1-9-9,9", "1-1-1-9,1" })
    public void findSecondLargestWithStreamsOtherWay(String numbers, int secondMax) {
        assertEquals(stream(numbers.split("-")).map(Integer::parseInt).sorted(reverseOrder()).skip(1).findFirst().get(),
                secondMax);
    }

    @ParameterizedTest
    @CsvSource({ "9,5,5,9", "-1,-2,-2,-1", "-1,1,1,-1" })
    public void swapNumbers1(int first, int second, int third, int fourth) {
        first += second;
        second = first - second;
        first -= second;

        assertEquals(first, third);
        assertEquals(second, fourth);
    }

    @ParameterizedTest
    @CsvSource({ "9,5,5,9", "-1,-2,-2,-1", "-1,1,1,-1" })
    public void swapNumbers2(int first, int second, int third, int fourth) {
        second += first;
        first = second - first;
        second -= first;

        assertEquals(first, third);
        assertEquals(second, fourth);
    }

    @ParameterizedTest
    @CsvSource({ "9,5,5,9", "-1,-2,-2,-1", "-1,1,1,-1" })
    public void swapNumbers3(int first, int second, int third, int fourth) {
        first -= second;
        second += first;
        first = second - first;

        assertEquals(first, third);
        assertEquals(second, fourth);
    }

    @ParameterizedTest
    @CsvSource({ "9,5,5,9", "-1,-2,-2,-1", "-1,1,1,-1" })
    public void swapNumbers4(int first, int second, int third, int fourth) {
        second -= first;
        first += second;
        second = first - second;

        assertEquals(first, third);
        assertEquals(second, fourth);
    }

    @ParameterizedTest
    @CsvSource({ "9,5,5,9", "-1,-2,-2,-1", "-1,1,1,-1" })
    public void swapNumbersBitwise1(int first, int second, int third, int fourth) {
        first ^= second;
        second ^= first;
        first ^= second;

        assertEquals(first, third);
        assertEquals(second, fourth);
    }

    @ParameterizedTest
    @CsvSource({ "9,5,5,9", "-1,-2,-2,-1", "-1,1,1,-1" })
    public void swapNumbersBitwise2(int first, int second, int third, int fourth) {
        second ^= first;
        first ^= second;
        second ^= first;

        assertEquals(first, third);
        assertEquals(second, fourth);
    }

    @ParameterizedTest
    @CsvSource("1-2-3-5-6-7,4")
    public void findMissingNumberInAnArray(String inputArray, int expectedResult) {
        int[] array = stream(inputArray.split("-")).mapToInt(Integer::parseInt).toArray();

        int n = array.length + 1;
        int sum = n * (n + 1) / 2;
        for (int i : array)
            sum -= i;

        assertEquals(expectedResult, sum);
    }

    @ParameterizedTest
    @CsvSource({ "swiss,w", "ss,", "swswa,a", "s,s", "," })
    public void findFirstNonRepeatedCharacter(String text, Character expectedResult) {
        Map<Character, Integer> characterCounts = getCountsByCharacter(text);
        List<Character> exactlyOne = getExactlyOne(text, characterCounts);

        if (exactlyOne.isEmpty())
            assertEquals(null, expectedResult);
        else
            assertEquals(exactlyOne.iterator().next(), expectedResult);
    }

    private List<Character> getExactlyOne(String text, Map<Character, Integer> counts) {
        if (text == null)
            return emptyList();
        List<Character> r = new ArrayList<>();
        for (char c : text.toCharArray())
            if (counts.get(c) == 1)
                r.add(c);
        return r;
    }

    private Map<Character, Integer> getCountsByCharacter(String text) {
        if (text == null)
            return emptyMap();
        Map<Character, Integer> counts = new TreeMap<>();
        for (char c : text.toCharArray())
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        return counts;
    }

    @ParameterizedTest
    @CsvSource({ "sswww,xxxw,1", "abcd,efgh,0", "aaaa,aaa,1" })
    public void findNumberOfRepeatedElements(String first, String second, int expectedResult) {
        Set<Character> f = toSet(first);
        Set<Character> s = toSet(second);
        Set<Character> i = intersection(f, s);

        assertEquals(expectedResult, i.size());
    }

    private Set<Character> intersection(Set<Character> first, Set<Character> second) {
        Set<Character> temp = new HashSet<>(first);
        temp.retainAll(second);
        return temp;
    }

    private Set<Character> toSet(String string) {
        Set<Character> r = new HashSet<>();
        for (int i = 0; i < string.length(); ++i)
            r.add(string.charAt(i));
        return r;
    }

    @ParameterizedTest
    @CsvSource({ "0,0", "1,1", "2,3", "3,6", "4,10", "100,5050" })
    public void sunOfNaturalNumbers(int n, int expectedSum) {
        int sum = 0;
        for (int i = 1; i <= n; ++i)
            sum += i;

        assertEquals(sum, expectedSum);
    }

    @ParameterizedTest
    @CsvSource({ "0,0", "1,1", "2,3", "3,6", "4,10", "100,5050" })
    public void sunOfNaturalNumbersProgression(int n, int expectedSum) {
        int sum = n * (n + 1) / 2;

        assertEquals(sum, expectedSum);
    }

    @ParameterizedTest
    @CsvSource("1-5-3-1-2,1-1-2-3-5")
    public void bubbleSort(String inputArray, String expectedResult) {
        int[] arr = stream(inputArray.split("-")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] > arr[j]) {
                    arr[i] ^= arr[j];
                    arr[j] ^= arr[i];
                    arr[i] ^= arr[j];
                }
        assertEquals(join("-", stream(arr).boxed().map(Object::toString).toArray(String[]::new)), expectedResult);
    }

    @ParameterizedTest
    @CsvSource("1-5-3-1-2,1-1-2-3-5")
    public void minimaxSort(String inputArray, String expectedResult) {
        int[] arr = stream(inputArray.split("-")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++)
                if (min > arr[j]) {
                    arr[j] ^= arr[i];
                    arr[i] ^= arr[j];
                    arr[j] ^= arr[i];
                    min = arr[i];
                }
        }

        assertEquals(join("-", stream(arr).boxed().map(Object::toString).toArray(String[]::new)), expectedResult);
    }

    @ParameterizedTest
    @CsvSource({ "aa,a", "bbaa,b", "baaa,a" })
    public void maxOccursInString(String string, char expectedResult) {
        Map<Character, Integer> counts = new LinkedHashMap<>();
        for (int i = 0; i < string.toCharArray().length; i++)
            counts.put(string.charAt(i), counts.getOrDefault(string.charAt(i), 0) + 1);

        int maxOccurs = -1;
        Character result = null;
        for (int i = 0; i < string.toCharArray().length; i++) {
            int count = counts.get(string.charAt(i));
            if (count > maxOccurs) {
                maxOccurs = count;
                result = string.charAt(i);
            }
        }

        assertEquals(result, expectedResult);
    }

    @ParameterizedTest
    @CsvSource({ " a  aa  ,aaa" })
    public void removeAllWhitespace(String string, String expectedResult) {
        String withoutWhitespace = string.replaceAll("\\s", "");

        assertEquals(withoutWhitespace, expectedResult);
    }

    @ParameterizedTest
    @CsvSource({ "test,true", "Test,false" })
    public void stringContains(String string, boolean contains) {
        boolean stringContains = string.contains("test");

        assertEquals(stringContains, contains);
    }

    @Test
    public void randomNumbersAreNotSoRandom() {
        Random random = new Random(0);
        int sum = 0;
        for (int i = 0; i < 10; i++)
            sum += random.nextInt(10);

        assertNotEquals(0, sum);
    }

    @ParameterizedTest
    @CsvSource("10,1010")
    public void convertsNumberToBinary(int decimal, String binary) {
        String b = toBinaryString(decimal);

        assertEquals(binary, b);
    }

    @ParameterizedTest
    @CsvSource({ "automation,z,0", "automation,a,2" })
    public void numberOfCharacterOccurences(String string, char character, int expectedCount) {
        int n = 0;
        for (char c : string.toCharArray())
            if (c == character)
                ++n;

        assertEquals(expectedCount, n);
    }

    @ParameterizedTest
    @CsvSource({ "user,pwd,userpwd" })
    public void login(String username, String password, String expectedJoined) {
        String string = username + " " + password;
        try (Scanner scanner = new Scanner(string)) {
            String joined = scanner.next() + scanner.next();

            assertEquals(expectedJoined, joined);
        }
    }

    @ParameterizedTest
    @CsvSource({ "automation,automation,true", "automation,Automation,false", "aAA,AA,true", "AA,AAa,false" })
    public void stringContains(String first, String second, boolean expectedValue) {
        boolean contains = first.contains(second);

        assertEquals(contains, expectedValue);
    }

    @ParameterizedTest
    @CsvSource({ "1-3-2-2,1-2-2-3" })
    public void sortArrays(String input, String expectedResult) {
        assertEquals(
                join("-", stream(input.split("-")).map(Integer::parseInt).sorted().map(i -> i + "").collect(toList())),
                expectedResult);
    }

    @ParameterizedTest
    @CsvSource({ "72,180", "60,165", "50,150", "30,140", "90,180" })
    public void bodyMassIndex(int weight, int height) {
        float bmi = 1.0f * weight / height / height * 1000;
        // System.out.println(bmi);

        assertTrue(18.5 > bmi);
        assertTrue(24.9 > bmi);
    }
}
