package eu.vytenis.patterns.state.invitation.states;

import eu.vytenis.patterns.state.api.AbstractState;
import eu.vytenis.patterns.state.api.State;
import eu.vytenis.patterns.state.api.States;

public class NotInvited extends AbstractState {
    public NotInvited(States states) {
        super(states);
    }

    @Override
    public State invite() {
        return states.invited();
    }

    @Override
    public State decline() {
        return this;
    }

    @Override
    public State accept() {
        return this;
    }
}
