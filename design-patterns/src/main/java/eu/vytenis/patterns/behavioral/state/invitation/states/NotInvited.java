package eu.vytenis.patterns.behavioral.state.invitation.states;

import eu.vytenis.patterns.behavioral.state.api.AbstractState;
import eu.vytenis.patterns.behavioral.state.api.State;
import eu.vytenis.patterns.behavioral.state.api.States;

@SuppressWarnings("rawtypes")
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
