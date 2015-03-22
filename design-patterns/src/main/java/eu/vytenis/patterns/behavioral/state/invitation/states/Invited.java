package eu.vytenis.patterns.behavioral.state.invitation.states;

import eu.vytenis.patterns.behavioral.state.api.AbstractState;
import eu.vytenis.patterns.behavioral.state.api.State;
import eu.vytenis.patterns.behavioral.state.api.States;

public class Invited extends AbstractState {
    public Invited(States states) {
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
        return states.accepted();
    }
}
