package eu.vytenis.patterns.behavioral.state.invitation;

import eu.vytenis.patterns.behavioral.state.api.State;
import eu.vytenis.patterns.behavioral.state.api.States;
import eu.vytenis.patterns.behavioral.state.invitation.states.Accepted;
import eu.vytenis.patterns.behavioral.state.invitation.states.Declined;
import eu.vytenis.patterns.behavioral.state.invitation.states.Invited;
import eu.vytenis.patterns.behavioral.state.invitation.states.NotInvited;

public class Invitation implements States, State<Invitation> {
    private State<State> notInvited = new NotInvited(this);
    private State<State> invited = new Invited(this);
    private State<State> accepted = new Accepted(this);
    private State<State> declined = new Declined(this);
    private State<State> state = notInvited;

    @Override
    public State notInvited() {
        return notInvited;
    }

    @Override
    public State invited() {
        return invited;
    }

    @Override
    public State accepted() {
        return accepted;
    }

    @Override
    public State declined() {
        return declined;
    }

    public Invitation invite() {
        state = state.invite();
        return this;
    }

    public Invitation decline() {
        state = state.decline();
        return this;
    }

    public Invitation accept() {
        state = state.accept();
        return this;
    }

    public State<State> getState() {
        return state;
    }
}
