package eu.vytenis.patterns.visitor.api;

public interface VersionControlSystem {
    <T> T accept(Visitor<T> visitor);
}
