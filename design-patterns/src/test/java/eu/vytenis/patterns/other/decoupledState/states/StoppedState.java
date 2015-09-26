package eu.vytenis.patterns.other.decoupledState.states;

import eu.vytenis.patterns.other.decoupledState.api.StartStopMachine;

public class StoppedState extends SimpleStartStopState {
    StoppedState() {
    }

    @Override
    public void start(StartStopMachine machine) {
        machine.starting();
        machine.setState(SimpleStartStopState.started());
    }

    @Override
    public void stop(StartStopMachine machine) {

    }
}
