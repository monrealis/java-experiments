package java8.interfaces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InterfaceMethodsTest {
	I i = new I() {
	};

	@Test
	public void five() {
		assertEquals(5, i.five());
	}

	@Test
	public void twoTimesFive() {
		assertEquals(10, I.twoTimesFive());
	}

	interface I {
		public static int twoTimesFive() {
			return 5 * 2;
		}

		default int five() {
			return 5;
		}
	}
}
