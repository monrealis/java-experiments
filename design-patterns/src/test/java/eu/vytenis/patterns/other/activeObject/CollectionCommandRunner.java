package eu.vytenis.patterns.other.activeObject;

import java.util.Collection;

import static java.util.Collections.unmodifiableCollection;

public abstract class CollectionCommandRunner<T extends Collection<Runnable>> implements Runnable, CommandRunner {
    private boolean exitIfQueueEmpty = false;
    protected T commands = create();
    private T newCommands = commands;

    @Override
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

    @Override
    public void add(Runnable command) {
        newCommands.add(command);
    }

    @Override
    public int getCommandsCount() {
        return commands.size();
    }

    protected abstract T create();

    @Override
    public void storeNewCommandsInNewQueue() {
        newCommands = create();
    }

    @Override
    public void exitIfQueueEmpty() {
        exitIfQueueEmpty = true;
    }
}
