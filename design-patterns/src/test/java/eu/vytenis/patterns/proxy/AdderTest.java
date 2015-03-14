package eu.vytenis.patterns.proxy;

import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import static org.junit.Assume.assumeNoException;

public class AdderTest {
    @Before
    public void before() {
        try {
            rebind();
        } catch (RemoteException | MalformedURLException e) {
            String command = "rmiregistry -J-Djava.rmi.server.codebase=file:///home/vytenis/IdeaProjects/java-experiments/design-patterns/target/classes/";
            assumeNoException("Start rmiregistry, for example, with: " + command, e);
        }
    }

    public void rebind() throws RemoteException, MalformedURLException {
        Naming.rebind("Adder", new SimpleAdder());
    }

    @Test
    public void pass() {
    }
}
