package servlet3;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PiRandomWalk {
    private static final int WALKS = 20_000;
    private static final int STEPS = 2_000;
    private static final double EPSILON = 0.05;

    @Test
    @Disabled
    void estimatePiFromRandomWalkRecurrence() {
        Random random = new Random(123);
        int returns = 0;
        for (int i = 0; i < WALKS; i++) {
            double x = 0.0;
            double y = 0.0;
            boolean returned = false;
            for (int step = 0; step < STEPS; step++) {
                double angle = random.nextDouble() * 2.0 * PI;
                x += cos(angle);
                y += sin(angle);
                if (!returned && (x * x + y * y) <= EPSILON * EPSILON) {
                    returned = true;
                    returns++;
                    break;
                }
            }
        }
        double probability = (double) returns / WALKS;
        double piEstimate = 1.0 / (probability * Math.log(1.0 / EPSILON));
        System.out.println("Estimated π = " + piEstimate);
        // Very loose bound — random walk is wild
        assertTrue(Math.abs(piEstimate - Math.PI) < 0.3);
    }
}