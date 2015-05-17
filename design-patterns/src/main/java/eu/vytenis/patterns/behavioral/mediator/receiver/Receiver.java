package eu.vytenis.patterns.behavioral.mediator.receiver;

import eu.vytenis.patterns.behavioral.mediator.communication.Communicator;

public class Receiver {
    private final Communicator mediator;
    private Object lastReceived;

    public Receiver(Communicator mediator) {
        this.mediator = mediator;
    }

    public void receive(Object o) {
        lastReceived = o;
    }

    public Object getLastReceived() {
        return lastReceived;
    }
}
