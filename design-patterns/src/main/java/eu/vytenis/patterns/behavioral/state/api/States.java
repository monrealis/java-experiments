package eu.vytenis.patterns.behavioral.state.api;

public interface States {
    State notInvited();

    State invited();

    State accepted();

    State declined();
}
