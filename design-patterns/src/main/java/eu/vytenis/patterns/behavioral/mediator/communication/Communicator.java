package eu.vytenis.patterns.behavioral.mediator.communication;

import eu.vytenis.patterns.behavioral.mediator.receiver.Receiver;
import eu.vytenis.patterns.behavioral.mediator.sender.Sender;

public class Communicator<T, U> {
    private Receiver<U> receiver;
    private Sender<T> sender;

    public void send(U o) {
        receiver.receive(o);
    }

    public void setSender(Sender<T> sender) {
        this.sender = sender;
    }

    public void setReceiver(Receiver<U> receiver) {
        this.receiver = receiver;
    }
}
