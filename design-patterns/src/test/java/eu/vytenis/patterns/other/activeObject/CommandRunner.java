package eu.vytenis.patterns.other.activeObject;

public interface CommandRunner extends Runnable {
    void add(Runnable command);

    int getCommandsCount();

    void storeNewCommandsInNewQueue();

    void exitIfQueueEmpty();
}
