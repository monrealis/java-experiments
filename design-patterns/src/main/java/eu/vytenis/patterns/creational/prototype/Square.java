package eu.vytenis.patterns.creational.prototype;

import java.util.List;

import static java.util.Arrays.asList;

public class Square extends Shape {
    private final int left;
    private final int top;
    private final int edge;

    public Square(int left, int top, int edge) {
        this.left = left;
        this.top = top;
        this.edge = edge;
    }

    public int getEdge() {
        return edge;
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    @Override
    protected List<Integer> toTuple() {
        return asList(left, top, edge);
    }
}
