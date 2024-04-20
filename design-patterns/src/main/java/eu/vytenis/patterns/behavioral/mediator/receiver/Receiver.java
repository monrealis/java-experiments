package eu.vytenis.patterns.behavioral.mediator.receiver;

public class Receiver {
    private String lastReceived;

    public void receive(String o) {
        lastReceived = o;
    }

    public String getLastReceived() {
        return lastReceived;
    }
}
