package java7.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumericLiteralsTest {
	@Test
	public void shouldUnderstandUnderscoresInNumericLiterals() {
		assertEquals(1000, 10_0_0);
	}
}
