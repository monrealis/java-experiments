package servlet3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PI {
    private static double pi = Math.PI;

    @Test
    public void wallis() {
        double sum = 0;
        for (int i = 1; i < 3; i++) {
            double nom = 2 * i * 2 * i;
            double den = (2 * i - 1) * (2 * i + 1);
            double added = 1.0 * nom / den;
            sum += added;
        }
        assertEquals(pi, 2 * sum, 0.001);
    }

    public void stirling(double tolerance) {

    }

    public void ramanujan(double tolerance) {

    }
}
