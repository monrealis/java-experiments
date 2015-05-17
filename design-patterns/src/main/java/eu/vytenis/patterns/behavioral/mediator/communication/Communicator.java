package eu.vytenis.patterns.behavioral.mediator.communication;

import eu.vytenis.patterns.behavioral.mediator.receiver.Receiver;
import eu.vytenis.patterns.behavioral.mediator.sender.Sender;

public class Communicator {
    private Receiver receiver;
    private Sender sender;

    public void send(Object o) {
        receiver.receive(o);
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}
