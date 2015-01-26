package eu.vytenis.patterns.visitor;

public class Subversion implements VersionControlSystem {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitSubversion(this);
    }
}
