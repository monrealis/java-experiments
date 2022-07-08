package eu.vytenis.adder;

import java.io.InputStream;
import java.util.Scanner;

public class Adder {
	private final InputStream in;

	public Adder(InputStream in) {
		this.in = in;
	}

	public void add() {
		try (var scanner = new Scanner(in)) {
			var d1 = scanner.nextDouble();
			var d2 = scanner.nextDouble();
			System.out.println(d1 + d2);
		} finally {
		}
	}
}
