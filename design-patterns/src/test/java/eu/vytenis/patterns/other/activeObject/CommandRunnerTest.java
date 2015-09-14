package eu.vytenis.patterns.other.activeObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static com.jayway.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CommandRunnerTest {
    private int callCount;
    private final CommandRunner runner;
    private Runnable addOne = new Add(1);
    private Runnable addTwo = new Add(2);

    public CommandRunnerTest(CommandRunner runner) {
        this.runner = runner;
    }

    @Test
    public void runsEmpty() {
        runner.exitIfQueueEmpty();
        runner.run();
        assertEquals(0, callCount);
    }

    @Test
    public void runOne() {
        runner.add(addOne);
        runner.exitIfQueueEmpty();
        runner.run();
        assertEquals(1, callCount);
    }

    @Test
    public void runTwo() {
        runner.add(addOne);
        runner.add(addTwo);
        runner.exitIfQueueEmpty();
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
        await().until(() -> runner.getCommandsCount() == 0);
    }

    private void assertManyCalls() {
        assertTrue(String.valueOf(callCount), callCount > 100);
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

    @Parameters
    public static List<Object[]> parameters() {
        List<Object[]> r = new ArrayList<>();
        r.add(new Object[]{new ListCommandRunner()});
        r.add(new Object[]{new BlockingQueueCommandRunner()});
        r.add(new Object[]{new FjpCommandRunner()});
        return r;
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
