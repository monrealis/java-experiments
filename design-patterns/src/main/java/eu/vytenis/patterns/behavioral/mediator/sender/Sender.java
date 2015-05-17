package eu.vytenis.patterns.behavioral.mediator.sender;

import eu.vytenis.patterns.behavioral.mediator.communication.Communicator;

public class Sender {
    private final Communicator mediator;

    public Sender(Communicator mediator) {
        this.mediator = mediator;
    }


    public void send(Object o) {
        mediator.send(o);
    }
}
