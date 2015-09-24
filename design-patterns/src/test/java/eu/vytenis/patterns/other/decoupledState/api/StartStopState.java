package eu.vytenis.patterns.other.decoupledState.api;

public abstract class StartStopState {
    public abstract void start(StartStopMachine machine);

    public abstract void stop(StartStopMachine machine);

    @Override
    public boolean equals(Object obj) {
        return getClass().equals(obj.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
