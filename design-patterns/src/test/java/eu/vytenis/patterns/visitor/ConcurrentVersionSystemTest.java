package eu.vytenis.patterns.visitor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcurrentVersionSystemTest {
    private final VersionControlSystem cvs = new ConcurrentVersionsSystem();
    private final VersionControlSystem svn = new Subversion();
    private final Visitor<String> xml = new XmlFormatter();
    private final Visitor<String> json = new JsonFormatter();

    @Test
    public void xml_serialized() {
        assertEquals("<cvs />", cvs.accept(xml));
        assertEquals("<svn />", svn.accept(xml));
    }

    @Test
    public void json_serialized() {
        assertEquals("{type: 'cvs'}", cvs.accept(json));
        assertEquals("{type: 'svn'}", svn.accept(json));
    }
}
