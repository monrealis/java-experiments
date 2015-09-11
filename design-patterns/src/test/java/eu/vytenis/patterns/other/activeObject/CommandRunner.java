package eu.vytenis.patterns.other.activeObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static java.util.Collections.unmodifiableCollection;

public class CommandRunner implements Runnable {
    private static final Runnable DO_NOTHING = new Runnable() {
        @Override
        public void run() {

        }
    };
    protected Collection<Runnable> commands = create();
    private Collection<Runnable> newCommands = commands;
    private boolean exitIfQueueEmpty = false;

    public void add(Runnable command) {
        newCommands.add(command);
    }

    public void run() {
        while (isProceed())
            take().run();
    }

    protected Runnable take() {
        if (commands.isEmpty())
            return DO_NOTHING;
        Iterator<Runnable> it = commands.iterator();
        Runnable first = it.next();
        it.remove();
        return first;
    }

    private boolean isProceed() {
        if (!commands.isEmpty())
            return true;
        if (!exitIfQueueEmpty)
            return true;
        return false;
    }

    public Collection<Runnable> getCommands() {
        return unmodifiableCollection(commands);
    }

    public void storeNewCommandsInNewQueue() {
        newCommands = create();
    }

    public void exitIfQueueEmpty() {
        exitIfQueueEmpty = true;
    }

    protected Collection<Runnable> create() {
        return new ArrayList<>();
    }
}
