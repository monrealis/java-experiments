package eu.vytenis.fitnesse.action;

import fit.ActionFixture;

import java.util.ArrayList;
import java.util.List;

public class SumActionFixture extends ActionFixture {
    private List<Integer> numbers = new ArrayList<>();
    private int sum = 0;

    public void add(int number) {
        numbers.add(number);
    }

    public void calculate() {
        sum = numbers.stream().reduce(Integer::sum).orElse(0);
    }

    public int sum() {
        return sum;
    }
}
