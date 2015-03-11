package eu.vytenis.patterns.state.api;

public interface States {
    State notInvited();

    State invited();

    State accepted();

    State declined();
}
