package eu.vytenis.patterns.creational.prototype;

import java.util.List;

public abstract class Shape implements Cloneable {
    @Override
    public boolean equals(Object obj) {
        if (!getClass().equals(obj.getClass()))
            return false;
        return toTuple().equals(((Shape) obj).toTuple());
    }

    @Override
    public int hashCode() {
        return toTuple().hashCode();
    }

    protected abstract List<Integer> toTuple();

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
