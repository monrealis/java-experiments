package eu.vytenis.patterns.other.decoupledState.states;

import eu.vytenis.patterns.other.decoupledState.api.StartStopMachine;

public class StartedState extends SimpleStartStopState {
    StartedState() {
    }

    @Override
    public void start(StartStopMachine machine) {

    }

    @Override
    public void stop(StartStopMachine machine) {
        machine.setState(SimpleStartStopState.stopped());
    }
}
