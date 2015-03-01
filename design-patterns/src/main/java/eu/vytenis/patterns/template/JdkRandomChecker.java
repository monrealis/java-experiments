package eu.vytenis.patterns.template;

import java.util.Random;

public class JdkRandomChecker extends RandomChecker {
    private Random random = new Random();

    @Override
    public int getRandomFrom0To100() {
        return random.nextInt(100 + 1);
    }
}
