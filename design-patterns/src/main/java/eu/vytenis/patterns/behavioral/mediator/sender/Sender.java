package eu.vytenis.patterns.behavioral.mediator.sender;

import eu.vytenis.patterns.behavioral.mediator.communication.Communicator;

public class Sender<U> {
    private final Communicator<?, U> mediator;
    private U lastSent;

    public Sender(Communicator<?, U> mediator) {
        this.mediator = mediator;
    }

    public void send(U o) {
        mediator.send(o);
    }

    private U getLastSent() {
        return lastSent;
    }
}
