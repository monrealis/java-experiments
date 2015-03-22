package eu.vytenis.patterns.behavioral.visitor.formatters;

import eu.vytenis.patterns.behavioral.visitor.api.Visitor;
import eu.vytenis.patterns.behavioral.visitor.vcs.ConcurrentVersionsSystem;
import eu.vytenis.patterns.behavioral.visitor.vcs.Subversion;

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
