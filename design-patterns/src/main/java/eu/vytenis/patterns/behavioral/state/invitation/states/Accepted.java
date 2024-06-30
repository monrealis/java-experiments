package eu.vytenis.patterns.behavioral.state.invitation.states;

import eu.vytenis.patterns.behavioral.state.api.AbstractState;
import eu.vytenis.patterns.behavioral.state.api.State;
import eu.vytenis.patterns.behavioral.state.api.States;

@SuppressWarnings("rawtypes")
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
