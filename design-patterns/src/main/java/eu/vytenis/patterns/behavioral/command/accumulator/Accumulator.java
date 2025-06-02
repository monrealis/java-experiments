package eu.vytenis.patterns.behavioral.command.accumulator;

public class Accumulator {
    private int sum;

    public Accumulator(int sum) {
        this.sum = sum;
    }

    public int get() {
        return sum;
    }

    public void set(int sum) {
        this.sum = sum;
    }
}
