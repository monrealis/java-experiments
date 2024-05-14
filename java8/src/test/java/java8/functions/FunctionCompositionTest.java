package java8.functions;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class FunctionCompositionTest {
	Function<Integer, Integer> addOne = i -> i + 1;
	Function<Integer, Integer> timesTwo = i -> i * 2;
	Function<Integer, String> addThree = i -> i + "3";

	@Test
	public void andThen_passes() {
		assertEquals(4, addOne.andThen(timesTwo).apply(1).intValue());
	}

	@Test
	public void compose_passes() {
		assertEquals(3, addOne.compose(timesTwo).apply(1).intValue());
	}

	@Test
	public void addThree_Passes() {
		assertEquals("33", addThree.apply(3));
	}
}
