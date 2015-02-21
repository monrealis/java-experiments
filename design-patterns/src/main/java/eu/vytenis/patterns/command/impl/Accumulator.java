package eu.vytenis.patterns.command.impl;

public class Accumulator {
    int sum;

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
