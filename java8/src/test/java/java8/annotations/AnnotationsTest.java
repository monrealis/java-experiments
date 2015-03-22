package java8.annotations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Repeated
@Repeated
public class AnnotationsTest {
    @Test
    public void shouldReturnTwoRepeatableAnnotations() {
        assertEquals(2, getClass().getAnnotationsByType(Repeated.class).length);
    }
}
