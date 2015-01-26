package eu.vytenis.patterns.visitor;

public interface Visitor<T> {
    T visitConcurrentVersionsSystem(ConcurrentVersionsSystem cvs);

    T visitSubversion(Subversion svn);
}
