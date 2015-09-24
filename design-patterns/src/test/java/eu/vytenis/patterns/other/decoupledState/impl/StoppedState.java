package eu.vytenis.patterns.other.decoupledState.impl;

import eu.vytenis.patterns.other.decoupledState.api.StartStopMachine;

public class StoppedState extends SimpleStartStopState {
    public static StoppedState stopped() {
        return new StoppedState();
    }

    private StoppedState() {
    }

    @Override
    public void start(StartStopMachine machine) {
        machine.setState(StartedState.started());
    }

    @Override
    public void stop(StartStopMachine machine) {

    }
}
