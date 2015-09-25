package eu.vytenis.patterns.other.decoupledState.machine;

import eu.vytenis.patterns.other.decoupledState.api.StartStopMachine;

public class SimpleStartStopMachine extends StartStopMachine {
    @Override
    public void starting() {
        System.out.println("Starting");
    }

    @Override
    public void stopping() {
        System.out.println("Stopping");
    }
}
