package eu.vytenis.lombok;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AccessorsTest {
    private Bean bean = new Bean();

    @Test
    public void getPropertyShouldReturnSameValueAsGivenInSetProperty() {
        String value = "anyValue";
        assertNotEquals(value, bean.getProperty());
        bean.setProperty(value);
        assertEquals(value, bean.getProperty());
    }
}
