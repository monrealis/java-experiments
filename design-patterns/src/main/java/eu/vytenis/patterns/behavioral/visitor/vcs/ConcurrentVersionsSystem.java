package eu.vytenis.patterns.behavioral.visitor.vcs;

import eu.vytenis.patterns.behavioral.visitor.api.VersionControlSystem;
import eu.vytenis.patterns.behavioral.visitor.api.Visitor;

public class ConcurrentVersionsSystem implements VersionControlSystem {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitConcurrentVersionsSystem(this);
    }
}
