package eu.vytenis.patterns.behavioral.mediator.receiver;

public class Receiver<T> {
    private T lastReceived;

    public void receive(T o) {
        lastReceived = o;
    }

    public T getLastReceived() {
        return lastReceived;
    }
}
