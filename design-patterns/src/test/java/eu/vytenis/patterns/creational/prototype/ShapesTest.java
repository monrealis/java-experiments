package eu.vytenis.patterns.creational.prototype;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ShapesTest {
    private Shape c1 = new Circle(1, 2, 3);
    private Shape c2 = new Circle(4, 5, 6);
    private Shape s1 = new Square(1, 2, 3);
    private Shape s2 = new Square(4, 5, 6);
    private Set<Shape> shapes = new HashSet<>();
    private Set<Shape> clones = new HashSet<>();

    @Before
    public void before() {
        shapes.addAll(asList(c1, c2, s1, s2));
        clones.addAll(asList(c1.clone(), c2.clone(), s1.clone(), s2.clone()));
    }

    @Test
    public void afterCloning_shapesAreEqual() {
        assertEquals(4, shapes.size());
        assertEquals(shapes, clones);
    }
}
