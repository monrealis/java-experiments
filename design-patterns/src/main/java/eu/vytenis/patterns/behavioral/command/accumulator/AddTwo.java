package eu.vytenis.patterns.behavioral.command.accumulator;

import eu.vytenis.patterns.behavioral.command.api.Command;

public class AddTwo implements Command {
    private final Accumulator accumulator;

    public AddTwo(Accumulator accumulator) {
        this.accumulator = accumulator;
    }

    @Override
    public void execute() {
        accumulator.set(accumulator.get() + 2);
    }

    @Override
    public void undo() {
        accumulator.set(accumulator.get() - 2);
    }
}
