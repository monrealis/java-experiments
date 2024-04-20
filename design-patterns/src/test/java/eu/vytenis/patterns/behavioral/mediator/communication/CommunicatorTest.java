package eu.vytenis.patterns.behavioral.mediator.communication;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import eu.vytenis.patterns.behavioral.mediator.receiver.Receiver;
import eu.vytenis.patterns.behavioral.mediator.sender.Sender;

public class CommunicatorTest {
    private Communicator<Object, Object> m = new Communicator<Object, Object>();
    private Sender<Object> s = new Sender<Object>(m);
    private Receiver<Object> r = new Receiver<Object>();

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
