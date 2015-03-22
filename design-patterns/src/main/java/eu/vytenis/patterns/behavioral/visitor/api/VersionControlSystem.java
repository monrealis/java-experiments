package eu.vytenis.patterns.behavioral.visitor.api;

public interface VersionControlSystem {
    <T> T accept(Visitor<T> visitor);
}
