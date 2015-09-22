package eu.vytenis.patterns.other.decoupledState;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateMachineTest {
    private Stopped stopped = Stopped.stopped();
    private Started started = Started.started();
    private StateMachine stateMachine = new StateMachine();

    @Test
    public void initially_stopped() {
        assertStopped();
    }

    @Test
    public void afterStopping_stopped() {
        stopAssertStopped();
    }

    @Test
    public void afterStarting_started() {
        startAssertStarted();
    }

    @Test
    public void afterStartingAndStopping_stopped() {
        startAssertStarted();
        stopAssertStopped();
    }

    private void startAssertStarted() {
        stateMachine.start();
        assertStarted();
    }

    private void stopAssertStopped() {
        stateMachine.stop();
        assertStopped();
    }

    private void assertStarted() {
        assertEquals(started, stateMachine.getState());
    }

    private void assertStopped() {
        assertEquals(stopped, stateMachine.getState());
    }
}
