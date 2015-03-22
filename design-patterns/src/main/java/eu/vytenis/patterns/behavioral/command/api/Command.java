package eu.vytenis.patterns.behavioral.command.api;

public interface Command {
    void execute();

    void undo();
}
