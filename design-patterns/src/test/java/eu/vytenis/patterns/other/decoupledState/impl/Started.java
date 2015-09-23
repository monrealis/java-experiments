package eu.vytenis.patterns.other.decoupledState.impl;

import eu.vytenis.patterns.other.decoupledState.api.State;
import eu.vytenis.patterns.other.decoupledState.api.StateMachine;

public class Started extends StartedStoppedState {
    public static Started started() {
        return new Started();
    }

    private Started() {
    }

    @Override
    public void start(StateMachine machine) {

    }

    @Override
    public void stop(StateMachine machine) {
        machine.setState(Stopped.stopped());
    }
}
