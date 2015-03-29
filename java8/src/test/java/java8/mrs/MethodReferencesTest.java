package java8.mrs;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

public class MethodReferencesTest {
    private static String getText() {
        return "text";
    }

    @Test
    public void staticMethod_works() {
        assertEquals("texttext", echoTwice(MethodReferencesTest::getText));
    }

    @Test
    public void instanceMethod_works() {
        assertEquals("texttext", echoFunctionTwice(String::toString));
    }

    @Test
    public void instanceOfExistingObjectMethod_works() {
        assertEquals("tt", echoTwice(this::getFirstLetter));
    }

    @Test
    public void instanceOfExistingObjectMethodWithArgs_works() {
        assertEquals("ee", echoTwiceNthLetter(this::getNthLetter, 1));
    }

    @Test
    public void constructorReference_works() {
        assertEquals("", echoTwice(String::new));
    }

    private String echoFunctionTwice(Function<String, String> f) {
        return f.apply(getText()) + f.apply(getText());
    }

    private String echoTwice(Supplier<String> supplier) {
        return supplier.get() + supplier.get();
    }

    private String echoTwiceNthLetter(Function<Integer, String> function, Integer n) {
        return function.apply(n) + function.apply(n);
    }

    private String getFirstLetter() {
        return getNthLetter(0);
    }

    private String getNthLetter(int n) {
        return getText().substring(n, n + 1);
    }
}
