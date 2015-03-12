package eu.vytenis.patterns.command.accumulator;

import eu.vytenis.patterns.command.api.Command;

public class MultiplyByTwo implements Command {
    private final Accumulator accumulator;

    public MultiplyByTwo(Accumulator accumulator) {
        this.accumulator = accumulator;
    }

    @Override
    public void execute() {
        accumulator.set(accumulator.get() * 2);
    }

    @Override
    public void undo() {
        accumulator.set(accumulator.get() / 2);
    }
}
