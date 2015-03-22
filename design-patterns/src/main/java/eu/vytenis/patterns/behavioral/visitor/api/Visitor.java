package eu.vytenis.patterns.behavioral.visitor.api;

import eu.vytenis.patterns.behavioral.visitor.vcs.ConcurrentVersionsSystem;
import eu.vytenis.patterns.behavioral.visitor.vcs.Subversion;

public interface Visitor<T> {
    T visitConcurrentVersionsSystem(ConcurrentVersionsSystem cvs);

    T visitSubversion(Subversion svn);
}
