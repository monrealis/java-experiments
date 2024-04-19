package eu.vytenis.patterns.behavioral.mediator.communication;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import eu.vytenis.patterns.behavioral.mediator.receiver.Receiver;
import eu.vytenis.patterns.behavioral.mediator.sender.Sender;

public class CommunicatorTest {
    private Communicator m = new Communicator();
    private Sender s = new Sender(m);
    private Receiver r = new Receiver(m);

    @Before
    public void before() {
        m.setReceiver(r);
        m.setSender(s);
    }

    @Test
    public void receivedReceivesSentObject() {
        Object o = new Object();
        s.send(o);
        assertEquals(o, r.getLastReceived());
    }
}
