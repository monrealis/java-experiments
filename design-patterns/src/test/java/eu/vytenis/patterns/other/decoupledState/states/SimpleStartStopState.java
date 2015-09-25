package eu.vytenis.patterns.other.decoupledState.states;

import eu.vytenis.patterns.other.decoupledState.api.StartStopState;

public abstract class SimpleStartStopState implements StartStopState {
    private static final StartedState started = new StartedState();
    private static StoppedState stopped = new StoppedState();

    public static StoppedState stopped() {
        return stopped;
    }

    public static StartedState started() {
        return started;
    }
}
