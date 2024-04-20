package eu.vytenis.patterns.behavioral.mediator.communication;

import eu.vytenis.patterns.behavioral.mediator.receiver.Receiver;

public class Communicator<U> {
    private Receiver receiver;

    public void send(String o) {
        receiver.receive(o);
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}
