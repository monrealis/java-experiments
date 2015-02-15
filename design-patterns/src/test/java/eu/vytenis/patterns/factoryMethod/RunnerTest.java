package eu.vytenis.patterns.factoryMethod;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class RunnerTest {
    private TestingRunnable runnable = new TestingRunnable();
    private Runner runner = new TestingRunner();
    private ThreadLocal<Boolean> runResult = new ThreadLocal<>();
    private boolean hasRun;

    @Test
    public void whenRunnableRunInThisThread_threadLocalUpdatedInThisThread() {
        assertNull(runResult.get());
        runnable.run();
        assertTrue(runResult.get());
    }

    @Test
    public void whenRunnableRunInRunner_hasRunIsTrue() {
        runInSeparateThread();
        assertTrue(hasRun);
    }

    private void runInSeparateThread() {
        runner.runInSeparateThread();
    }

    @Test
    public void whenRunnableRunInRunner_threadLocalNotUpdatedInThisThread() {
        runInSeparateThread();
        assertNull(runResult.get());
    }

    private class TestingRunner extends Runner {
        @Override
        protected Runnable createRunnable() {
            return runnable;
        }
    }

    private class TestingRunnable implements Runnable {
        @Override
        public void run() {
            runResult.set(true);
            hasRun = true;
        }
    }
}
