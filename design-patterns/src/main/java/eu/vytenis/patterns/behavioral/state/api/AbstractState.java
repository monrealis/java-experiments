package eu.vytenis.patterns.behavioral.state.api;

public abstract class AbstractState implements State<State> {
    protected final States states;

    public AbstractState(States states) {
        this.states = states;
    }
}
