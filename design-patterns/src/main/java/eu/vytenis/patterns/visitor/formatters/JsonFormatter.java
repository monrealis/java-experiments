package eu.vytenis.patterns.visitor.formatters;

import eu.vytenis.patterns.visitor.api.Visitor;
import eu.vytenis.patterns.visitor.vcs.ConcurrentVersionsSystem;
import eu.vytenis.patterns.visitor.vcs.Subversion;

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
