package eu.vytenis.patterns.creational.prototype;

import java.util.List;

import static java.util.Arrays.asList;

public class Circle extends Shape {
    private final int centerX;
    private final int centerY;
    private final int radius;

    public Circle(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    protected List<Integer> toTuple() {
        return asList(centerX, centerY, radius);
    }
}
