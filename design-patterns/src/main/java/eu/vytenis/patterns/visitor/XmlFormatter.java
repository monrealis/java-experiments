package eu.vytenis.patterns.visitor;

public class XmlFormatter implements Visitor<String> {
    @Override
    public String visitConcurrentVersionsSystem(ConcurrentVersionsSystem cvs) {
        return "<cvs />";
    }

    @Override
    public String visitSubversion(Subversion svn) {
        return "<svn />";
    }
}
