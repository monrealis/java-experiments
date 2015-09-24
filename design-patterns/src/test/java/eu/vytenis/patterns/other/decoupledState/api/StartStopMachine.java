package eu.vytenis.patterns.other.decoupledState.api;

import eu.vytenis.patterns.other.decoupledState.impl.StoppedState;

public class StartStopMachine {
    private StartStopState state = StoppedState.stopped();

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
