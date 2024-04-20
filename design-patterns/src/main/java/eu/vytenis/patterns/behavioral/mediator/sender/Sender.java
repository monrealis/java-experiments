package eu.vytenis.patterns.behavioral.mediator.sender;

import eu.vytenis.patterns.behavioral.mediator.communication.Communicator;

public class Sender<T> {
    private final Communicator<T> mediator;

    public Sender(Communicator<T> mediator) {
        this.mediator = mediator;
    }

    public void send(T t) {
        mediator.send(t.toString());
    }
}
