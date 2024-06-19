package eu.vytenis.lombok;

import org.junit.Test;

public class AccessorsTest {
    private Bean bean = new Bean();

    @Test
    public void checksAgainstNullArguments() throws Exception {
        try {

            bean.f(null);
            throw new Exception();
        } catch (NullPointerException e) {
            // OK
        }
    }

    @Test
    public void handlesSneakyExceptions() {
        try {
            bean.throwSneaky();
        } catch (Exception e) {
            // OK
        }
    }
}
