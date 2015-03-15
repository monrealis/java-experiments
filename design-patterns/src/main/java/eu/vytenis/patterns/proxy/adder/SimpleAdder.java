package eu.vytenis.patterns.proxy.adder;

import eu.vytenis.patterns.proxy.api.Adder;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SimpleAdder extends UnicastRemoteObject implements Adder {
    public SimpleAdder() throws RemoteException {
    }

    @Override
    public int add(int first, int second) {
        return first + second;
    }
}
