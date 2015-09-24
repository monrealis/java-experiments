package eu.vytenis.patterns.other.decoupledState.impl;

import eu.vytenis.patterns.other.decoupledState.api.StartStopMachine;

public class StartedState extends SimpleStartStopState {
    public static StartedState started() {
        return new StartedState();
    }

    private StartedState() {
    }

    @Override
    public void start(StartStopMachine machine) {

    }

    @Override
    public void stop(StartStopMachine machine) {
        machine.setState(StoppedState.stopped());
    }
}
