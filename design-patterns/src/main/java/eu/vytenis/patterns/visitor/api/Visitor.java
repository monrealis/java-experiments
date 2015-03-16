package eu.vytenis.patterns.visitor.api;

import eu.vytenis.patterns.visitor.vcs.ConcurrentVersionsSystem;
import eu.vytenis.patterns.visitor.vcs.Subversion;

public interface Visitor<T> {
    T visitConcurrentVersionsSystem(ConcurrentVersionsSystem cvs);

    T visitSubversion(Subversion svn);
}
