package java8.annotations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Repeated
@Repeated
@Repeated
public class AnnotationsTest {
    @Test
    public void shouldReturnThreeRepeatableAnnotations() {
        assertEquals(3, getClass().getAnnotationsByType(Repeated.class).length);
    }
}
