package eu.vytenis.patterns.state.invitation.states;

import eu.vytenis.patterns.state.api.AbstractState;
import eu.vytenis.patterns.state.api.State;
import eu.vytenis.patterns.state.api.States;

public class Accepted extends AbstractState {
    public Accepted(States states) {
        super(states);
    }

    @Override
    public State invite() {
        return this;
    }

    @Override
    public State decline() {
        return states.declined();
    }

    @Override
    public State accept() {
        return this;
    }
}
