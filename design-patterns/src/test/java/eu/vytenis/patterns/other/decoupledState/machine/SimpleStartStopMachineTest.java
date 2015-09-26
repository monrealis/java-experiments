package eu.vytenis.patterns.other.decoupledState.machine;

import eu.vytenis.patterns.other.decoupledState.api.StartStopMachine;
import eu.vytenis.patterns.other.decoupledState.states.SimpleStartStopState;
import eu.vytenis.patterns.other.decoupledState.states.StartedState;
import eu.vytenis.patterns.other.decoupledState.states.StoppedState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SimpleStartStopMachineTest {
    private StoppedState stopped = SimpleStartStopState.stopped();
    private StartedState started = SimpleStartStopState.started();
    private StartStopMachine startStopMachine = new SimpleStartStopMachine();
    private PrintStream originalOut;
    private ByteArrayOutputStream out;

    @Before
    public void before() {
        originalOut = System.out;
        resetOut();
    }

    private void resetOut() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @After
    public void after() {
        System.setOut(originalOut);
    }

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
    public void afterStarting_printsStarted() {
        startStopMachine.start();
        assertEquals("Starting\n", getOutAsString());
    }

    @Test
    public void afterStopping_printsStopped() {
        startAssertStarted();
        resetOut();
        startStopMachine.stop();
        assertEquals("Stopping\n", getOutAsString());
    }

    private String getOutAsString() {
        return new String(out.toByteArray());
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
