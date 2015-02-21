package eu.vytenis.patterns.command.api;

public interface Command {
    void execute();

    void undo();
}
