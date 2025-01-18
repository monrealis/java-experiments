package servlet3;

import org.junit.Test;

public class VariousTests {
    @Test
    public void palyndrome() {
        String palyndrome = "madam";

        String s = new StringBuilder(palyndrome).reverse().toString();

        System.out.println(s.equals(palyndrome));
    }
}
