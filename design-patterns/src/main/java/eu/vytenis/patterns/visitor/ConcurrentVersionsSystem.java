package eu.vytenis.patterns.visitor;

public class ConcurrentVersionsSystem implements VersionControlSystem {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitConcurrentVersionsSystem(this);
    }
}
