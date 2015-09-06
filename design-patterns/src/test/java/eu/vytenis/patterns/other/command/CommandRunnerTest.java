package eu.vytenis.patterns.other.command;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandRunnerTest {
    private int callCount;
    private CommandRunner runner = new CommandRunner();
    private Runnable addOne = new AddOne();

    @Test
    public void runsEmpty() {
        runner.run();
        assertEquals(0, callCount);
    }

    @Test
    public void runOne() {
        runner.add(addOne);
        runner.run();
        assertEquals(1, callCount);
    }

    private class AddOne implements Runnable {
        @Override
        public void run() {
            callCount++;
        }
    }
}
