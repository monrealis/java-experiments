package eu.vytenis.patterns.other.decoupledState.api;

import eu.vytenis.patterns.other.decoupledState.states.SimpleStartStopState;

public abstract class StartStopMachine {
    private StartStopState state = SimpleStartStopState.stopped();

    public void start() {
        state.start(this);
    }

    public void stop() {
        state.stop(this);
    }

    public StartStopState getState() {
        return state;
    }

    public void setState(StartStopState state) {
        this.state = state;
    }

    public abstract void starting();

    public abstract void stopping();
}
