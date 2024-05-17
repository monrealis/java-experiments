package java8.lambdas;

import org.junit.Test;

import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

public class LambdasTest {
	@Test
	public void supplier_passes() {
		assertEquals("y", echo(() -> "y"));
	}

	private String echo(Supplier<String> s) {
		return s.get();
	}

	@Test
	public void ambiguousCalls_resolvedByCasting() {
		consume((Runnable) System.out::println);
		consume((OtherTypeOfRunnable) System.out::println);
	}

	private void consume(OtherTypeOfRunnable c) {
		c.run();
	}

	private void consume(Runnable r) {
		r.run();
	}

	@FunctionalInterface
	public static interface OtherTypeOfRunnable {
		void run();
	}
}
