package eu.vytenis.patterns.template;

import java.util.ArrayList;
import java.util.List;

public abstract class RandomChecker {
    public static final int COUNT = 100;

    public double getAverage() {
        int sum = getSum();
        return 1.0 * sum / COUNT;
    }

    private int getSum() {
        return getRandomList().stream().reduce(Integer::sum).get();
    }

    private List<Integer> getRandomList() {
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < COUNT; ++i)
            r.add(getRandomFrom0To100());
        return r;
    }

    protected abstract int getRandomFrom0To100();
}
