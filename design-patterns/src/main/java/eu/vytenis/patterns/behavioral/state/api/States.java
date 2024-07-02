package eu.vytenis.patterns.behavioral.state.api;

@SuppressWarnings("rawtypes")
public interface States {
    State notInvited();

    State invited();

    State accepted();

    State declined();
}
