package eu.vytenis.patterns.other.decoupledState.api;

public interface StartStopState {
    void start(StartStopMachine machine);

    void stop(StartStopMachine machine);
}
