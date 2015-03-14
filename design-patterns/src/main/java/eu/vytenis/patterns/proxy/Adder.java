package eu.vytenis.patterns.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Adder extends Remote {
    int add(int first, int second) throws RemoteException;
}
