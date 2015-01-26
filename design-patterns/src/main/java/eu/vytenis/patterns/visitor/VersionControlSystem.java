package eu.vytenis.patterns.visitor;

public interface VersionControlSystem {
    <T> T accept(Visitor<T> visitor);
}
