package eu.vytenis.patterns.other.decoupledState.api;

import eu.vytenis.patterns.other.decoupledState.api.StateMachine;

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
