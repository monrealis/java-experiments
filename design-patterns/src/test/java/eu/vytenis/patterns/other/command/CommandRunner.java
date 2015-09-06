package eu.vytenis.patterns.other.command;

import java.util.ArrayList;
import java.util.List;

public class CommandRunner {
    private List<Runnable> commands = new ArrayList<>();

    public void add(Runnable command) {
        commands.add(command);
    }

    public void run() {
        while (!commands.isEmpty())
            commands.remove(0).run();
    }
}
