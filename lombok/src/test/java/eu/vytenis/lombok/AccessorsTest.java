package eu.vytenis.lombok;
import org.junit.Test;

public class AccessorsTest {
    private Bean bean = Bean.builder().build();

    @Test
    public void checksAgainstNullArguments() throws Exception {
        try {

            bean.f(null);
            throw new Exception();
        } catch (NullPointerException e) {
            // OK
        }
    }
}
