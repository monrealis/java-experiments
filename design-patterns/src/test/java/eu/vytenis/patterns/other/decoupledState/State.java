package eu.vytenis.patterns.other.decoupledState;

public abstract class State {
    public abstract void start(StateMachine machine);

    public abstract void stop(StateMachine machine);

    @Override
    public boolean equals(Object obj) {
        return getClass().equals(obj.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
