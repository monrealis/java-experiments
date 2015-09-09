package eu.vytenis.patterns.other.activeObject;

import org.junit.Test;

import javax.swing.*;

import static com.jayway.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandRunnerTest {
    private int callCount;
    private CommandRunner runner = new CommandRunner();
    private Runnable addOne = new Add(1);
    private Runnable addTwo = new Add(2);

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

    @Test
    public void runTwo() {
        runner.add(addOne);
        runner.add(addTwo);
        runner.run();
        assertEquals(3, callCount);
    }

    @Test
    public void runTwoForEver() throws InterruptedException {
        invokeTwoPseudoThreads();
        waitUntilPseudoThreadsFinish();
        assertManyCalls();
    }


    private void invokeTwoPseudoThreads() {
        runner.add(new ReaddAfterRun(runner, addOne));
        runner.add(new ReaddAfterRun(runner, addTwo));
        SwingUtilities.invokeLater(runner);
    }

    private void waitUntilPseudoThreadsFinish() throws InterruptedException {
        Thread.sleep(10);
        runner.storeNewCommandsInNewQueue();
        await().until(() -> runner.getCommands().isEmpty());
    }

    private void assertManyCalls() {
        assertTrue(String.valueOf(callCount), callCount > 1000);
    }

    private static class ReaddAfterRun implements Runnable {
        private final CommandRunner runner;
        private final Runnable target;

        private ReaddAfterRun(CommandRunner runner, Runnable target) {
            this.runner = runner;
            this.target = target;
        }

        @Override
        public void run() {
            target.run();
            runner.add(this);
        }
    }

    private class Add implements Runnable {
        private final int amount;

        private Add(int amount) {
            this.amount = amount;
        }

        @Override
        public void run() {
            callCount += amount;
        }
    }
}
