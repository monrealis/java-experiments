package java8.predicates;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

public class PredicateCompositionTest {
    Predicate<Integer> truePredicate = i -> true;
    Predicate<Integer> falsePredicate = i -> false;

    @Test
    public void andAndNot_pass() {
        assertTrue(truePredicate.and(falsePredicate.negate()).test(null));
    }

    @Test
    public void or_passes() {
        assertTrue(truePredicate.or(falsePredicate).test(null));
    }
}
