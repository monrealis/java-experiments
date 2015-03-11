package eu.vytenis.patterns.state.invitation.states;

import eu.vytenis.patterns.state.api.AbstractState;
import eu.vytenis.patterns.state.api.State;
import eu.vytenis.patterns.state.api.States;

public class Declined extends AbstractState {
    public Declined(States states) {
        super(states);
    }

    @Override
    public State invite() {
        return this;
    }

    @Override
    public State decline() {
        return this;
    }

    @Override
    public State accept() {
        return states.accepted();
    }
}
