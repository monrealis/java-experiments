package eu.vytenis.patterns.other.decoupledState.api;

import eu.vytenis.patterns.other.decoupledState.impl.Stopped;

public class StateMachine {
    private State state = Stopped.stopped();

    public void start() {
        state.start(this);
    }

    public void stop() {
        state.stop(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
