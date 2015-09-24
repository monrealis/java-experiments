package eu.vytenis.patterns.other.decoupledState;

import eu.vytenis.patterns.other.decoupledState.api.StartStopMachine;
import eu.vytenis.patterns.other.decoupledState.impl.SimpleStartStopState;
import eu.vytenis.patterns.other.decoupledState.impl.StartedState;
import eu.vytenis.patterns.other.decoupledState.impl.StoppedState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StartStopStateMachineTest {
    private StoppedState stopped = SimpleStartStopState.stopped();
    private StartedState started = SimpleStartStopState.started();
    private StartStopMachine startStopMachine = new StartStopMachine();

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
        startStopMachine.start();
        assertStarted();
    }

    private void stopAssertStopped() {
        startStopMachine.stop();
        assertStopped();
    }

    private void assertStarted() {
        assertEquals(started, startStopMachine.getState());
    }

    private void assertStopped() {
        assertEquals(stopped, startStopMachine.getState());
    }
}
