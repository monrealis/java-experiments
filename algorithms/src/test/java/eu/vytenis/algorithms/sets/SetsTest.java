package eu.vytenis.algorithms.sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class SetsTest {
    private static Random random = new Random();
    private static int count = 10_000_000;

    @Test
    public void measure() {
        add(LinkedHashSet::new, "", sorted());
        add(TreeSet::new, "", sorted());
        add(HashSet::new, "", sorted());
        add(LinkedHashSet::new, "S", sorted());
        add(TreeSet::new, "S", sorted());
        add(HashSet::new, "S", sorted());
        add(LinkedHashSet::new, "I", sortedInverted());
        add(TreeSet::new, "I", sortedInverted());
        add(HashSet::new, "I", sortedInverted());
        add(LinkedHashSet::new, "R", random());
        add(TreeSet::new, "R", random());
        add(HashSet::new, "R", random());
    }

    private IntStream sorted() {
        return IntStream.range(0, count);
    }

    private IntStream sortedInverted() {
        return IntStream.range(0, count).map(i -> -i);
    }

    private IntStream random() {
        return IntStream.range(0, count).map(i -> random.nextInt());
    }

    private Set<Integer> add(Supplier<Set<Integer>> setSupplier, String id, IntStream stream) {
        Set<Integer> set = setSupplier.get();
        long duration = millis(() -> stream.forEach(set::add));
        if (id.length() > 0)
            System.out.println(String.format("%20s(%s): %s ms", set.getClass().getSimpleName(), id, duration));
        return set;
    }

    private long millis(Runnable r) {
        long from = System.currentTimeMillis();
        r.run();
        long duration = System.currentTimeMillis() - from;
        return duration;
    }
}
