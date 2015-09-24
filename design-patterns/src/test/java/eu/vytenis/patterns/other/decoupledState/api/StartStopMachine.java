package eu.vytenis.patterns.other.decoupledState.api;

import eu.vytenis.patterns.other.decoupledState.impl.SimpleStartStopState;

public class StartStopMachine {
    private StartStopState state = SimpleStartStopState.stopped();

    public void start() {
        state.start(this);
    }

    public void stop() {
        state.stop(this);
    }

    public void setState(StartStopState state) {
        this.state = state;
    }

    public StartStopState getState() {
        return state;
    }
}
