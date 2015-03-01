package eu.vytenis.patterns.template;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JdkRandomCheckerTest {
    private RandomChecker c = new JdkRandomChecker();

    @Test
    public void averageIsAround50() {
        double average = c.getAverage();
        assertTrue(String.valueOf(average), average > 30 && average < 70);
    }
}
