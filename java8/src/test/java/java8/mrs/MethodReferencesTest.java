package java8.mrs;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

public class MethodReferencesTest {

    @Test
    public void staticMethod_works() {
        assertEquals("texttext", echoTwice(MethodReferencesTest::text));
    }

    @Test
    public void instanceMethod_works() {
        assertEquals("texttext", echoFunctionTwice(String::toString));
    }

    @Test
    public void instanceOfExistingObjectMethod_works() {
        assertEquals("tt", echoTwice(this::firstLetter));
    }

    @Test
    public void instanceOfExistingObjectMethodWithArgs_works() {
        assertEquals("ee", echoTwiceNthLetter(this::nthLetter, 1));
    }

    @Test
    public void constructorReference_works() {
        assertEquals("", echoTwice(String::new));
    }

    private String echoFunctionTwice(Function<String, String> f) {
        return f.apply(text()) + f.apply(text());
    }

    private String echoTwice(Supplier<String> supplier) {
        return supplier.get() + supplier.get();
    }

    private String echoTwiceNthLetter(Function<Integer, String> function, Integer n) {
        return function.apply(n) + function.apply(n);
    }

    private String firstLetter() {
        return nthLetter(0);
    }

    private String nthLetter(int n) {
        return text().substring(n, n + 1);
    }

    private static String text() {
        return "text";
    }
}
