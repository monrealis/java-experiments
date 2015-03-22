package eu.vytenis.patterns.behavioral.command.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class MacroCommand implements Command {
    private List<Command> commands = new ArrayList<>();

    public MacroCommand(Command... commands) {
        this.commands.addAll(asList(commands));
    }

    @Override
    public void execute() {
        commands.forEach(Command::execute);
    }

    @Override
    public void undo() {
        reversedCommands().forEach(Command::undo);
    }

    private List<Command> reversedCommands() {
        List<Command> inverted = new ArrayList<>(commands);
        Collections.reverse(inverted);
        return inverted;
    }
}
