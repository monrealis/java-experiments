package eu.vytenis.patterns.visitor;

public class JsonFormatter implements Visitor<String> {
    @Override
    public String visitConcurrentVersionsSystem(ConcurrentVersionsSystem cvs) {
        return "{type: 'cvs'}";
    }

    @Override
    public String visitSubversion(Subversion svn) {
        return "{type: 'svn'}";
    }
}
