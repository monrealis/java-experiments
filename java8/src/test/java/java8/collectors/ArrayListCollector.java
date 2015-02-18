package java8.collectors;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.function.Function.identity;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class ArrayListCollector<T> implements Collector<T, ArrayList<T>, ArrayList<T>> {
    @Override
    public Supplier<ArrayList<T>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<ArrayList<T>, T> accumulator() {
        return ArrayList::add;
    }

    @Override
    public BinaryOperator<ArrayList<T>> combiner() {
        return (l1, l2) -> {
            l1.addAll(l2);
            return l1;
        };
    }

    @Override
    public Function<ArrayList<T>, ArrayList<T>> finisher() {
        return identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(IDENTITY_FINISH);
    }
}
