package eu.vytenis.patterns.other.decoupledState.impl;

import eu.vytenis.patterns.other.decoupledState.api.StateMachine;

public class Stopped extends StartedStoppedState {
    public static Stopped stopped() {
        return new Stopped();
    }

    private Stopped() {
    }

    @Override
    public void start(StateMachine machine) {
        machine.setState(Started.started());
    }

    @Override
    public void stop(StateMachine machine) {

    }
}
