package eu.vytenis.patterns.other.activeObject;

import java.util.Collection;

import static java.util.Collections.unmodifiableCollection;

public abstract class CommandRunner<T extends Collection<Runnable>> implements Runnable {
    private boolean exitIfQueueEmpty = false;
    protected T commands = create();
    private T newCommands = commands;

    public void run() {
        while (isProceed())
            take().run();
    }

    protected abstract Runnable take();

    private boolean isProceed() {
        if (!commands.isEmpty())
            return true;
        if (!exitIfQueueEmpty)
            return true;
        return false;
    }

    public void add(Runnable command) {
        newCommands.add(command);
    }

    public Collection<Runnable> getCommands() {
        return unmodifiableCollection(commands);
    }

    protected abstract T create();

    public void storeNewCommandsInNewQueue() {
        newCommands = create();
    }

    public void exitIfQueueEmpty() {
        exitIfQueueEmpty = true;
    }
}
