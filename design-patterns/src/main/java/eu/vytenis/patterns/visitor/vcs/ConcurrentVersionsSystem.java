package eu.vytenis.patterns.visitor.vcs;

import eu.vytenis.patterns.visitor.api.VersionControlSystem;
import eu.vytenis.patterns.visitor.api.Visitor;

public class ConcurrentVersionsSystem implements VersionControlSystem {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitConcurrentVersionsSystem(this);
    }
}
