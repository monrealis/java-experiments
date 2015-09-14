package eu.vytenis.patterns.other.activeObject;

import java.util.Collection;

public interface CommandRunner extends Runnable {
    void add(Runnable command);

    int getCommandsCount();

    void storeNewCommandsInNewQueue();

    void exitIfQueueEmpty();
}
