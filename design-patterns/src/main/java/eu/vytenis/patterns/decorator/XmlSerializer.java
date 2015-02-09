package eu.vytenis.patterns.decorator;

import org.w3c.dom.Document;

public interface XmlSerializer {
    String serialize(Document document);
}
