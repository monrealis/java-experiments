package eu.vytenis.patterns.other.activeObject;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class CommandRunner implements Runnable {
    private List<Runnable> commands = new ArrayList<>();
    private List<Runnable> newCommands = commands;

    public void add(Runnable command) {
        newCommands.add(command);
    }

    public void run() {
        while (!commands.isEmpty()) {
            Runnable remove = commands.remove(0);
            remove.run();
        }
    }

    public List<Runnable> getCommands() {
        return unmodifiableList(commands);
    }

    public void storeNewCommandsInNewQueue() {
        newCommands = new ArrayList<>();
    }
}
