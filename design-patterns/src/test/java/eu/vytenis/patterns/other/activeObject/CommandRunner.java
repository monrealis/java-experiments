package eu.vytenis.patterns.other.activeObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static java.util.Collections.unmodifiableCollection;

public class CommandRunner implements Runnable {
    private Collection<Runnable> commands = create();
    private Collection<Runnable> newCommands = commands;

    public void add(Runnable command) {
        newCommands.add(command);
    }

    public void run() {
        while (!commands.isEmpty()) {
            Iterator<Runnable> it = commands.iterator();
            Runnable first = it.next();
            it.remove();
            first.run();
        }
    }

    public Collection<Runnable> getCommands() {
        return unmodifiableCollection(commands);
    }

    public void storeNewCommandsInNewQueue() {
        newCommands = create();
    }

    private Collection<Runnable> create() {
        return new ArrayList<>();
    }
}
