package eu.vytenis.lombok;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.StringContains;

public class AccessorsTest {
    private Bean bean = Bean.builder().build();

    @Test
    public void getPropertyShouldReturnSameValueAsGivenInSetProperty() {
        String value = "anyValue";
        assertNotEquals(value, bean.getProperty());
        bean.setProperty(value);
        assertEquals(value, bean.getProperty());
    }

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
    public void toString_printsAllField() {
        bean.setProperty("xxx");

        assertThat(bean.toString(), StringContains.containsString("xxx"));
    }
}
