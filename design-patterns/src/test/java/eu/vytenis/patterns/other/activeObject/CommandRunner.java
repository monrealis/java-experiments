package eu.vytenis.patterns.other.activeObject;

import java.util.Collection;

public interface CommandRunner extends Runnable {
    void add(Runnable command);

    Collection<Runnable> getCommands();

    void storeNewCommandsInNewQueue();

    void exitIfQueueEmpty();
}
